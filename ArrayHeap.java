//Justin Chen
//Assignment 5

package cse360assign5;

import java.util.*;

/**
 * class ArrayHeap
 *
 * @author dcalliss
 *
 * Methods to implement a heap for a priority queue.
 *
 */

public class ArrayHeap {

	/**
	 * Constructor
	 *
	 * Create an empty heap
	 */

	private ArrayList<ArrayHeapEntry> queue;

	ArrayHeap () {
		queue = new ArrayList<ArrayHeapEntry> ();
	}

	/**
	 * insert
	 *
	 * Create an entry from the parameters and then insert the entry into
	 * the last position.  The heap is then reconstructed.
	 *
	 * @param val
	 * @param list
	 */

	public void insert (int val, StringListExt list) {

		ArrayHeapEntry temp = new ArrayHeapEntry (val, list);

		queue.add(temp);

		reheap (queue.size() - 1);
	}

	/*
	 * reheap
	 *
	 * Private method to assist in insert into the heap.  The entry in the
	 * heap is compared to the parent and moved up the array.
	 *
	 */

	private void reheap (int lastPos) {

		int parent = (lastPos - 1) / 2;

		if (parent >= 0) {
			if (queue.get(parent).getKey() < queue.get(lastPos).getKey()) {
				swap (parent, lastPos);
				reheap (parent);
			}
		}
	}

	/*
	 * swap
	 *
	 * Exchange the entries at the positions indicated.
	 *
	 */

	private void swap (int pos1, int pos2) {

		ArrayHeapEntry temp = queue.get(pos1);
		queue.set(pos1, queue.get(pos2));
		queue.set(pos2, temp);
	}

	/**
	 * newEntries
	 *
	 * Return the current size of the array
	 *
	 * @return count of items in array
	 */

	public int numEntries() {
		return queue.size();
	}

	/*
	 * heapDown
	 *
	 * Method to help with the delete method.  An entry is compared to
	 * its children and swapped if needed.
	 *
	 */
	private void heapDown (int pos) {

		int size = queue.size();
		int leftPos = (pos + 1) * 2 - 1;
		int rightPos = (pos + 1) * 2;
		int swapPos = leftPos;

		if (leftPos < size) {
			if (rightPos < size)
				if (queue.get(leftPos).getKey() < queue.get(rightPos).getKey())
					swapPos = rightPos;
			if (queue.get(pos).getKey() < queue.get(swapPos).getKey()) {
				swap (pos, swapPos);
				heapDown (swapPos);
			}
		}
	}

	/**
	 * remove
	 *
	 * The first entry in the array is returned and then the heap
	 * is adjusted.
	 *
	 * @return first entry
	 */

	public ArrayHeapEntry remove () {

		ArrayHeapEntry entry = null;
		int size = queue.size();

		if (size >= 1) {
			entry = queue.get(0);
			queue.set(0, queue.get(size - 1));
			queue.remove(size - 1);
			heapDown (0);
		}

		return entry;
	}
	
	/* 		PRINT STUFF JUSTIN CHEN ADDED		*/
	
	void print()	{	//-print all entries in the heap in the order from the beginning (position 0) to the last. 
		int size = queue.size();
		for(int index = 0; index < size; index++)	{
			System.out.println(queue.get(index).toString());	//prints out every index of the array
		}
		System.out.println("");
	}
	
	public void printAll()	{	// assignment5
		int size = queue.size();
		ArrayHeapEntry Stringtemp = null;
		for(int index = 0; index < size; index++)	{
			Stringtemp = remove();
			System.out.println(Stringtemp.toString());
		}
		System.out.println("");
	}

}