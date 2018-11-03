/*
 * Clinton Rogers
 * 11/23/2014
 * Winner Class, simply stores a world series winner, and the year they won
 */
public class Winner {
	private String team;
	private int year;
	
	@SuppressWarnings("unused")
	private Winner()
	{
		/*
		 * Make default constructor private so programers who use this
		 * class are forced to use the constructor that requires them
		 * to provide both the team name and year
		 */
		
	}
	
	public Winner(String team, int year)
	{
		this.team = team;
		this.year = year;
	}
	
	public String getTeam() {
		return team;
	}
	public int getYear() {
		return year;
	}
	
	

}
