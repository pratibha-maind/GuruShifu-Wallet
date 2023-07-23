
package com.thoughtworks.wallet;

public class Wallet {

    private Rupee rupeeBalance ;
    private Dollar dollarBalance;


    public Wallet() throws Exception{
        rupeeBalance = new Rupee(0.0);
        dollarBalance = new Dollar(0.0);

    }

    public void put(Rupee ruppee) throws Exception{
        
        rupeeBalance = rupeeBalance.add(ruppee);

    }

    public Rupee getRupeeBalance() {

        return rupeeBalance;
    }

    public Dollar getDollarBalance () {
        return dollarBalance;
    }
    
    public void put(Dollar dollar) throws Exception{
        
        dollarBalance = dollarBalance.add(dollar);

        
    }
    
}