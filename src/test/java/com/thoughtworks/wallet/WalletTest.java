
package com.thoughtworks.wallet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WalletTest {

    @Test
    public void shouldAbleToAddTenRupee() throws Exception{
        Wallet wallet = new Wallet();
        double amount = 10;
        double balance = 10;

        assertDoesNotThrow( () -> {
            Rupee rupee = new Rupee(amount);
        });

        Rupee rupee = new Rupee(amount);
        wallet.put(rupee);
        Rupee actualAmount = wallet.getRupeeBalance();
        Rupee expectedAmount = new Rupee(balance);

        assertEquals(expectedAmount, actualAmount);


    }

    @Test
    public void shouldNotAbleToAddRupeeWhenNegative() throws Exception{
        double amount = -10;

        assertThrows(Exception.class, () ->  {
            Rupee rupee = new Rupee(amount);
        });


    }

    @Test
    public void shouldAbleToAddTenDollarWhenTenDollarIsGiven() throws Exception{
        double amount =10;
        double balance = 10;
        Wallet wallet = new Wallet();

        assertDoesNotThrow( () -> {
            Dollar dollar = new Dollar(amount);
        });

        Dollar dollar = new Dollar(amount);
        wallet.put(dollar);
        Dollar actualAmount = wallet.getDollarBalance();
        Dollar expectedAmount = new Dollar(balance);

        assertEquals(expectedAmount, actualAmount);



    }

    @Test
    public void shouldNotAbleToAddDollarWhenNegative() throws Exception{
        double amount = -10;

        assertThrows(Exception.class, () ->  {
            Dollar dollar  = new Dollar(amount);
        });


    }

    @Test
    public void shouldAbleToAddRupeeAndDollarAndProvideBalanceInRupee() throws Exception{
        double amount = 2.0;
        Wallet wallet  = new Wallet();

        assertDoesNotThrow(() ->  {
            Rupee rupee = new Rupee(amount);
            Dollar dollar  = new Dollar(amount);
        });

        Rupee rupee = new Rupee(amount);
        Dollar dollar  = new Dollar(amount);
        wallet.put(rupee);
        wallet.put(dollar);
        Rupee expectedBalance = new Rupee(162.0);
        Rupee actualBalance = wallet.getTotalBalance();

        assertEquals(expectedBalance, actualBalance);

    }
}
