package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class MesseageBox {

	//Esta clase hace una ventanita para avisarle algo al usuario

	
	public MesseageBox(String message)
	{
		Stage stage = new Stage();
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		
		Label lbl = new Label(message);
		Button btn = new Button(" OK ");
		
		btn.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) {
						stage.close();
					}
			
				});
		box.getChildren().add(lbl);
		box.getChildren().add(btn);
		
		Scene scene = new Scene(box, 200, 150);
		
		stage.setScene(scene);
		
		stage.show();
	}
}
