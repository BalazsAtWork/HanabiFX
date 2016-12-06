package de.novatec.cg.sc.hanabi.common;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.Number;

public class Card {

    @SerializedName("color")
    private Color color;

    @SerializedName("number")
    private Number number;

    public Card() {
    }

    public Card(Color color, Number number) {
        this.color = color;
        this.number = number;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Card [color=" + color + ", number=" + number + "]";
    }
}
