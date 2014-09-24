package application;
	
import java.io.File;
import java.util.List;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.stage.*;


public class Main extends Application {
	
	//Este es el main por ahora que ofrece una humilde interfaz grafica
	//@Override
	static File file;
	static Label lbl;
	static FileChooser chooser;
	static Stage stage;
	static Button btn;
	public void start(Stage stage) {
		
		//Esta parte lo unico que hace es una ventanita simple con un boton
		lbl = new Label("Escoge el archivo apretando el boton");
		btn = new Button("ClickMe");
		btn.setAlignment(Pos.CENTER);
		chooser = new FileChooser();
		
		FileChooser.ExtensionFilter filt = new FileChooser.ExtensionFilter("xml", "*.xml");
		chooser.getExtensionFilters().add(filt);
		btn.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) {
						btn.setDisable(true);
						Button1Pressed();
					}
			
				});
	
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(lbl);
		root.getChildren().add(btn);
		
		Scene scene = new Scene(root, 300,300);
		
		
		stage.setScene(scene);
		
		stage.show();
	}
	
	public void Button1Pressed()
	{
		//al apretar el boton te vienes para aca dnde buscas el archivo con Dialog
		//Aqui se revisa el titulo del xml para saber con que estamos tratando y actuar acorde
		//Diagram hace los diagramas de Usercases
		file = chooser.showOpenDialog(stage);
		XMLCompiler compiler = new XMLCompiler();
		if(compiler.root(file).equals("UseCaseDiagram"))
		{
		List<Actor> Actors = compiler.getActors(file);
		List<UseCase> UseCases = compiler.getUseCase(file);
		List<Connection> Connections = compiler.getConnections(file);
		
		Diagram d = new Diagram(Actors, UseCases, Connections);
		String path = file.getAbsolutePath();
		path = path.replace(".xml", ".png");
		d.SaveIamge(path);
		}
		else if(compiler.root(file).equals("ClassDiagram"))
		{
			List<Class> Classes = compiler.getClasses(file);
			ClassDiagram cd = new ClassDiagram(Classes);
			String path = file.getAbsolutePath();
			path = path.replace(".xml", ".png");
			cd.SaveIamge(path);
			
			
		}
		
		
		btn.setDisable(false);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
