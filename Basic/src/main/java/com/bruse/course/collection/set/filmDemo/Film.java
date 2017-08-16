package com.bruse.course.collection.set.filmDemo;

public class Film {

	private String name;
	private String director;
	private String actor;
	private int time;
	
	public Film(){
		
	}
	
	public Film(String name, String director, String actor, int time) {
		super();
		this.name = name;
		this.director = director;
		this.actor = actor;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return name + "\t\t" + director + "\t\t"
				+ actor + "\t\t" + time;
	}
	
	

	
	
}
