
package com.banking;

import java.math.BigDecimal;

public class Account {

    private String accountNumber;
    private String customerName;
    private BigDecimal balance;

    public Account(String accountNumber,
                   String customerName,
                   BigDecimal balance) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
