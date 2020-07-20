package RunFiles;
import EventHandlers.Handler;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable{

    private JFrame frame;
    private Handler handler;

    public UserInterface(){

    }

    @Override
    public void run() {
        //Setting up the frame
        frame = new JFrame("Welcome to the Cooking Measurement Converter"); //Title of the frame
        frame.setPreferredSize(new Dimension(400, 300)); //Dimensions of the frams

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Under what condition the frame will stop

        createComponents(frame.getContentPane()); //Gets the components

        frame.pack(); //Structures the components in an efficient way
        frame.setVisible(true); //Makes the frame visible when run

    }

    /**
     * Description: This method will create the components but mostly add panels from helper methods to the frame. This
     * method also has the layout manager for the frame.
     *
     * @param container is the container for the components (in our case, it's the frame).
     */
    private void createComponents(Container container){
        //Creating the layout manager
        GridLayout layout = new GridLayout(4, 1);
        container.setLayout(layout);

        //Adding the components to the frame
        container.add(fromPanel());
        container.add(toPanel());
        container.add(conversionResultPanel());
        container.add(disclaimerTextField());
    }

    /**
     * Description: This method creates the comboBox that will be used with the "from" conversion. This method is
     * separate, instead of in the createComponents method so that the code is easier to read and maintain.
     *
     * @return the JPanel that contains the fromComboBox
     */
    public JComboBox<String> fromComboBox(){
        //Creates a combo box to add items to. In our case, those items are strings of units of measure.
        JComboBox<String> fromComboBox = new JComboBox<>();

        //Adding actionListener
        handler = new Handler();
        fromComboBox.addActionListener(handler);

        //Here we add the strings of units of measure to the combo box as options for the user
        fromComboBox.addItem("Select");
        fromComboBox.addItem("Kilogram(kg)");
        fromComboBox.addItem("Gram(g)");
        fromComboBox.addItem("Milligram(mg)");
        fromComboBox.addItem("Milliliters(ml)");
        fromComboBox.addItem("Ounce(oz)");
        fromComboBox.addItem("Pound(lbs)");
        fromComboBox.addItem("Teaspoon(tsp)");
        fromComboBox.addItem("Tablespoon(tbsp)");

        //When method is called, it returns the comboBox
        return fromComboBox;
    }

    /**
     * Description: This method creates the comboBox that will be used with the "to" conversion. This method is
     * separate, instead of in the createComponents method so that the code is easier to read and maintain.
     *
     * @return the JPanel that contains the toComboBox
     */
    public JComboBox<String> toComboBox(){
        //Creates a combo box to add items to. In our case, those items are strings of units of measure.
        JComboBox<String> toComboBox = new JComboBox<>();

        //Adding actionListener
        handler = new Handler();
        toComboBox.addActionListener(handler);

        //Here we add the strings of units of measure to the combo box as options for the user
        toComboBox.addItem("Select");
        toComboBox.addItem("Kilogram(kg)");
        toComboBox.addItem("Gram(g)");
        toComboBox.addItem("Milligram(mg)");
        toComboBox.addItem("Milliliters(ml)");
        toComboBox.addItem("Ounce(oz)");
        toComboBox.addItem("Pound(lbs)");
        toComboBox.addItem("Teaspoon(tsp)");
        toComboBox.addItem("Tablespoon(tbsp)");

        //When method is called, it returns the comboBox
        return toComboBox;
    }

    /**
     * Description: This method will return a panel that contains the textBox that will hold the converted measurment
     * value results.
     *
     * @return panel with conversion results
     */
    public JPanel conversionResultPanel(){
        //The panel that we will add the results text box to
        JPanel panel = new JPanel();

        //The label that will say "Result: " before the actual results to signify that the results will be shown
        JLabel resultLabel = new JLabel("Result: ");

        //The textField that will hold the converted result. The size is set to 10 columns to be an adequate size.
        JTextField resultTextField = new JTextField(10);
        resultTextField.setEditable(false); //Result will be controlled by program, not by user.

        //Here we add the "Result: " label and text box that will hold the results, to the panel.
        panel.add(resultLabel);
        panel.add(resultTextField);

        //When method is called, it will return a panel that contains the result label and text box.
        return panel;
    }

    /**
     * Description: This method will return a textfield that contains the label that will hold the disclaimer to the user
     * when converting from volume to weight or the other way around.
     *
     * @return panel with disclaimer textfield on it.
     */
    public JPanel disclaimerTextField(){
        //The panel that we will add the disclaimer text field to
        JPanel panel = new JPanel();

        //The disclaimer textfield
        JTextField disclaimerLabel = new JTextField("");//This disclaimer will remain empty until filled by action listener
        disclaimerLabel.setEditable(false);

        //Adding actionListener to disclaimer label:
        handler = new Handler();
        disclaimerLabel.addActionListener(handler);

        //Add disclaimer label to panel
        panel.add(disclaimerLabel);

        //return the panel
        return panel;
    }

    /**
     * Description: This method will return a panel that contains the "From: " label, the text box where the user will
     * input the amount they want converted, and the measurment that the user wants to convert from.
     *
     * @return panel that contains the 'from' label, textbox, and comboBox,
     */
    public JPanel fromPanel(){
        //The panel that will hold our 'from' components
        JPanel panel = new JPanel();

        //Here are the components we will add to the panel.
        JLabel fromLabel = new JLabel("From: "); //will have a label called "From: "
        JTextField fromTextField = new JTextField(10); //Where the user will input a number amount to convert
        JComboBox<String> fromComboBox = fromComboBox(); //The measurement to convert from

        //Adding action listener to fromTextField
        handler = new Handler();
        fromTextField.addActionListener(handler);

        //Here we add the components to the panel
        panel.add(fromLabel);
        panel.add(fromTextField);
        panel.add(fromComboBox);

        //Adding an action listener

        //When method is called, it will return a panel that contains 'from' label, text box, and combo box
        return panel;
    }

    /**
     * Description: This method will return a JPanel that contains the "To: " label that alludes the user to select
     * the measurement they want to convert to, via a combo box, and a button that labeled "Convert" that will
     * initiate the conversion.
     *
     * @return panel that contains the 'to' label, comboBox, and convert button.
     */
    public JPanel toPanel(){
        //The panel that will hold our 'to' components
        JPanel panel = new JPanel();

        //Here are the components we will add to the panel.
        JLabel toLabel = new JLabel("To: "); //A label that will say "To: "
        JComboBox<String> toComboBox = toComboBox(); //The toComboBox from a helper method with all measurements for the user
        JButton convertButton = new JButton("Convert"); //The convert button that will initiate the conversion

        //Adding action listener to button
        handler = new Handler();
        convertButton.addActionListener(handler);

        //Here we add the components to the panel
        panel.add(toLabel);
        panel.add(toComboBox);
        panel.add(convertButton);

        //When this method is called, it will return a panel that contains 'to' label, combo box, and convert button.
        return panel;
    }

}
