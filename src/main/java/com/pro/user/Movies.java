package com.pro.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movies")
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int MovieId;

	private String MovieName;

	public int getMovieId() {
		return MovieId;
	}

	public void setMovieId(int movieId) {
		MovieId = movieId;
	}

	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	@Override
	public String toString() {
		return "Movies [MovieId=" + MovieId + ", MovieName=" + MovieName + "]";
	}
	
}
