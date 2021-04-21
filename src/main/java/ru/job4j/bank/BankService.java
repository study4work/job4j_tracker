package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
            if (!users.get(user).contains(account)) {
                 users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user: users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        for (Account acc : accounts) {
            if (acc.getRequisite().equals(requisite)) {
                return acc;
            }
        }
        return  null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Account accountsrc = findByRequisite(srcPassport,srcRequisite);
        Account accountdest = findByRequisite(destPassport,destRequisite);
        if (accountsrc == null || accountdest == null || accountsrc.getBalance() <= 0) {
            rsl = false;
        } else {
            accountdest.setBalance(accountdest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}