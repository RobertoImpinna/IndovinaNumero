

/**
 * Sample Skeleton for 'IndoNumero.fxml' Controller Class
 */

package it.polito.tdp.indonumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class IndoNumeroController {

	
	private int NMAX = 100;
	private int TMAX = 7;
	
	
	private int segreto;
	private int tentativi; //tentativi fatti
	
	private boolean inGame=false;
	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNuova"
    private Button btnNuova; // Value injected by FXMLLoader

    @FXML // fx:id="txtCurr"
    private TextField txtCurr; // Value injected by FXMLLoader

    @FXML // fx:id="txtMax"
    private TextField txtMax; // Value injected by FXMLLoader

    @FXML // fx:id="boxGioco"
    private HBox boxGioco; // Value injected by FXMLLoader

    @FXML // fx:id="txtProva"
    private TextField txtProva; // Value injected by FXMLLoader

    @FXML // fx:id="btnProva"
    private Button btnProva; // Value injected by FXMLLoader

    @FXML // fx:id="txtLog"
    private TextArea txtLog; // Value injected by FXMLLoader

    @FXML
    void handleNuova(ActionEvent event) {

    	

    	this.segreto=(int)(Math.random()*NMAX)+1;
    
    	this.tentativi=0;
    	this.inGame=true;
    	
    	btnNuova.setDisable(true);
    	boxGioco.setDisable(false);
    	txtCurr.setText(String.format("%d", this.tentativi));
    	txtMax.setText(String.format("%d", this.TMAX));
    	txtProva.clear();
    	txtLog.clear();
    	txtLog.setText("Indovina un numero compreso tra 1 e "+NMAX+"\n");
    	
    }

    @FXML
    void handleProva(ActionEvent event) {
    	
    	String numS=txtProva.getText();
    	
    	if(numS.length()==0) {
    		txtLog.appendText("Devi inserire un numero\n");
    		return;
    	
    	}
    	try {
    	int num=Integer.parseInt(numS);
    	//numero era effettivamente un intero
    	if(num==this.segreto) {
    		
    		//ha indovinato
    		txtLog.appendText("Hai vinto!!\n");
    		
    		//chiudere la partita
    		boxGioco.setDisable(true);
    		btnNuova.setDisable(false);
    		inGame=false;
    		
    	}else {
    		//tentativo errato
    		this.tentativi++;
    		txtCurr.setText(String.format("%d", this.tentativi));
    		
    		if(this.tentativi==this.TMAX) {
    			//ha perso
    			txtLog.appendText("Hai perso, il numero era: "+this.segreto);
    			//chiudi la partita
    			btnNuova.setDisable(true);
    			boxGioco.setDisable(true);
    			inGame=false;
    		}else {
    			// sono ancora in gioco
    			if(num<segreto) {
    				//troppo basso
    				txtLog.appendText("Troppo basso\n");
    			}else {
    				//troppo alto
    				txtLog.appendText("Troppo alto\n");
    				
    			}
    		}
    	}
    	}
    	catch(NumberFormatException ex) {
    		txtLog.appendText("Il dato inserito non � numerico\n");
    		return;
    		
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnNuova != null : "fx:id=\"btnNuova\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtCurr != null : "fx:id=\"txtCurr\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtMax != null : "fx:id=\"txtMax\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert boxGioco != null : "fx:id=\"boxGioco\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtProva != null : "fx:id=\"txtProva\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'IndoNumero.fxml'.";

    }
}
