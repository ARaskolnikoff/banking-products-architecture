package org.example.banking.products;

import org.example.banking.abstracts.AbstractBankProduct;
import org.example.banking.interfaces.DepositInterface;

import static org.example.banking.helpers.ValidateHelper.validateNonNegative;

/**
 * Реализация банковского вклада.
 * Наследует абстрактный класс AbstractBankProduct и реализует интерфейс DepositInterface.
 *
 * @see AbstractBankProduct
 * @see DepositInterface
 * @author Петр Белинский
 */
public class Deposit extends AbstractBankProduct implements DepositInterface {

    /**
     * Конструктор класса Deposit.
     *
     * @param name     название вклада
     * @param currency валюта вклада
     * @param balance  баланс вклада, должен быть неотрицательным
     *
     */
    public Deposit(String name, String currency, double balance) {
        super(name, currency, balance);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void closeDeposit() {
        setBalance(0);
    }

    /**
     * {@inheritDoc}
     * Баланс должен быть неотрицательным.
     */
    @Override
    protected void setBalance(double balance) {
        try {
            validateNonNegative(balance);
            this.balance = balance;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Баланс вклада не может быть отрицательным!");
        }
    }
}