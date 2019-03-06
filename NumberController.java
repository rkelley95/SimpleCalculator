/**
 * 
 *  @author Ryan Kelley
 *  @version 3/16/17
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NumberController {

    @FXML
    private TextField field1 = new TextField();

    @FXML
    private TextField field2 = new TextField();

    @FXML
    private Button subtract;

    @FXML
    private Button add;

    @FXML
    private TextArea result;
    
    Numbers model = new Numbers();
    //String num1 = field1.getText();
    String num2 = field2.getText();
    
    /**
     * Sets num1 and num2 in the Numbers.java class to the input of the textfields and
     * then adds them.
     * 
     * @param event
     */
    
    @FXML
    void add(ActionEvent event) {
    	String num1 = field1.getText();
    	String num2 = field2.getText();
    	model.setNum1(num1);
    	model.setNum2(num2);
    	display("Addition - " + model.addition());
    }
    
    /**
     * Displays the result of the addition and subtraction methods in the GUI.
     * 
     * @param message	What needs to be displayed.
     */
    
    private void display(String message) 
    {
    	result.setText(message);
	}

    /**
     * Sets num1 and num2 in the Numbers.java class to the input of the textfields and
     * then subtracts them.
     * 
     * @param event
     */
    
	@FXML
    void subtract(ActionEvent event) {
		//view.addToStacks(num1, num2);
		String num1 = field1.getText();
		String num2 = field2.getText();
		model.setNum1(num1);
		model.setNum2(num2);
    	display("Subtraction - " + model.subtraction());
    }

}
