package com.example.braveui;

public class TimerItemModel {
    private final String actionText;
    private final int actionImage;

    public TimerItemModel(String actionText, int actionImage) {
        this.actionText = actionText;
        this.actionImage = actionImage;
    }

    public String getActionText() {
        return actionText;
    }

    public int getActionImage() {
        return actionImage;
    }
}
