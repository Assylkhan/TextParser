package com.epam.textHandler;

import com.epam.entity.TextComponent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler {
    public static TextComponent parse(StringBuilder stringBuilder) throws NullPointerException{
        Pattern p = Pattern.compile("(\\S.+?[.!?])(?=\\s+|$)");
        Matcher sentenceMatcher = p.matcher(stringBuilder);
        TextComponent text = new TextComponent();
        while(sentenceMatcher.find()){
            TextComponent newSentence = new TextComponent();
            Matcher tokenMatcher = Pattern.compile("([\\w':;-]+)|([.,!?])").matcher(sentenceMatcher.group());
            while (tokenMatcher.find()){
                TextComponent token = new TextComponent(tokenMatcher.group());
                newSentence.add(token);
            }
            text.add(newSentence);
        }
        return text;
    }
    public static String textToString(TextComponent text){
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent sentence : text.getTextComponents()){
            stringBuilder.append(sentenceToString(sentence));
        }
        return String.valueOf(stringBuilder).replaceAll("[\\n]{2,}", "\n").replaceAll("[\\s]{2,}", " ");
    }
    public static String sentenceToString(TextComponent sentence){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= sentence.getTextComponents().size()-1; i++) {
            if (i!=sentence.getTextComponents().size()-2)
                stringBuilder.append(sentence.getTextComponents().get(i).toString()+" ");
            else
                stringBuilder.append(sentence.getTextComponents().get(i).toString());
        }
        return String.valueOf(stringBuilder);

    }
}