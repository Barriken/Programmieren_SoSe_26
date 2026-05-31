package de.tha.prog2.task2;

public  class Player <T> implements Comparable<T>{
	public int points;
	public String name;
	
	public Player (String name) {
		this.name = name;
	}
	public void recordPoints(int points) {
		this.points += points;
	}
	

	@Override
	public int compareTo(T o) {
		
		Player other = (Player) o;
		
		return (this.points - other.points);
	}
	
	public String toString() {
		return points + " - " + name;
	}
}
