package application;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClassDiagram {

	Stage stage;
	Scene scene;
	GridPane grid;
	
	public ClassDiagram(List<Class> Classes)
	{
		if(Classes!=null){
			int j = 0;
			grid = new GridPane();
		for(int i =0; i<Classes.size();i++)
		{
			Class clas = Classes.get(i);
			
			Box b = new Box(clas);
			
		    Text t = new Text("    ");
		    grid.add(t, i+1, 0);
			grid.add(b, j, 0);
			j = j+2;
			
			
		}
		scene = new Scene(grid,Classes.size()*250,200);
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
		}
	}
	public void SaveIamge(String path)
	{
		WritableImage image = grid.snapshot(new SnapshotParameters(), null);
		
		File file = new File(path);
		 try {
		        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
		    } catch (IOException e) {
		        // TODO: handle exception here
		    }
	}
}
