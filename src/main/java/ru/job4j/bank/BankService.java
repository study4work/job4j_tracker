package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс осуществляет минимальный набор функций для банковского сервиса.
 */
public class BankService {
    /**
     * Хранилище данных в HashMap
     * key модель данных User
     * set модель данных Account
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового юзера в мапу,если такового еще нет.
     * @param user юзер.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавляет аккаунт в мапу,находя user по пасспорту,
     * если пользователь существует и не содержит данный аккаунт.
     * @param passport User для которого нужно добавить аккаунт.
     * @param account который нужно добавить к user.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод находит пользователя по пасспорту.
     * @param passport user которого нужно найти.
     * @return возвращет искомого User.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет аккаунт в значении листа аккантов в хашмапе по реквизитам аккаунта.
     * @param passport по которому нужно найти User.
     * @param requisite по которым нам нужно найти Account.
     * @return искомы Account из списка аккаунтов.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account acc : accounts) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денег с одного Account на другой,
     * если они существуют и на них есть нужная сумма.
     * @param srcPassport паспорт аккаунта с которого переводим.
     * @param srcRequisite реквизиты аккаунта с которого переводим.
     * @param destPassport поспорт аккаунта на который переводим.
     * @param destRequisite реквизиты аккаута на который переводим.
     * @param amount значение которое переводим.
     * @return true в случае,если перевод осуществелен.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountsrc = findByRequisite(srcPassport, srcRequisite);
        Account accountdest = findByRequisite(destPassport, destRequisite);
        if (accountsrc != null && accountdest != null && accountsrc.getBalance() >= amount) {
            accountdest.setBalance(accountdest.getBalance() + amount);
            accountsrc.setBalance(accountsrc.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}