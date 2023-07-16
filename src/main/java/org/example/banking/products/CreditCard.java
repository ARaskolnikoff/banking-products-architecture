package org.example.banking.products;

import org.example.banking.abstracts.AbstractBankProduct;
import org.example.banking.interfaces.CreditCardInterface;

import static org.example.banking.helpers.ValidateHelper.validateNonNegative;

/**
 * Реализация кредитной карты банка.
 * Наследует абстрактный класс AbstractBankProduct и реализует интерфейс CreditCardInterface.
 *
 * @see AbstractBankProduct
 * @see CreditCardInterface
 * @author Петр Белинский
 */
public class CreditCard extends AbstractBankProduct implements CreditCardInterface {
    protected double interestRate;
    protected double debt;

    /**
     * Конструктор класса CreditCard.
     *
     * @param name         название кредитной карты
     * @param currency     валюта кредитной карты
     * @param balance      баланс кредитной карты
     * @param interestRate процентная ставка кредитной карты, не должна быть отрицательной
     */
    public CreditCard(String name, String currency, double balance, double interestRate) {
        super(name, currency, balance);
        setDebt();
        setInterestRate(interestRate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getDebt() {
        return debt;
    }

    /**
     * Возвращает процентную ставку кредитной карты.
     *
     * @return процентная ставка кредитной карты
     */
    @Override
    public double getInterestRate(){
        return interestRate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void topUp(double moneyAmount) {
        try {
            validateNonNegative(moneyAmount);
            setBalance(getBalance() + moneyAmount);
            setDebt();
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Сумма пополнения не может быть отрицательной!");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void withdraw(double moneyAmount) {
        try {
            validateNonNegative(moneyAmount);
            setBalance(getBalance() - moneyAmount);
            setDebt();
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Сумма списания не может быть отрицательной!");
        }
    }

    /**
     * Устанавливает задолженность по кредитной карте.
     */
    protected void setDebt() {
        if (getBalance() >= 0) {
            this.debt = 0;
        } else {
            this.debt = 0 - getBalance();
        }
    }

    /**
     * Устанавливает процентную ставку кредитной карты.
     */
    protected void setInterestRate(double interestRate) {
        try {
            validateNonNegative(interestRate);
            this.interestRate = interestRate;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Процентная ставка кредитной карты не может быть отрицательной!");
        }
    }
}