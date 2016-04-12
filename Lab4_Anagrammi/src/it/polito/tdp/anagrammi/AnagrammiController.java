package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AnagrammiController {
	
	private AnagrammiModel model;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextFlow txtResult;
    //TextFlow is special layout designed to lay out rich text

    @FXML
    private Button btnReset;
    
    
    public void setModel(AnagrammiModel model){
    	this.model=model;
    }
    

    @FXML
    void doCalcola(ActionEvent event) {
    	//pulisco l'area di testo
    	txtResult.getChildren().clear();
    	String s=txtInput.getText();
    	
    	//una TextArea non sarà mai null ma al più "" 
    	if(s.equals("")){
    		System.out.println("INSERISCI UNA PAROLA");
    		txtResult.getChildren().add(new Text("Inserisci una Parola"));
    		return;
    	}
    	
    	List<String> parole= model.findAllAnagrams(s); 	
    	
    	
    	for(String el:parole){
    		
    		Text word  =new Text(); 
    		word.setText(el+"\n");
    		//volendo si poteva fare anche direttamente Text word= new Text(el.toString()+"\n");
    	
    		if(model.isPresent(el))
    			word.setFill(Color.BLUE);
    		else
    			word.setFill(Color.RED);
			txtResult.getChildren().add(word);
			
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInput.clear();
    	txtResult.getChildren().clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
