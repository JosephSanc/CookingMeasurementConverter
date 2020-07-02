package WeightConversions;

/*
This program will convert kilograms to:
    - Pounds
    - Grams
    - Milligrams
    - Ounces

    Author: Joseph Sanchez
    Date: 07/02/2020
 */

public class Kilograms {

    public double kilogramsToPounds(double kilograms){
        return kilograms * 2.2046;
    }

    public double kilogramsToGrams(double kilograms){
        return kilograms / 0.0010000;
    }

    public double kilogramsToMilligrams(double kilograms){
        return kilograms / 0.0000010000;
    }

    public double kilogramsToOunces(double kilograms){
        return kilograms * 35.274;
    }
}
