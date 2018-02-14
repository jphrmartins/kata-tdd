package br.com.ubots.katatdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private Pattern pattern;
    private String delimiters;
    private Matcher matcher;

    public Delimiter() {
        this.pattern = Pattern.compile("(^[\\/]{2})([\\W]+)\\n");
        this.delimiters = ", | \n";
    }

    public String getDelimiters(String expression) {
        this.matcher = this.pattern.matcher(expression);
        if (matcher.find()){
            delimiters = matcher.group(2);
        }
        return delimiters;
    }
}
