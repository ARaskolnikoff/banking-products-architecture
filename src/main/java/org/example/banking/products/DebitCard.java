package org.example.banking.products;

import org.example.banking.abstracts.AbstractBankProduct;
import org.example.banking.interfaces.CardInterface;

import static org.example.banking.helpers.ValidateHelper.validateNonNegative;

/**
 * Реализация дебетовой карты банка.
 * Наследует абстрактный класс AbstractBankProduct и реализует интерфейс CardInterface.
 *
 * @see AbstractBankProduct
 * @see CardInterface
 * @author Петр Белинский
 */
public class DebitCard extends AbstractBankProduct implements CardInterface {

    /**
     * Конструктор класса DebitCard.
     *
     * @param name     название дебетовой карты
     * @param currency валюта дебетовой карты
     * @param balance  баланс дебетовой карты, должен быть неотрицательным
     *
     */
    public DebitCard(String name, String currency, double balance) {
        super(name, currency, balance);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void withdraw(double moneyAmount) {
        try {
            validateNonNegative(moneyAmount);
            setBalance(getBalance() - moneyAmount);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Сумма списания не может быть отрицательной!");
        }
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
            throw new IllegalArgumentException("Баланс дебетовой карты не может быть отрицательным!");
        }
    }
}
