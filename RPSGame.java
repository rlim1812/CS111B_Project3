/*
 * Ryan Lim
 * Jill Huang
 * Fiona Gallagher
 * Marion Gallagher
 */

package Project3;
import java.util.Random;

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
	public void findWinner(int cpuMove, int userMove){
		//match ups
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
	
	public String toString(){
		return ("Computer Wins: "+cpuWins+"\nUser Wins: "+userWins+"\nTies: "+ties);
	}
	
}