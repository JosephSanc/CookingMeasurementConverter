package VolumeConversions;

/*
This program will convert tablepoons to:
    - Grams
    - Milligrams
    - Kilograms
    - Milliliters
    - Teaspoons
    - Fluid ounces
    - Ounces

    Author: Joseph Sanchez
    Date: 07/08/2020
 */

public class Tablespoons {

    /**
     * Description: This method will take an "tablespoons" argument and output its value in grams
     *
     * @param tablespoons the amount of ounces we are trying to convert
     * @return the value of tablespoons when it is converter to grams
     */
    public double tablespoonsToGrams(double tablespoons){
        return tablespoons * 17.07;
    }

    /**
     * Description: This method will take an "tablespoons" argument and output its value in milligrams
     *
     * @param tablespoons the amount of ounces we are trying to convert
     * @return the value of tablespoons when it is converter to milligrams
     */
    public double tablespoonsToMilligrams(double tablespoons){
        return tablespoons * 14.786765;
    }

    /**
     * Description: This method will take an "tablespoons" argument and output its value in kilograms
     *
     * @param tablespoons the amount of ounces we are trying to convert
     * @return the value of tablespoons when it is converter to kiligrams
     */
    public double tablespoonsToKilograms(double tablespoons){
        return tablespoons * 0.014786765;
    }

    /**
     * Description: This method will take an "tablespoons" argument and output its value in milliliters
     *
     * @param tablespoons the amount of ounces we are trying to convert
     * @return the value of tablespoons when it is converter to milliliters
     */
    public double tablespoonsToMillilters(double tablespoons){
        return tablespoons * 14.7868;
    }

    /**
     * Description: This method will take an "tablespoons" argument and output its value in teaspoons
     *
     * @param tablespoons the amount of ounces we are trying to convert
     * @return the value of tablespoons when it is converter to teaspoons
     */
    public double tablespoonsToTeaspoons(double tablespoons){
        return tablespoons * 3;
    }

    /**
     * Description: This method will take an "tablespoons" argument and output its value in fluid ounces
     *
     * @param tablespoons the amount of ounces we are trying to convert
     * @return the value of tablespoons when it is converter to fluid ounces
     */
    public double tablespoonsToFluidOunces(double tablespoons){
        return tablespoons / 2;
    }

    /**
     * Description: This method will take an "tablespoons" argument and output its value in ounces
     *
     * @param tablespoons the amount of ounces we are trying to convert
     * @return the value of tablespoons when it is converter to ounces
     */
    public double tablespoonsToOunces(double tablespoons){
        return tablespoons / 2;
    }

}
