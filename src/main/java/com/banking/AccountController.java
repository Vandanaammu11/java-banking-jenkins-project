
package com.banking;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountNumber}")
    public Account getAccount(
            @PathVariable String accountNumber) {

        if (!accountService.getAccount()
                .getAccountNumber().equals(accountNumber)) {
            throw new IllegalArgumentException(
                "Account not found"
            );
        }

        return accountService.getAccount();
    }

    @PostMapping("/{accountNumber}/deposit")
    public BigDecimal deposit(
            @PathVariable String accountNumber,
            @RequestParam BigDecimal amount) {

        validateAccount(accountNumber);

        return accountService.deposit(amount);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public BigDecimal withdraw(
            @PathVariable String accountNumber,
            @RequestParam BigDecimal amount) {

        validateAccount(accountNumber);

        return accountService.withdraw(amount);
    }

    private void validateAccount(String accountNumber) {
        if (!accountService.getAccount()
                .getAccountNumber().equals(accountNumber)) {
            throw new IllegalArgumentException(
                "Account not found"
            );
        }
    }
}
