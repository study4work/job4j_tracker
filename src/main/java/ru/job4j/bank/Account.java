package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс является моделью данных для банковского аккаунта.
 */
public class Account {
    /**
     * переменные экземпля класа для названия реквизитов и значения баланса.
     */
    private String requisite;
    private double balance;

    /**
     * конструктор класса.
     * @param requisite реквизиты.
     * @param balance баланс.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер для реквизитов.
     * @return Название реквизитов.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер для реквизитов
     * @param requisite позволяет установить значение для созданного экземпляра класса.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * геттер для баланса.
     * @return значение баланса.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * сеттре для баланса.
     * @param balance позволяет установить знаение для созданного экземпляра класса.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}