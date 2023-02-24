package com.pro.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;

//import com.pro.entity.Movies;


@Service
public class UserServiceLayer {
	@Autowired
	UserRepository urep;

	@Autowired
	MoviesRepository mrep;

	@Autowired
	ShowsRepository srep;

	@Autowired
	HallRepository hrep;

	@Autowired
	HallCapacityRepository hcrep;

	@Autowired
	SeatTypeRepository strep;

	public void updateCapacity(int nos, int hallcapid) {
		// int remainseats =

		hcrep.updateSeatCapacity(nos, hallcapid);
	}

	public void updateTotalSeats(int nos, int hallid) {
		hrep.updateTotalSeats(nos, hallid);
	}

	public void addUser(User user) {
		urep.save(user);
	}

	public void addShow(Shows user) {
		srep.save(user);
	}

	public void addMovie(Movies mov) {
		mrep.save(mov);
	}

	public void addseattype(SeatType st) {
		strep.save(st);
	}

	public void addhallcapacity(HallCapacity hallcap) {
		hcrep.save(hallcap);
	}

	public void addHall(Hall mov) {
		hrep.save(mov);
	}

	public String register(String regpage) {
		return regpage;
	}

	public ArrayList<Movies> getMovies() {
		ArrayList<Movies> movies = new ArrayList<>();
		mrep.findAll().forEach(movies::add);
		return movies;
	}

	public ArrayList<Shows> getShows() {
		ArrayList<Shows> shows = new ArrayList<>();
		srep.findAll().forEach(shows::add);
		return shows;
	}

	public ArrayList<Hall> getHall() {
		ArrayList<Hall> movied = new ArrayList<>();
		hrep.findAll().forEach(movied::add);
		return movied;
	}

	public ArrayList<Shows> getMovieDetails() {
		ArrayList<Shows> movied = new ArrayList<>();
		srep.findAll().forEach(movied::add);
		return movied;
	}

	public ArrayList<User> getUser() {
		ArrayList<User> movied = new ArrayList<>();
		urep.findAll().forEach(movied::add);
		return movied;
	}

	public ArrayList<HallCapacity> getHallCapacity() {
		ArrayList<HallCapacity> hallcaplist = new ArrayList<>();
		hcrep.findAll().forEach(hallcaplist::add);
		return hallcaplist;
	}

	public boolean verifyUser(String username, String password) {
		User tmp = (User) urep.findByName(username);

		try {
			if (tmp.getName().equals(username)) {
				if (tmp.getPass().equals(password)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	 
}