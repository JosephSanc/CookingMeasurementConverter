package WeightConversions;

/*
This program will convert ounces to:
    - Pounds
    - Grams
    - Milligrams
    - Kilograms

    Author: Joseph Sanchez
    Date: 07/01/2020
 */
public class Ounces {

    /**
     * Description: This method will take an "ounces" argument and output its value in grams
     *
     * @param ounces the amount of ounces we are trying to convert
     * @return the value of ounces when it is converter to grams
     */
    public double ouncesToGrams(double ounces){
        return ounces / 0.035274;
    }

    /**
     * Description: This method will take an "ounces" argument and output its value in pounds
     *
     * @param ounces the amount of ounces we are trying to convert
     * @return the value of ounces when it is converter to grams
     */
    public double ouncesToPounds(double ounces){
        return ounces * 0.062500;
    }

    /**
     * Description: This method will take an "ounces" argument and output its value in kilograms
     *
     * @param ounces the amount of ounces we are trying to convert
     * @return the value of ounces when it is converter to kilograms
     */
    public double ouncesToKilograms(double ounces){
        return ounces / 35.274;
    }

    /**
     * Description: This method will take an "ounces" argument and output its value in milligrams
     *
     * @param ounces the amount of ounces we are trying to convert
     * @return the value of ounces when it is converter to milligrams
     */
    public double ouncesToMilligrams(double ounces){
        return ounces / 0.000035274;
    }
}
