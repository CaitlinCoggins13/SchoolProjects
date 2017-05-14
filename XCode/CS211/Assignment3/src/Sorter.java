// Sorter.java
// Caitlin Coggins

import java.lang.Math.*;

/*
 * Sorter contains methods that can sort Comparable arrays by insertion, selection, bubble, or merge.
 * EDIT: Heapsort has been added.
 */
public class Sorter 
{
	/**
     * Sorts the parameter array with insertion sort.
     * @param comparable the unsorted array
     * @return comparable the sorted array
     */
    public static Comparable[] insertionSort(Comparable[] comparable)
    {
    	// assists in moving values
        Comparable move;
        
        // points to the line between the sorted and unsorted parts of the array
        int point = 0;
        
        // holds the cell of the lowest value checked
        int least = 0;
        
        // for every value until the array is sorted
        for(int i = point; i<comparable.length; ++i)
        {
        	least = point;
        
        	// for every value in the current unsorted portion of the array
            for( int j = point; j<comparable.length; ++j)
            {
            	// compare the values
                int compare = comparable[least].compareTo(comparable[j]);
                
             // if the new value is less than the current one, set the least value to be the new value 
                if(compare == 1)
                    least = j;
            }
            
            // hold the least value
            move = comparable[least];
          
            // shift every element between least's former place and the border of the sorted array up one cell
            for(int k = least; k > point; --k)
            {
                comparable[k] = comparable[k-1];
            }
      
            // put the least value in the array
            comparable[i] = move;
            
            // move the pointer
            ++point;
        }
        
        return(comparable);
    }
    
    /**
     * Sorts the parameter array with selection sort.
     * @param comparable the unsorted array
     * @return comparable the sorted array
     */
    public static Comparable[] selectionSort(Comparable[] comparable)
    {
    	// assists with moving values
        Comparable move;
        
        // points to the line between the sorted and unsorted parts of the array
        int point = 0;
        
        // holds the cell of the lowest value checked
        int least = 0;
        
        for(int i=0; i<comparable.length; ++i)
        {
        	least = point;
        	
        	// in the unsorted portion of the array
            for(int j=point; j<comparable.length; ++j)
            {
            	// compare values
                int compare = comparable[least].compareTo(comparable[j]);
            
                // if the new value is less than the current one, set the least value to be the new value
                if(compare == 1)
                    least = j;
            }
            // move the least value to its correct place in the sorted part
            move = comparable[least];
            comparable[least] = comparable[i];
            // move the value that was where the least was to where the least value used to be
            comparable[i] = move;
            
            // move the pointer
            ++point;
        }
        
        return(comparable);
    }
    
    /**
     * Sorts the parameter array with bubble sort.
     * @param comparable the unsorted array
     * @return comparable the sorted array
     */
    public static Comparable[] bubbleSort(Comparable[] comparable)
    {
    	// assists with switching two values
        Comparable move;
        
        // counts the number of elements in order
        int inOrder = 0;
        
        // while the number of sorted elements is less than the total number of elements
        while(inOrder < comparable.length-1)
        {
            inOrder = 0;
            
            for(int i=0; i<comparable.length-1; ++i)
            {
            	// compare two consecutive elements
                int compare = comparable[i].compareTo(comparable[i+1]);
                
                // if the one to the right is less than the one one the right
                if(compare == 1)
                {
                	// switch the order of the values
                    move = comparable[i];
                    comparable[i] = comparable[i+1];
                    comparable[i+1] = move;
                }
                // if they're in order
                else
                {
                	// add one to the "in order" counter
                	++inOrder;
                }
                   
            }
            
        }
        return(comparable);
    }
    
    /**
     * Sorts an array with merge sort
     * @param comparable the array to be sorted
     * @return the array created after merging all sorted arrays together
     */
    public static Comparable[] mergeSort(Comparable[] comparable)
    {
    	// if there is 1 element or less, return the array
        if (comparable.length < 2)
            return comparable;
        else
        {
        	// find the midpoint of the array
        	int mid = comparable.length/2;
        	
        	// initialize two arrays to hold the two halves
        	Comparable[] firstHalf = new Comparable[mid];
        	Comparable[] secondHalf = new Comparable[comparable.length - mid];
        	
        	// copy parts of the original array into the two halved arrays
        	System.arraycopy(comparable, 0, firstHalf, 0, mid);
        	System.arraycopy(comparable, mid, secondHalf, 0, comparable.length - mid);
        	
        	// recursively sorts and merges the whole array
        	return merging(mergeSort(firstHalf), mergeSort(secondHalf));
        }
    }
    
    /**
     * Merges two sorted arrays
     * @param part1 one array to be sorted
     * @param part2 the other array to be sorted
     * @return combined the merged array
     */
    private static Comparable[] merging(Comparable[] part1, Comparable[] part2) 
    {
    	// holds the new merged array
    	Comparable[] combined;
    	
    	// points to the line between the placed and unplaced elements in part1
        int j = 0;
        
        // points to the line between the placed and unplaced elements in part2
        int k  = 0; 
        
        // initialize combined array
        combined = new Comparable[part1.length + part2.length];
        
        // for every element to be placed
        for (int i = 0; i < combined.length; ++i) 
        {
        	// if there are still elements to be placed in both parts
            if(j < part1.length && k < part2.length)
            {
            	// if the value in array 1 is less
                if(part1[j].compareTo(part2[k]) == -1)
                {
                	// make the next value in the combined array this value of array 1
                    combined[i] = part1[j];
                    
                    // move the pointer
                    j++;
                }
                // if the value in array two is less or both values are equal
                else
                {
                	// make the next value in the combined array this value of array 2
                    combined[i] = part2[k];
                    
                    // move the pointer
                    k++;
                }
            }
            // if all the elements in an array have already been placed
            else
            {
            	// if part1 is the array with remaining elements
                if(j < part1.length)
                {
                	// copy all the remaining elements into the combined array
                    System.arraycopy(part1, j, combined, i, part1.length-j);
                    break;
                }
                
                // if part2 is the array with remaining elements
                else
                {
                	// copy all the remaining elements into the combined array
                    System.arraycopy(part2, k, combined, i, part2.length-k);
                    break;
                }
            }
        }
        return combined;
    } 
    
    /**
     * Performs a heap sort on an array of data.
     * @param comparable the array of unsorted data
     * @return the sorted array
     * @pre the array of data is comparable data, the array is not empty
     * @post the array is sorted from min to max
     */
    public static Comparable[] heapSort(Comparable[] comparable)
    {
    	// instance of heap
    	BinaryHeapA sortHeap = new BinaryHeapA();
    	
    	// all values put in heap
    	for(int i = 0; i<comparable.length; ++i)
    	{
    		sortHeap.insert(comparable[i]);
    	}
    	
    	// for all values, root value is stored, heap has last value moved to the root and resorted
    	for(int i = 0; i<comparable.length; ++i)
    	{
    		comparable[i] = sortHeap.getRoot();
    		sortHeap.changeRoot();
    	}
    	
    	return comparable;
    }
    
    /**
     * Converts a Comparable[] to an Integer[].  Only used by merge sort.
     * @param old
     * @param change
     */
    public static void convert(Comparable[] old, Comparable[] change)
    {
    	for(int i = 0; i < old.length; ++i)
    	{
    		change[i] = old[i];
    	}
    }
}