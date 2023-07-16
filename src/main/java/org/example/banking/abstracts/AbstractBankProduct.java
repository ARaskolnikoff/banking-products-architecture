package org.example.banking.abstracts;

import org.example.banking.interfaces.BankProductInterface;

import static org.example.banking.helpers.ValidateHelper.validateNonNegative;

/**
 * Абстрактный класс продукта банка.
 * Реализует интерфейс BankProductInterface.
 *
 * @see BankProductInterface
 * @author Петр Белинский
 */
public abstract class AbstractBankProduct implements BankProductInterface {
    private final String name;
    private final String currency;
    protected double balance;

    /**
     * Конструктор абстрактного класса AbstractBankProduct.
     *
     * @param name     название продукта
     * @param currency валюта счета
     * @param balance  баланс счета
     */
    public AbstractBankProduct(String name, String currency, double balance) {
        this.name = name;
        this.currency = currency;
        setBalance(balance);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCurrency() {
        return currency;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает баланс счета.
     *
     * @param balance новый баланс счета
     */
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void topUp(double moneyAmount) {
        try {
            validateNonNegative(moneyAmount);
            setBalance(getBalance() + moneyAmount);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Сумма пополнения не может быть отрицательной!");
        }
    }
}