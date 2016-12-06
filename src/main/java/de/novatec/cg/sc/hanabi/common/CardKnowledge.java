package de.novatec.cg.sc.hanabi.common;

import java.util.HashSet;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.Number;

public class CardKnowledge {

    @SerializedName("knows_color")
    private boolean knowsColor;

    @SerializedName("knows_number")
    private boolean knowsNumber;

    @SerializedName("knows_color_not")
    private HashSet<Color> knowsColorNot = new HashSet<>();

    @SerializedName("knows_number_not")
    private HashSet<Number> knowsNumberNot = new HashSet<>();

    public boolean playerKnowsColor() {
        return knowsColor;
    }

    public void setPlayerKnowsColor(boolean knowsColor) {
        this.knowsColor = knowsColor;
    }

    public boolean playerKnowsNumber() {
        return knowsNumber;
    }

    public void setPlayerKnowsNumber(boolean knowsNumber) {
        this.knowsNumber = knowsNumber;
    }

    public HashSet<Color> getKnowsColorNot() {
        return knowsColorNot;
    }

    public HashSet<Number> getKnowsNumberNot() {
        return knowsNumberNot;
    }

    @Override
    public String toString() {
        return "CardKnowledge [knowsColor=" + knowsColor + ", knowsNumber=" + knowsNumber + ", knowsColorNot=" + knowsColorNot + ", knowsNumberNot="
                + knowsNumberNot + "]";
    }

}
