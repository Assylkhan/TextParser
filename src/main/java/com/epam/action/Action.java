package com.epam.action;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import com.epam.entity.TextComponent;

public class Action {
    /**
     *
     * @param text
     * @param wordLength that begins with consonant letter
     * @return text object
     */
    public static TextComponent removeFromText(TextComponent text, int wordLength){
        TextComponent newText = new TextComponent();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("constants", Locale.getDefault());
        Pattern p = Pattern.compile(resourceBundle.getString("consonants")); //words that start with consonant letters
        for (TextComponent sentence : text.getTextComponents()){
            TextComponent newSentence = new TextComponent();
            for (TextComponent token : sentence.getTextComponents()){
                //we don't add words to container that match wordLength and begin with consonant letter
                if (!(token.toString().length() == wordLength && p.matcher(token.toString()).find()))
                    newSentence.add(token);
            }
            newText.add(newSentence);
        }
        return newText;
    }
}