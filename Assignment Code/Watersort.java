import java.util.Random;
import java.util.*;
import static java.lang.Math.*;

public class Watersort
{
	public static void main(String[] args)
	{
		Character top = null;
		Character red = new Character('r');
		Character blue = new Character('b');
		Character green = new Character('g');
		
		//Create 5 bottles 
		StackAsMyArrayList<Character> bottle1 = new StackAsMyArrayList<Character>(); //bottle is myStack
		StackAsMyArrayList<Character> bottle2 = new StackAsMyArrayList<Character>(); //bottle is myStack
		StackAsMyArrayList<Character> bottle3 = new StackAsMyArrayList<Character>(); //bottle is myStack
		StackAsMyArrayList<Character> bottle4 = new StackAsMyArrayList<Character>(); //bottle is myStack
		StackAsMyArrayList<Character> bottle5 = new StackAsMyArrayList<Character>(); //bottle is myStack
		
		//Store the 5 bottles in a bottles array
		StackAsMyArrayList[] bottles = {bottle1, bottle2, bottle3, bottle4, bottle5};
		
		
		
		
		
		/**           PART 2           **/  //Note. I made 2 methods both working. Method one is based on strategy 1 which is much shorter, and method 2 is based on strategy 2 which is much larger. I have commented out method 2
		
		
		//Method 1 uses a random number generator to fill the bottles one bottle at a time.
		Random objGenerator = new Random(); 
		int upperbound = 3;
		
		int blue_amount = 0;
		int red_amount = 0;
		int green_amount = 0;
		int maximum_colors = 4;
		
		// Fill first 3 bottles in bottles array randomly
		for (int bottles_counter = 0; bottles_counter < 3; bottles_counter++) 
		{
			int open_places = 0;
			int bottle = bottles_counter;
			while (true) 
			{
				int random_color = objGenerator.nextInt(upperbound);
				if (open_places == maximum_colors) 
				{
					break;
				} 
				else if (random_color == 1 && blue_amount < maximum_colors) 
				{ 
					bottles[bottle].push(blue);
					blue_amount++;
					open_places++;
				} 
				else if (random_color == 0 && red_amount < maximum_colors) 
				{ 
					bottles[bottle].push(red);
					red_amount++;
					open_places++;
				} 
				else if (random_color == 2 && green_amount < maximum_colors) 
				{ 
					bottles[bottle].push(green);
					green_amount++;
					open_places++;
				}
			}
		}
		
		
		//Use a for loop to get the toString value of each bottle to show output after mixing ink
		System.out.println("\nBottles content after randomly filling first 3 bottles:");
		for (int i = 0; i < 5; i++)
		{
			System.out.println("Bottle " + (i+1) + ": " + bottles[i].toString());
		}
		
		
		
		
		
		/**
		//Method 2 fills the bottles and then mixes them up thoroughly with a random number generator having the game played in reverse.
		
		Random objGenerator = new Random();  
		int upperbound = 3;  //generate random values from 0 - 2
		int randomInteger;
		
		System.out.println("\nPut ink in the bottles:");
		for (int i = 0; i < 4; i++)
		{
			bottle1.push(blue);
			bottle2.push(red);
			bottle3.push(green);
		}
		
		//Use a for loop to get the toString value of each bottle to show bottles before mixing ink inside.
		for (int i = 0; i < 5; i++)
		{
			System.out.println("Bottle " + (i+1) + ": " + bottles[i].toString());
		}
		
		
		
		//Mixing bottles   
		//Explenation of code:
		
		//* Phase 1, I mixed up the ink inside the bottles thoroughly. I ended up with mixed ink in bottles 3, 4, and 5.
		//* Phase 2, I used a random number generator to choose which bottles to mix with one another.
		//* Finally in phase 3 I rearanged the bottles to have ink in only the first 3 bottles. I then let this entire process run inside a for loop which executes 3 times ensuring that the mixture will almost always be different.
		
		
		
		
		for (int k = 0; k < 3; k++)
		{
			//Phase 1
			bottle4.push((Character) bottle1.pop());
			bottle5.push((Character) bottle2.pop());
			bottle4.push((Character) bottle3.pop());
			bottle5.push((Character) bottle1.pop());
			bottle4.push((Character) bottle2.pop());
			bottle5.push((Character) bottle3.pop());
			bottle4.push((Character) bottle1.pop());
			bottle5.push((Character) bottle2.pop());
		
			bottle1.push((Character) bottle3.pop());
			bottle1.push((Character) bottle2.pop());
			bottle1.push((Character) bottle3.pop());
		
			for (int i = 0; i < 4; i++)
			{
				bottle3.push((Character) bottle1.pop());
			}
		
		
			//phase 2
			randomInteger = objGenerator.nextInt(upperbound);
			if (randomInteger == 0)
			{
				for (int i = 0; i < 4; i++)
				{
					bottle1.push((Character) bottle4.pop());
				}
			}
			else if (randomInteger == 1)
			{
				for (int i = 0; i < 4; i++)
				{
					bottle1.push((Character) bottle5.pop());
				}
			}
			else
			{
				for (int i = 0; i < 4; i++)
				{
					bottle2.push((Character) bottle3.pop());
				}
			}
		
		
			//Phase 3
			if (bottle4.getStackSize() == 0)  //randomInteger == 0 in phase 2
			{
				for (int i = 0; i < 2; i++)
				{
					bottle2.push((Character) bottle3.pop());
					bottle2.push((Character) bottle5.pop());
				}
			
				for (int j = 0; j < 2; j++)
				{
					bottle3.push((Character) bottle5.pop());
				}
			}
			else if (bottle5.getStackSize() == 0)  //randomInteger == 1 in phase 2
			{
				for (int i = 0; i < 2; i++)
				{
					bottle2.push((Character) bottle3.pop());
					bottle2.push((Character) bottle4.pop());
				}
			
				for (int j = 0; j < 2; j++)
				{
					bottle3.push((Character) bottle4.pop());
				}
			}
			else
			{
				for (int i = 0; i < 2; i++)
				{
					bottle1.push((Character) bottle4.pop());
					bottle1.push((Character) bottle5.pop());
				}
			
				for (int j = 0; j < 2; j++)
				{
					bottle3.push((Character) bottle4.pop());
					bottle3.push((Character) bottle5.pop());
				}
			}
		}
		
		//Use a for loop to get the toString value of each bottle to show output after mixing ink
		System.out.println("\nBottles content after mixing up the ink inside the bottles:");
		for (int i = 0; i < 5; i++)
		{
			System.out.println("Bottle " + (i+1) + ": " + bottles[i].toString());
		}
		**/
		
		
		
		
		
		/**            PART 3             **/
		
		System.out.println("\n\n\n-------------------------------------------------*\nLets start the game: \n-------------------------------------------------*");
		boolean Solved = false;
		Scanner input = new Scanner(System.in);
				
		int sourceBottle;
		int targetBottle;
		
		while(!Solved)
		{
			boolean inputInvalid;
			inputInvalid = true;
			while (inputInvalid)
			{
				try
				{
					System.out.println("\n");
					for (int i = 0; i < 5; i++)
					{
						System.out.println("Bottle " + (i+1) + ": " + bottles[i].toString());
					}
					
					System.out.print("\nEnter source bottle number: ");
					sourceBottle = input.nextInt();
				
					
					if (sourceBottle <= 5 && sourceBottle >=1)
					{
						System.out.print("\nEnter target bottle number: ");
						targetBottle = input.nextInt();
						
						if(targetBottle <= 5 && targetBottle >= 1)
						{
							//pop and push
							if (bottles[sourceBottle-1].getStackSize() == 0)
							{
								System.out.println("Source bottle is empty");
							}
							else if(bottles[targetBottle-1].getStackSize() == 0)
							{
								top = (Character) bottles[sourceBottle-1].peek();
								bottles[targetBottle-1].push(top);
								bottles[sourceBottle-1].pop();
							
								Solved = solve(bottles);
								inputInvalid = false;
							}
							else if (bottles[sourceBottle-1].peek() == bottles[targetBottle-1].peek())
							{
								top = (Character) bottles[sourceBottle-1].peek();
								bottles[targetBottle-1].push(top);
								bottles[sourceBottle-1].pop();
							
								Solved = solve(bottles);
								inputInvalid = false;
							}
							else
							{
								System.out.println("Dont mix ink!");
								inputInvalid = true;
							}
						}
						else
						{
							System.out.println("There are only 5 bottles. Choose a target bottle between 1 and 5.");
							inputInvalid = true;
						}
					}
					else
					{
						System.out.println("There are only 5 bottles. Choose a source bottle between 1 and 5.");
						inputInvalid = true;
					}
				}
				catch(ArithmeticException ae)
				{
					System.out.println("The following arithmetic exception was thrown:\n"+ae);
				}
				catch(Exception e)
				{
					System.out.println("The following exception was thrown:\n"+e);
				}
			}
			//System.out.println("\nSuccessful round");
		}
		for (int i = 0; i < 5; i++)
		{
			System.out.println("Bottle " + (i+1) + ": " + bottles[i].toString());
		}
		System.out.println("\nWell done, you have solved the watersort puzzle!");
	}
	
	//solved method
	public static boolean solve(StackAsMyArrayList bottles[])
	{
		boolean solved = false;
		for (int i = 0; i < 5; i++)
		{
			if (bottles[i].getStackSize() == 4 && bottles[i].checkStackUniform() == true || bottles[i].getStackSize() == 0)
			{
				solved = true;
			}
			else
			{
				return false;
			}
		}
		return solved;
	}
}