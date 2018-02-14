package br.com.ubots.katatdd;

import br.com.ubots.katatdd.exception.NegativeNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorString {
    private Delimiter delimeter = new Delimiter();

    public int sum(String expression) {
        if (expression.isEmpty()) {
            return 0;
        } else if (expression.trim().length() == 1) {
            return Integer.parseInt(expression.trim());
        }
        return sumValues(expression);
    }

    private int sumValues(String expression) {
        String[] expressionSplited = getSplitDelimiters(expression);
        List<Integer> expressionClean = ignoreNotAllowedNumbers(expressionSplited);
        List<Integer> negativeNumbers = new ArrayList<>();
        int result = 0;
        for (Integer value: expressionClean){
            if (value < 0) {
                negativeNumbers.add(value);
            }
            result += value;
        }
        if (!negativeNumbers.isEmpty()) {
            throw new NegativeNumberException(get(negativeNumbers));
        }
        return result;
    }

    private List<Integer> ignoreNotAllowedNumbers(String[] expressionSplited) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < expressionSplited.length; i++) {
            if (!expressionSplited[i].isEmpty()){
                int value = Integer.parseInt(expressionSplited[i]);
                if (value <= 1000){
                    numbers.add(value);
                }
            }
        }
        return numbers;
    }

    private String get(List<Integer> negativeNumbers) {
        String numbers = "";
        for (Integer negative : negativeNumbers) {
            numbers += negative + " ";
        }
        return numbers.trim();
    }

    private String[] getSplitDelimiters(String expression) {
        String delimiters = delimeter.getDelimiters(expression);
        if (", | \n".equals(delimiters)) {
            return expression.split("[" + delimiters + "]");
        }
        String expressionSplited[] = expression.split("\\n(" + delimiters + ")*");
        String numbersPosition = expressionSplited[1];
        return numbersPosition.split("[" + delimiters + "]");

    }
}
