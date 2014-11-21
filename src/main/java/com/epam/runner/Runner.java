package com.epam.runner;

import com.epam.action.Action;
import com.epam.entity.TextComponent;
import com.epam.fileHandling.FileHandling;
import com.epam.textHandler.TextHandler;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Runner {
    private static Logger logger = Logger.getLogger(Runner.class);
    public static void main(String[] args) {
        TextComponent text = new TextComponent();
        TextComponent changedText = new TextComponent();
        try {
            text = TextHandler.parse(FileHandling.read("text.txt"));
            changedText = Action.removeFromText(text, 3);
            FileHandling.write(text, "D:/textParser.txt");
        } catch (IOException e){
            logger.debug(e);
        } catch (NullPointerException e){
            logger.debug(e);
        } catch (Exception e){
            logger.debug(e);
        }
        logger.info(TextHandler.textToString(text));
        logger.info(TextHandler.textToString(changedText));
    }
}
