package de.tha.prog2.task2;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import de.tha.prog2.tools.GameDataProvider;

public class task02 {
	public static void main (String [] args) {
		
	}
	
	public Collection<VereinsDaten> auswerten (GameDataProvider data, int days) {
		int currentDay = 1;
		HashMap<String, VereinsDaten> tabelle = new HashMap<String, VereinsDaten>();
		
		while (currentDay <= days) 
		{
			var currentGames = data.getGames(currentDay);
			for (var game : currentGames) 
			{
				VereinsDaten away = new VereinsDaten();
				VereinsDaten home = new VereinsDaten();
				
				away.name = game.awayTeam;
				home.name = game.homeTeam;
				
				if (tabelle.containsKey(game.awayTeam)) 
				{
					away = tabelle.get(game.awayTeam);
				}	
				if (tabelle.containsKey(game.homeTeam)) 
				{
					home = tabelle.get(game.awayTeam);
				}
				
				away.playedGames += 1;
				home.playedGames += 1;
				
				away.shotGoals += game.awayGoals;
				home.shotGoals += game.homeGoals;
				
				away.receivedGoals += game.awayGoals;
				home.receivedGoals += game.homeGoals;
				
				away.goalDiff = (away.shotGoals - away.receivedGoals);
				home.goalDiff = (home.shotGoals - home.receivedGoals);
				
				if (game.awayGoals > game.homeGoals) {
					away.wins+= 1;
					home.losses += 1;
					
					away.points += 3;
				}
				else if (game.awayGoals == game.homeGoals) {
					away.draws += 1;
					home.draws += 1;
					
					away.points += 1;
					home.points += 1;
				}
				else {
					home.wins += 1;
					away.losses += 1;
					
					home.points += 3;
				}
				tabelle.put(home.name, home);
				tabelle.put(away.name, away);
			}
		}
		return tabelle.values();
	}
}
