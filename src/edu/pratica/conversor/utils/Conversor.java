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
}
