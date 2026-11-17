
package com.banking;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Test
    void testDeposit() {

        AccountService service = new AccountService();

        BigDecimal result =
            service.deposit(new BigDecimal("500"));

        assertEquals(
            0,
            new BigDecimal("1500.00").compareTo(result)
        );
    }

    @Test
    void testWithdraw() {

        AccountService service = new AccountService();

        BigDecimal result =
            service.withdraw(new BigDecimal("200"));

        assertEquals(
            0,
            new BigDecimal("800.00").compareTo(result)
        );
    }

    @Test
    void testInsufficientBalance() {

        AccountService service = new AccountService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.withdraw(
                new BigDecimal("2000")
            )
        );
    }
}
