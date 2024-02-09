package com.example.ooplqb8;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Calculater {
    private double num;
    StringBuffer strDigit;
    char operator;
    private boolean isDot;
    private boolean isWrite;

    public Calculater() {clear();}

    public String printNum() {return String.valueOf(num);}
    public String getDigit() { return strDigit.toString();}
    public void setOperator(char operator) { this.operator = operator; }

    public void addDigit(int a) {
        if (Double.valueOf(strDigit.toString()) == 0.0f && isDot == false)
            strDigit.setLength(0);
        strDigit.append(a);
        isWrite = true;
    }

    public void addDot(){
        if(isDot == false) {
            isDot = true;
            strDigit.append('.');
        }
    }

    public int calculate(){
        int result = 0;
        if(isWrite == true || operator == '√' || operator == 'C') {
            double digit = Double.valueOf(strDigit.toString());
            switch (operator) {
                case '+' -> num += digit;
                case '-' -> num -= digit;
                case '/' -> {
                    if (digit == 0.0) {
                        clear();
                        result = 1;
                    } else num /= digit;
                }
                case 'x' -> num *= digit;
                case '^' -> {
                    System.out.println(num);
                    System.out.println(digit);
                    if (Double.isNaN(num) || num < 0.0) {
                        num = Math.pow(num, digit);
                        clear();
                        result = 2;
                    }
                    System.out.println(num);
                }
                case '√' -> {
                    num = Math.sqrt(num);
                    if (Double.isNaN(num)) {
                        clear();
                        result = 2;
                    }
                }
                case 'C' -> clear();
                case '=' -> num = digit;
            }
            isDot = false;
            strDigit = new StringBuffer("0");
            isWrite = false;
            operator = '=';
        }
        return result;
    }
    private void clear() {
        isDot = false;
        strDigit = new StringBuffer("0");
        isWrite = false;
        num = 0;
        operator = '=';
    }
}
