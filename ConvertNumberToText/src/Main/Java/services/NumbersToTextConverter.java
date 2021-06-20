package services;

import api.services.NumberClassConverter;

public class NumbersToTextConverter {
    NumberClassConverter numberClassConverter;

    public NumbersToTextConverter(NumberClassConverter numberClassConverter) {
        this.numberClassConverter = numberClassConverter;
    }

    public String getTextNumberView(String Number){
        int length=Number.length();
        if (length%3==1) Number="00"+Number;
        if (length%3==2) Number="0"+Number;
        int countClass=Number.length()/3;
        String TextNumber="";
        while (countClass>0){
            int[] classNumber=getClassNumber(Number,countClass);
            TextNumber=TextNumber+numberClassConverter.getNumberClassText(classNumber,countClass-1);
            countClass--;
        }
        return TextNumber;

    }
    private static int[] getIntNumberClass(String numberClass)
    {
        int[] ints = numberClass.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .toArray();
        return  ints;
    };
    public int[] getClassNumber(String number,int classIndex){
        int indexStrBegin=(number.length()/3-classIndex)*3;
        int indexStrEnd=(number.length()/3-classIndex)*3+3;
        String classNumberString=number.substring(indexStrBegin,indexStrEnd);
        return getIntNumberClass(classNumberString);
    }

}
