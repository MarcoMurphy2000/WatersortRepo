
public class StackAsMyArrayList<E> 
{   
	MyArrayList<E> theStack;
    public StackAsMyArrayList()
    {  
		theStack = new MyArrayList<E>();       
    }
	
	
	
	/** Additions to the StackAsMyArrayList class **/
	public E peek()
	{
		E temp = null;
		
		boolean isDone = false;
		if (theStack.getSize() > 0)
		{
			temp=theStack.get(theStack.getSize()-1); //get function returns the value of the index given as parameter.
		}
		return temp; // temp will be null in special case of empty list
	}
	
	public int getStackSize()
	{
		return theStack.getSize();
		/**
		int size = theStack.getSize();
		return size;
		**/
	}
	
	public boolean checkStackUniform()
	{
		return theStack.checkUniform();
		/**
		if (checkUniform())
		{
			return true;
		}
		return false;
		**/
	}
	/** End of additions**/
	
	
	
    public void push(E newElement) 
    {  
		if (!theStack.checkSpace()) //If checkSpace returns false/ or stated differently, if checkSpace does not return true:
		{
			//System.out.println("The bottle is already filled to the top!");
			throw new IndexOutOfBoundsException
			("Stack out of bounds (Bottle is filled to the top)");
		}
		else
		{
			theStack.add(theStack.getSize(),newElement);
		}
    }
	
	public E pop() //remove end of array
    {  
		E temp = null;
		
		boolean isDone = false;
		if (theStack.getSize() > 0)
		{
			temp=theStack.remove(theStack.getSize()-1); //remove function returns the value that is removed
		}
		return temp; // temp will be null in special case of empty list
    }
    
	public String toString()
	{
		return theStack.toString();
	}
	
}//end class
