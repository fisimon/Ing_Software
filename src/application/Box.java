package application;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Box extends GridPane{
	
	public Box(Class clas)
	{
		Label name = new Label(clas.name);
		name.setStyle("-fx-border-color: black;");
		
		
		GridPane.setConstraints(name, 0, 0);
		
		this.getChildren().add(name);
		
		GridPane pane = new GridPane();
		for(int i=0;i<clas.Atts.size();i++)
		{
			String text = clas.Atts.get(i).visibility + clas.Atts.get(i).name + " : "+ clas.Atts.get(i).type;
			
			Text t = new Text(text);
			GridPane.setConstraints(t, 0, i);
			pane.getChildren().add(t);
		}
		this.add(pane, 0, 1);
		
		Text linea = new Text("-------");
		this.add(linea, 0, 2);
		pane = new GridPane();
		for(int i = 0; i<clas.Methods.size();i++)
		{
			 
			 String ps ="";
			 
			 for(Param par : clas.Methods.get(i).Params)
			 {
				 ps = ps + par.name + " : " + par.type;
			 }
			 
			 String text = clas.Methods.get(i).name + "("+ ps + ") : " + clas.Methods.get(i).type;
			 Text t = new Text(text);
			 GridPane.setConstraints(t, 0, i);
			 pane.getChildren().add(t);
				
		}
		this.add(pane, 0, 3);
		this.setStyle("-fx-border-color: black;");
		
		
	}
	
	

}
