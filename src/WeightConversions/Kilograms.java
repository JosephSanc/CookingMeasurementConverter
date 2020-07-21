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

    /**
     * Description: This method will take an "kilograms" argument and output its value in pounds
     *
     * @param kilograms the amount of kilograms we are trying to convert
     * @return the value of kilograms when it is converter to pounds
     */
    public double kilogramsToPounds(double kilograms){
        return kilograms * 2.2046;
    }

    /**
     * Description: This method will take an "kilograms" argument and output its value in grams
     *
     * @param kilograms the amount of kilograms we are trying to convert
     * @return the value of kilograms when it is converter to grams
     */
    public double kilogramsToGrams(double kilograms){
        return kilograms / 0.0010000;
    }

    /**
     * Description: This method will take an "kilograms" argument and output its value in milligrams
     *
     * @param kilograms the amount of kilograms we are trying to convert
     * @return the value of kilograms when it is converter to milligrams
     */
    public double kilogramsToMilligrams(double kilograms){
        return kilograms / 0.0000010000;
    }

    /**
     * Description: This method will take an "kilograms" argument and output its value in ounces
     *
     * @param kilograms the amount of kilograms we are trying to convert
     * @return the value of kilograms when it is converter to ounces
     */
    public double kilogramsToOunces(double kilograms){
        return kilograms * 35.274;
    }
}
