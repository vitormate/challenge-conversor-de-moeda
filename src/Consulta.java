import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    private final String key = "77300dc0bbe19730444b7e1a";
    private String baseCoin;
    private String targetCoin;

    public Consulta() {}

    public Consulta(String baseCoin, String targetCoin) {
        this.baseCoin = baseCoin;
        this.targetCoin = targetCoin;
    }

    public Convertido ConversaoMoeda(double amount) throws IOException, InterruptedException {
        String endereco = "https://v6.exchangerate-api.com/v6/" + this.key + "/pair/" + this.baseCoin + "/" +
                targetCoin + "/" + amount;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();

        return gson.fromJson(response.body(), Convertido.class);
    }
}
