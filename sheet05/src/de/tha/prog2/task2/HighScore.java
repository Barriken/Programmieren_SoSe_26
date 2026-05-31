package de.tha.prog2.task2;

public class HighScore {
	protected Player[] entries = new Player[10];
	
	
	public void recordEntry(Player newPlayer) 
	{
		for (int i = 0; i < entries.length; i++) 
		{
			if (entries[i] == null) {
				entries[i] = newPlayer;
				return;
				}
			else if (entries[i].points < newPlayer.points)
			{
				 for (int j = entries.length - 2; j >= i; j--) {
					 entries[j + 1] = entries[j];
				 }
				 entries[i] = newPlayer;
				 return;
			}
		}
	}
	
	public String toString() {
		String result = "";
		result += "** HIGH SCORE **\n";
		
		for (Player p : entries) {
			if (p == null) {
				System.out.println(result);
				return result;
			}
			result += p.toString() + "\n";
		}
		System.out.println(result);
		return result;
	}
}
