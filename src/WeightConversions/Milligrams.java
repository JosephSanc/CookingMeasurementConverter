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

    /**
     * Description: This method will take an "milligrams" argument and output its value in ounces
     *
     * @param milligrams the amount of milligrams we are trying to convert
     * @return the value of milligrams when it is converter to ounces
     */
    public double milligramsToOunces(double milligrams){
        return milligrams * 0.000035274;
    }

    /**
     * Description: This method will take an "milligrams" argument and output its value in grams
     *
     * @param milligrams the amount of milligrams we are trying to convert
     * @return the value of milligrams when it is converter to grams
     */
    public double milligramsToGrams(double milligrams){
        return milligrams / 1000;
    }

    /**
     * Description: This method will take an "milligrams" argument and output its value in kilograms
     *
     * @param milligrams the amount of milligrams we are trying to convert
     * @return the value of milligrams when it is converter to kilograms
     */
    public double milligramsToKilograms(double milligrams){
        return milligrams / 1000000;
    }

    /**
     * Description: This method will take an "milligrams" argument and output its value in pounds
     *
     * @param milligrams the amount of milligrams we are trying to convert
     * @return the value of milligrams when it is converter to pounds
     */
    public double milligramsToPounds(double milligrams){ //this method isn't very useful unless the milligrams are large
        return milligrams * 0.0000022046;
    }

}
