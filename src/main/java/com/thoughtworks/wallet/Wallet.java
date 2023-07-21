
package com.thoughtworks.wallet;

public class Wallet {

    private Rupee balance ;

    public Wallet() throws Exception{
        balance = new Rupee(0.0);
    }

    public void put(Rupee ruppee) throws Exception{
        
        balance = balance.add(ruppee);
    }

    public Rupee balance() {
        return balance;
    }

    
}