
package com.banking;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final Account account =
        new Account(
            "1001",
            "Customer",
            new BigDecimal("1000.00")
        );

    public Account getAccount() {
        return account;
    }

    public BigDecimal deposit(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be positive"
            );
        }

        BigDecimal newBalance =
            account.getBalance().add(amount);

        account.setBalance(newBalance);

        return newBalance;
    }

    public BigDecimal withdraw(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be positive"
            );
        }

        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException(
                "Insufficient balance"
            );
        }

        BigDecimal newBalance =
            account.getBalance().subtract(amount);

        account.setBalance(newBalance);

        return newBalance;
    }
}
