package br.com.ubots.katatdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private Matcher singleMatcher;
    private Matcher multipleMatcher;

    public Delimiter(String expression) {
        this.singleMatcher = Pattern.compile("(^[\\/]{2})([\\W]{1})\\n").matcher(expression);
        this.multipleMatcher = Pattern.compile("(?<=\\[)([^\\[\\]]+)(?=\\])").matcher(expression);
    }

    public String getDelimiters() {
        if (singleMatcher.find()) {
            return singleMatcher.group(2);
        } else if (multipleMatcher.find()) {
            return getMultipleDelimiters();
        }
        return ",|\n";
    }

    private String getMultipleDelimiters() {
        this.multipleMatcher = this.multipleMatcher.reset();
        StringBuffer delimiters = new StringBuffer();
        while (multipleMatcher.find()){
            delimiters.append(multipleMatcher.group() + "|");
        }
        return delimiters.substring(0, delimiters.length() - 1);
    }

}
