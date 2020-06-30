package WeightConversions;

/*
In this class I will write methods to convert grams to:
    - kilograms
    - milligrams
    - pounds
    - ounces

    Author: Joseph Sanchez
    Date: 6/29/2020
 */

public class Grams {

    /**
     * Description: This method will take a "grams" argument and output its value in kilograms
     *
     * @param grams the amount of grams we are trying to convert
     * @return the value of grams when it is converter to kilograms
     */
    public double gramsToKilograms(double grams){
        return grams/1000;
    }

    /**
     * Description: This method will take a "grams" argument and output its value in milligrams
     *
     * @param grams the amount of grams we are trying to convert
     * @return the value of grams when it is converted to milligrams
     */
    public double gramsToMilligrams(double grams){
        return grams * 1000;
    }

    /**
     * Description: This method will take a "grams" argument and output its value in pounds
     *
     * @param grams the amount of grams we are trying to convert
     * @return the value of grams when it is converted to pounds
     */
    public double gramsToPounds(double grams){
        return grams / 454;
    }

    /**
     * Description: This method will take a "grams" argument and output its value in pounds
     *
     * @param grams the amount of grams we are trying to convert
     * @return the value of grams when it is converted to ounces
     */
    public double gramsToOunces(double grams){
        return grams / 28.35;
    }




}
