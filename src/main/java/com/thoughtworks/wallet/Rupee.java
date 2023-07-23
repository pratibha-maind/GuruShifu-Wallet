package com.thoughtworks.wallet;

public class Rupee extends Exception{
    private final double value;

    public Rupee(double amount) throws Exception
    {
        if(amount < 0)
            throw new Exception();
        this.value = amount;
    }

    public Rupee add(Rupee ruppee) throws Exception{
        return new Rupee (this.value + ruppee.getValue());

    }

    public double getValue()
    {
        return this.value;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if( (o == null)){
            return false;
        }
        if(! (getClass() == o.getClass()))
        {
            return false;
        }

        Rupee rupee = (Rupee) o;

        return value == rupee.value;

    }
    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

}
