package com.apple.bank.exception;

/**
 * @ author Egcoo
 * @ date 2023/4/29 - 15:02
 * 转账异常
 */
public class transferException extends Exception {
    public transferException() {
    }

    public transferException(String message) {
        super(message);
    }

}
