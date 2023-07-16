package org.example.banking;

import org.example.banking.interfaces.*;
import org.example.banking.products.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Юнит-тесты для проверки функциональности банковских продуктов.
 *
 * @author Петр Белинский
 */
public class BankingTests {

    /**
     * Тест на проверку получения баланса дебетовой карты.
     */
    @Test
    @Tag("positive")
    @DisplayName("Проверка получения баланса дебетовой карты")
    public void testDebitCardBalance() {
        CardInterface debitCard = new DebitCard("Debit Card", "USD", 1000);
        assertEquals(1000, debitCard.getBalance());
    }

    /**
     * Тест на проверку получения баланса кредитной карты.
     */
    @Test
    @Tag("positive")
    @DisplayName("Проверка получения баланса кредитной карты")
    public void testCreditCardBalance() {
        CreditCardInterface creditCard = new CreditCard("Credit Card", "USD", 1000, 0.1);
        assertEquals(1000, creditCard.getBalance());
    }

    /**
     * Тест на проверку получения баланса банковского вклада.
     */
    @Test
    @Tag("positive")
    @DisplayName("Проверка получения баланса банковского вклада")
    public void testDepositBalance() {
        DepositInterface deposit = new Deposit("Deposit", "USD", 1000);
        assertEquals(1000, deposit.getBalance());
    }

    /**
     * Тест на проверку пополнения дебетовой карты.
     */
    @Test
    @Tag("positive")
    @DisplayName("Проверка пополнения дебетовой карты")
    public void testDebitCardTopUp() {
        CardInterface debitCard = new DebitCard("Debit Card", "USD", 1000);
        debitCard.topUp(500);
        assertEquals(1500, debitCard.getBalance());
    }

    /**
     * Тест на проверку пополнения кредитной карты.
     */
    @Test
    @Tag("positive")
    @DisplayName("Проверка пополнения кредитной карты")
    public void testCreditCardTopUp() {
        CreditCardInterface creditCard = new CreditCard("Credit Card", "USD", -1000, 0.1);
        creditCard.topUp(500);
        assertEquals(-500, creditCard.getBalance());
        assertEquals(500, creditCard.getDebt());
    }

    /**
     * Тест на проверку пополнения банковского вклада.
     */
    @Test
    @Tag("positive")
    @DisplayName("Проверка пополнения банковского вклада")
    public void testDepositTopUp() {
        DepositInterface deposit = new Deposit("Deposit", "USD", 1000);
        deposit.topUp(500);
        assertEquals(1500, deposit.getBalance());
    }

    /**
     * Тест на проверку списания с дебетовой карты.
     */
    @Test
    @Tag("positive")
    @DisplayName("Проверка списания с дебетовой карты")
    public void testDebitCardWithdraw() {
        CardInterface debitCard = new DebitCard("Debit Card", "USD", 1000);
        debitCard.withdraw(500);
        assertEquals(500, debitCard.getBalance());
    }

    /**
     * Тест на проверку списания с кредитной карты.
     */
    @Test
    @Tag("positive")
    @DisplayName("Проверка списания с кредитной карты")
    public void testCreditCardWithdraw() {
        CreditCardInterface creditCard = new CreditCard("Credit Card", "USD", 1000, 0.1);
        creditCard.withdraw(500);
        assertEquals(500, creditCard.getBalance());
        assertEquals(0, creditCard.getDebt());
    }

    /**
     * Тест на проверку закрытия банковского вклада.
     */
    @Test
    @Tag("positive")
    @DisplayName("Проверка закрытия банковского вклада")
    public void testDepositClose() {
        DepositInterface deposit = new Deposit("Deposit", "USD", 1000);
        deposit.closeDeposit();
        assertEquals(0, deposit.getBalance());
    }

    /**
     * Тест на проверку установки отрицательного баланса банковского вклада.
     * Ожидается, что будет выброшено исключение IllegalArgumentException.
     */
    @Test
    @Tag("positive")
    @DisplayName("Проверка установки отрицательного баланса кредитной карты")
    public void testCreditCardSetNegativeBalance() {
        CreditCardInterface creditCard = new CreditCard("Credit Card", "USD", -1000, 0.1);
        assertEquals(-1000, creditCard.getBalance());
        assertEquals(1000, creditCard.getDebt());
    }

    /**
     * Тест на проверку пополнения дебетовой карты с отрицательной суммой.
     * Ожидается, что будет выброшено исключение IllegalArgumentException.
     */
    @Test
    @Tag("negative")
    @DisplayName("Проверка пополнения дебетовой карты с отрицательной суммой")
    public void testDebitCardTopUp_InvalidAmount_Negative() {
        CardInterface debitCard = new DebitCard("Debit Card", "USD", 1000);

        assertThrows(IllegalArgumentException.class, () -> {
            debitCard.topUp(-500);
        });
    }

    /**
     * Тест на проверку пополнения кредитной карты с отрицательной суммой.
     * Ожидается, что будет выброшено исключение IllegalArgumentException.
     */
    @Test
    @Tag("negative")
    @DisplayName("Проверка пополнения кредитной карты с отрицательной суммой")
    public void testCreditCardTopUp_InvalidAmount_Negative() {
        CreditCardInterface creditCard = new CreditCard("Credit Card", "USD", 1000, 0.1);

        assertThrows(IllegalArgumentException.class, () -> {
            creditCard.topUp(-500);
        });
    }

    /**
     * Тест на проверку пополнения банковского вклада с отрицательной суммой.
     * Ожидается, что будет выброшено исключение IllegalArgumentException.
     */
    @Test
    @Tag("negative")
    @DisplayName("Проверка пополнения банковского вклада с отрицательной суммой")
    public void testDepositTopUp_InvalidAmount_Negative() {
        DepositInterface deposit = new Deposit("Deposit", "USD", 1000);

        assertThrows(IllegalArgumentException.class, () -> {
            deposit.topUp(-500);
        });
    }

    /**
     * Тест на проверку списания с дебетовой карты с отрицательной суммой.
     * Ожидается, что будет выброшено исключение IllegalArgumentException.
     */
    @Test
    @Tag("negative")
    @DisplayName("Проверка списания с дебетовой карты с отрицательной суммой")
    public void testDebitCardWithdraw_InvalidAmount_Negative() {
        CardInterface debitCard = new DebitCard("Debit Card", "USD", 1000);

        assertThrows(IllegalArgumentException.class, () -> {
            debitCard.withdraw(-500);
        });
    }

    /**
     * Тест на проверку списания с кредитной карты с отрицательной суммой.
     * Ожидается, что будет выброшено исключение IllegalArgumentException.
     */
    @Test
    @Tag("negative")
    @DisplayName("Проверка кредитной карты с отрицательной суммой")
    public void testCreditCardWithdraw_InvalidAmount_Negative() {
        CreditCardInterface creditCard = new CreditCard("Credit Card", "USD", 1000, 0.1);

        assertThrows(IllegalArgumentException.class, () -> {
            creditCard.withdraw(-500);
        });
    }

    /**
     * Тест на проверку установки отрицательного баланса дебетовой карты.
     * Ожидается, что будет выброшено исключение IllegalArgumentException.
     */
    @Test
    @Tag("negative")
    @DisplayName("Проверка установки отрицательного баланса дебетовой карты")
    public void testDebitCardSetBalance_InvalidBalance_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DebitCard("Debit Card", "USD", -500);
        });
    }

    /**
     * Тест на проверку установки отрицательного баланса банковского вклада.
     * Ожидается, что будет выброшено исключение IllegalArgumentException.
     */
    @Test
    @Tag("negative")
    @DisplayName("Проверка установки отрицательного баланса банковского вклада")
    public void testDepositSetBalance_InvalidBalance_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Deposit("Deposit", "USD", -500);
        });
    }
}