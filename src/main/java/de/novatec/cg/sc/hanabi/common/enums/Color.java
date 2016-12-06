package de.novatec.cg.sc.hanabi.common.enums;

public enum Color {
    BLUE(javafx.scene.paint.Color.BLUE, javafx.scene.paint.Color.WHITE), GREEN(javafx.scene.paint.Color.GREEN, javafx.scene.paint.Color.WHITE), RED(
            javafx.scene.paint.Color.RED, javafx.scene.paint.Color.WHITE), WHITE(javafx.scene.paint.Color.WHITE,
                    javafx.scene.paint.Color.BLACK), YELLOW(javafx.scene.paint.Color.YELLOW, javafx.scene.paint.Color.BLACK);

    private final javafx.scene.paint.Color fxColor;
    private final javafx.scene.paint.Color fxNumberColor;

    private Color(javafx.scene.paint.Color fxCardColor, javafx.scene.paint.Color fxNumberColor) {
        this.fxColor = fxCardColor;
        this.fxNumberColor = fxNumberColor;
    }

    public javafx.scene.paint.Color getFxColor() {
        return fxColor;
    }

    public javafx.scene.paint.Color getFxNumberColor() {
        return fxNumberColor;
    }
}
