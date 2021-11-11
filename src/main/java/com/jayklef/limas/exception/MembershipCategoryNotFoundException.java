package com.jayklef.limas.exception;

public class MembershipCategoryNotFoundException extends Exception{

    public MembershipCategoryNotFoundException() {
        super();
    }

    public MembershipCategoryNotFoundException(String message) {
        super(message);
    }

    public MembershipCategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MembershipCategoryNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MembershipCategoryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
