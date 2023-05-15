package com.apple.bank.exception;

/**
 * @ author Egcoo
 * @ date 2023/4/29 - 14:56
 * <p>
 * 余额不足
 */
public class MoneyNotEnoughException extends Exception {

    public MoneyNotEnoughException() {

    }

    public MoneyNotEnoughException(String message) {
        super(message);
    }
}

