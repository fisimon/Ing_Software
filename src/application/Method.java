package application;

import java.util.ArrayList;
import java.util.List;

public class Method {
	String name;
	String type;
	
	List<Param> Params;
	
	public Method(String name, String type)
	{
		this.name=name;
		this.type=type;
		Params = new ArrayList<Param>();
	}
	public void addParam(Param p)
	{
		Params.add(p);
	}

}
