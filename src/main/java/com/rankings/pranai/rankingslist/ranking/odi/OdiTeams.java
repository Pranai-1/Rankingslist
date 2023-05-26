package com.rankings.pranai.rankingslist.ranking.odi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OdiTeams {
	@Id
	private int id;
  private String name;
  private int matches;
  private int points;
  private int rating;
  private String username;
  OdiTeams(){
	  
  }
public OdiTeams(int id, String name, int matches, int points, int rating,String username) {
	super();
	this.id = id;
	this.name = name;
	this.matches = matches;
	this.points = points;
	this.rating = rating;
	this.username=username;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMatches() {
	return matches;
}
public void setMatches(int matches) {
	this.matches = matches;
}
public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
@Override
public String toString() {
	return "Teams [id=" + id + ", name=" + name + ", matches=" + matches + ", points=" + points + ", rating=" + rating
			+ "]";
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
  
}


