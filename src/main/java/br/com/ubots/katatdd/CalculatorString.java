package br.com.ubots.katatdd;

import br.com.ubots.katatdd.exception.NegativeNumberException;

import java.util.ArrayList;
import java.util.List;

public class CalculatorString {

    public int sum(String expression) {
        if (expression.isEmpty()) {
            return 0;
        } else if (expression.trim().length() == 1) {
            return Integer.parseInt(expression.trim());
        }
        return getResult(expression);
    }

    private int getResult(String expression) {
        String[] expressionSplited = getSplitDelimiters(expression);
        List<Integer> expressionClean = ignoreOverThousandValues(expressionSplited);
        return sumValues(expressionClean);
    }

    private String[] getSplitDelimiters(String expression) {
        Delimiter delimiter = new Delimiter(expression);
        String delimiters = delimiter.getDelimiters();
        if (",|\n".equals(delimiters)) {
            return expression.split(delimiters);
        }
        return getCustomDelimiters(expression, delimiters);
    }

    private String[] getCustomDelimiters(String expression, String delimiters) {
        String expressionSplited[] = expression.split("\\n");
        String numbersPosition = expressionSplited[1];
        return numbersPosition.split(delimiters);
    }

    private List<Integer> ignoreOverThousandValues(String[] expressionSplited) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < expressionSplited.length; i++) {
            int value = Integer.parseInt(expressionSplited[i]);
            if (value <= 1000) {
                numbers.add(value);
            }
        }
        return numbers;
    }


    private int sumValues(List<Integer> expressionClean) {
        List<Integer> negativeNumbers = new ArrayList<>();
        int result = 0;
        for (Integer value : expressionClean) {
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

    private String get(List<Integer> negativeNumbers) {
        String numbers = "";
        for (Integer negative : negativeNumbers) {
            numbers += negative + " ";
        }
        return numbers.trim();
    }
}