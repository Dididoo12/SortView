/*

Author: Edward Tang
Date: November 9, 2018
Purpose: This program is designed to test different sorting methods on randomized integer arrays and display the results.

*/

// The "Sorting" class.
import java.awt.*;
import hsa.Console;
import java.lang.Math;

public class Sorting
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console (45, 153, "Sorting");
	String restart;
	do
	{
	    c.clear ();
	    SortMethods sortTest = new SortMethods (100);
	    sortTest.reset ();

	    c.println ("[TESTING PHASE]\n\nBubble - " + sortTest.sorted () + " (before):");
	    sortTest.print (c);
	    sortTest.bubble ();
	    c.println ("\nBubble - " + sortTest.sorted () + " (after):");
	    sortTest.print (c);
	    sortTest.reset ();
	    c.println ("\n\nSelection - " + sortTest.sorted () + " (before):");
	    sortTest.print (c);
	    sortTest.selection ();
	    c.println ("\nSelection - " + sortTest.sorted () + " (after):");
	    sortTest.print (c);
	    sortTest.reset ();
	    c.println ("\n\nInsertion - " + sortTest.sorted () + " (before):");
	    sortTest.print (c);
	    sortTest.insertion ();
	    c.println ("\nInsertion - " + sortTest.sorted () + " (after):");
	    sortTest.print (c);
	    sortTest.reset ();
	    c.println ("\n\nQuick - " + sortTest.sorted () + " (before):");
	    sortTest.print (c);
	    sortTest.quick ();
	    c.println ("\nQuick - " + sortTest.sorted () + " (after):");
	    sortTest.print (c);
	    sortTest.reset ();
	    c.println ("\n\nMerge - " + sortTest.sorted () + " (before):");
	    sortTest.print (c);
	    sortTest.merge ();
	    c.println ("\nMerge - " + sortTest.sorted () + " (after):");
	    sortTest.print (c);
	    sortTest.reset ();
	    c.println ("\n\nShell - " + sortTest.sorted () + " (before):");
	    sortTest.print (c);
	    sortTest.shell ();
	    c.println ("\nShell - " + sortTest.sorted () + " (after):");
	    sortTest.print (c);

	    c.print ("\n\n[Press any key to continue to the timing phase]");
	    c.getChar ();
	    c.clear ();

	    int initialSize = readBoundInt (1, 5000, "[TIMING PHASE]\n\nEnter the starting test size for the integer array, from 1 to 5000 (inclusive): ", "You must enter a test size between 1 and 5000 (inclusive): ");
	    sortTest = new SortMethods (initialSize);

	    c.clear ();
	    c.println ("[TIMING PHASE]\n\nThe sorting times (in milliseconds) will be displayed below (NOTE - Any sort exceeding 10 seconds of runtime will not run for the remaining tests): ");


	    Canvas graph = new Canvas ();

	    c.println ("\n   Size  Bubble  Selection  Insertion  Quick  Merge  Shell");

	    boolean continueBubble = true;
	    boolean continueSelection = true;
	    boolean continueInsertion = true;
	    boolean continueQuick = true;
	    boolean continueMerge = true;
	    boolean continueShell = true;

	    long[] [] times = new long [6] [10];

	    for (int i = 0 ; i < 10 ; i++)
	    {
		long start, timeTaken;
		c.print (sortTest.size, 7);

		if (continueBubble)
		{
		    sortTest.reset ();
		    start = System.currentTimeMillis ();
		    sortTest.bubble ();
		    timeTaken = System.currentTimeMillis () - start;
		    c.print (timeTaken, 8);
		    times [0] [i] = timeTaken;
		    if (timeTaken > 10000)
			continueBubble = false;
		}
		else
		{

		    c.print ("     N/A");
		    times [0] [i] = -1;
		}

		if (continueSelection)
		{
		    sortTest.reset ();
		    start = System.currentTimeMillis ();
		    sortTest.selection ();
		    timeTaken = System.currentTimeMillis () - start;
		    c.print (timeTaken, 11);
		    times [1] [i] = timeTaken;
		    if (timeTaken > 10000)
			continueSelection = false;
		}
		else
		{
		    c.print ("        N/A");
		    times [1] [i] = -1;
		}
		if (continueInsertion)
		{
		    sortTest.reset ();
		    start = System.currentTimeMillis ();
		    sortTest.insertion ();
		    timeTaken = System.currentTimeMillis () - start;
		    c.print (timeTaken, 11);
		    times [2] [i] = timeTaken;
		    if (timeTaken > 10000)
			continueInsertion = false;
		}
		else
		{
		    c.print ("        N/A");
		    times [2] [i] = -1;
		}

		if (continueQuick)
		{
		    sortTest.reset ();
		    start = System.currentTimeMillis ();
		    sortTest.quick ();
		    timeTaken = System.currentTimeMillis () - start;
		    c.print (timeTaken, 7);
		    times [3] [i] = timeTaken;
		    if (timeTaken > 10000)
			continueQuick = false;
		}
		else
		{
		    c.print ("    N/A");
		    times [3] [i] = -1;
		}

		if (continueMerge)
		{
		    sortTest.reset ();
		    start = System.currentTimeMillis ();
		    sortTest.merge ();
		    timeTaken = System.currentTimeMillis () - start;
		    c.print (timeTaken, 7);
		    times [4] [i] = timeTaken;
		    if (timeTaken > 10000)
			continueMerge = false;
		}
		else
		{
		    c.print ("    N/A");
		    times [4] [i] = -1;
		}

		if (continueShell)
		{
		    sortTest.reset ();
		    start = System.currentTimeMillis ();
		    sortTest.shell ();
		    timeTaken = System.currentTimeMillis () - start;
		    c.print (timeTaken, 7);
		    times [5] [i] = timeTaken;
		    if (timeTaken > 10000)
			continueShell = false;
		}
		else
		{
		    c.print ("    N/A");
		    times [5] [i] = -1;
		}

		c.println ();
		sortTest = new SortMethods (sortTest.size * 2);
	    }

	    c.println ();

	    c.setTextBackgroundColor (Color.gray);

	    long maxTime = 1;
	    for (int i = 0 ; i < times.length ; i++)
		for (int j = 0 ; j < times [i].length ; j++)
		    if (times [i] [j] > maxTime)
			maxTime = times [i] [j];

	    c.setTextColor (Color.black);
	    c.println ("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

	    sortTest.size /= 2;
	    int height = 300;
	    int width = 1100;
	    int baseY = 700;
	    int baseX = 90;

	    c.setTextBackgroundColor (Color.white);


	    c.setColor (Color.black);
	    c.setFont (new Font ("Arial", Font.BOLD, 32));
	    c.drawString ("Runtimes vs. Size", (baseX + width) / 2 - 100, baseY - height - 30);
	    c.setFont (new Font ("Arial", Font.BOLD, 16));

	    c.setColor (Color.magenta);
	    c.drawString ("Bubble, ", baseX + width / 3 - 12, baseY - height - 6);
	    c.setColor (Color.pink);
	    c.drawString ("Selection, ", baseX + width / 3 + 50, baseY - height - 6);
	    c.setColor (Color.cyan);
	    c.drawString ("Insertion, ", baseX + width / 3 + 128, baseY - height - 6);
	    c.setColor (Color.blue);
	    c.drawString ("Quick, ", baseX + width / 3 + 203, baseY - height - 6);
	    c.setColor (Color.red);
	    c.drawString ("Merge, ", baseX + width / 3 + 255, baseY - height - 6);
	    c.setColor (Color.green);
	    c.drawString ("Shell ", baseX + width / 3 + 308, baseY - height - 6);

	    c.setColor (Color.black);
	    c.drawLine (baseX, baseY - height - 4, baseX, baseY);
	    c.drawLine (baseX, baseY, baseX + width, baseY);

	    c.drawString ("Runtime (ms)", baseX - Double.toString (maxTime / 2.0).length () * 10, baseY - height - 10);
	    c.drawString ("Size", (baseX + width) / 2 + 32, baseY + 50);
	    c.setFont (new Font ("Arial", Font.BOLD, 13));
	    c.drawString (Long.toString (maxTime), baseX - Long.toString (maxTime).length () * 8, baseY - height + 13);
	    c.drawString (Double.toString (maxTime / 2.0), baseX - Double.toString (maxTime / 2.0).length () * 8, baseY - height / 2);
	    c.drawString (Integer.toString (sortTest.size), (baseX + width) - Double.toString (sortTest.size).length () / 2 * 4, baseY + 15);
	    c.drawString (Double.toString (sortTest.size / 2.0), (baseX + width) / 2 + 32, baseY + 15);
	    c.drawString ("0", baseX - 15, baseY);

	    for (int i = 0 ; i < 9 ; i++)
	    {
		// t = current time
		// conversion = maxTime/height (ms per pixel)
		// -----------------------------------------------------
		// t / conversion = y-coordinate
		// y-coordinate = t * height / maxTime
		int currentX = (int) (baseX + (int) (initialSize * Math.pow (2, i)) * (double) width / sortTest.size);
		int nextX = (int) (baseX + (int) (initialSize * Math.pow (2, i + 1)) * (double) width / sortTest.size);
		c.setColor (Color.magenta);
		if (times [0] [i + 1] != -1)
		    c.drawLine (currentX, (int) (baseY - times [0] [i] * height / maxTime) - 1, nextX, (int) (baseY - times [0] [i + 1] * height / maxTime - 1));
		c.setColor (Color.pink);
		if (times [1] [i + 1] != -1)
		    c.drawLine (currentX, (int) (baseY - times [1] [i] * height / maxTime) - 1, nextX, (int) (baseY - times [1] [i + 1] * height / maxTime) - 1);
		c.setColor (Color.cyan);
		if (times [2] [i + 1] != -1)
		    c.drawLine (currentX, (int) (baseY - times [2] [i] * height / maxTime) - 2, nextX, (int) (baseY - times [2] [i + 1] * height / maxTime) - 2);
		c.setColor (Color.blue);
		if (times [3] [i + 1] != -1)
		    c.drawLine (currentX, (int) (baseY - times [3] [i] * height / maxTime) - 3, nextX, (int) (baseY - times [3] [i + 1] * height / maxTime) - 3);
		c.setColor (Color.red);
		if (times [4] [i + 1] != -1)
		    c.drawLine (currentX, (int) (baseY - times [4] [i] * height / maxTime) - 4, nextX, (int) (baseY - times [4] [i + 1] * height / maxTime) - 4);
		c.setColor (Color.green);
		if (times [5] [i + 1] != -1)
		    c.drawLine (currentX, (int) (baseY - times [5] [i] * height / maxTime) - 5, nextX, (int) (baseY - times [5] [i + 1] * height / maxTime) - 5);

	    }
	    c.setCursor (40, 1);
	    c.print ("Enter anything to test the sorts again, or enter 'stop' to stop the program: ");
	    restart = c.readString ();
	    c.println ();
	}
	while (!restart.equals ("stop"));

	// Place your program here.  'c' is the output console
    } // main method


    /*

    Author: Edward Tang
    Date: September 13, 2018
    Purpose: This method is designed to request input from the user for an integer value, redo the input request with an error message if the value is not within desired bounds
	     (inclusive range, [OPTIONAL] odd/even), and return a "valid" input.
    Input: [int] The minimum integer value, [int] the maximum integer value, [String] the desired input request message, [String] the desired error message, [int] desired integer
	   parity (DEFAULT impossible parity, AKA no eventual parity check)
    Output: [int] An integer within the desired range, inclusively

    */

    public static int readBoundInt (int intMin, int intMax, String readRequest, String error, int parity)
    {
	c.print (readRequest);
	int num = c.readInt ();
	while (num < intMin || num > intMax || (num % 2 == 0 && parity == 1) || (num % 2 != 0 && parity == 0))
	{
	    c.print (error);
	    num = c.readInt ();
	}
	return num;
    }


    /*

    Author: Edward Tang
    Date: September 13, 2018
    Purpose: This is the overloaded version of readBoundInt, meant to exclude parity checks.
    Input: [int] The minimum integer value, [int] the maximum integer value, [String] the desired input request message, [String] the desired error message, [int] desired integer
	   parity (DEFAULT impossible parity, AKA no eventual parity check)
    Output: [int] An integer within the desired range, inclusively

    */

    public static int readBoundInt (int intMin, int intMax, String readRequest, String error)
    {
	return readBoundInt (intMin, intMax, readRequest, error, 3);
    }
} // Sorting class

/*

Author: Edward Tang
Date: November 9, 2018
Purpose: This class
Fields:
    original                [int array] The original array of random integers
    aClone                  [int array] A clone of the original array, for the purpose of being sorted
    size                    [int] The size of the original array
Methods:
    constructor
    reset                   Sets aClone to a cloned array of the original array
    toString                Returns the array aClone as a string
    print                   Displays the array aClone on a given Console object
    sorted                  Returns true/false based on whether or not the array aClone is sorted
    bubble                  Sorts the array aClone through the bubble method
    selection               Sorts the array aClone through the selection method
    insertion               Sorts the array aClone through the insertion method
    quick                   Sorts the array aClone through the quick method by calling recurseQuick
    recurseQuick            Returns a given integer array sorted through the quick method
    merge                   Sorts the array aClone through the merge method by calling returnMerge
    returnMerge             Returns a given integer array sorted through the merge method
    shell                   Sorts the array aClone through the shell method
    bogo                    Sorts the array aClone through the bogo method
*/

class SortMethods
{
    int[] original;
    int[] aClone;
    int size;

    public SortMethods (int size)
    {
	if (size < 1)
	    size = 1;
	this.size = size;
	original = new int [size];
	for (int i = 0 ; i < size ; i++)
	    original [i] = (int) (Math.random () * (size + 1));
    }


    public SortMethods (int[] array)
    {
	size = array.length;
	original = new int [size];
	for (int i = 0 ; i < size ; i++)
	    original [i] = array [i];
    }


    public SortMethods (SortMethods oldObject)
    {
	size = oldObject.size;
	original = new int [size];
	for (int i = 0 ; i < size ; i++)
	    original [i] = oldObject.original [i];
	reset ();
    }


    public SortMethods ()
    {
	size = 1;
	original = new int [1];
    }


    /*

    Author: Edward Tang
    Date: November 9, 2018
    Purpose: Sets aClone to a cloned array of the original array
    Input: N/A
    Output: N/A

    */

    public void reset ()
    {
	aClone = new int [size];
	for (int i = 0 ; i < size ; i++)
	    aClone [i] = original [i];
    }


    /*

    Author: Edward Tang
    Date: November 9, 2018
    Purpose: Returns the array aClone as a string
    Input: N/A
    Output: [String] The array aCLone

    */

    public String toString ()
    {
	String array = "";
	for (int i = 0 ; i < size - 1 ; i++)
	    array += aClone [i] + " ";
	array += aClone [size - 1];
	return array;
    }


    /*

    Author: Edward Tang
    Date: November 14, 2018
    Purpose: Displays the array aClone on a given Console object
    Input: [Console] The console object to print on
    Output: N/A

    */

    public void print (Console c)
    {
	int count = c.getMaxColumns () - c.getColumn () + 1;
	for (int i = 0 ; i < size - 1 ; i++)
	{
	    if (count >= Integer.toString (aClone [i]).length () + 1)
	    {
		c.print (aClone [i] + " ");
		count -= Integer.toString (aClone [i]).length () + 1;
	    }
	    else if (count >= Integer.toString (aClone [i]).length ())
	    {
		c.print (aClone [i]);
		count -= Integer.toString (aClone [i]).length ();
	    }
	    else
	    {
		c.println ();
		count = c.getMaxColumns ();
	    }
	}
    }


    /*

    Author: Edward Tang
    Date: November 9, 2018
    Purpose: Returns true/false based on whether or not the array aClone is sorted
    Input: N/A
    Output: [boolean] True/false based on whether or not aClone is sorted

    */

    public boolean sorted ()
    {
	boolean isSorted = true;

	for (int i = 1 ; i < size ; i++)
	    if (aClone [i - 1] > aClone [i])
		isSorted = false;

	return isSorted;
    }


    /*

    Author: Edward Tang
    Date: November 9, 2018
    Purpose: Sorts the array aClone through the bubble method
    Input: N/A
    Output: N/A

    */

    public void bubble ()
    {
	for (int loopNum = 0 ; loopNum < size - 1 ; loopNum++)
	{
	    for (int i = 0 ; i < size - loopNum - 1 ; i++)
	    {
		if (aClone [i] > aClone [i + 1])
		{
		    int tempInt = aClone [i + 1];
		    aClone [i + 1] = aClone [i];
		    aClone [i] = tempInt;
		}
	    }
	}
    }


    /*

    Author: Edward Tang
    Date: November 9, 2018
    Purpose: Sorts the array aClone through the selection method
    Input: N/A
    Output: N/A

    */

    public void selection ()
    {
	for (int minIndex = 0 ; minIndex < size - 1 ; minIndex++)
	{
	    int newMinIndex = minIndex;
	    for (int i = minIndex + 1 ; i < size ; i++)
		if (aClone [i] < aClone [newMinIndex])
		    newMinIndex = i;
	    int tempInt = aClone [newMinIndex];
	    aClone [newMinIndex] = aClone [minIndex];
	    aClone [minIndex] = tempInt;
	}
    }



    /*

    Author: Edward Tang
    Date: November 10, 2018
    Purpose: Sorts the array aClone through the insertion method
    Input: N/A
    Output: N/A

    */

    public void insertion ()
    {
	for (int i = 1 ; i < size ; i++)
	{
	    for (int j = i ; j > 0 && aClone [j] < aClone [j - 1] ; j--)
	    {
		int tempInt = aClone [j];
		aClone [j] = aClone [j - 1];
		aClone [j - 1] = tempInt;
	    }
	}
    }


    /*

    Author: Edward Tang
    Date: November 10, 2018
    Purpose: Sorts the array aClone through the quick method by calling recurseQuick
    Input: N/A
    Output: N/A

    */

    public void quick ()
    {
	recurseQuick (0, size - 1);
    }


    /*

    Author: Edward Tang
    Date: November 10, 2018
    Purpose: Sorts the array aClone through the quick method, given a starting and stopping index
    Input: [int] The leftmost index of the array, [int] the rightmost index of the array
    Output: N/A

    */

    public void recurseQuick (int x, int y)
    {
	int left = x - 1;
	int right = y + 1;
	int temp;
	int pivot = aClone [(x + y) / 2];
	do
	{
	    left++;
	    right--;
	    while (left < y && aClone [left] < pivot)
		left++;
	    while (right > x && aClone [right] > pivot)
		right--;
	    if (left < right)
	    {
		temp = aClone [left];
		aClone [left] = aClone [right];
		aClone [right] = temp;
	    }
	}
	while (left <= right);
	if (x < right)
	    recurseQuick (x, right);
	if (left < y)
	    recurseQuick (left, y);

    }


    /*

    Author: Edward Tang
    Date: November 10, 2018
    Purpose: Sorts the array aClone through the bogo method
    Input: N/A
    Output: N/A

    */

    public void bogo ()
    {
	while (!sorted ())
	{
	    for (int i = 0 ; i < size ; i++)
	    {
		int tempInt = aClone [i];
		int randomIndex = (int) (Math.random () * size);
		aClone [i] = aClone [randomIndex];
		aClone [randomIndex] = tempInt;
	    }
	}
    }


    /*

    Author: Edward Tang
    Date: November 10, 2018
    Purpose: Sorts the array aClone through the merge method by calling returnMerge
    Input: N/A
    Output: N/A

    */

    public void merge ()
    {
	aClone = returnMerge (aClone);
    }


    /*

    Author: Edward Tang
    Date: November 10, 2018
    Purpose: Returns a given integer array sorted through the merge method
    Input: [int array] The array to be sorted
    Output: [int array] The sorted array

    */

    public int[] returnMerge (int[] intArray)
    {
	if (intArray.length > 1)
	{
	    int[] array = new int [intArray.length / 2];
	    int arrayIndex = array.length;
	    for (int i = 0 ; i < arrayIndex ; i++)
		array [i] = intArray [i];
	    int[] array2 = new int [intArray.length - arrayIndex];
	    for (int i = 0 ; i < array2.length ; i++)
	    {
		array2 [i] = intArray [arrayIndex];
		arrayIndex++;
	    }

	    array = returnMerge (array);
	    array2 = returnMerge (array2);

	    arrayIndex = 0;
	    int array2Index = 0;
	    for (int i = 0 ; i < intArray.length ; i++)
	    {
		if (arrayIndex < array.length && (array2Index >= array2.length || array [arrayIndex] <= array2 [array2Index]))
		{
		    intArray [i] = array [arrayIndex];
		    arrayIndex++;
		}
		else
		{
		    intArray [i] = array2 [array2Index];
		    array2Index++;
		}
	    }
	}


	return intArray;
    }


    /*

    Author: Edward Tang
    Date: November 12, 2018
    Purpose: Sorts the array aClone through the shell method
    Input: N/A
    Output: N/A

    */

    public void shell ()
    {
	int gap = 1;
	while (gap <= size)
	    gap = gap * 3 + 1;
	do
	{
	    gap /= 3;
	    for (int i = gap ; i < size ; i++)
	    {
		int hold = aClone [i];
		int j = i - gap;
		while (j >= 0 && aClone [j] > hold)
		{
		    aClone [j + gap] = aClone [j];
		    j -= gap;
		}
		aClone [j + gap] = hold;
	    }
	}


	while (gap > 1);
    }
}


