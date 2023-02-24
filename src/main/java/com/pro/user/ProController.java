package com.pro.user;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProController {

	@Autowired
	UserServiceLayer usl;

	// ADMIN Endpts.
	@GetMapping("/admin")
	public String getAdmin() {
		return usl.register("admin");
	}

	@PostMapping("/entermovie")
	public String addMovie(Movies mov) {
		usl.addMovie(mov);
		return usl.register("admin");
	}

	@PostMapping("/entershow")
	public String addShow(Shows mov) {
		usl.addShow(mov);
		return usl.register("admin");
	}

	@PostMapping("/enterhall")
	public String addHall(Hall mov) {
		usl.addHall(mov);
		return usl.register("admin");
	}

	@PostMapping("/addseattype")
	public String addseattype(SeatType st) {
		usl.addseattype(st);
		return usl.register("admin");
	}

	@PostMapping("/addhallcapacity")
	public String addhallcapacity(HallCapacity hallcap) {
		usl.addhallcapacity(hallcap);
		return usl.register("admin");
	}

	@GetMapping("/welcome")
	public ModelAndView getWelcome() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Movies> movies = usl.getMovies();
		mv.addObject("name", movies);
		mv.setViewName("welcome");
		return mv;
	}

	/*
	 * @GetMapping("/showdetails") public ModelAndView getShow() { ModelAndView mv =
	 * new ModelAndView(); ArrayList<Shows> shows = usl.getShows();
	 * mv.addObject("shows", shows); mv.setViewName("showdetails"); return mv; }
	 */

	@RequestMapping("/showdetails")
	public ModelAndView getShow(@RequestParam int movieid) {
		// String movieid = req.getParameter("movieid");
		// System.out.println("******************************************" +movieid);
		ModelAndView mv = new ModelAndView();
		ArrayList<Shows> shows = usl.getShows();
		mv.addObject("movieid", movieid);
		mv.addObject("shows", shows);
		mv.setViewName("showdetails");
		return mv;
	}

	@RequestMapping("/moviedetails")
	public ModelAndView getMovieD(HttpServletRequest req, @RequestParam String movieid) {
		ModelAndView mv = new ModelAndView();
		// System.out.println("******************************************" +movieid);
		ArrayList<Shows> movied = usl.getMovieDetails();
		mv.addObject("movieid", movieid);
		mv.addObject("movied", movied);
		mv.setViewName("moviedetails");
		return mv;
	}

	@RequestMapping("/bookseattype")
	public ModelAndView getBookSeattype(HttpServletRequest req, HttpServletResponse res, @RequestParam int hallid) {
		ModelAndView mv = new ModelAndView();
		// System.out.println("******************************************" +movieid);
		req.getParameter("showid");
		Cookie c = new Cookie("userid", req.getParameter("showid"));
		res.addCookie(c);
		ArrayList<HallCapacity> hallcaplist = usl.getHallCapacity();
		mv.addObject("hallcaplist", hallcaplist);
		mv.addObject("hallid", hallid);
		mv.setViewName("bookseattype");
		return mv;
	}

	@RequestMapping("/payment")
	public ModelAndView getPaymentDetails(HttpServletRequest req, @RequestParam int nos, @RequestParam double seatfare,
			@RequestParam int hallcapid) {
		double total = nos * seatfare;
		ModelAndView mv = new ModelAndView();
		// System.out.println("******************************************" +movieid);

		ArrayList<HallCapacity> hallcaplist = usl.getHallCapacity();
		mv.addObject("hallcaplist", hallcaplist);
		mv.addObject("nos", nos);
		mv.addObject("total", total);
		mv.addObject("hallcapid", hallcapid);
		mv.setViewName("payment");
		return mv;
	}

	@PostMapping("/confirm")
	public ModelAndView getConfirmDetails(HttpServletRequest req, @RequestParam int nos, @RequestParam int hallcapid) {
		ModelAndView mv = new ModelAndView();
		// ArrayList<Hall> halllist = usl.getHall();
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("userid")) {
				mv.addObject("userid", c.getValue());
				System.out.println("33333333333333" + c.getValue());
			}
			if (c.getName().equals("showid")) {
				mv.addObject("showid", c.getValue());
			}
		}
		System.out.println("33333333333333");

		ArrayList<HallCapacity> hallcaplist = usl.getHallCapacity();
		Iterator<HallCapacity> it = hallcaplist.iterator();
		while (it.hasNext()) {
			HallCapacity m = it.next();
			if (m.getHallCapacityId() == hallcapid) {
				usl.updateTotalSeats(nos, m.getHallId().getHallId());
			}
		}
		usl.updateCapacity(nos, hallcapid);
		mv.addObject("hallcaplist", hallcaplist);
		mv.addObject("nos", nos);
		mv.addObject("hallcapid", hallcapid);
		mv.setViewName("confirm");
		return mv;
	}

	@RequestMapping("/cancel")
	public String paymentCancel() {
		return usl.register("paymentcancel");
	}

	@PostMapping("/adduser")
	public String addRecord(User obj, @RequestParam String pass, @RequestParam String mobno, @RequestParam String cpass,
			@RequestParam String email) {

		if (pass.equals(cpass) == true && mobno.length() == 10 && email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			usl.addUser(obj);
			return usl.register("success");
		} else if (pass.equals(cpass) == false) {
			return usl.register("invalidpass");
		} else if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$") == false) {
			return usl.register("invalidmail");
		} else if (mobno.length() != 10) {
			return usl.register("invalidmobno");
		} else {
			return usl.register("invalidinfo");
		}

		/*
		 * ModelAndView mv = new ModelAndView(); mv.addObject("name", obj);
		 * mv.setViewName("Demo"); return mv;
		 */
		// return usl.register("Demo");
	}

	@GetMapping("/userregistration")
	public String registerPage(String usr) {
		return usl.register("userregister");
	}

	@PostMapping("/userlogin")
	public String getUserPage(HttpServletRequest req, @RequestParam String username, @RequestParam String password) {
		String input = req.getParameter("a1");

		// ModelAndView mv = new ModelAndView();

		if (input.equals("Login")) {
			if (usl.verifyUser(username, password) == true) {
				return usl.register("loginsuccess");

			} else {

				return usl.register("loginfail");

			}

		} else {
			return usl.register("userregister");

		}
	}

	@PostMapping("/userloginafter")
	public ModelAndView getUserPage1(HttpServletResponse res, HttpServletRequest req, @RequestParam String moviename,
			@RequestParam String username, @RequestParam String password) {
		String input = req.getParameter("a1");

		// String data = req.getParameter("showid");
		ArrayList<User> userlist = usl.getUser();
		Iterator<User> it = userlist.iterator();
		while (it.hasNext()) {
			User m = it.next();
			if (m.getName().equals(username)) {
				String i = String.valueOf(m.getUserid());
				Cookie c = new Cookie("userid", i);
				res.addCookie(c);
			}
		}

		ModelAndView mv = new ModelAndView();
		ArrayList<Shows> showlist = usl.getMovieDetails();
		mv.addObject("showlist", showlist);
		mv.addObject("moviename", moviename);
		if (input.equals("Login")) {
			if (usl.verifyUser(username, password) == true) {
				mv.setViewName("loginsuccess");
				return mv;
			} else {
				mv.setViewName("loginfail");
				return mv;
			}
			// return usl.register("Demo");
		} else {
			mv.setViewName("userregister");
			return mv;
		}
	}

	@RequestMapping("/userlogin")
	public String userLogin() {
		return usl.register("userlogin");
	}

	@RequestMapping("/userlogin1")
	public ModelAndView userLogin1(HttpServletRequest req, @RequestParam String moviename) {
		// String movieid = req.getParameter("movieid");
		ModelAndView mv = new ModelAndView();
		ArrayList<Shows> showlist = usl.getMovieDetails();
		mv.addObject("moviename", moviename);
		mv.addObject("showlist", showlist);
		mv.setViewName("userlogin1");
		return mv;
	}
}
