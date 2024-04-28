package edu.pratica.conversor.utils;

import com.google.gson.Gson;
import edu.pratica.conversor.records.InfosCoins;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    private String endereco = "https://v6.exchangerate-api.com/v6/974665e8984272b6d206a5b7/latest/";
    private String moeda;
    Gson gson = new Gson();

    public InfosCoins getJson(String moeda) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco + moeda))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), InfosCoins.class);
    }

    private boolean verificarDisponibilidade(String moeda) {
        if (moeda.compareTo("BRL") == 0) {
            return true;
        } else if (moeda.compareTo("ARS") == 0) {
            return true;
        } else if (moeda.compareTo("BOB") == 0) {
            return true;
        } else if (moeda.compareTo("CLP") == 0) {
            return true;
        } else if (moeda.compareTo("COP") == 0) {
            return true;
        } else if (moeda.compareTo("USD") == 0) {
            return true;
        } else if (moeda.compareTo("AOA") == 0) {
            return true;
        }
        return false;
    }

    public boolean validarMoeda (String moeda) {
        if (moeda.length() > 3) {
            return false;
        } else if (!this.verificarDisponibilidade(moeda)) {
            return false;
        }
        return true;
    }
}
