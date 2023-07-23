
package com.thoughtworks.wallet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WalletTest {go


    @Test
    public void shouldAddTenRupeeToWalletWhenGiven() throws Exception{
        double amount = 10.0;

        assertDoesNotThrow(() ->{
            Money money  = new Money(amount, Money.currencyType.RUPEE);
        });

        Money money  = new Money(amount, Money.currencyType.RUPEE);
        Wallet wallet = new Wallet();

        wallet.put(money);
        Money expectedBalance = new Money(amount, Money.currencyType.RUPEE);
        Money actualBalance = wallet.getBalance();

        assertTrue(expectedBalance.equals(actualBalance));

    }

    @Test
    public void shouldAddAmountTenDollarToWalletWhenGiven() throws Exception{
        double amount = 10.0;
        double expectAmount = 823.0;

        assertDoesNotThrow(() ->{
            Money money  = new Money(amount, Money.currencyType.DOLLAR);
        });

        Money money  = new Money(amount, Money.currencyType.DOLLAR);
        Wallet wallet = new Wallet();

        wallet.put(money);
        Money expectedBalance = new Money(expectAmount, Money.currencyType.RUPEE);
        Money actualBalance = wallet.getBalance();

        assertTrue(expectedBalance.equals(actualBalance));

    }

    @Test
    public void shouldAddTenRupeeAndTenDollarToWalletWhenGiven() throws Exception{
        double amount = 10.0;
        double expectedAmount = 833.0;

        assertDoesNotThrow(() ->{
            Money moneyInDollar = new Money(amount, Money.currencyType.DOLLAR);
            Money moneyInRupee  = new Money(amount, Money.currencyType.RUPEE);
        });

        Money moneyInDollar  = new Money(amount, Money.currencyType.DOLLAR);
        Money moneyInRupee  = new Money(amount, Money.currencyType.RUPEE);
        Wallet wallet = new Wallet();

        wallet.put(moneyInRupee);
        wallet.put(moneyInDollar);
        Money expectedBalance = new Money(expectedAmount, Money.currencyType.RUPEE);
        Money actualBalance = wallet.getBalance();

        assertTrue(expectedBalance.equals(actualBalance));

    }

    @Test
    public void shouldNotAddNegativeMoneyToWalletWhenGiven() throws Exception{
        double amount = -10.0;

        assertThrows(Exception.class, () ->{
            Money money = new Money(amount, Money.currencyType.RUPEE);
        });
    }


}
