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
        return new Dollar (this.value + dollar.getValue());

    }

    public Rupee add (Rupee rupee) throws Exception{
        double dollarToRupee = this.value + rupee.getValue() *80;
        return new Rupee (dollarToRupee);

    }
    private double getValue()
    {
        return this.value;
    }


    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(! (o == null || getClass() == o.getClass())){
            return false;
        }

        Dollar dollar = (Dollar) o;

        return this.value == dollar.value;

    }
    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}