package com.company;

import java.util.ArrayList;

public class Ex3_2_1 {
    public static void printArrayList(ArrayList<String> arrayList){
        for(int i=0;i<arrayList.size();i++)
            System.out.println(arrayList.get(i));

    }
    public static boolean isFormula(String s){
        if(s=="0"||s=="1"||s=="2"||s=="3"||s=="4"||s=="5"||s=="6"||s=="8"||s=="9"){
            return true;
        }
        int countLeftBracket=0;
        int countRightBracket=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                countLeftBracket++;
            else if(s.charAt(i)==')')
                countRightBracket++;
        }
        if(countLeftBracket==countRightBracket)
        {
            int countActions=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='/'||s.charAt(i)=='*'||s.charAt(i)=='%')
                    countActions++;
            }
            if(countRightBracket!=countActions)
                return false;
            return isFormulaRec(s);
        }
        else return false;
    }
    public static boolean isFormulaRec(String s){
        if(s.length()==1&&s.charAt(0)==')'){
            return true;
        }
        char charAt0=s.charAt(0);
        char charAt1=s.charAt(1);

        if(charAt0=='('&&(charAt1=='0'||charAt1=='1'||charAt1=='2'||charAt1=='3'||charAt1=='4'||charAt1=='5'||charAt1=='6'||charAt1=='7'||charAt1=='8'||charAt1=='9'||charAt1=='('||charAt1=='x'))
        {
            return isFormulaRec(s.substring(1));
        }
        if(charAt0==')'&&(charAt1==')'||charAt1=='*'||charAt1=='+'||charAt1=='-'||charAt1=='/'||charAt1=='%'))
        {
            return isFormulaRec(s.substring(1));
        }
        if((charAt0=='+'||charAt0=='-'||charAt0=='*'||charAt0=='/'||charAt0=='%')&&(charAt1=='0'||charAt1=='1'||charAt1=='2'||charAt1=='3'||charAt1=='4'||charAt1=='5'||charAt1=='6'||charAt1=='7'||charAt1=='8'||charAt1=='9'||charAt1=='('||charAt1=='x'))
        {
            return isFormulaRec(s.substring(1));
        }
        if((charAt0=='0'||charAt0=='1'||charAt0=='2'||charAt0=='3'||charAt0=='4'||charAt0=='5'||charAt0=='6'||charAt0=='7'||charAt0=='8'||charAt0=='9'||charAt0=='x')&&(charAt1=='+'||charAt1=='-'||charAt1=='*'||charAt1=='/'||charAt1=='%'||charAt1==')'))
        {
            return isFormulaRec(s.substring(1));
        }
        return false;

    }
    public static boolean isFormulaArrayList(ArrayList<String> arrayList){
        if(arrayList.size()==1&&isNumeric(arrayList.get(0)))
            return true;
        int countOperetors=0;
        int countLeftBar=0;
        int countRightBar=0;
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i).equals("("))
                countLeftBar++;
            if(arrayList.get(i).equals(")"))
                countRightBar++;
            if(arrayList.get(i).equals("+")||arrayList.get(i).equals("-")||arrayList.get(i).equals("*")||arrayList.get(i).equals("/")||arrayList.get(i).equals("%"))
                countOperetors++;
        }
        if(!(countLeftBar==countRightBar&&countLeftBar==countOperetors))
            return false;
        return isFormulaRecArrayList(arrayList);
    }
    public static boolean isOperator(String s){
        if(s.equals("+")||s.equals("-")||s.equals("/")||s.equals("*")||s.equals("%"))
            return true;
        return false;
    }
    public static boolean isFormulaRecArrayList(ArrayList<String> arrayList){
        if(arrayList.size()==1&&arrayList.get(0).equals(")"))
            return true;
        String stringAt0=arrayList.get(0);
        String stringAt1=arrayList.get(1);

        if(stringAt0.equals("(")&&(isNumeric(stringAt1)||stringAt1.equals("(")))
        {
            ArrayList<String> subbedArray=new ArrayList<>();
            for(int i=1;i<arrayList.size();i++)
                subbedArray.add(arrayList.get(i));
            return isFormulaRecArrayList(subbedArray);
        }

        if(stringAt0.equals(")")&&(stringAt1.equals(")")|| isOperator(stringAt1))){
            ArrayList<String> subbedArray=new ArrayList<>();
            for(int i=1;i<arrayList.size();i++)
                subbedArray.add(arrayList.get(i));
            return isFormulaRecArrayList(subbedArray);
        }

        if(isOperator(stringAt0)&&(stringAt1.equals("(")||isNumeric(stringAt1)))
        {
            ArrayList<String> subbedArray=new ArrayList<>();
            for(int i=1;i<arrayList.size();i++)
                subbedArray.add(arrayList.get(i));
            return isFormulaRecArrayList(subbedArray);
        }
        if(isNumeric(stringAt0)&&(isOperator(stringAt1)||stringAt1.equals(")")))
        {
            ArrayList<String> subbedArray=new ArrayList<>();
            for(int i=1;i<arrayList.size();i++)
                subbedArray.add(arrayList.get(i));
            return isFormulaRecArrayList(subbedArray);
        }
        return false;








    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static boolean isBasicFormulaArrayList(ArrayList arrayList){
        boolean leftNumber=false;
        boolean rightNumber=false;
        boolean operator=false;
        boolean leftBar=false;
        boolean rightBar=false;
        // printArrayList(arrayList);
        if(arrayList.size()!=5)
            return false;
        if(arrayList.get(0).equals("("))
            leftBar=true;

        if(arrayList.get(4).equals(")"))
            rightBar=true;

        if(arrayList.get(2).equals("+")||arrayList.get(2).equals("-")||arrayList.get(2).equals("*")||arrayList.get(2).equals("/")||arrayList.get(2).equals("%"))
            operator=true;

        String s1= (String) arrayList.get(1);
        String s2= (String) arrayList.get(3);
        if(isNumeric(s1)){
            leftNumber=true;
        }
        if(isNumeric(s2))
            rightNumber=true;
        if(leftBar&&rightBar&&leftNumber&&rightNumber&&operator)
            return true;
        return false;




    }
    public static ArrayList convertStringToArrayList(String s){
        ArrayList <String> arrayList=new ArrayList<>();
        for(int i=0;i<s.length();i++)
            arrayList.add(String.valueOf(s.charAt(i)));
        return arrayList;


    }
    public static String convertArrayListToString(ArrayList arrayList){
        String s="";
        for(int i=0;i<arrayList.size();i++){
            s=s+arrayList.get(i);
        }
        return s;
    }
    public static double assignRecArrayList(ArrayList arrayList){
        if(isBasicFormulaArrayList(arrayList))
            return calculateBasicFormulaArrayList(arrayList);
        if(!isFormulaArrayList(arrayList))
            return Double.NaN;
        int breakingPoint=arrayList.size();

        for(int i=0;i<breakingPoint;i++){
            // ArrayList<String> subArrayList= (ArrayList<String>) arrayList.subList(i,i+5);
            ArrayList<String> subArrayList=new ArrayList<>();
            for(int k=0;k<5;k++){
                subArrayList.add((String) arrayList.get(i+k));
            }
            if(isBasicFormulaArrayList(subArrayList)){
                //ArrayList<String> newArray= (ArrayList<String>) arrayList.subList(0,i);
                ArrayList<String> newArray=new ArrayList<>();
                for(int t=0;t<i;t++){
                    newArray.add((String) arrayList.get(t));
                }
                newArray.add(String.valueOf(calculateBasicFormulaArrayList(subArrayList)));
                for(int k=i+5;k<arrayList.size();k++)
                    newArray.add((String) arrayList.get(k));
                arrayList=newArray;
                i=breakingPoint;
            }

        }
        return assignRecArrayList(arrayList);







    }
    public static double calculateBasicFormulaArrayList(ArrayList<String> arrayList) {
        String operetor=arrayList.get(2);
        String rightBar=arrayList.get(4);
        String leftBar=arrayList.get(0);
        String rightNumber=arrayList.get(3);
        String leftNumber=arrayList.get(1);

        if(operetor.equals("+"))
            return Double.parseDouble(leftNumber)+Double.parseDouble(rightNumber);
        if(operetor.equals("-"))
            return Double.parseDouble(leftNumber)-Double.parseDouble(rightNumber);
        if(operetor.equals("*"))
            return Double.parseDouble(leftNumber)*Double.parseDouble(rightNumber);
        if(operetor.equals("/"))
            return Double.parseDouble(leftNumber)/Double.parseDouble(rightNumber);
        if(operetor.equals("%"))
            return Double.parseDouble(leftNumber)%Double.parseDouble(rightNumber);
        return Double.NaN;



    }
    public static double assign(String s,int x){
        s=s.replaceAll("x", String.valueOf(x));
        if(!isFormula(s))
            return Double.NaN;
        if(isNumeric(s))
            return Double.parseDouble(s);
        ArrayList<String> arrayList=new ArrayList();
        arrayList=convertStringToArrayList(s);
        return (double) assignRecArrayList(arrayList);

    }

    public static void main(String[] args) {

        System.out.println(assign("((2+2)*(x*9))",9));
    }
}
