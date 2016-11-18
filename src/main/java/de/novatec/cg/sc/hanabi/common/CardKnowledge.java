package de.novatec.cg.sc.hanabi.common;

public class CardKnowledge {

    private boolean knowsColor;
    private boolean knowsNumber;

    // EXTENDED FEATURE
    //    private HashSet<Color> knowsColorNot;
    //    private HashSet<Number> knowsNumberNot;

    public CardKnowledge(boolean knowsColor, boolean knowsNumber) {
        this.knowsColor = knowsColor;
        this.knowsNumber = knowsNumber;
    }

    public boolean isKnowsColor() {
        return knowsColor;
    }

    public boolean isKnowsNumber() {
        return knowsNumber;
    }
}
