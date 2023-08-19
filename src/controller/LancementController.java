package controller;

import java.io.IOException;

import main.UMSApplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LancementController {
	
	@FXML
	private Button  lancement;
	
	@FXML
	private void initialize() {
		//UMSApplication.getInstance().setLancementController(this);
	}
	
	
	@FXML
	private void onLancementClick () throws IOException
	{
		UMSApplication.getInstance().onLancementClick();
	}

}
