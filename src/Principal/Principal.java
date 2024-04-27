package Principal;

import com.google.gson.Gson;
import edu.pratica.conversor.utils.Api;
import edu.pratica.conversor.records.InfosCoins;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Api construtor = new Api();
        Gson gson = new Gson();
        String jSON = construtor.getJson("BRL");

        InfosCoins valores = gson.fromJson(jSON,InfosCoins.class);

        System.out.println(valores.conversion_rates().USD() * 50);
    }
}
