package RunFiles;

import WeightConversions.Grams;
import WeightConversions.Pounds;

public class Main {

    public static void main(String[] args) throws Exception {

        //Testing grams conversions
        Grams gram = new Grams();
        System.out.println("Testing grams conversions:");
        System.out.println("1 gram to kilograms: " + gram.gramsToKilograms(1));
        System.out.println("1 gram to milligrams: " + gram.gramsToMilligrams(1));
        System.out.println("1 gram to pounds: " + gram.gramsToPounds(1));
        System.out.println("1 gram to ounces: " + gram.gramsToOunces(1));

        System.out.println();

        //Testing pounds conversion:
        Pounds pounds  = new Pounds();
        System.out.println("Testing pounds conversions");
        System.out.println("1 pound to kilograms: " + pounds.poundsToKilograms(1));
        System.out.println("1 pound to milligrams: " + pounds.poundsToMillograms(1));
        System.out.println("1 pound to ounces: " + pounds.poundsToOunces(1));
        System.out.println("1 pound to grams: " + pounds.poundsToGrams(1));




    }
}
