package edu.pratica.conversor.utils;

import edu.pratica.conversor.records.ValuesCoin;

public class Conversor {
    private double valorDeConversao;
    private ValuesCoin valores;

    public Conversor(double valor, ValuesCoin valores) {
        this.valorDeConversao = valor;
        this.valores = valores;
    }

    public double getValueUSD () {
        return this.valorDeConversao * valores.USD();
    }

    public double getValueARS () {
        return this.valorDeConversao * valores.ARS();
    }

    public double getValueBOB () {
        return this.valorDeConversao * valores.BOB();
    }

    public double getValueBRL () {
        return this.valorDeConversao * valores.BRL();
    }

    public double getValueCLP () {
        return this.valorDeConversao * valores.CLP();
    }

    public double getValueCOP () {
        return this.valorDeConversao * valores.COP();
    }

    public double getValueAOA () {
        return this.valorDeConversao * valores.AOA();
    }


    public void converterMoeda(String moedaDestino) {
        if (moedaDestino.compareTo("BRL") == 0) {
            System.out.println("O valor convertido" +
                    " é de R$ " + this.getValueBRL() + " em real brasileiro");
        } else if (moedaDestino.compareTo("ARS") == 0) {
            System.out.println("O valor convertido é de $ " + this.getValueARS() + " em peso argentino");
        } else if (moedaDestino.compareTo("BOB") == 0) {
            System.out.println("O valor convertido é de $b " + this.getValueBOB() + " em  bolíviano da bolívia");
        } else if (moedaDestino.compareTo("CLP") == 0) {
            System.out.println("O valor convertido é de $ " + this.getValueCLP() + " em peso chileno");
        } else if (moedaDestino.compareTo("COP") == 0) {
            System.out.println("O valor convertido é de $ " + this.getValueCOP() + " em peso colombiano");
        } else if (moedaDestino.compareTo("USD") == 0) {
            System.out.println("O valor convertido é de $ " + this.getValueUSD() + " em dólar americano");
        } else if (moedaDestino.compareTo("AOA") == 0) {
            System.out.println("O valor convertido é de Kz " + this.getValueAOA() + " em kwanza angolano");
    }
    }
}
