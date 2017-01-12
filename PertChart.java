//Justin Chen
//CSE360
//Assignment 5
//11/29/16

package cse360assign5;

public class PertChart {
	
	private NetworkTable table;
	private ArrayHeap paths;
	
	PertChart(String [][] data)	{
		table = new NetworkTable();
		for(int index = 0; index < data.length; index++)	{	// fills a new networktable table
			String name = data[index][0];
			int cost = Integer.parseInt(data[index][1]);
			String pred = data[index][2];
			table.add(name,cost,pred);
		}
		table.setSuccessors();	// sets successors for the table
		findPaths();	
	}
	
	private void findPaths()	{	// finds all the paths and their costs from the data
		
		paths = new ArrayHeap();	// creates path heap
		boolean succAvail = true;	
		NetworkEntry FirstTemp = table.getFirst();	//get first entry from table
		StringListExt StringTemp = new StringListExt();	
		StringTemp.add(FirstTemp.getLabel());	// get label of first entry & add into a stringlist
		paths.insert(FirstTemp.getCost(), StringTemp);	// insert cost and first label into path heap
		
		while(succAvail)	{	// while succAvail is true
			succAvail = false;	// succAvail is false
			ArrayHeap TempHeap = paths;	//	create a temp heap
			ArrayHeap Finalheap = new ArrayHeap();	// Final paths temp
			
			while(paths.numEntries() != 0)	{	// while there are entries in the path heap
				ArrayHeapEntry HeapTemp;	//heap temp
				HeapTemp = paths.remove();	// remove top entry from heap
				String LastName = HeapTemp.getList().getLast();	//get last entry name from list
				StringListExt SuccTemp = new StringListExt();
				SuccTemp = table.getEntry(LastName).getSuccList();	//get successor list for last entry name
				
				for(int index = 0; index < SuccTemp.length(); index++)	{	// for every entry in the successor list
					StringListExt StringListTemp = new StringListExt();
					
					for(int index2 = 0; index2 < HeapTemp.getList().length(); index2++)	// fills a new stringlistext 
						StringListTemp.add(HeapTemp.getList().get(index2));
					
					NetworkEntry tempNet;
					tempNet = table.getEntry(SuccTemp.get(index));	// get entry for successor 
					int TotalCost =  HeapTemp.getKey() + tempNet.getCost();	// cost of successor + cost of top entry
					StringListTemp.add(SuccTemp.get(index));	// append label of successor to new string list
					TempHeap.insert(TotalCost, StringListTemp);	//	insert new cost and new stringlist u made into temp heap		1
					if(tempNet.getSuccList().length() != 0)	
						succAvail = true;	// if the successor has a successor, then succAvail = true
				}	
				
				if(table.getEntry(HeapTemp.getList().getLast()).getSuccList().length() == 0)	{
					Finalheap.insert(HeapTemp.getKey(), HeapTemp.getList());
				}
				
			}
			//copies the final paths from the data onto paths
			paths = Finalheap;
		}
		//signifies new data
		System.out.println("--------------------------------------New Data--------------------------------------");
	}
	
	public void printAllPaths()	{	//Prints all the paths in order of greatest to least
		System.out.println("Path(s) for the Data:");
		paths.print();
	}
}
