package Principal;

import com.google.gson.Gson;
import edu.pratica.conversor.utils.Api;
import edu.pratica.conversor.records.InfosCoins;
import edu.pratica.conversor.utils.Conversor;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Api construtor = new Api();
        Scanner leitura = new Scanner(System.in);
        Gson gson = new Gson();

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
                 ---------------------------------------------------
                """);
        System.out.println("Digite a sigla da moeda de entrada: ");
        String moedaEntrada = leitura.next();

        String jSON = construtor.getJson(moedaEntrada);
        InfosCoins valores = gson.fromJson(jSON,InfosCoins.class);

        System.out.println("Digite o valor da moeda de entrada: ");
        double valorDeEntrada = leitura.nextDouble();

        Conversor converter = new Conversor(valorDeEntrada, valores.conversion_rates());

        System.out.println("Insira a moeda a qual você deseja que seja convertida: ");
        String moedaDestino = leitura.next();
        if (moedaDestino.compareTo("BRL") == 0) {
            System.out.println(converter.getValueBRL());
        } else if (moedaDestino.compareTo("ARS") == 0) {
            System.out.println(converter.getValueARS());
        } else if (moedaDestino.compareTo("BOB") == 0) {
            System.out.println(converter.getValueBOB());
        } else if (moedaDestino.compareTo("CLP") == 0) {
            System.out.println(converter.getValueCLP());
        } else if (moedaDestino.compareTo("COP") == 0) {
            System.out.println(converter.getValueCOP());
        } else if (moedaDestino.compareTo("USD") == 0) {
            System.out.println(converter.getValueUSD());
        }



      //  System.out.println("R$ %.2f".formatted(valores.conversion_rates().USD() * 50));
    }
}
