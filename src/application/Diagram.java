package application;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Diagram {

	Stage stage;
	Scene scene;
	Group group;
	//Esta clase me hace una ventana con el diagrama dados los datos del .xml
	public Diagram(List<Actor> Actors, List<UseCase> UseCases, List<Connection> Connections)
	{
		Map gElements = new HashMap();
		stage = new Stage();
		
		GridPane grid = new GridPane();
		
		int heigth = 300;
		int width = 300;
		
		for(int i = 1; i<Actors.size()+1 && i<3; i++)
		{
			Actor act = Actors.remove(0);
			Stickman stick = new Stickman(act.name); 
			gElements.put(act.id, stick);
			
			switch(i)
			{
			case 1:
				act.setPos(0, 2);
				GridPane.setConstraints(stick, 0, 2);
				break;
			case 2:
				act.setPos(6, 3);
				GridPane.setConstraints(stick, 6, 3);
				break;
			
			}
			Actors.add(act);
			grid.getChildren().add(stick);
		}
		
		
		if(UseCases.size()<=10)
		{
			heigth = 410;
			width =  600;
			for(int i = 1; i<UseCases.size()+1;i++)
			{
				UseCase uc = UseCases.remove(0);
				
				Bubble b = new Bubble(uc.name);
				
				gElements.put(uc.id, b);
				switch(i)
				{
				case 8:
					uc.SetPos(1, 1);
					GridPane.setConstraints(b, 1, 1);
					break;
				case 6:
					uc.SetPos(1, 3);
					GridPane.setConstraints(b, 1, 3);
					break;
				case 5:
					uc.SetPos(2, 0);
					GridPane.setConstraints(b, 2, 0);
					break;
				case 2:
					uc.SetPos(2, 2);
					GridPane.setConstraints(b, 2, 2);
					break;
				case 1: 
					uc.SetPos(2, 4);
					GridPane.setConstraints(b, 2, 4);
					break;
				case 3:
					uc.SetPos(3, 1);
					GridPane.setConstraints(b, 3, 1);
					break;
				case 4:
					uc.SetPos(3, 3);
					GridPane.setConstraints(b, 3, 3);
					break;
				case 7:
					uc.SetPos(4, 0);
					GridPane.setConstraints(b, 4, 0);
					break;
				case 9:
					uc.SetPos(4, 2);
					GridPane.setConstraints(b, 4, 2);
					break;
				case 10: 
					uc.SetPos(4, 4);
					GridPane.setConstraints(b, 4, 4);
					break;
					
				}
				
				
				grid.getChildren().add(b);
				UseCases.add(uc);
				
			}
		}
		
		group = new Group(grid);
		
		
		
		scene = new Scene(group, width, heigth);
		
		for(int i = 1; i< Connections.size()+1;i++)
		{
			Connection con = Connections.remove(0);
			Group po = (Group) gElements.get(con.from);
			Group pf = (Group) gElements.get(con.to);
			
			Connections.add(con);
			
		}
		stage.setScene(scene);
		stage.show();
		
	}
	public void SaveIamge(String path)
	{
		WritableImage image = group.snapshot(new SnapshotParameters(), null);
		
		File file = new File(path);
		 try {
		        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
		    } catch (IOException e) {
		        // TODO: handle exception here
		    }
	}
}

