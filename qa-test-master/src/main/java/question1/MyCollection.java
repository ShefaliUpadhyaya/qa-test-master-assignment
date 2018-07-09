package question1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private int[] numArray;
	int n, size;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
		n = arraySize;
		size = 0;
	}

	public int search(int searchingNum) {
		for(int i = 0; i < numArray.length; i++) {
			if(numArray[i]==searchingNum) 
				return i;	
		}
		return -1;
	}

	public boolean add(int numberToAdd) {
		int i = search(numberToAdd);
		if(i!=-1) 
			return false;
		else if(size==n) 
			doubleCapacity();
		int c = size;
		numArray[c] = numberToAdd;
		size+=1;
		return true;
	}

	public void doubleCapacity() {
		int[] doubleArray = new int[2*numArray.length];
        System.arraycopy(doubleArray,0,numArray,0,numArray.length); 
        numArray = doubleArray;
    }

	public boolean remove(int numberToRemove) {
		int exists = search(numberToRemove);
		if(exists!=-1) 
			return true;
		/*int flag = 1, loc = 0;
        for (int i = 0; i < n; i++) {
        	if(numArray[i] == numberToRemove)
            {	flag =1;
                loc = i;
                break;
            }
            else flag = 0;
        }
        if(flag == 1)
        {	for(int i = loc+1; i < n; i++)
            	numArray[i-1] = numArray[i];
        }*/
		return false;
	}

	public int getCount() {
		return size;
	}

	int gcd(int a,int b)
	{
	    if(b == 0)
	    return a;
	     
	    else
	    return gcd(b, a%b);
	}
	
	void leftRotate(int arr[], int d, int n)
	{	for (int i = 0; i < gcd(d, n); i++)
	  {
	    int temp = numArray[i];
	    int j = i;
	    while(true)
	    {
	      int k = j + d;
	      if (k >= n)
	        k = k - n;
	         
	      if (k == i)
	        break;
	         
	      numArray[j] = numArray[k];
	      j = k;
	    }
	    numArray[j] = temp;
	  }
	  
	}

	public int[] rotate(int n) {
		leftRotate(numArray, n, this.n);
		return numArray;
	}
	
	public String toString() {
		if(size==0) {
			return "{}";
		}
		String str = "{";
		for(int i = 0; i < getCount(); i++) {
			str += numArray[i];
			if(i < getCount()-1)
				str += ",";
		}	
		str += "}";
		return str;
	}
	

}
