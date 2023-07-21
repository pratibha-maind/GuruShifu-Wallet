package com.thoughtworks.wallet;

public class Dollar {
    private final double value;

    public Dollar(double amount) throws Exception
    {
        if(amount < 0)
            throw new Exception();
        this.value = amount;
    }

    public Dollar add (Dollar dollar) throws Exception{
        return new Dollar (this.value + dollar.getValue()* 82);

    }
    private double getValue()
    {
        return this.value;
    }
}