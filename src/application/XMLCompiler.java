package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public  class XMLCompiler {
	
	//Esta clase es la que lee el .xml
	
	//root me da el nombre del nodo principal
	public String root(File file)
	{
		Document doc;
		try{
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  doc = db.parse(file);
		  doc.getDocumentElement().normalize();
		}catch(Exception e)
		{
			return "ERROR2";
		}
		return doc.getDocumentElement().getNodeName();
	}

	//estos metodos me devuelven una lista con la informacion del .xml
	public List<Actor> getActors(File file)
	{
		List<Actor> Actors = new ArrayList<Actor>();
		Document doc;
		NodeList nodes;
		try{
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  doc = db.parse(file);
		  doc.getDocumentElement().normalize();
		  
		  nodes = doc.getElementsByTagName("actor");
		  for(int i = 0; i<nodes.getLength();i++)
		  {
			  Type type = Type.PRIMARY;
			  String id;
			  String name;
			  
			  Element node = (Element)nodes.item(i);
			  
			  if(node.getAttribute("type").equals("primary"))
			  {
				  type = Type.PRIMARY;
			  }
			  else if(node.getAttribute("type").equals("secondary"))
			  {
				  type = Type.SECONADRY;
			  }
			  else
			  {
				  System.out.println("Error3");
			  }
			  
			  id = node.getAttribute("id");
			  
			  name = node.getAttribute("name");
			  Actor a = new Actor(type,id,name);
			  Actors.add(a);
		  }
		  
		  
		  }catch(Exception e)
		{
			  return null;
		}
		
		return Actors;
	}
	public List<UseCase> getUseCase(File file)
	{
		List<UseCase> UseCases = new ArrayList<UseCase>();
		Document doc;
		NodeList nodes;
		try{
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  doc = db.parse(file);
		  doc.getDocumentElement().normalize();
		  
		  nodes = doc.getElementsByTagName("usecase");
		  
		  for(int i = 0; i<nodes.getLength();i++)
		  {
			 
			  String id;
			  String name;
			  
			  Element node = (Element)nodes.item(i);
			  
			  
			  
			  id = node.getAttribute("id");
			  
			  name = node.getAttribute("name");
			  UseCase u = new UseCase(id,name);
			  UseCases.add(u);
		  }
		  
		  
		  }catch(Exception e)
		{
			  return null;
		}
		
		return UseCases;
	}
	public List<Connection> getConnections(File file)
	{
		List<Connection> Connections = new ArrayList<Connection>();
		Document doc;
		NodeList nodes;
		try{
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  doc = db.parse(file);
		  doc.getDocumentElement().normalize();
		  
		  nodes = doc.getElementsByTagName("connection");
		  
		  for(int i = 0; i<nodes.getLength();i++)
		  {
			  CType type = CType.BASIC;
			  String from;
			  String to;
			  
			  Element node = (Element)nodes.item(i);
			  
			  if(node.getAttribute("type").equals("basic"))
			  {
				  type = CType.BASIC;
			  }
			  else if(node.getAttribute("type").equals("extend"))
			  {
				  type = CType.EXTEND;
			  }
			  else if(node.getAttribute("type").equals("include"))
			  {
				  type = CType.INCLUDE;
			  }
			  else if(node.getAttribute("type").equals("isa"))
			  {
				  type = CType.ISA;
			  }
			  else
			  {
				  System.out.println("Error4");
			  }
			  
			  from = node.getAttribute("from");
			  
			  to = node.getAttribute("to");
			  Connection c  = new Connection(type, from,to);
			  Connections.add(c);
		  }
		  
		  
		  }catch(Exception e)
		{
			  return null;
		}
		
		return Connections;
	}
	
	public List<Class> getClasses(File file)
	{
		List<Class> Classes = new ArrayList<Class>();
		Document doc;
		NodeList nodes;
		try{
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  doc = db.parse(file);
		  doc.getDocumentElement().normalize();
		  
		  nodes = doc.getElementsByTagName("class");
		  
		  for(int i = 0; i<nodes.getLength();i++)
		  {
			 
			  String id;
			  String name;
			  
			  Element node = (Element)nodes.item(i);
			  
			  
			  
			  id = node.getAttribute("id");
			  
			  name = node.getAttribute("name");
			  
			  Class c = new Class(id,name);
			  
			  NodeList atts = node.getElementsByTagName("att");
			  
			  for(int j = 0; j<atts.getLength();j++)
			  {
				  
				  
				  Element node2 = (Element)atts.item(j);
				  		  
				  
				  
				  name = node2.getAttribute("name");
				  String vis = node2.getAttribute("visibility");
				     
				  
				  Attributes a = new Attributes(id,name,vis);
				  
				  c.addAtt(a);
			  }
			  
			  NodeList mets = node.getElementsByTagName("method");
			  
			  
			  for(int j = 0; j<mets.getLength();j++)
			  {
				  
				  Element node2 = (Element)mets.item(j);
				  name = node2.getAttribute("name");
				  String type= node2.getAttribute("type");
				  
				  Method m = new Method(name , type);
				  
				  NodeList params = node2.getElementsByTagName("param");
				  
				  for(int k =0;k<params.getLength();k++)
				  {
					  Element node3 = (Element) params.item(k);
					  
					  name = node3.getAttribute("name");
					  type= node3.getAttribute("type");
					  
					  Param p = new Param(name,type);
					  
					  m.addParam(p);
							  
					  
				  }
				  c.addMeth(m);
				  
				  
			  }
			  Classes.add(c);
			  
		  }
		  
		  
		  }catch(Exception e)
		{
			  
			  System.out.println(e.toString());
			  return null;
		}
		
		return Classes;
	}

}
