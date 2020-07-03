package WeightConversions;

/*
In this class I will convert milligrams to:
    - ounces
    - grams
    - kilograms
    - pounds

    Author: Joseph Sanchez
    Data: 07/03/2020
 */

public class Milligrams {

    public double milligramsToOunces(double milligrams){
        return milligrams * 0.000035274;
    }

    public double milligramsToGrams(double milligrams){
        return milligrams / 1000;
    }

    public double milligramsToKilograms(double milligrams){
        return milligrams / 1000000;
    }

    public double milligramsToPounds(double milligrams){
        return milligrams * 0.0000022046;
    }

}
