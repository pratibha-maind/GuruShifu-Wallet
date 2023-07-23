
package com.thoughtworks.wallet;

public class Wallet {

   Money balance;

    public Wallet() throws Exception{
        balance = new Money(0.0, Money.currencyType.RUPEE);
    }

    public void put(Money money) throws Exception {
        balance = balance.add(money);

    }
    public Money getBalance()
    {
        return balance;
    }

    
}