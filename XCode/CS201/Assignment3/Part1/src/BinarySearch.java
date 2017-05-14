// BinarySearch.java
// Caitlin Coggins

/**
 * BinarySearch finds a value in an array of values and returns its index.
 **/
public class BinarySearch
{
    /**
     * Main method, starts program.
     * Runs tester of the binary search.
     * @param args, user input, non ein this program
     **/
    public static void main( String[] args)
    {
        tester();
    }
    
    /**
     * Searches the sorted array for the test object between loIndex and hiIndex, inclusive.
     * Assumes the array is sorted in increasing order (smallest at index 0).
     * If test is found, returns its index; otherwise, returns -1.
     **/
    private static int binarySearch( int[] sorted, int test )
    {
        // start the recursion between first and last indices
        return binarySearch( sorted, test, 0, sorted.length -1 );
    }
    
    /**
     * Searches the sorted array for the test number between loIndex and hiIndex, inclusive.
     * Assumes the array is sorted in increasing order (smallest at index 0).
     * If test is found, returns its index; otherwise, returns -1.
     **/
    private static int binarySearch( int[] sorted, int test, int loIndex, int hiIndex )
    {
        // value not in array
        if( loIndex >= hiIndex)
            return -1;
        
        else
        {
            // location of value in middle of what is being tested
            int midIndex = loIndex + (hiIndex-loIndex)/2;
            
            // value in lower half of what was previously tested
            if(test < sorted[midIndex])
                return binarySearch( sorted, test, loIndex, midIndex);
            
            // value in upper half of what was previously tested
            else if(test > sorted[midIndex])
                return binarySearch( sorted, test, midIndex+1, hiIndex);
            
            // value found
            else
                return midIndex;
        }
    }
    
    /**
     * Creates an array of odd numbers and an array with test values.
     * Starts binary search, looking for each test value in the array of odd numbers.
     **/
    public static void tester()
    {
        // array of odd numbers
        int[] oddNumbers = new int[100];
        
        // array of numbers to search for
        int[] findValues = {26, 78 , 100, 186, 13, 99, 101, 177};
        
        // first odd number
        int odd = 1;
        
        // holds returned location of value in oddNumbers array
        int found;
        
        // places the first 100 odd numbers into the oddNumbers array
        for(int i=0; i<100; ++i)
        {
            oddNumbers[i]=odd;
            
            odd+=2;
        }
        
        // searches for each value in findValues in oddNumbers with binarySearch
        for(int i=0; i<findValues.length; ++i)
        {
            found = binarySearch(oddNumbers, findValues[i]);
            
            System.out.println("searching for " + findValues[i] + ": " + found);
        }
    }
}
