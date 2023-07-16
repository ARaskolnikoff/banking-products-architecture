package org.example.banking.interfaces;

/**
 * Интерфейс продукта банка.
 *
 * @author Петр Белинский
 */
public interface BankProductInterface {

    /**
     * Возвращает название продукта.
     *
     * @return название продукта
     */
    String getName();

    /**
     * Возвращает валюту счета.
     *
     * @return валюта счета
     */
    String getCurrency();

    /**
     * Возвращает баланс счета.
     *
     * @return баланс счета
     */
    double getBalance();

    /**
     * Пополняет счет на указанную сумму.
     * Сумма должна быть неотрицательной.
     *
     * @param moneyAmount сумма пополнения
     */
    void topUp(double moneyAmount);
}
