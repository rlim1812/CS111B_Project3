import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RPSGUIGame extends JFrame {

	// buttons for the user to enter their move
	private JButton rockButton, paperButton, scissorsButton;

	// labels to display the number of wins/losses/ties
	private JLabel statusC, statusU, statusT;


	// images and labels to display the computer and user's moves and the outcome of a match-up
	private ImageIcon paperImage, scissorsImage, rockImage;
	private JLabel compPlay, userPlay;
	private JLabel outcome;
	// the game object
	private RPSGame game;

	public RPSGUIGame() {

		// initializes the window
		super("Rock, Paper, Scissors, Go!");
		setSize(450, 400);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.black);
		setResizable(false);

		// creates the game object
		// 	NOTE: IF COMPLETING THE EXTRA CREDIT, YOU WILL NEED TO ADD A PARAMETER TO REPRESENT THE BET AMOUNT
		game = new RPSGame();


		// creates the labels for displaying the computer and user's move;
		// the images for the moves and the outcome of a match-up will be displayed
		// in a single panel
		rockImage = new ImageIcon("rock.jpg");
		paperImage = new ImageIcon("paper.jpg");
		scissorsImage = new ImageIcon("scissors.jpg");

		compPlay = new JLabel();
		compPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		compPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		compPlay.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		compPlay.setForeground(Color.cyan);
		userPlay = new JLabel();
		userPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		userPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		userPlay.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		userPlay.setForeground(Color.cyan);
		
		outcome = new JLabel();
		//outcome.setHorizontalTextPosition(SwingConstants.CENTER);
		outcome.setHorizontalAlignment(SwingConstants.CENTER);
		outcome.setForeground(Color.pink);
		
		JPanel imageOutcomePanel = new JPanel();
		imageOutcomePanel.setBackground(Color.black);
		imageOutcomePanel.setLayout(new BorderLayout());
		imageOutcomePanel.add(compPlay, BorderLayout.WEST);
		imageOutcomePanel.add(userPlay, BorderLayout.EAST);
		imageOutcomePanel.add(outcome, BorderLayout.SOUTH);
		
		// creates the labels for the status of the game (number of wins, losses, and ties);
		// the status labels will be displayed in a single panel
		statusC = new JLabel("Computer Wins: " + game.getCpuWins());
		statusU = new JLabel("User Wins: " + game.getUserWins());
		statusT = new JLabel("Ties: " + game.getTies());
		statusC.setForeground(Color.white);
		statusU.setForeground(Color.white);
		statusT.setForeground(Color.white);
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(Color.black);
		statusPanel.add(statusC);
		statusPanel.add(statusU);
		statusPanel.add(statusT);

		// the play and status panels are nested in a single panel
		JPanel gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(250, 250));
		gamePanel.setBackground(Color.black);
		gamePanel.add(imageOutcomePanel);
		gamePanel.add(statusPanel);
		
		// creates the buttons and displays them in a control panel;
		// one listener is used for all three buttons
		rockButton = new JButton("Play Rock");
		rockButton.addActionListener(new GameListener());
		paperButton = new JButton("Play Paper");
		paperButton.addActionListener(new GameListener());
		scissorsButton = new JButton("Play Scissors");
		scissorsButton.addActionListener(new GameListener());

		JPanel controlPanel = new JPanel();
		controlPanel.add(rockButton);
		controlPanel.add(paperButton);
		controlPanel.add(scissorsButton);
		controlPanel.setBackground(Color.black);
		
		// the gaming and control panel are added to the window
		contentPane.add(gamePanel, BorderLayout.CENTER);
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	/* determines which button was clicked and updates the game accordingly */
	private class GameListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int user_move = 0;
			userPlay.setText("Your move");
			compPlay.setText("Computer's move");
			if(event.getSource() == rockButton)
			{
				user_move = 1;
				userPlay.setIcon(rockImage);
			} else if(event.getSource() == paperButton)
			{
				user_move = 2;
				userPlay.setIcon(paperImage);
			}
			else if (event.getSource() == scissorsButton)
			{
				user_move = 3;
				userPlay.setIcon(scissorsImage);
			}
			int comp_move = game.generateComputerPlay();
			if(comp_move == 1 )
			{
				compPlay.setIcon(rockImage);
			} 
			else if(comp_move== 2)
			{
				compPlay.setIcon(paperImage);
			}
			else if(comp_move == 3)
			{
				compPlay.setIcon(scissorsImage);
			}
			// Winning or losing message
			//outcome.setText(game.findWinner(user_move, comp_move));
			
			statusC.setText("Computer Wins: " + game.getCpuWins());
			statusU.setText("User Wins: " + game.getUserWins());
			statusT.setText("Ties: " + game.getTies());
			
		}
		
		
	}

	
	public static void main(String args[]) {
		// create an object of your class
		RPSGUIGame frame = new RPSGUIGame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
