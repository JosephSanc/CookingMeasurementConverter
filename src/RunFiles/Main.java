package RunFiles;

import WeightConversions.Grams;

public class Main {

    public static void main(String[] args) throws Exception {

        Grams gram = new Grams();
        System.out.println(gram.gramsToKilograms(5));
        System.out.println(gram.gramsToMilligrams(1));
        System.out.println(gram.gramsToPounds(1));
        System.out.println(gram.gramsToOunces(1));

    }
}
