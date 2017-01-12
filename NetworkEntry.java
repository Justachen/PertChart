//Justin Chen
//Assignment 5

package cse360assign5;

public class NetworkEntry {
	
	private String name;
	private int cost;
	private StringListExt predList;
	private StringListExt succList;
	
	public NetworkEntry(String nameval, int costval, String pred)
	{
		name = nameval;		//Initialize the class level variables
		cost = costval;
		predList = new StringListExt();
		succList = new StringListExt();
		predList.insert(pred);	// leaves succList empty and puts pred in predList
	}
	
	StringListExt getPredList()
	{	//returns the list predList
		return predList;
	}
	
	StringListExt getSuccList()
	{	//returns the list succList
		return succList;
	}
	
	String getLabel()
	{	//returns the name
		return name;
	}
	
	int getCost()
	{	// returns the value
		return cost;
	}
	
	void addSucc(String succ)
	{	// adds variable into SuccList
		//System.out.println(succ);
		succList.insert(succ);
	}
	
	void addPred(String pred)
	{	// adds variable into predList
		predList.insert(pred);
	}
	
	public String toString()
	{	// Prints out the whole line from name, cost, predList, succList
		String outputList = "";
		outputList += name + " " + cost + " Pred " + predList.toString() + "Succ " + succList.toString(); 
		return outputList;
	}
}

