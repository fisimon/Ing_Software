package application;

import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Stickman extends Group {

	public Stickman (String name)
	{
		
		Circle c = new Circle(50,20,10);
		Line body = new Line(50,57,50,20);
		Line leg1 = new Line(50, 57, 40, 70);
		Line leg2 = new Line(50, 57, 60, 70);
		Line arms = new Line(40,40,60,40);
		Text t = new Text(name);
		t.setY(85);
		
		this.getChildren().addAll(c,body, leg1,leg2, t,arms);
	}
}
