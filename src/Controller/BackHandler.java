package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


/**
 * Created by Rosen on 29/03/2015.
 */
public class BackHandler implements EventHandler<ActionEvent> {

	private Stage toBackFrom;
	
	public BackHandler(Stage toBackFrom){
		this.toBackFrom = toBackFrom;
	}


    @Override
    public void handle(ActionEvent event) {
    	toBackFrom.close();
    }
}
