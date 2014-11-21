package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent {
    private String value;
    private List<TextComponent> textComponents;
    /**
     *
     * @param value
     */

    public void setValue(String value) {
        this.value = value;
    }

    public TextComponent(String value) {
        this.value = value;
        textComponents = new ArrayList<TextComponent>();
    }
    public TextComponent(){
        textComponents = new ArrayList<TextComponent>();
    }

    public List<TextComponent> getTextComponents() {
        return textComponents;
    }

    public void add(TextComponent textComponent){
        textComponents.add(textComponent);
    }

    public void remove(TextComponent textComponent){
        textComponents.remove(textComponent);
    }

    public String toString() {
        return value;
    }
}
