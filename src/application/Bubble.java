package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class Bubble extends Group {
	
	Ellipse ellipse;
	int lineas=0;
	public Bubble(String text)
	{
		int spaces = text.length() - text.replaceAll(" ", "").length();
		
		if(text.length() > 11)
		{
			if(spaces>=3){
			text = text.replaceFirst(" ", "xxxx");
			text = text.replaceFirst(" ", "xxxx");
			text = text.replaceFirst(" ", "\n");
			text = text.replace("xxxx", " ");
			lineas++;
			}
			else
			{
				text= text.replaceFirst(" ", "\n");
				lineas++;
			}
			
		}
		
		ellipse = new Ellipse();
		
		ellipse.setRadiusX(70);
		ellipse.setRadiusY(lineas*40);
		ellipse.setFill(Color.CORNFLOWERBLUE);
		
		Text t = new Text(text);
		t.layoutXProperty().set(-55);
		t.layoutYProperty().set(-10);
		
		this.getChildren().addAll(ellipse,t);
	}

}
