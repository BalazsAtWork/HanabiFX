package de.novatec.cg.sc.hanabi.common;

import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.Number;

public class Card {
    private final Color color;
    private final Number number;

    public Card(Color color, Number number) {
        this.color = color;
        this.number = number;
    }

    public Color getColor() {
        return color;
    }

    public Number getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Card [color=" + color + ", number=" + number + "]";
    }
}