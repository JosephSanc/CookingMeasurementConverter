package RunFiles;

import WeightConversions.Grams;
import WeightConversions.Kilograms;
import WeightConversions.Ounces;
import WeightConversions.Pounds;

import java.util.Scanner;

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
        System.out.println("Testing pounds conversions:");
        System.out.println("1 pound to kilograms: " + pounds.poundsToKilograms(1));
        System.out.println("1 pound to milligrams: " + pounds.poundsToMillograms(1));
        System.out.println("1 pound to ounces: " + pounds.poundsToOunces(1));
        System.out.println("1 pound to grams: " + pounds.poundsToGrams(1));

        System.out.println();

        //Testing ounces conversion:
        Ounces ounces = new Ounces();
        System.out.println("Testing ounces conversions:");
        System.out.println("1 ounce to kilograms: " + ounces.ouncesToKilograms(1));
        System.out.println("1 ounce to milligrams " + ounces.ouncesToMilligrams(1));
        System.out.println("1 ounce to pounds: " + ounces.ouncesToPounds(1));
        System.out.println("1 ounce to grams: " + ounces.ouncesToGrams(1));

        System.out.println();

        //Testing kilograms conversions:
        Kilograms kilograms = new Kilograms();
        System.out.println("Testing kilograms conversions:");
        System.out.println("1 kilogram to ounces: " + kilograms.kilogramsToOunces(1));
        System.out.println("1 kilogram to grams: " + kilograms.kilogramsToGrams(1));
        System.out.println("1 kilogram to milligrams: " + kilograms.kilogramsToMilligrams(1));
        System.out.println("1 kilogram to pounds: " + kilograms.kilogramsToPounds(1));





    }
}
