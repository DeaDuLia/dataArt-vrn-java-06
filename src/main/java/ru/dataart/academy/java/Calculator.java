package ru.dataart.academy.java;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

public class Calculator {
    private interface Calculation {
        int run(String text, int count);
    }

    /**
     * @param zipFilePath -  path to zip archive with text files
     * @param character   - character to find
     * @return - how many times character is in files
     */

    public Integer getNumberOfChar(String zipFilePath, char character) {
        Calculation calculation = (word, count) -> word.contains(""+character)? count+1 : count;
        return doCalculationInZipFile(zipFilePath, calculation);
    }

    /**
     * @param zipFilePath - path to zip archive with text files
     * @return - max length
     */

    public Integer getMaxWordLength(String zipFilePath) {
        Calculation calculation = (word, count) -> Math.max(word.length(), count);
        return doCalculationInZipFile(zipFilePath, calculation);
    }

    private Integer doCalculationInZipFile(String zipFilePath, Calculation calculation) {
        if (zipFilePath == null) return 0;
        int counter = 0;
        try(ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFilePath))) {
            while((zip.getNextEntry())!= null){
                Scanner in = new Scanner(zip);
                String text;
                while (in.hasNextLine()) {
                    text = in.next();
                    counter = calculation.run(text, counter);
                }
            }
        } catch(Exception ignored){}
        return counter;
    }

}
