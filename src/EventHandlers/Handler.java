package EventHandlers;
import WeightConversions.*;
import VolumeConversions.*;
import RunFiles.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Handler implements ActionListener{
    //The JComponents from the UserInterface class that will affect the action listener
    private JTextField fromTextField;
    private JTextField disclaimerTextField;
    private JTextField resultsTextField;
    private JComboBox fromComboBox;
    private JComboBox toComboBox;

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
    public void addFromComboBox(JComboBox fromComboBox){
        this.fromComboBox = fromComboBox;
    }

    /**
     * Description: This method will add the toComboBox from the UserInterface class and store it in the global
     * object variable 'toComboBox'.
     *
     * @param toComboBox is the toComboBox from the UserInterface class.
     */
    public void addToComboBox(JComboBox toComboBox){
        this.toComboBox = toComboBox;
    }

    /**
     * Description: This method will add the disclaimerTextField from the UserInterface class and store it in the global
     * object variable 'disclaimerTextField'.
     *
     * @param disclaimerTextField is the disclaimerTextField from the UserInterface class
     */
    public void addDisclaimerTextField(JTextField disclaimerTextField){
        this.disclaimerTextField = disclaimerTextField;
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
        //Classes with conversion methods
        Grams gramsConversion = new Grams(); //Going to be used for grams to ______ conversions
        Kilograms kilogramsConversion = new Kilograms(); //Going to be used for kilograms to ______ conversions.
        Milligrams milligramsConversion = new Milligrams(); //Going to be used for milligrams to ____ conversions.
        Ounces ouncesConversion = new Ounces(); //Going to be used for ounces to _____ conversions.
        Pounds poundsConversion = new Pounds(); //Going to be used for pounds to _____ conversions.
        Teaspoons teaspoonsConversion = new Teaspoons(); //Going to be used teaspoons to ______ conversions.
        Tablespoons tablespoonsConversion = new Tablespoons(); //Going to be used for tablespoons to _____ conversions.

            if(fromComboBox.getSelectedItem().equals("Kilogram(kg)") && toComboBox.getSelectedItem().equals("Gram(g)")){
                String result = "" + gramsConversion.gramsToKilograms(Double.parseDouble(fromTextField.getText()));
                resultsTextField.setText(result);
            }


    }


}
