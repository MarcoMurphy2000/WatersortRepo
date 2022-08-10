public class MyArrayList<E>   //E is a generic object 
{
	//Instance variables
	private int size; //Number of elements in the list
	private E[] data;
	private int MAXELEMENTS = 5;
	
	/** Create an empty list */
	public MyArrayList()
	{
		data = (E[]) new Object[MAXELEMENTS]; //We cannot create an array of generics
		size = 0; //Number of elements in the list
	}
	
	
	public int getMAXELEMENTS()
	{
		return MAXELEMENTS;
	}
	  
	public boolean checkSpace()  //If there is space, return true. Else return false
	{
		if (size+1<MAXELEMENTS)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	/**Additions for Watersort puzzle**/
	public boolean checkUniform()
	{
		boolean uniform = false;
		for (int i = 0; i < size-1; i++)
		{
			if (data[i] == data[i + 1])
			{
				uniform = true;
			}
			else{
				return false;
			}
		}
		return uniform;
	}
	
	public int getSize()   //Accessor (get method) for getSize
	{
		return size;
	}
	/** End of additions for watersort puzzle**/
	
	
	
	public void add(int index, E e) 
	{   
		// Ensure the index is in the right range
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException
			("Index: " + index + ", Size: " + size); 
		}
		// Move the elements to the right after the specified index
		for (int i = size - 1; i >= index; i--)
		{
			data[i + 1] = data[i];
		}
		// Insert new element to data[index]
		data[index] = e;
		// Increase size by 1
		size++;
	}
	
	public boolean contains(Object e) 
	{
		for (int i = 0; i < size; i++)
		{
			if (e.equals(data[i])) 
			{
				return true;
			}
		}
		return false;
	}
	
	public E get(int index) 
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException
			("Index: " + index + ", Size: " + size);
		}
		return data[index];
	}
		
	public E remove(int index) 
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException
			("Index: " + index + ", Size: " + size);
		}
		E e = data[index];
		// Shift data to the left
		for (int j = index; j < size - 1; j++)
		{
			data[j] = data[j + 1];
		}
		data[size - 1] = null; // This element is now null
		// Decrement size
		size--;
		return e;
	}
  
	public void clear()
	{
		size = 0;
	}
	
	public void filter(E low, E high)  //Low and high depends on the class, which is why it is of type E
	{
		int j=0;
		E[] temp = (E[])new Object[MAXELEMENTS];  //Create a new array to store the valid values "The calling array is therefore updated"
	  
		if (getSize()== 0)
			return;
		if (((Comparable)low).compareTo(high)>0)  // If the calling object is larger than the parameter object, compare to should return a number larger than zero.
			return;
	  
		for (int i = 0; i< size; i++)
		{
			if ((((Comparable)data[i]).compareTo(low) >=0) && (((Comparable)data[i]).compareTo(high) <=0))
			{	
				temp[j] = data[i];
				j++;
			}
		}
		data = temp;
		size = j;
	}
	
	
	public MyArrayList<E> merge(MyArrayList<E> param)
	{
		int i=0; //counter in calling array
		int j=0; // counter in param array
		int k=0; // counter in return array
		MyArrayList<E> returnArray = new MyArrayList();
	  
		if (this.getSize() ==0) // same as if (size==0)
			return param;
		if (param.getSize()==0)
			return this;
		if ((this.getSize()+ param.getSize()) > MAXELEMENTS)
			throw new IndexOutOfBoundsException
        ("Combined list out of bounds");
		
		// traverse both list until one list is completely done
		while (i<this.getSize() && j<param.getSize())
		{
			// Compare single value from each list and copy smallest into result
			if (((Comparable)data[i]).compareTo(param.data[j]) <0)
			{
				returnArray.data[k]= this.data[i];
				k++;
				i++;	
			}
			else
			{
				returnArray.data[k]=param.data[j];
				k++;
				j++;
			}
		}
	  
		// copy remainder of the array
		if (i < this.getSize())
		{
			for (i=i;i<getSize();i++) //for starts at current position
			{
				returnArray.data[k]= this.data[i];
				k++;
			}
		}
		if (j < param.getSize())
		{
			for (j=j;j<param.getSize();j++)
			{
				returnArray.data[k]=param.data[j];
				k++;
			}
		}
		returnArray.size = k; // set size of return array
		return returnArray;
	}
	
	public String toString() 
	{
		String result="[";
		for (int i = 0; i < size; i++) 
		{
			result+= data[i];
			if (i < size - 1)
			{
				result+=", ";
			}
		}
		return result.toString() + "]";
	}
	
	
	
	public boolean sortList() 
	{
		E hold;
		for (int i = 0; i < size-1; i++)
		{
			for (int j = 0; j<size-1; j++)
			{  	 
				if(((Comparable)data[j]).compareTo(data[j+1])>0)
				{
					hold= data[j+1];
					data[j+1]=data[j];
					data[j]=hold;
				}       
			}
		} 
		return true;	  	
	}
	
	/** insertSorted function **/
	public void insertSorted(E e)   //Method receives a generic object E being the type of the parameter (any type)
	{
		int loc = size - 1;
			
		if (getSize()== 0)
			return;
		
		
		while (((Comparable)data[loc]).compareTo(e) >= 0 && loc >= 0)
		{
			data[loc + 1] = data[loc]; //Bump item from data[loc] up to loc + 1.
			loc = loc - 1;  //Go on to next location.
		}
		data[loc + 1] = e; //put item to be stored in last vacated space.
		size = size + 1;
	}
}