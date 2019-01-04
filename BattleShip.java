package codes;
import java.util.Scanner;
import java.awt.AWTException;
import java.io.IOException;

public class BattleShip { 
//ERRORTRAPPIN
	
public static final int LENGTH = 10, WIDTH = 10; //number of rows and number of columns
public static int carrier1, battleship1, cruiser1, submarine1, destroyer1, rowguess;
public static int carrier2, battleship2, cruiser2, submarine2, destroyer2;
public static int direction, columnguess, wins=0, losses=0;
public static Scanner input = new Scanner(System.in);
public static boolean gameover, passed = true;
public static boolean playership[][] = new boolean [LENGTH][WIDTH];
public static boolean computership[][] = new boolean [LENGTH][WIDTH];

	public static void display()//displays what the grid would look like
	{	
		System.out.print(" ");
		for(int x=1; x<11; x++) //displays column numbers
		{	
			System.out.print(""+x);
			System.out.print(" ");
		}
		System.out.println("");
		char alphabet = 'A';
		for(int x=0; x < LENGTH; x++)
		{  
			System.out.print(alphabet ); //displays row letters
			    
			for(int y=0; y < WIDTH; y++)
			{
				System.out.print("* "); //shows possible ship positions
			}
			System.out.println("");
			alphabet++;
		}
	}
	public static void input()throws IOException //player inputs ship positions
	{	boolean valid = true;
		do
		{	valid = true;
			System.out.println("Where would you like to place your length 5 carrier?");
			System.out.println("Row: ");
			char carriertemp = errortrap(65,74);
			carrier1 = (int) carriertemp - 65; //converts row letter to row number	
			System.out.println("Column: ");
			carrier2 = errortrap2(1,10) - 1;
			if (playership[carrier1][carrier2] == true)
			{
				valid = false; //if there is already ship at that position
			}
			else
			{
				System.out.println("Facing which direction? 1.Left 2.Right 3.Up 4.Down");
				direction = errortrap2(1,4);
				if (direction ==1)//facing left
				{	
					if (carrier2 < 4)
					{
						valid = false; //ship goes off the grid
					}
					else
					{
						for(int x = 1; x < 5; x++)
						{
							if(playership[carrier1][carrier2-x] == true)
							{
								valid = false; //overlaps with another ship
							}
									
						}
					}
					
				}else if (direction == 2)//facing right
				{
					if (carrier2 > 5)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 5; x++)
						{
							if(playership[carrier1][carrier2+x] == true)
							{
								valid = false;
							}
									
						}
					}
				}else if (direction == 3)//facing up
				{
					if (carrier1 < 4)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 5; x++)
						{
							if(playership[carrier1-x][carrier2] == true)
							{
								valid = false;
							}
									
						}
					}
				}else if (direction == 4)//facing down
				{
					if (carrier1 > 5)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 5; x++)
						{
							if(playership[carrier1+x][carrier2] == true)
							{
								valid = false;
							}
									
						}
					}
				}
			}	
		}while (valid == false); //while position is not valid for that ship
		
		playership[carrier1][carrier2] = true; //puts ship at that point
		//the rest of the ship length is placed into position
		if (direction ==1)//facing left
		{
			for(int x = 1; x < 5; x++)
			{
				playership[carrier1][carrier2-x] = true;
			}
		}else if (direction == 2)//facing right
		{
			for(int x = 1; x < 5; x++)
			{
				playership[carrier1][carrier2+x] = true;
			}
		}else if (direction == 3)//facing up
		{
			for(int x = 1; x < 5; x++)
			{
				playership[carrier1-x][carrier2] = true;
			}
		}else if (direction == 4)//facing down
		{
			for(int x = 1; x < 5; x++)
			{
				playership[carrier1+x][carrier2] = true;
			}
		}
		do
		{	valid = true;
			System.out.println("Where would you like to place your length 4 battleship?");
			System.out.println("Row: ");
			char battleshiptemp = errortrap(65,74);
			battleship1 = (int) battleshiptemp - 65; //converts row letter to row number
			System.out.println("Column: ");
			battleship2 = errortrap2(1,10) - 1;
			if (playership[battleship1][battleship2] == true)
			{
				valid = false;
			}
			else
			{
				System.out.println("Facing which direction? 1.Left 2.Right 3.Up 4.Down");
				direction = errortrap2(1,4);
				if (direction ==1)//facing left
				{	
					if (battleship2 < 3)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 4; x++)
						{
							if(playership[battleship1][battleship2-x] == true)
							{
								valid = false;
							}
									
						}
					}
					
				}else if (direction == 2)//facing right
				{
					if (battleship2 > 6)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 4; x++)
						{
							if(playership[battleship1][battleship2+x] == true)
							{
								valid = false;
							}
									
						}
					}
				}else if (direction == 3)//facing up
				{
					if (battleship1 < 3)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 4; x++)
						{
							if(playership[battleship1-x][battleship2] == true)
							{
								valid = false;
							}
									
						}
					}
				}else if (direction == 4)//facing down
				{
					if (battleship1 > 6)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 4; x++)
						{
							if(playership[battleship1+x][battleship2] == true)
							{
								valid = false;
							}
									
						}
					}
				}
			}	
	}while (valid == false);
		playership[battleship1][battleship2] = true; //there is a ship at that position

		if (direction ==1)//facing left
		{
			for(int x = 1; x < 4; x++)
			{
				playership[battleship1][battleship2-x] = true;
			}
		}else if (direction == 2)//facing right
		{
			for(int x = 1; x < 4; x++)
			{
				playership[battleship1][battleship2+x] = true;
			}
		}else if (direction == 3)//facing up
		{
			for(int x = 1; x < 4; x++)
			{
				playership[battleship1-x][battleship2] = true;
			}
		}else if (direction == 4)//facing down
		{
			for(int x = 1; x < 4; x++)
			{
				playership[battleship1+x][battleship2] = true;
			}
		}
		do
		{	valid = true;
			System.out.println("Where would you like to place your length 3 cruiser?");
			System.out.println("Row: ");
			char cruisertemp = errortrap(65,74);
			cruiser1 = (int) cruisertemp - 65; //converts row letter to row number
			System.out.println("Column: ");
			cruiser2 = errortrap2(1,10) - 1;
			if (playership[cruiser1][cruiser2] == true)
			{
				valid = false;
			}
			else
			{
				System.out.println("Facing which direction? 1.Left 2.Right 3.Up 4.Down");
				direction = errortrap2(1,4);
				if (direction ==1)//facing left
				{	
					if (cruiser2 < 2)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 3; x++)
						{
							if(playership[cruiser1][cruiser2-x] == true)
							{
								valid = false;
							}
									
						}
					}
					
				}else if (direction == 2)//facing right
				{
					if (cruiser2 > 7)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 3; x++)
						{
							if(playership[cruiser1][cruiser2+x] == true)
							{
								valid = false;
							}
									
						}
					}
				}else if (direction == 3)//facing up
				{
					if (cruiser1 < 2)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 3; x++)
						{
							if(playership[cruiser1-x][cruiser2] == true)
							{
								valid = false;
							}
									
						}
					}
				}else if (direction == 4)//facing down
				{
					if (cruiser1 > 7)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 3; x++)
						{
							if(playership[cruiser1+x][cruiser2] == true)
							{
								valid = false;
							}
									
						}
					}
				}
			}	
		}while (valid == false);	
		playership[cruiser1][cruiser2] = true; 
		if (direction ==1)//facing left
		{
			for(int x = 1; x < 3; x++)
			{
				playership[cruiser1][cruiser2-x] = true;
			}
		}else if (direction == 2)//facing right
		{
			for(int x = 1; x < 3; x++)
			{
				playership[cruiser1][cruiser2+x] = true;
			}
		}else if (direction == 3)//facing up
		{
			for(int x = 1; x < 3; x++)
			{
				playership[cruiser1-x][cruiser2] = true;
			}
		}else if (direction == 4)//facing down
		{
			for(int x = 1; x < 3; x++)
			{
				playership[cruiser1+x][cruiser2] = true;
			}
		}
		do
		{	valid = true;
			System.out.println("Where would you like to place your length 3 submarine?");
			System.out.println("Row: ");
			char submarinetemp = errortrap(65,74);
			submarine1 = (int) submarinetemp - 65; //converts row letter to row number
			System.out.println("Column: ");
			submarine2 = errortrap2(1,10) - 1;
			if (playership[submarine1][submarine2] == true)
			{
				valid = false;
			}
			else
			{
				System.out.println("Facing which direction? 1.Left 2.Right 3.Up 4.Down");
				direction = errortrap2(1,4);
				if (direction ==1)//facing left
				{	
					if (submarine2 < 2)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 3; x++)
						{
							if(playership[submarine1][submarine2-x] == true)
							{
								valid = false;
							}
									
						}
					}
					
				}else if (direction == 2)//facing right
				{
					if (submarine2 > 7)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 3; x++)
						{
							if(playership[submarine1][submarine2+x] == true)
							{
								valid = false;
							}
									
						}
					}
				}else if (direction == 3)//facing up
				{
					if (submarine1 < 2)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 3; x++)
						{
							if(playership[submarine1-x][submarine2] == true)
							{
								valid = false;
							}
									
						}
					}
				}else if (direction == 4)//facing down
				{
					if (submarine1 > 7)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 3; x++)
						{
							if(playership[submarine1+x][submarine2] == true)
							{
								valid = false;
							}
									
						}
					}
				}
			}
			
		}while(valid == false);
			
		playership[submarine1][submarine2] = true; 
		if (direction ==1)//facing left
		{
			for(int x = 1; x < 3; x++)
			{
				playership[submarine1][submarine2-x] = true;
			}
		}else if (direction == 2)//facing right
		{
			for(int x = 1; x < 3; x++)
			{
				playership[submarine1][submarine2+x] = true;
			}
		}else if (direction == 3)//facing up
		{
			for(int x = 1; x < 3; x++)
			{
				playership[submarine1-x][submarine2] = true;
			}
		}else if (direction == 4)//facing down
		{
			for(int x = 1; x < 3; x++)
			{
				playership[submarine1+x][submarine2] = true;
			}
		}
		do
		{	valid = true;
			System.out.println("Where would you like to place your length 2 destroyer?");
			System.out.println("Row: ");
			char destroyertemp = errortrap(65,74);
			destroyer1 = (int) destroyertemp - 65; //converts row letter to row number
			System.out.println("Column: ");
			destroyer2 = errortrap2(1,10) - 1;
			if (playership[destroyer1][destroyer2] == true)
			{
				valid = false; //if there is already ship at that position
			}
			else
			{
				System.out.println("Facing which direction? 1.Left 2.Right 3.Up 4.Down");
				direction = errortrap2(1,4);
				if (direction ==1)//facing left
				{	
					if (destroyer2 < 1)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 2; x++)
						{
							if(playership[destroyer1][destroyer2-x] == true)
							{
								valid = false;
							}
									
						}
					}
					
				}else if (direction == 2)//facing right
				{
					if (destroyer2 > 8)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 2; x++)
						{
							if(playership[destroyer1][destroyer2+x] == true)
							{
								valid = false;
							}
									
						}
					}
				}else if (direction == 3)//facing up
				{
					if (destroyer1 < 1)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 2; x++)
						{
							if(playership[destroyer1-x][destroyer2] == true)
							{
								valid = false;
							}
									
						}
					}
				}else if (direction == 4)//facing down
				{
					if (destroyer1 > 8)
					{
						valid = false;
					}
					else
					{
						for(int x = 1; x < 2; x++)
						{
							if(playership[destroyer1+x][destroyer2] == true)
							{
								valid = false;
							}
									
						}
					}
				}
			}
		}while(valid == false); 

		playership[destroyer1][destroyer2] = true; 
		if (direction ==1)//facing left
		{
			for(int x = 1; x < 2; x++)
			{
				playership[destroyer1][destroyer2-x] = true;
			}
		}else if (direction == 2)//facing right
		{
			for(int x = 1; x < 2; x++)
			{
				playership[destroyer1][destroyer2+x] = true;
			}
		}else if (direction == 3)//facing up
		{
			for(int x = 1; x < 2; x++)
			{
				playership[destroyer1-x][destroyer2] = true;
			}
		}else if (direction == 4)//facing down
		{
			for(int x = 1; x < 2; x++)
			{
				playership[destroyer1+x][destroyer2] = true;
			}
		}
	}
	public static void random() throws IOException //computer generates ship positions
	{
		int min = 0, max = 9, minimum = 1, maximum = 4, ships = 0;
		int row, column, orientation, x=6;
		boolean valid =true;
		System.out.println("hi");
		do
		{	
			x = x -1;
			if (ships == 4) //two ships both have length 3
			{
				x = 3;
			}
			do
			{	 valid = true;
				 row = (int)(Math.random()*(max-min+1) + min);
				 column = (int)(Math.random()*(max-min+1) + min);
				 orientation = (int)(Math.random()*(maximum-minimum+1) + minimum);
				 if (orientation ==1)//facing left
					{	
						if (column < x-1)
						{
							valid = false;
						}
						else
						{
							for(int y = 1; y < x; y++)
							{
								if(computership[row][column-y] == true)
								{
									valid = false;
								}
										
							}
						}
						
					}else if (orientation == 2)//facing right
					{
						if (column > 10-x)
						{
							valid = false;
						}
						else
						{
							for(int y = 1; y < x; y++)
							{
								if(computership[row][column+y] == true)
								{
									valid = false;
								}
										
							}
						}
					}else if (orientation == 3)//facing up
					{
						if (row < x-1)
						{
							valid = false;
						}
						else
						{
							for(int y = 1; y < x; y++)
							{
								if(computership[row-y][column] == true)
								{
									valid = false;
								}
										
							}
						}
					}else if (orientation == 4)//facing down
					{
						if (row > 10-x)
						{
							valid = false;
						}
						else
						{
							for(int y = 1; y < x; y++)
							{
								if(computership[row+y][column] == true)
								{
									valid = false;
								}
										
							}
						}
					}
			}while (valid == false);
			
			computership[row][column] = true; //there is a ship at that position
			if (orientation ==1)//facing left
			{
				for(int y = 1; y < x; y++)
				{
					computership[row][column-y] = true;
				}
			}else if (orientation == 2)//facing right
			{
				for(int y = 1; y < x; y++)
				{
					computership[row][column+y] = true;
				}
			}else if (orientation == 3)//facing up
			{
				for(int y = 1; y < x; y++)
				{
					computership[row-y][column] = true;
				}
			}else if (orientation == 4)//facing down
			{
				for(int y = 1; y < x; y++)
				{
					computership[row+y][column] = true;
				}
			}
			ships++;
		}while (ships < 5);	//generates positions for 5 ships	
	}
	public static void guess()throws IOException //player inputs guess
	{
		System.out.println("Where would you like to hit?");
		System.out.println("Row: "); 
		char temp = errortrap(65,74);
		rowguess = (int) temp - 65;
		System.out.println("Column: ");
		columnguess = errortrap2(1,10) - 1;
	}
	public static void compare1()throws IOException //checks player guess
	{	boolean guess = false;
		do
		{
			guess();
			if (computership[rowguess][columnguess] == true)
			{
				System.out.println("You've hit a ship!");
				computership[rowguess][columnguess] = false;
				guess = true;
			}
			else
			{
				System.out.println("You've missed.");
				guess = false;
			}
		}while (guess == true); //player gets another guess if previous guess was right
	}
	public static void compare2()throws IOException //checks computer's guess
	{	boolean guess = false;
		do
		{	System.out.println("Computer is guessing now...");
			randomguess();
			if (playership[rowguess][columnguess] == true)
			{
				System.out.println("One of your ships have been hit!");
				playership[rowguess][columnguess] = false;
				guess = true;
			}
			else
			{
				System.out.println("Computer has missed.");
				System.out.println("Your turn.");
				guess = false;
			}
		}while (guess == true); //computer guesses again if guess was right
	}
	public static void randomguess() throws IOException //generates random guess for computer
	{
		int min = 0, max = 9;
		int rowguess = (int)(Math.random()*(max-min+1) + min);
		int columnguess = (int)(Math.random()*(max-min+1) + min);
	}
	public static char errortrap( int min, int max)throws IOException //errortrap for char input
	{	char choice = 'a';
		String inputLine;
		boolean inputValid;
	    passed = false;
	    
		do
		{	
			inputValid = true;
            try
            {
                 inputLine = input.nextLine(); //Trying to get input
                 if (inputLine.length()>0)
                 {
                	 choice = inputLine.toUpperCase().charAt(0); //takes first char from input
                 }
                 else
                 {
                	 choice =' ';
                 }
            }
            catch (Exception error) 
            {
                System.out.println("Invalid Input." + error.toString()); 
                inputValid = false;
            }
            if(inputValid == true && ((int)choice < min || (int)choice > max)) 
            {
                if (choice == ' ')
                {
                }
                else
                {
                	System.out.println("Invalid value.");
                }
                // passed = false; 
            }       
            else
            {
            	if (inputValid == true)
            	{ //only if input is valid and within range too
            		passed = true;
            	}
            }
        }while(passed == false);
	
	     return choice;  
	}
	public static int errortrap2(int min, int max) //error traps integer inputs
	{
		int choice=0;
		boolean inputValid;
	    passed = false;
		do
		{	
			inputValid = true;
            try
            {
                 choice = input.nextInt(); 
            }
            catch (Exception error) 
            {
                System.out.println("Invalid Input." + error.toString()); 
                inputValid = false; //keeps looping if input is not a number
            }
            if(inputValid == true && (choice < min || choice > max))
            {
                System.out.println("Invalid value.");
            }       
            else
            {
            	if (inputValid == true)
            	{ //only if input is valid and within range too
            		passed = true;
            	}
            }
        }while(passed == false);
		
		return choice;
	}
	public static void gameover()
	{	boolean gameover1 = true, gameover2 = true;
		for(int x=0; x < LENGTH; x++)
		{
			for(int y=0; y < WIDTH; y++)
			{
				if (playership[x][y] == true)//there are ships that haven't been hit
				{
					gameover1 = false;
				}
			}
		}
		for(int x=0; x < LENGTH; x++)
		{
			for(int y=0; y < WIDTH; y++)
			{
				if (computership[x][y] == true)//there are ships that haven't been hit
				{
					gameover2 = false;
				}
			}
		}
		if (gameover1 == true ) //computer won
		{
			System.out.println("You've Lost.");
			losses++;
		}
		if (gameover2 == true ) //player won
		{
			System.out.println("You've Won!");
			wins++;
		}
		if (gameover1 == true || gameover2 == true)
		{
			gameover = true;//either player or computer wins
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int playagain = 0, menuchoice;
		do 
		{	//main menu
			System.out.println("=========================");
			System.out.println("Welcome to Battleship!");
			System.out.println("1. Instructions");
			System.out.println("2. Play!");
			System.out.println("=========================");
			System.out.println("");
			menuchoice = errortrap2(1,2);
			if (menuchoice == 1)
			{	System.out.println("Objective: Try to sink all 5 of the computer's ships.");
				System.out.println("");
				System.out.println("1. Position your 5 ships on the 10x10 grid.");
				System.out.println("2. Guess positions of the computer's ships.");
				System.out.println("3. If you get a hit, you can keep guessing.");
				System.out.println("4. Game is over when all 5 ships of you or the computer is sunk.");
				System.out.println("");
				
			}
		}while (menuchoice != 2);

		do
		{	
			System.out.println("");
			for(int x = 0; x <LENGTH; x++) //initializes grid, no ships yet
			{
				for(int y = 0; y < WIDTH; y++)//nested loop for each dimension
				{
					playership[x][y] = false;
				}
			}
			for(int x = 0; x <LENGTH; x++)//initializes grid, no ships yet
			{
				for(int y = 0; y < WIDTH; y++)//nested loop for each dimension
				{
					computership[x][y] = false;
				}
			}
			display();
			input();
			random();
			do //loops turns until game is over
			{	
				compare1();
				gameover();
				if (gameover == true) //if game is over at this point, no more turns
				{
					break;
				}
				compare2();
				gameover(); //checks to see if the game is over
			}while (gameover == false);//alternate player and computer turns until one wins
			System.out.println("");
			System.out.println("Would you like to play again? 1.Yes 2.No");
			playagain = input.nextInt(); //option to play again
		}while (playagain == 1);
		
		System.out.println(""); //score count
		System.out.println("========================="); 
		System.out.println("Number of games won:  "+wins);
		System.out.println("Number of games lost: "+losses);
		System.out.println("=========================");
	}
}
