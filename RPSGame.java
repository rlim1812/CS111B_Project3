/*
 * Ryan Lim
 * Jill Huang
 * Fiona Gallagher
 * Marion Gallagher
 */


import java.util.*;

public class RPSGame {
	//Instance Variables
	private int cpuWins;
	private int userWins;
	private int ties;
	private int whoWon;
	
	//constants to represent moves
	static final int Rock = 1;
	static final int Paper = 2;
	static final int Scissors = 3;
	static final int CpuWon = 10;
	static final int UserWon = 20;
	static final int Tie = 30;
	
	/*
	 * constructor 
	 * the game starts off with a blank state,
	 * there are no initial cpuWins, userWins, or ties
     */
	
	public RPSGame(){
		cpuWins = 0;
		userWins = 0;
		ties = 0;
	}
	
	/*
	 * setters and getters 
	 * 
	 * Since this class does not
	 * interact with the user,
	 * the GUI class will take care
	 * of validity checking
	 * 
	 */
	
	public void setCpuWins(int newNumCpuWins){
		cpuWins = newNumCpuWins;
	}
	public void setUserWins(int newNumUserWins){
		userWins = newNumUserWins;
	}
	public void setTies(int newNumTies){
		ties = newNumTies;
	}
	
	public int getCpuWins(){
		return cpuWins;
	}
	public int getUserWins(){
		return userWins;
	}
	public int getTies(){
		return ties;
	}
	public int getWhoWon() {
		return whoWon;
	}
	
	/*
	 * generate a random move by the computer
	 * 1 - Rock
	 * 2 - Paper
	 * 3 - Scissors
	 */
	
	public int generateComputerPlay(){
		Random generator = new Random();
		//generate a random int to represent the computer's move and then return its value
		return generator.nextInt(3) + 1;
	}
	
	//find the winner
	public String findWinner(int cpuMove, int userMove){
		//match ups
		String message = null;
		if(cpuMove == userMove)
		{
			ties++;
		}
		else
		{
			
			if(cpuMove == Rock)
			{
				if(userMove == Paper)
				{
					userWins++;
				}
				else if(userMove == Scissors)
				{
					cpuWins++;
				}
			}
			if(cpuMove == Paper)
			{
				
					if(userMove == Rock)
					{
						cpuWins++;
					}
					else if(userMove == Scissors)
					{
						userWins++;
					}
				
			}
			if(cpuMove == Scissors)
			{
				if(userMove == Rock)
				{
					userWins++;
				}
				else if(userMove == Paper)
				{
					cpuWins++;
				}
			}
		}
	//	System.out.println(toString());
		message = "Whatever";
		return message;
		
	}
	
	public String toString(){
		return ("Computer Wins: "+cpuWins+"\nUser Wins: "+userWins+"\nTies: "+ties);
	}
	
}