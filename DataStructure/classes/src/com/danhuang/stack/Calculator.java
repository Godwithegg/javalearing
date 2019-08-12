package com.danhuang.stack;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = "2+3*4-3";
        Stack<Double> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();
        char ch = ' ';
        String isNum = "";
        if(isOperator(s.charAt(0)))numStack.push(0.0);
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            if(isOperator(ch)){
                if(operStack.isEmpty()){
                    operStack.push(ch);
                }else{
                    if(i==s.length()-1){
                        operStack.push(ch);
                    }else{
                        char oper1 = operStack.peek();
                        if(prority(ch) <= prority(oper1)){
                            double num1 = numStack.pop();
                            double num2 = numStack.pop();
                            char oper = operStack.pop();
                            double res = cal(num1,num2 ,oper1 );
                            numStack.push(res);

                            if(ch =='+'||ch=='-'){
                                while(true){
                                    if(operStack.isEmpty()){
                                        break;
                                    }
                                    num1 = numStack.pop();
                                    num2 = numStack.pop();
                                    oper = operStack.pop();
                                    res = cal(num1,num2,oper);
                                    numStack.push(res);
                                }
                            }
                            operStack.push(ch);
                        }else{
                            operStack.push(ch);
                        }
                    }
                }
            }else{
                isNum+=ch;
                if(i==s.length()-1){
                    numStack.push(Double.parseDouble(isNum));
                }else{
                    char c = s.charAt(i+1);
                    if(isOperator(c)){
                        numStack.push(Double.parseDouble(isNum));
                        isNum="";
                    }
                }
            }

        }
        while(true){
            if(operStack.isEmpty()){
                break;
            }
            double num1 = numStack.pop();
            double num2 = numStack.pop();
            char oper = operStack.pop();
            double res = cal(num1,num2,oper);
            numStack.push(res);
        }
        Double pop = numStack.pop();
        System.out.printf("%.0f",pop);
    }
    public static boolean isOperator(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/';
    }
    public static int prority(char oper){
        if(oper =='+'||oper=='-'){
            return 0;
        }else if(oper=='*'||oper=='/'){
            return 1;
        }else{
            return -1;
        }
    }
    public static double cal(double num1,double num2,char oper){
        if(oper == '+'){
            return num1+num2;
        }else if(oper == '-'){
            return num2-num1;
        }else if(oper=='*'){
            return num1*num2;
        }else{
            return num2/num1;
        }
    }

}