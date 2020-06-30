package RunFiles;

import WeightConversions.Grams;

public class Main {

    public static void main(String[] args) throws Exception {

        //Testing grams conversions
        Grams gram = new Grams();
        System.out.println("1 gram to kilograms: " + gram.gramsToKilograms(1));
        System.out.println("1 gram to milligrams: " + gram.gramsToMilligrams(1));
        System.out.println("1 gram to pounds: " + gram.gramsToPounds(1));
        System.out.println("1 gram to ounces: " + gram.gramsToOunces(1));

        


    }
}
