package com.jejen.test.laundry.system.common;

public enum Operand {
    EQ("equals"),
    LK("matches"),
    NE("not equal to"),
    GT("greater than"),
    GE("greater than or equals"),
    LT("less than"),
    LE("less than or equals"),
    RG("between"),
    NR("not between"),
    CT("contains"),
    NC("not containing"),
    BW("begins with"),
    EW("ends with"),
    DNBW("does not begin with"),
    DNEW("does not end with"),
    SAID("sounds like");
    private final String text;

    private Operand(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}