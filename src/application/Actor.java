package application;

public class Actor extends Graficos{

	Type type;
	String id;
	String name;
	int x;
	int y;
	public  Actor(Type type, String id, String name){
		this.type = type;
		this.id = id;
		this.name=name;
	}
	public void setPos(int x, int y)
	{
		this.x=x;
		this.y=y;
			
	}
}
