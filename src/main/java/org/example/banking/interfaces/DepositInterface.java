package org.example.banking.interfaces;

/**
 * Интерфейс бансковского вклада.
 * Наследует интерфейс BankProductInterface.
 *
 * @see BankProductInterface
 * @author Петр Белинский
 */
public interface DepositInterface extends BankProductInterface {

    /**
     * Закрывает банковский вклад.
     */
    void closeDeposit();
}