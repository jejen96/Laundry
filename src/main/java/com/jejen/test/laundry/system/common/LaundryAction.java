package com.jejen.test.laundry.system.common;

import java.util.Arrays;

public enum LaundryAction {
    INPUT("I"), AUTHORIZE("A"), SEE("S"), DELETE("D"), REVERSE("R"), VERIFY("V");
    
    private final String action;

    LaundryAction(String i) {

        action = i;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return this.action;
    }

    public static LaundryAction parse(String f){
        return Arrays.stream(values()).filter(v->v.action.equals(f)).findAny().get();
    }
}
