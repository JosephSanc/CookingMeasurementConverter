package WeightConversions;

/*
In this class I will convert pounds to:
    - ounces
    - grams
    - kilograms
    - milligrams

    Author: Joseph Sanchez
    Data: 06/30/2020
 */

public class Pounds {

    /**
     * Description: This method will take a "pounds" argument and output its value in grams
     *
     * @param pounds the amount of pounds we are trying to convert
     * @return the value of pounds when it is converter to grams
     */
    public double poundsToGrams(double pounds){
        return pounds * 453.59237;
    }

    /**
     * Description: This method will take a "pounds" argument and output its value in ounces
     *
     * @param pounds the amount of pounds we are trying to convert
     * @return the value of pounds when it is converter to ounces
     */
    public double poundsToOunces(double pounds){
        return pounds * 16;
    }

    /**
     * Description: This method will take a "pounds" argument and output its value in kilograms
     *
     * @param pounds the amount of pounds we are trying to convert
     * @return the value of pounds when it is converter to kilograms
     */
    public double poundsToKilograms(double pounds){
        return pounds * 0.45;
    }

    /**
     * Description: This method will take a "pounds" argument and output its value in milligrams
     *
     * @param pounds the amount of pounds we are trying to convert
     * @return the value of pounds when it is converter to milligrams
     */
    public double poundsToMilligrams(double pounds){
        return pounds * 453592.33;
    }

}
