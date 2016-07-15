//Programmed by: Ryan Lim, Jill Huang, Ethan <I don't know his last name>,
//and (debatably) Marion Fiona Gallagher.
package Project3;
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
	
//Constructor-- the game starts off in a blank state, with no initial cpuWins, userWins, or ties.
	public RPSGame(){
		cpuWins = 0;
		userWins = 0;
		ties = 0;
	}
	
/*
Setters and Getters 
Since this class doesn't interact with the user, the GUI class will take care of validity checking.
*/
//(setters)
	public void setCpuWins(int newNumCpuWins){
		cpuWins = newNumCpuWins;
	}
	public void setUserWins(int newNumUserWins){
		userWins = newNumUserWins;
	}
	public void setTies(int newNumTies){
		ties = newNumTies;
	}
//(getters)
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

//Method to generate a random move by the computer-- with
//1 == Rock, 2 == Paper, and 3 == Scissors.
	public int generateComputerPlay(){
		Random generator = new Random();
		//generate a random int to represent the computer's move and then return its value
		int aiMove = generator.nextInt(3) + 1;
		return aiMove;
	}

	
//Method to figure out whether the computer or the user won
	public void findWinner(int cpuMove, int userMove){
		//matchups for ROCK
		if (cpuMove == Rock) {
			if (userMove == Rock){
				ties++;
				whoWon = Tie;
			}
			else if (userMove == Paper){
				userWins++;
				whoWon = UserWon;
			}
			else if (userMove == Scissors) {
				cpuWins++;
				whoWon = CpuWon;
			}
		//matchups for PAPER
		} else if (cpuMove == Paper) {
			if (userMove == Rock) {
				cpuWins++;
				whoWon = CpuWon;
			}
			else if (userMove == Paper){
				ties++;
				whoWon = Tie;
			}
			else if (userMove == Scissors) {
				userWins++;
				whoWon = UserWon;
			}
		//matchups for SCISSORS
		} else if (cpuMove == Scissors) {
			if (userMove == Rock) {
				userWins++;
				whoWon = UserWon;
			}
			else if (userMove == Paper) {
				cpuWins++;
				whoWon = CpuWon;
			} else if (userMove == Scissors) {
				ties++;
				whoWon = Tie;
			}
		}
	}

//method to print to the consol the number of wins for the computer
//and the user, plus the number of ties.
	public String toString(){
		return ("Computer Wins: "+cpuWins+"\nUser Wins: "+userWins+"\nTies: "+ties);
	}
	
}
