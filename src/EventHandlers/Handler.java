package EventHandlers;
import WeightConversions.*;
import VolumeConversions.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Handler implements ActionListener{
    //The JComponents from the UserInterface class that will affect the action listener
    private JTextField fromTextField;
    private JTextField resultsTextField;
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private JButton convertButton;

    //Classes with conversion methods
    private Grams gramsConversion = new Grams(); //Going to be used for grams to ______ conversions
    private Kilograms kilogramsConversion = new Kilograms(); //Going to be used for kilograms to ______ conversions.
    private Milligrams milligramsConversion = new Milligrams(); //Going to be used for milligrams to ____ conversions.
    private Ounces ouncesConversion = new Ounces(); //Going to be used for ounces to _____ conversions.
    private Pounds poundsConversion = new Pounds(); //Going to be used for pounds to _____ conversions.
    private Teaspoons teaspoonsConversion = new Teaspoons(); //Going to be used teaspoons to ______ conversions.
    private Tablespoons tablespoonsConversion = new Tablespoons(); //Going to be used for tablespoons to _____ conversions.

    /**
     * Description: This method will add the fromTextField from the UserInterface class and store it in the global
     * object variable 'fromTextField'
     *
     * @param fromTextField is the fromTextField from the UserInterface class.
     */
    public void addFromTextField(JTextField fromTextField){
        this.fromTextField = fromTextField;
    }

    /**
     * Description: This method will add the fromComboBox from the UserInterface class and store it in the global
     * object variable 'fromComboBox'.
     *
     * @param fromComboBox is the fromComboBox from the UserInterface class.
     */
    public void addFromComboBox(JComboBox<String> fromComboBox){
        this.fromComboBox = fromComboBox;
    }

    /**
     * Description: This method will add the toComboBox from the UserInterface class and store it in the global
     * object variable 'toComboBox'.
     *
     * @param toComboBox is the toComboBox from the UserInterface class.
     */
    public void addToComboBox(JComboBox<String> toComboBox){
        this.toComboBox = toComboBox;
    }

    /**
     * Description: This method will add the resultsTextField from the UserInterface class and store it in the global
     * object variable 'resultsTextField'.
     *
     * @param resultsTextField is the resultsTextField from the UserInterface class.
     */
    public void addResultsTextField(JTextField resultsTextField){
        this.resultsTextField = resultsTextField;
    }

    /**
     * Description: This method will add the convert button from the UserInterface class and store it in the global
     * object variable 'convertButton'.
     *
     * @param convertButton is the convert button from the UserInterface
     */
    public void addConvertButton(JButton convertButton){this.convertButton = convertButton;}

    /**
     * Description: This method will take an event 'e' and change the behavior of the GUI cooking measurement converter
     * user interface. The actions that will be performed include 1) Changing the options in the toComboBox, depending
     * on what is selected in fromComboBox, ie. kilogram is only converted to grams, milligrams, ounces, and pounds in
     * this program. 2) Convert the value in the fromTextBox to the unit of measure in the toComboBox, ie. 1 kilogram to
     * grams conversion would put 1000 in the resultTextField. This is done with the use of helper methods below for
     * easier readability and modularity. Methods starting with 'convert' makes the conversion and the methods starting
     * with 'from' change the items in the toComboBox.
     *
     * @param e the event we will act on
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Getting the source
        Object src = e.getSource();
        try{
            reDefineComboBox(src);
            convertKilo(src);
            convertMilligrams(src);
            convertGrams(src);
            convertOunces(src);
            convertPounds(src);
            convertTeaspoons(src);
            convertTablespoons(src);
        } catch (Exception exc){
            JOptionPane.showMessageDialog(null, "Be sure to enter a decimal number");
        }
    }

    /**
     *
     * Description: This method shows a disclaimer to the user when converting from volume to weight since those
     * conversions can't be accurate, ie. tsp of water to grams can be different when it's sand being used.
     */
    private void volumeToWeightDisclaimer(){
        JOptionPane.showMessageDialog(null, "Conversion is from volume to weight, so the " +
                "result will be a close approximation but not exact (ie. the volume to weight conversion between " +
                "water and sand may be different. The conversion is close enough for your cooking needs!");
    }

    /**
     * Description: This method organizes the helper methods that redefine the toComboBox depending on what is selected
     * in the fromComboBox. Just in case, a popup shows up if something goes wrong.
     *
     * @param src is the result of the getSource method that is in the actionPerformed method. The src is either
     *            convertButton or fromComboBox. In this case, we're changing toComboBox items depending on the
     *            fromComboBox so we are just checking if src equals fromComboBox.
     */
    private void reDefineComboBox(Object src){
        if(src == fromComboBox){
            if(fromComboBox.getSelectedItem().equals("Kilogram(kg)")){ //Redefines toComboBox when "Kilogram(kg)" is picked
                fromKilo();
            } else if(fromComboBox.getSelectedItem().equals("Gram(g)")){ //Redefines toComboBox when "Gram(g)" is picked
                fromGrams();
            } else if(fromComboBox.getSelectedItem().equals("Milligram(mg)")){ //Redefines toComboBox when "Milligram(mg)" is picked
                fromMilligrams();
            } else if(fromComboBox.getSelectedItem().equals("Ounce(oz)")){ //Redefines toComboBox when "Ounce(oz)" is picked
                fromOunces();
            } else if(fromComboBox.getSelectedItem().equals("Pound(lb)")){ //Redefines toComboBox when "Pound(lb)" is picked
                fromPounds();
            } else if(fromComboBox.getSelectedItem().equals("Teaspoon(tsp)")){ //Redefines toComboBox when "Teaspoon(tsp)" is picked
                fromTeaspoons();
            } else if(fromComboBox.getSelectedItem().equals("Tablespoon(tbsp)")){ //Redefines toComboBox when "Tablespoon(tbsp)" is picked
                fromTablespoons();
            } else {
                JOptionPane.showMessageDialog(null, "Something went wrong, try again");
            }
        }
    }

    /**
     * Description: This method checks if the result of the getSource method in the actionPerformed method is
     * convertButton (sorry if that sounds a little confusing, if you look at line 88 then it makes more sense).
     * From there, the value in fromComboBox is checked to be "Kilogram(kg)" and then the selected item of toComboBox is
     * checked. Depending on that selection, we'll use the conversion methods from the Kilograms class to make the
     * conversion and put that result in the resultTextField.
     *
     * @param src is the result of the getSource method that is in the actionPerformed method. The src is either
     *            convertButton or fromComboBox. In this case, we're checking if it's convertButton.
     */
    private void convertKilo(Object src){
        if(src == convertButton){
            if(fromComboBox.getSelectedItem().equals("Kilogram(kg)")){
                if(toComboBox.getSelectedItem().equals("Gram(g)")){ //Converts kilograms to grams
                    String result = "" +
                            kilogramsConversion.kilogramsToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Milligram(mg)")){ //Convert kilograms to milligrams
                    String result = "" +
                            kilogramsConversion.kilogramsToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){ //Convert kilograms to ounces
                    String result = "" +
                            kilogramsConversion.kilogramsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Pound(lbs)")){ //Convert kilograms to pounds
                    String result = "" +
                            kilogramsConversion.kilogramsToPounds(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    /**
     * Description: This method checks if the result of the getSource method in the actionPerformed method is
     * convertButton (sorry if that sounds a little confusing, if you look at line 88 then it makes more sense).
     * From there, the value in fromComboBox is checked to be "Milligram(mg)" and then the selected item of toComboBox
     * is checked. Depending on that selection, we'll use the conversion methods from the Milligrams class to make the
     * conversion and put that result in the resultTextField.
     *
     * @param src is the result of the getSource method that is in the actionPerformed method. The src is either
     *            convertButton or fromComboBox. In this case, we're checking if it's convertButton.
     */
    private void convertMilligrams(Object src){
        if(src == convertButton){
            if(fromComboBox.getSelectedItem().equals("Milligram(mg)")){
                if(toComboBox.getSelectedItem().equals("Gram(g)")){ //Convert milligrams to grams
                    String result = "" +
                            milligramsConversion.milligramsToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){ //Converts milligrams to kilograms
                    String result = "" +
                            milligramsConversion.milligramsToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){ //Converts milligrams to ounces
                    String result = "" +
                            milligramsConversion.milligramsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Pound(lbs)")){ //Converts from milligrams to pounds
                    String result = "" +
                            milligramsConversion.milligramsToPounds(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    /**
     * Description: This method checks if the result of the getSource method in the actionPerformed method is
     * convertButton (sorry if that sounds a little confusing, if you look at line 88 then it makes more sense).
     * From there, the value in fromComboBox is checked to be "Gram(g)" and then the selected item of toComboBox
     * is checked. Depending on that selection, we'll use the conversion methods from the Grams class to make the
     * conversion and put that result in the resultTextField.
     *
     * @param src is the result of the getSource method that is in the actionPerformed method. The src is either
     *            convertButton or fromComboBox. In this case, we're checking if it's convertButton.
     */
    private void convertGrams(Object src){
        if(src == convertButton){
            if(fromComboBox.getSelectedItem().equals("Gram(g)")){
                if(toComboBox.getSelectedItem().equals("Milligram(mg)")){ //Convert grams to milligrams
                    String result = "" +
                            gramsConversion.gramsToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){ //Convert grams to kilograms
                    String result = "" +
                            gramsConversion.gramsToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){ //Convert grams to ounces
                    String result = "" +
                            gramsConversion.gramsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Pound(lbs)")){ //Convert grams to pounds
                    String result = "" +
                            gramsConversion.gramsToPounds(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    /**
     * Description: This method checks if the result of the getSource method in the actionPerformed method is
     * convertButton (sorry if that sounds a little confusing, if you look at line 88 then it makes more sense).
     * From there, the value in fromComboBox is checked to be "Ounce(oz)" and then the selected item of toComboBox
     * is checked. Depending on that selection, we'll use the conversion methods from the Ounces class to make the
     * conversion and put that result in the resultTextField.
     *
     * @param src is the result of the getSource method that is in the actionPerformed method. The src is either
     *            convertButton or fromComboBox. In this case, we're checking if it's convertButton.
     */
    private void convertOunces(Object src){
        if(src == convertButton){
            if(Objects.equals(fromComboBox.getSelectedItem(), "Ounce(oz)")){
                if(Objects.equals(toComboBox.getSelectedItem(), "Milligram(mg)")){ //Converts ounces to milligrams
                    String result = "" +
                            ouncesConversion.ouncesToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){ //Converts ounces to kilograms
                    String result = "" +
                            ouncesConversion.ouncesToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Gram(g)")){ //Converts ounces to grams
                    String result = "" +
                            ouncesConversion.ouncesToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Pound(lbs)")){ //Converts ounces to pounds
                    String result = "" +
                            ouncesConversion.ouncesToPounds(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    /**
     * Description: This method checks if the result of the getSource method in the actionPerformed method is
     * convertButton (sorry if that sounds a little confusing, if you look at line 88 then it makes more sense).
     * From there, the value in fromComboBox is checked to be "Pound(lb)" and then the selected item of toComboBox
     * is checked. Depending on that selection, we'll use the conversion methods from the Pounds class to make the
     * conversion and put that result in the resultTextField.
     *
     * @param src is the result of the getSource method that is in the actionPerformed method. The src is either
     *            convertButton or fromComboBox. In this case, we're checking if it's convertButton.
     */
    private void convertPounds(Object src){
        if(src == convertButton){
            if(Objects.equals(fromComboBox.getSelectedItem(), "Pound(lb)")){
                if(Objects.equals(toComboBox.getSelectedItem(), "Milligram(mg)")){ //Converts pounds to milligrams
                    String result = "" +
                            poundsConversion.poundsToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){ //Converts pounds to kilograms
                    String result = "" +
                            poundsConversion.poundsToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Gram(g)")){ //Converts pounds to grams
                    String result = "" +
                            poundsConversion.poundsToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){ //Converts pounds to ounces
                    String result = "" +
                            poundsConversion.poundsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong  HELO");
                }

            }
        }
    }

    /**
     * Description: This method checks if the result of the getSource method in the actionPerformed method is
     * convertButton (sorry if that sounds a little confusing, if you look at line 88 then it makes more sense).
     * From there, the value in fromComboBox is checked to be "Teaspoon(tsp)" and then the selected item of toComboBox
     * is checked. Depending on that selection, we'll use the conversion methods from the Teaspooons class to make the
     * conversion and put that result in the resultTextField.
     *
     * @param src is the result of the getSource method that is in the actionPerformed method. The src is either
     *            convertButton or fromComboBox. In this case, we're checking if it's convertButton.
     */
    private void convertTeaspoons(Object src){
        if(src == convertButton){
            if(Objects.equals(fromComboBox.getSelectedItem(), "Teaspoon(tsp)")){
                if(Objects.equals(toComboBox.getSelectedItem(), "Milligram(mg)")){ //Converts teaspoons to milligrams
                    String result = "" +
                            teaspoonsConversion.teaspoonsToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){ //Converts teaspoons to kilograms
                    String result = "" +
                            teaspoonsConversion.teaspoonsToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Gram(g)")){ //Converts teaspoons to grams
                    String result = "" +
                            teaspoonsConversion.teaspoonsToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){ //Converts teaspoons to ounces
                    String result = "" +
                            teaspoonsConversion.teaspoonsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Fluid Ounce(fl oz)")){ //Converts teaspoons to fluid ounces
                    String result = "" +
                            teaspoonsConversion.teaspoonsToFluidOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Tablespoon(tbsp)")){ //Converts teaspoons to tablespoons
                    String result = "" +
                            teaspoonsConversion.teaspooonsToTablespoons(Double.parseDouble(fromTextField.getText()));
                    canBeFraction(result);
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    /**
     * Description: This method checks if the result of the getSource method in the actionPerformed method is
     * convertButton (sorry if that sounds a little confusing, if you look at line 88 then it makes more sense).
     * From there, the value in fromComboBox is checked to be "Tablespoon(tbsp)" and then the selected item of toComboBox
     * is checked. Depending on that selection, we'll use the conversion methods from the Tablespoons class to make the
     * conversion and put that result in the resultTextField.
     *
     * @param src is the result of the getSource method that is in the actionPerformed method. The src is either
     *            convertButton or fromComboBox. In this case, we're checking if it's convertButton.
     */
    private void convertTablespoons(Object src) {
        if(src == convertButton){
            if(Objects.equals(fromComboBox.getSelectedItem(), "Tablespoon(tbsp)")){
                if(Objects.equals(toComboBox.getSelectedItem(), "Milligram(mg)")){ //Converts tablespoons to milligrams
                    String result = "" +
                            tablespoonsConversion.tablespoonsToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){ //Converts tablespoons to kilograms
                    String result = "" +
                            tablespoonsConversion.tablespoonsToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Gram(g)")){ //Converts tablespoons to grams
                    String result = "" +
                            tablespoonsConversion.tablespoonsToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){ //Converts tablespoons to ounces
                    String result = "" +
                            tablespoonsConversion.tablespoonsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Fluid Ounce(fl oz)")){ //Converts tablespoons to fluid ounces
                    String result = "" +
                            tablespoonsConversion.tablespoonsToFluidOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Teaspoon(tsp)")){ //Converts tablespoons to teaspoons
                    String result = "" +
                            tablespoonsConversion.tablespoonsToTeaspoons(Double.parseDouble(fromTextField.getText()));
                    result = canBeFraction(result);
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    /**
     * Description: This method recreates the toComboBox when "Kilogram(kg)" is selected in the fromComboBox
     */
    private void fromKilo(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Ounce(oz)");
        toComboBox.addItem("Pound(lbs)");
    }

    /**
     * Description: This method recreates the toComboBox when "Gram(g)" is selected in the fromComboBox
     */
    private void fromGrams(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Ounce(oz)");
        toComboBox.addItem("Pound(lbs)");
    }

    /**
     * Description: This method recreates the toComboBox when "Milligram(mg)" is selected in the fromComboBox
     */
    private void fromMilligrams(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Ounce(oz)");
        toComboBox.addItem("Pound(lbs)");
    }

    /**
     * Description: This method recreates the toComboBox when "Ounce(oz)" is selected in the fromComboBox
     */
    private void fromOunces(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Pound(lbs)");
    }

    /**
     * Description: This method recreates the toComboBox when "Pound(lbs)" is selected in the fromComboBox
     */
    private void fromPounds(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Ounce(oz)");
    }

    /**
     * Description: This method recreates the toComboBox when "Tablespoon(tbsp)" is selected in the fromComboBox
     */
    private void fromTablespoons(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Ounce(oz)");
        toComboBox.addItem("Fluid Ounce(fl oz)");
        toComboBox.addItem("Teaspoon(tsp)");
    }

    /**
     * Description: This method recreates the toComboBox when "Teaspoon(tsp)" is selected in the fromComboBox
     */
    private void fromTeaspoons(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Ounce(oz)");
        toComboBox.addItem("Fluid Ounce(fl oz)");
        toComboBox.addItem("Tablespoon(tbsp)");
    }

    /**
     * Description: This method checks if a conversion for teaspoon or tablespoons comes out to a common fraction such
     * as "1/2 teaspoon" so that it is easier for the user.
     *
     * @param result is the configured result depending on if it matches a common fraction
     * @return a string result but as the fraction, instead of the decimal.
     */
    private String canBeFraction(String result){
        if(Double.parseDouble(result) == 1.0/2){
            result = "1/2";
            return result;
        } else if(Double.parseDouble(result) == 1.0/3){
            result = "1/3";
            return result;
        } else if(Double.parseDouble(result) == 3.0/4){
            result = "3/4";
            return result;
        } else if(Double.parseDouble(result) == 1.0/4){
            result = "1/4";
            return result;
        } else if(Double.parseDouble(result) == 1.0/8){
            result = "1/8";
            return result;
        } else if(Double.parseDouble(result) == 1.0/16){
            result = "1/16";
            return result;
        } else {
            return result;
        }
    }





}
