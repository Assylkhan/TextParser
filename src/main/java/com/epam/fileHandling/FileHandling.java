package com.epam.fileHandling;

import java.io.*;
import com.epam.entity.TextComponent;
import com.epam.textHandler.TextHandler;
import org.apache.log4j.Logger;

public class FileHandling {
    private static final Logger logger = Logger.getLogger(FileHandling.class);
    public static void write(TextComponent text, String path){
        String stringedText = TextHandler.textToString(text);
        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter(path);
            printWriter.print(stringedText);
        } catch(FileNotFoundException e){
            logger.debug(e);
        } finally {
            printWriter.close();
        }
    }

    public static StringBuilder read(String file) throws IOException {
        InputStream inputStream = FileHandling.class.getClassLoader().getResourceAsStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        StringBuilder stringBuilder = new StringBuilder();
        while ((s=bufferedReader.readLine())!=null){
            stringBuilder.append(s);
        }
        return stringBuilder;
    }
}