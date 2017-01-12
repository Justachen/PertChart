//Justin Chen
//Assignment 5

package cse360assign5;

import java.util.*;

/**
 *
 * @author Debra Calliss
 *
 * class NetworkTable is used to hold the nodes and edges of a network
 *
 * variables
 * 	table - a list of all nodes (uses NetworkEntry)
 *  lookup = a secondary data structure used for searching
 *
 */

public class NetworkTable {

	private ArrayList<NetworkEntry> table;
	private StringListExt lookup;

	/**
	 * GraphTable
	 *
	 * Create an empty table and lookup list
	 */

	NetworkTable () {
		table = new ArrayList<NetworkEntry>();
		lookup = new StringListExt();
	}

	/**
	 * print
	 *
	 * Print all entries in the table, one entry per line
	 *
	 */

	public void print() {

		for (int pos = 0; pos < table.size(); pos++)
			System.out.println(table.get(pos).toString());
	}

	/**
	 * add
	 *
	 * Add the information on a node into the table.  If the node already appears, add the
	 * predecessor to its predecessor list
	 *
	 * @param name - name of node
	 * @param val - weight of the node
	 * @param pred - name of a node that precedes the node
	 *
	 */

	public void add (String name, int val, String pred) {

		NetworkEntry entry;

		int loc = lookup.search (name);
		if (loc == -1) {  // node is not in table
			entry = new NetworkEntry (name, val, pred);

			table.add(entry);
			if (lookup.search(name) == -1)
				lookup.add(name);
		}
		else {
			entry = table.get(loc);
			entry.addPred (pred);
		}
	}

	/**
	 * setSuccessors
	 *
	 * Work through the table and set all successors for each node
	 *
	 */

	public void setSuccessors () {

		for (int pos = 0; pos < table.size(); pos++){

			String nodeName = table.get(pos).getLabel();
			StringListExt predList = table.get(pos).getPredList();

			for (int predPos = 0; predPos < predList.length(); predPos++) {

				String pred = predList.get(predPos);

				if (!pred.equals("-")) {

					int tempPos = lookup.search(pred);
					if (tempPos != -1)
						table.get(tempPos).addSucc(nodeName);
				}
			}
		}
	}
	
	public NetworkEntry getFirst()	{
		NetworkEntry temp = null;
		for(int index = 0; index < table.size(); index++)	{
			for(int index2 = 0; index2 < table.get(index).getPredList().length(); index2++)	{
				if("-" == table.get(index).getPredList().get(index2).toString())	{
					temp = table.get(index);
				}
			}
		}
		return temp;
	}
	
	public NetworkEntry getEntry(String name)	{
		NetworkEntry temp = null; 
		for(int index = 0; index < table.size(); index++)	{
			if(table.get(index).getLabel().equals(name))	{
				temp = table.get(index);
			}
		}
		return temp;
	}
}

