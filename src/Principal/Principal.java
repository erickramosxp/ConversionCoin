package Principal;

import edu.pratica.conversor.utils.Api;
import edu.pratica.conversor.records.InfosCoins;
import edu.pratica.conversor.utils.Conversor;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Api construtor = new Api();
        Scanner leitura = new Scanner(System.in);
        int continuar = 1;

        do {
            System.out.println("""
                    |---------- Bem vindo ao conversor de moedas --------|
                    |                                                    |
                    |--------------- MOEDAS DISPONIVEIS -----------------|
                                     BRL - Real brasileiro
                                     ARS - Peso Argentino
                                     BOB - Boliviano boliviano
                                     CLP - Peso chileno
                                     COP - Peso colombiano
                                     USD - Dólar americano
                                     AOA - Kwanza angolano
                     ---------------------------------------------------
                                     Digite 0 se deseja sair
                    """);
            System.out.println("Digite a sigla da moeda de entrada: ");
            String moedaEntrada = leitura.next();
            if (moedaEntrada.compareTo("0") == 0)
                break;
            if (!construtor.validarMoeda(moedaEntrada.toUpperCase())) {
                System.out.println("\t\t\t\u001B[31mOpção invalida! Tente novamente.\u001B[0m\n");
                continue;
            }

            InfosCoins valores = construtor.getJson(moedaEntrada);

            System.out.println("Digite o valor da moeda de entrada: ");
            double valorDeEntrada = leitura.nextDouble();

            Conversor converter = new Conversor(valorDeEntrada, valores.conversion_rates());

            System.out.println("Insira a moeda a qual você deseja que seja convertida: ");
            String moedaDestino = leitura.next();

            if(!construtor.validarMoeda(moedaDestino.toUpperCase())) {
                do {
                    System.out.println("\t\t\t\u001B[31mOpção invalida! Tente novamente.\u001B[0m\n");
                    System.out.println("Insira a moeda a qual você deseja que seja convertida ou sair: ");
                    moedaDestino = leitura.next();
                    if (moedaDestino.toLowerCase().compareTo("sair") == 0) {
                        break;
                    }
                } while (!construtor.validarMoeda(moedaDestino.toUpperCase()));
            }
            if (moedaDestino.toLowerCase().compareTo("sair") == 0) {
                break;
            }

            converter.converterMoeda(moedaDestino.toUpperCase());
            System.out.println();

            System.out.println("Deseja continuar ?");
            System.out.println("Digite 0 parar sair ou qualquer número para continuar");
            continuar = leitura.nextInt();
        } while (continuar != 0);
        System.out.println("\nMuito obrigado!");
    }
}
