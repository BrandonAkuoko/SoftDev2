package activity3;

import java.util.Random;

public class Year {
    public static final int DAYS_IN_YEAR = 365;
    private int yearNumber;
    private static Random random = new Random();
    public Year(int yearNumber){
        this.yearNumber = yearNumber;


    }

    public int getYearNumber(){
        return this.yearNumber;
    }
    public int numberOfDays(){
        return getDaysInYear(yearNumber);
    }

    public static int getDaysInYear(int year){
        if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0){
            return DAYS_IN_YEAR + 1;
        }
        else{
            return DAYS_IN_YEAR;
        }
    }
    public static Year[] parseYear(String years){ // 2020, 2021,2022

        String[] tokens =  years.split(" ");
        Year[] arrayHolder = new Year[tokens.length];
        for(int i = 0; i < tokens.length; i++){
            arrayHolder[i] = new Year(Integer.parseInt(tokens[i])); // "2020"
        }
        return arrayHolder;

    }
    public static int randomYear(int min, int max){
        return random.nextInt(max + 1 - min) + min;
        
    }
    @Override
    public boolean equals(Object another){
        //this vs. another
        if(another instanceof Year){
            Year anotherYear = (Year) another;
            return this.yearNumber == anotherYear.yearNumber;
        }
        return false;
    }
    @Override
    public String toString(){
        return "There are " + numberOfDays() + " in " + yearNumber;
    }
}
