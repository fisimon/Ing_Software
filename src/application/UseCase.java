package application;

public class UseCase extends Graficos{

	String id;
	String name;
	
	int x;
	int y;
	
	public UseCase(String id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public void SetPos(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
}
