package de.novatec.cg.sc.hanabi.common;

import java.util.HashSet;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.Color;

public class CardKnowledge {

    @SerializedName("knowns_color")
    private boolean knowsColor;

    @SerializedName("knowns_number")
    private boolean knowsNumber;

    @SerializedName("knowns_color_not")
    private HashSet<Color> knowsColorNot;

    @SerializedName("knowns_number_not")
    private HashSet<Number> knowsNumberNot;

    public boolean playerKnowsColor() {
        return knowsColor;
    }

    public boolean playerKnowsNumber() {
        return knowsNumber;
    }

}
