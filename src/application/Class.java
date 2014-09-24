package application;

import java.util.ArrayList;
import java.util.List;

public class Class {

	String id;
	String name;
	List<Attributes> Atts;
	List<Method> Methods;
	
	public Class(String id, String name)
	{
		this.id=id;
		this.name=name;
		Atts = new ArrayList<Attributes>();
		Methods = new ArrayList<Method>();
	}
	public void addAtt(Attributes a)
	{
		Atts.add(a);
	}
	public void addMeth(Method m)
	{
		Methods.add(m);
	}
}
