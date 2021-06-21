package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод находит пользователя по пасспорту.
     * @param passport user которого нужно найти.
     * @return возвращет искомого User.
     */
    public Optional<User> findByPassport(String passport) {
      return users.keySet()
              .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет аккаунт в значении листа аккантов в хашмапе по реквизитам аккаунта.
     * @param passport по которому нужно найти User.
     * @param requisite по которым нам нужно найти Account.
     * @return искомы Account из списка аккаунтов.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
            return user.flatMap(value -> users.get(value).stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst());
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
        Optional<Account> accountsrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountdest = findByRequisite(destPassport, destRequisite);
        if (accountsrc.isPresent() && accountdest.isPresent()
                && accountsrc.get().getBalance() >= amount) {
            accountdest.get().setBalance(accountdest.get().getBalance() + amount);
            accountsrc.get().setBalance(accountsrc.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}