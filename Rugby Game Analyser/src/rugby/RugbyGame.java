/**
 * 
 */
package rugby;

/**
 * class represents a rugby game
 */
public class RugbyGame {
	
	/**
	 * Constants for text formatting
	 */
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";
	
	private String team1;
	private int team1Score;
	private String team2;
	private int team2Score;
	private String winner;
	

	/**
	 * default constructor
	 */
	public RugbyGame() {
		
	}


	/**
	 * constructor using arguments
	 * @param team1
	 * @param team1Score
	 * @param team2
	 * @param team2Score
	 * @param winner
	 */
	public RugbyGame(String team1, int team1Score, String team2, int team2Score) {
		this.team1 = team1;
		this.team1Score = team1Score;
		this.team2 = team2;
		this.team2Score = team2Score;
		this.winner = (team1Score > team2Score ? team1 : team2);
	}


	/**
	 * @return the team1
	 */
	public String getTeam1() {
		return team1;
	}


	/**
	 * @param team1 the team1 to set
	 */
	public void setTeam1(String team1) {
		this.team1 = team1;
	}


	/**
	 * @return the team1Score
	 */
	public int getTeam1Score() {
		return team1Score;
	}


	/**
	 * @param team1Score the team1Score to set
	 */
	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}


	/**
	 * @return the team2
	 */
	public String getTeam2() {
		return team2;
	}


	/**
	 * @param team2 the team2 to set
	 */
	public void setTeam2(String team2) {
		this.team2 = team2;
	}


	/**
	 * @return the team2Score
	 */
	public int getTeam2Score() {
		return team2Score;
	}


	/**
	 * @param team2Score the team2Score to set
	 */
	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
	}


	/**
	 * @return the winner
	 */
	public String getWinner() {
		return winner;
	}


	/**
	 * @param winner the winner to set
	 */
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	/**
	 * calculate the winner of the game
	 */
	public void calculateWinner() {
		this.winner = (team1Score > team2Score ? team1 : team2);
	}


	/**
	 * displaying result to a string
	 */
	@Override
	public String toString() {
		return team1 + " " + team1Score + "\t:  " + team2 + " " + team2Score + "\t|    " + "Winner " + GREEN_TEXT +  winner + RESET_TEXT ;
	}
	
	
	
	

}
