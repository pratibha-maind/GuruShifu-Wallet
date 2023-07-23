
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

    @Test
    public void shouldBeAbleToDebitTenRupeeFromWalletWhenAvailable() throws Exception{
        double amount = 10;
        double expectedAmount = 10.0;
        assertDoesNotThrow(() ->{
            Money moneyInRupee  = new Money(amount, Money.currencyType.RUPEE);
        });

        Money moneyInRupee  = new Money(amount, Money.currencyType.RUPEE);
        Wallet wallet  = new Wallet();

        wallet.put(moneyInRupee);
        wallet.put(moneyInRupee);
        wallet.takeOut(moneyInRupee);
        Money expectedBalance = new Money(expectedAmount, Money.currencyType.RUPEE);
        Money actualBalance = wallet.getBalance();

        assertTrue(actualBalance.equals(expectedBalance));


    }

    @Test
    public void shouldNotBeAbleToDebitTenRupeeFromWalletWhenNotAvailable() throws Exception{
        double amount = 10;
        double amountToTake = 20;

        assertDoesNotThrow(() ->{
            Money moneyToAdd = new Money(amount, Money.currencyType.RUPEE);
            Money moneyToTake  = new Money(amountToTake, Money.currencyType.RUPEE);
        });

        Money moneyToAdd  = new Money(amount, Money.currencyType.RUPEE);
        Money moneyToTake  = new Money(amountToTake, Money.currencyType.RUPEE);
        Wallet wallet  = new Wallet();

        wallet.put(moneyToAdd);

        assertThrows(Exception.class, () -> {
            wallet.takeOut(moneyToTake);
        });


    }
    @Test
    public void shouldAbleToTakeTwoDollarWhenHundredRupeeAndOneDollarAreAvailabale() throws Exception{
        double amountInRupee = 100.0;
        double amountInDollar = 1.0;
        double amountToTake  = 2.0;
        double expectedAmount = 17.7;

        assertDoesNotThrow(() ->{
            Money moneyToAddInRupee = new Money(amountInRupee, Money.currencyType.RUPEE);
            Money moneyToAddInDollar  = new Money(amountInDollar, Money.currencyType.DOLLAR);
            Money moneyToTakeInDollar  = new Money(amountToTake, Money.currencyType.DOLLAR);
        });

        Money moneyToAddInRupee = new Money(amountInRupee, Money.currencyType.RUPEE);
        Money moneyToAddInDollar  = new Money(amountInDollar, Money.currencyType.DOLLAR);
        Money moneyToTakeInDollar  = new Money(amountToTake, Money.currencyType.DOLLAR);
        Wallet wallet = new Wallet();

        wallet.put(moneyToAddInRupee);
        wallet.put(moneyToAddInDollar);
        wallet.takeOut(moneyToTakeInDollar);
        Money expectedBalance = new Money(expectedAmount, Money.currencyType.RUPEE);
        Money actualBalance = wallet.getBalance();

        assertTrue(actualBalance.equals(expectedBalance));


    }

}
