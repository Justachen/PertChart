//Justin Chen
//Assignment 5

package cse360assign5;

public class ArrayHeapEntry{
	private int key;
	private StringListExt list;
	
	public ArrayHeapEntry(int keyval, StringListExt listinit)	{		//initializes variables
		key = keyval;
		list = listinit;
	}
	
	int getKey(){	//returns the key val
		return key;
	}
	
	StringListExt getList()	{	//returns the list
		return list;
	}
	
	public String toString(){
		//return data values as a String.  There should be a space between the key and the start of the StringListExt
		String output = "";
		output = key + " " + list.toString();
		return output;
	}
	
}