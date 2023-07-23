package com.thoughtworks.wallet;

import java.text.DecimalFormat;

public class Money
{
    private double value;
    public enum currencyType { RUPEE, DOLLAR};

    currencyType type;

     final DecimalFormat decfor = new DecimalFormat("0.0");

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

    public Money remove(Money money) throws Exception
    {
        double amount = 0.0;
        if(money.type == currencyType.RUPEE)
            amount = money.value;
        if(money.type == currencyType.DOLLAR)
            amount = money.value*82.3;
        if(this.value < amount)
            throw new Exception();
        double newAmount = this.value - amount;
        double newAmount2 = Double.parseDouble(decfor.format(newAmount));
        Money newMoney = new Money(newAmount2, currencyType.RUPEE );
        return newMoney;
    }



}
