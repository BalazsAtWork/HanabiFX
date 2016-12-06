package de.novatec.cg.sc.hanabi.common.enums;

public enum Number {
    ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5");

    private final String displayValue;

    private Number(String displayValue) {
        this.displayValue = displayValue;
    }

    public String displayValue() {
        return displayValue;
    }
}
