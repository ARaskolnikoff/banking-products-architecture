package org.example.banking.helpers;

/**
 * Класс, предоставляющий вспомогательные методы для валидации значений.
 *
 * @author Петр Белинский
 */
public class ValidateHelper {

    /**
     * Проверяет, что значение неотрицательное.
     *
     * @param <T>   тип значения, должен быть подклассом {@link Number}
     * @param value значение для проверки
     * @throws IllegalArgumentException если значение отрицательное
     */
    public static <T extends Number> void validateNonNegative(T value) {
        if (value.doubleValue() < 0) {
            throw new IllegalArgumentException("Значение не может быть отрицательным!");
        }
    }
}