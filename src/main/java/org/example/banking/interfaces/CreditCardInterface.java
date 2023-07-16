package org.example.banking.interfaces;

/**
 * Интерфейс кредитной карты банка.
 * Наследует интерфейсы BankProductInterface и CardInterface.
 *
 * @see BankProductInterface
 * @see CardInterface
 * @author Петр Белинский
 */
public interface CreditCardInterface extends BankProductInterface, CardInterface {

    /**
     * Возвращает текущую задолженность по кредитной карте.
     *
     * @return текущая задолженность по кредитной карте
     */
    double getDebt();

    /**
     * Возвращает процентную ставку кредитной карты.
     *
     * @return процентная ставка кредитной карты
     */
    double getInterestRate();
}