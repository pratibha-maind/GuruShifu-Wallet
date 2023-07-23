package com.thoughtworks.wallet;

public class Money
{
    private double value;
    public enum currencyType { RUPEE, DOLLAR};

    currencyType type;

    public Money(double amount, currencyType currencyType) throws Exception
    {
        if(amount <0)
        {
            throw new Exception();
        }
        if(currencyType == currencyType.RUPEE)
        {
            value = amount;
            this.type = currencyType.RUPEE;
        }
        if(currencyType == currencyType.DOLLAR)
        {
            value = amount;
            this.type = currencyType.DOLLAR;
        }
    }

    public Money add(Money money) throws Exception
    {
        double amount;
        if(money.type == currencyType.RUPEE)
        {
            amount = money.value;
        }
        else
        {
            amount = money.value*82.3;
        }
        double newAmount = this.value + amount;
        Money newMoney = new Money(newAmount, currencyType.RUPEE );
        return newMoney;
    }

    @Override
    public boolean equals( Object obj)
    {
        if( this == obj)
            return true;
        if( obj == null)
            return false;
        if( this.getClass() != obj.getClass())
            return false;

        Money money = (Money) obj;
        return Double.compare(this.value, money.value) == 0;
    }

    @Override
    public int hashCode(){
        return Double.hashCode(this.value);
    }

    @Override
    public String toString() {
        return this.value + " " + this.type;
    }
}
