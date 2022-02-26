package com.jejen.test.laundry.system.common;

import java.util.Arrays;
import java.util.NoSuchElementException;


public enum LaundryType {
    ACCOUNT_NUMBER(""),
    ALPHABETIC(""),
    ALPHANUMERIC(""),
    ANY_CHARACTER(""),
    AMOUNT(""),
    COMPANY_CODE(""),
    CURRENCY_CODE(""),
    CUSTOMER_NUMBER(""),
    DATE(""),
    FREQUENCY(""),
    MNEMONIC(""),
    NUMERIC(""),
    PROGRAM_NAME(""),
    DEPT_ACCOUNT_OFFICER("");

    private final String[] routines;

    private LaundryType(String... routines) {
        this.routines = routines;
    }

    public static LaundryType getByRoutine(String routine){
        LaundryType result =  ANY_CHARACTER;
        try{
            result = Arrays.stream(LaundryType.values()).filter(f-> Arrays.stream(f.routines).anyMatch(d->d.equals(routine))).findFirst().get();
        }catch (NoSuchElementException ex){

        }
        return result;
    }
}
