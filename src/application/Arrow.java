package application;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class Arrow extends StackPane{

	Line body;
	Line head1;
	Line head2;
	
	public Arrow(int xi, int yi, int xf, int yf)
	{
		body=new Line();
		head1= new Line();
		head2 = new Line();
		
		
		if(xi==xf)
		{
		
			
			if(yi>yf)
			{
				body = new Line(50,0,50,100);
				body.strokeWidthProperty().setValue(5);
				body.scaleYProperty().set(0.8);
				head1 = new Line(50,100,40,80);
				head1.translateYProperty().set(35);
				head1.strokeWidthProperty().setValue(5);
				head1.translateXProperty().set(-7);
				head2 = new Line(50,100,60,80);
				head2.translateYProperty().set(35);
				head2.translateXProperty().set(8);
				head2.strokeWidthProperty().setValue(5);
				
			}
			else
			{
				body = new Line(50,0,50,100);
				body.strokeWidthProperty().setValue(5);
				body.scaleYProperty().set(0.8);
				head1 = new Line(50,100,40,80);
				head1.translateYProperty().set(-35);
				head1.strokeWidthProperty().setValue(5);
				
				head2 = new Line(50,100,60,80);
				head2.translateYProperty().set(-35);
				head2.translateXProperty().set(-7);
				head2.strokeWidthProperty().setValue(5);
			}
		}
		else
		{
			if(xi>xf)
			{
				body = new Line(0,50,100,50);
				body.strokeWidthProperty().setValue(5);
				body.scaleXProperty().set(0.8);
				head1 = new Line(100,50,80,40);
				head1.translateYProperty().set(8);
				head1.translateXProperty().set(-35);
				head1.strokeWidthProperty().setValue(5);
				
				head2 = new Line(100,50,80,60);
				head2.translateXProperty().set(-35);
				head2.translateYProperty().set(-7);
				head2.strokeWidthProperty().setValue(5);
			}
			else
			{
				body = new Line(0,50,100,50);
				body.strokeWidthProperty().setValue(5);
				body.scaleXProperty().set(0.8);
				head1 = new Line(100,50,80,40);
				head1.translateYProperty().set(-7);
				head1.translateXProperty().set(35);
				head1.strokeWidthProperty().setValue(5);
				
				head2 = new Line(100,50,80,60);
				head2.translateXProperty().set(35);
				head2.translateYProperty().set(8);
				head2.strokeWidthProperty().setValue(5);
			}
		}
		
		this.getChildren().addAll(body,head1,head2);
	}
}
