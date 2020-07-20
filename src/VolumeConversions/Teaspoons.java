package VolumeConversions;

/*
This program will convert teaspoons to:
    - Grams
    - Milligrams
    - Kilograms
    - Milliliters
    - Tablespoons
    - Fluid ounces
    - Ounces

    Author: Joseph Sanchez
    Date: 07/07/2020
 */

public class Teaspoons {

    /**
     * Description: This method will take an "teaspoons" argument and output its value in grams
     *
     * @param teaspoons the amount of ounces we are trying to convert
     * @return the value of teaspoons when it is converter to grams
     */
    public double teaspoonsToGrams(double teaspoons){
        return teaspoons * 4.92892159;
    }

    /**
     * Description: This method will take an "teaspoons" argument and output its value in milligrams
     *
     * @param teaspoons the amount of ounces we are trying to convert
     * @return the value of teaspoons when it is converter to milligrams
     */
    public double teaspoonsToMilligrams(double teaspoons){
        return teaspoons * 5687.50;
    }

    /**
     * Description: This method will take an "teaspoons" argument and output its value in kilograms
     *
     * @param teaspoons the amount of ounces we are trying to convert
     * @return the value of teaspoons when it is converter to kilograms
     */
    public double teaspoonsToKilograms(double teaspoons){
        return teaspoons * 0.004928922;
    }

    /**
     * Description: This method will take an "teaspoons" argument and output its value in milliliters
     *
     * @param teaspoons the amount of ounces we are trying to convert
     * @return the value of teaspoons when it is converter to milliliters
     */
    public double teaspoonsToMilliliters(double teaspoons){
        return teaspoons * 4.92892;
    }

    /**
     * Description: This method will take an "teaspoons" argument and output its value in tablespoons
     *
     * @param teaspoons the amount of ounces we are trying to convert
     * @return the value of teaspoons when it is converter to tablespoons
     */
    public double teaspooonsToTablespoons(double teaspoons){
        return teaspoons * 0.333333;
    }

    /**
     * Description: This method will take an "teaspoons" argument and output its value in fluid ounces
     *
     * @param teaspoons the amount of ounces we are trying to convert
     * @return the value of teaspoons when it is converter to fluid ounces
     */
    public double teaspoonsToFluidOunces(double teaspoons){
        return teaspoons * 0.166667;
    }

    /**
     * Description: This method will take an "teaspoons" argument and output its value in ounces
     *
     * @param teaspoons the amount of ounces we are trying to convert
     * @return the value of teaspoons when it is converter to ounces
     */
    public double teaspoonsToOunces(double teaspoons){
        return teaspoons * 0.166667;
    }

}
