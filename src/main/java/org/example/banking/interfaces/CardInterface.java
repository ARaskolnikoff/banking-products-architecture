package org.example.banking.interfaces;

/**
 * Интерфейс карты банка.
 * Наследует интерфейс BankProductInterface.
 *
 * @see BankProductInterface
 * @author Петр Белинский
 */
public interface CardInterface extends BankProductInterface {

    /**
     * Списывает указанную сумму со счета.
     * Сумма должна быть неотрицательной.
     *
     * @param moneyAmount сумма списания
     */
    void withdraw(double moneyAmount);
}