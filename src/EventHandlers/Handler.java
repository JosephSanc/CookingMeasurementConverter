package EventHandlers;
import WeightConversions.*;
import VolumeConversions.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public void addConvertButton(JButton convertButton){this.convertButton = convertButton;}

    /**
     * Description: This method will take an event 'e' and change the behavior of the GUI cooking measurement converter
     * user interface. The main action that will be performed is the conversion of a measurement to another by pressing
     * a button and having the final conversion show up in a JTextField that is labeled 'resultsTextField'. The method
     * will take into consideration the units of measure (the original measurement and the measurement to convert to)
     * and use methods from the classes in the VolumeConversions package and WeightConversions package, to make the
     * conversions. There will be a disclaimer to the user when converting from weight to volume, or vise versa, (ie.
     * grams to teaspoons) the result will be an approximation since those units of measure cannot be exactly converted
     * since it depends on what is being measured (the weight to volume conversion of water might be different than that
     * of sand).
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
            JOptionPane.showMessageDialog(null, "Be sure to enter a number");
        }
    }



    //Note: modify these helper methods at a later date to now show up later if user checks a button
    public void weightToVolumeDisclaimer(){
        JOptionPane.showMessageDialog(null, "Conversion is from weight to volume, so the " +
                "result will be a close approximation but not exact (ie. the weight to volume conversion between " +
                "water and sand may be different. The conversion is close enough for your cooking needs!");
    }

    public void volumeToWeightDisclaimer(){
        JOptionPane.showMessageDialog(null, "Conversion is from volume to weight, so the " +
                "result will be a close approximation but not exact (ie. the volume to weight conversion between" +
                "water and sand may be different. The conversion is close enough for your cooking needs!");
    }

    public void reDefineComboBox(Object src){
        if(src == fromComboBox){
            if(fromComboBox.getSelectedItem().equals("Kilogram(kg)")){
                fromKilo();
            } else if(fromComboBox.getSelectedItem().equals("Gram(g)")){
                fromGrams();
            } else if(fromComboBox.getSelectedItem().equals("Milligram(mg)")){
                fromMilligrams();
            } else if(fromComboBox.getSelectedItem().equals("Ounce(oz)")){
                fromOunces();
            } else if(fromComboBox.getSelectedItem().equals("Pound(lb)")){
                fromPounds();
            } else if(fromComboBox.getSelectedItem().equals("Teaspoon(tsp)")){
                fromTeaspoons();
            } else if(fromComboBox.getSelectedItem().equals("Tablespoon(tbsp)")){
                fromTablespoons();
            } else {
                JOptionPane.showMessageDialog(null, "Something went wrong, try again");
            }
        }
    }

    public void convertKilo(Object src){
        if(src == convertButton){
            if(fromComboBox.getSelectedItem().equals("Kilogram(kg)")){
                if(toComboBox.getSelectedItem().equals("Gram(g)")){
                    String result = "" +
                            kilogramsConversion.kilogramsToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Milligram(mg)")){
                    String result = "" +
                            kilogramsConversion.kilogramsToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){
                    String result = "" +
                            kilogramsConversion.kilogramsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Pound(lbs)")){
                    String result = "" +
                            kilogramsConversion.kilogramsToPounds(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    public void convertMilligrams(Object src){
        if(src == convertButton){
            if(fromComboBox.getSelectedItem().equals("Milligram(mg)")){
                if(toComboBox.getSelectedItem().equals("Gram(g)")){
                    String result = "" +
                            milligramsConversion.milligramsToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){
                    String result = "" +
                            milligramsConversion.milligramsToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){
                    String result = "" +
                            milligramsConversion.milligramsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Pound(lbs)")){
                    String result = "" +
                            milligramsConversion.milligramsToPounds(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    public void convertGrams(Object src){
        if(src == convertButton){
            if(fromComboBox.getSelectedItem().equals("Gram(g)")){
                if(toComboBox.getSelectedItem().equals("Milligram(mg)")){
                    String result = "" +
                            gramsConversion.gramsToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){
                    String result = "" +
                            gramsConversion.gramsToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){
                    String result = "" +
                            gramsConversion.gramsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Pound(lbs)")){
                    String result = "" +
                            gramsConversion.gramsToPounds(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    public void convertOunces(Object src){
        if(src == convertButton){
            if(fromComboBox.getSelectedItem().equals("Ounce(oz)")){
                if(toComboBox.getSelectedItem().equals("Milligram(mg)")){
                    String result = "" +
                            ouncesConversion.ouncesToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){
                    String result = "" +
                            ouncesConversion.ouncesToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Gram(g)")){
                    String result = "" +
                            ouncesConversion.ouncesToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Pound(lbs)")){
                    String result = "" +
                            ouncesConversion.ouncesToPounds(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    public void convertPounds(Object src){
        if(src == convertButton){
            if(fromComboBox.getSelectedItem().equals("Pound(lb)")){
                if(toComboBox.getSelectedItem().equals("Milligram(mg)")){
                    String result = "" +
                            poundsConversion.poundsToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){
                    String result = "" +
                            poundsConversion.poundsToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Gram(g)")){
                    String result = "" +
                            poundsConversion.poundsToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){
                    String result = "" +
                            poundsConversion.poundsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong  HELO");
                }

            }
        }
    }

    public void convertTeaspoons(Object src){
        if(src == convertButton){
            if(fromComboBox.getSelectedItem().equals("Teaspoon(tsp)")){
                if(toComboBox.getSelectedItem().equals("Milligram(mg)")){
                    String result = "" +
                            teaspoonsConversion.teaspoonsToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){
                    String result = "" +
                            teaspoonsConversion.teaspoonsToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Gram(g)")){
                    String result = "" +
                            teaspoonsConversion.teaspoonsToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){
                    String result = "" +
                            teaspoonsConversion.teaspoonsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Fluid Ounce(fl oz)")){
                    String result = "" +
                            teaspoonsConversion.teaspoonsToFluidOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Tablespoon(tbsp)")){
                    String result = "" +
                            teaspoonsConversion.teaspooonsToTablespoons(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    public void convertTablespoons(Object src){
        if(src == convertButton){
            if(fromComboBox.getSelectedItem().equals("Tablespoon(tbsp)")){
                if(toComboBox.getSelectedItem().equals("Milligram(mg)")){
                    String result = "" +
                            tablespoonsConversion.tablespoonsToMilligrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Kilogram(kg)")){
                    String result = "" +
                            tablespoonsConversion.tablespoonsToKilograms(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Gram(g)")){
                    String result = "" +
                            tablespoonsConversion.tablespoonsToGrams(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Ounce(oz)")){
                    String result = "" +
                            tablespoonsConversion.tablespoonsToOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Fluid Ounce(fl oz)")){
                    String result = "" +
                            tablespoonsConversion.tablespoonsToFluidOunces(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else if(toComboBox.getSelectedItem().equals("Teaspoon(tsp)")){
                    String result = "" +
                            tablespoonsConversion.tablespoonsToTeaspoons(Double.parseDouble(fromTextField.getText()));
                    resultsTextField.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }
        }
    }

    public void fromKilo(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Ounce(oz)");
        toComboBox.addItem("Pound(lbs)");
    }

    public void fromGrams(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Ounce(oz)");
        toComboBox.addItem("Pound(lbs)");
    }

    public void fromMilligrams(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Ounce(oz)");
        toComboBox.addItem("Pound(lbs)");
    }

    public void fromOunces(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Pound(lbs)");
    }

    public void fromPounds(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Ounce(oz)");
    }

    public void fromTablespoons(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Ounce(oz)");
        toComboBox.addItem("Fluid Ounce(fl oz)");
        toComboBox.addItem("Teaspoon(tsp)");
    }

    public void fromTeaspoons(){
        toComboBox.removeAllItems();
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Ounce(oz)");
        toComboBox.addItem("Fluid Ounce(fl oz)");
        toComboBox.addItem("Tablespoon(tbsp)");
    }






}
