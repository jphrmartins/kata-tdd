package br.com.ubots.katatdd;

public class CalculatorString {
    public int sum(String expresion) {
        if (expresion.isEmpty()){
            return 0;
        } else if (expresion.trim().length() == 1){
            return Integer.parseInt(expresion.trim());
        }
        return sumValues(expresion);
    }

    private int sumValues(String expresion) {
        expresion = limpaExpressao(expresion);
        String[] expresionSplited = expresion.split("[,]");
        int result = 0;
        for (int i = 0; i < expresionSplited.length; i++){
            result += Integer.parseInt(expresionSplited[i]);
        }
        return result;
    }

    private String limpaExpressao(String expresion) {
        return expresion.replaceAll("\n", "");
    }
}
