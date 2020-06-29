package WeightConversions;

/*
In this class I will write methods to convert grams to:
    - kilograms
    - milligrams
    - pounds
    - ounces
I will also make conversion with dry grams to:
    - 1/16 teaspoon
    - 1/8  teaspoon
    - 1/4  teaspoon
    - 1/2  teaspoon
    - teaspoons (this measurement isn't specified because it will be specified by the user)
    - 1/16 tablespoon
    - 1/8  tablespoon
    - 1/4  tablespoon
    - 1/2  tablespoon
    - tablespoons
The same measurment that will be converted from dry grams to x (x being a measurement) will also be done with wet grams
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
