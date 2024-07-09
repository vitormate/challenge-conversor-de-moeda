import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        String menu = """
                *****************************************************************************
                Seja bem vindo/a o Conversor de Moeda =]
                
                1) Dólar =>> Real brasileiro
                2) Real brasileiro =>> Dólar
                3) Yen =>> Real brasileiro
                4) Real brasileiro =>> Yen
                5) Won =>> Real brasileiro
                6) Real brasileiro =>> Won
                7) Sair
                Escolha uma opção válida:
                *****************************************************************************
                """;

        while (true) {
            System.out.println(menu);
            int choice = input.nextInt();
            Consulta consulta;
            String baseCoin;
            String targetCoin;

            if (choice == 7) {
                break;
            } else if (choice == 1) {
                baseCoin = "USD";
                targetCoin = "BRL";
                consulta = new Consulta(baseCoin, targetCoin);
            } else if (choice == 2) {
                baseCoin = "BRL";
                targetCoin = "USD";
                consulta = new Consulta(baseCoin, targetCoin);
            } else if (choice == 3) {
                baseCoin = "JPY";
                targetCoin = "BRL";
                consulta = new Consulta(baseCoin, targetCoin);
            } else if (choice == 4) {
                baseCoin = "BRL";
                targetCoin = "JYP";
                consulta = new Consulta(baseCoin, targetCoin);
            } else if (choice == 5) {
                baseCoin = "KRW";
                targetCoin = "BRL";
                consulta = new Consulta(baseCoin, targetCoin);
            } else if (choice == 6) {
                baseCoin = "BRL";
                targetCoin = "KRW";
                consulta = new Consulta(baseCoin, targetCoin);
            } else {
                System.out.println("Escolha uma opção válida!");
                continue;
            }

            System.out.println("Digite o valor que deseja converter: ");
            double amount = input.nextDouble();

            Convertido res = consulta.ConversaoMoeda(amount);

            System.out.println("Valor " + amount + " [" + baseCoin + "] corresponde ao valor final de =>> " + res +
                    " [" + targetCoin + "]");
        }


    }
}