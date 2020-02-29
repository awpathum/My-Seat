package com.airline.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Gender;
import com.airline.models.Passenger;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPassenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("errors", false);

		Passenger p = new Passenger();
		String firstName = request.getParameter("firstname");
		System.out.println("firstName : " + firstName);

		if (firstName.length() == 0) {
			System.out.println("Empty first name error");
			request.setAttribute("errors", true);
			request.setAttribute("firstname_error", true);
		} else {
			p.setFirstName(firstName);
		}
		String lastName = request.getParameter("lastname");

		System.out.println("lastName : " + lastName);

		if (lastName.length() == 0) {
			System.out.println("Empty last name error");
			request.setAttribute("errors", true);
			request.setAttribute("lastname_error", true);
		} else {
			p.setLastName(lastName);
		}

		String dob_raw = request.getParameter("dob");

		String dobArray[] = dob_raw.split("\\/");

		String pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
		Pattern r = Pattern.compile(pattern);

		Matcher m = r.matcher(dob_raw);
		if (m.find()) {
			String month = dobArray[0];
			String day = dobArray[1];
			String year = dobArray[2];

			Calendar cal = Calendar.getInstance();

			cal.set(Calendar.YEAR, Integer.parseInt(year));
			cal.set(Calendar.MONTH, Integer.parseInt(month));
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));

			Date dob = cal.getTime();
			System.out.println(dob);
			p.setDob(dob);
		} else {

			System.out.println("Invalid Date of Birth");
			request.setAttribute("errors", true);
			request.setAttribute("date_format_error", true);
		}
		String gender = request.getParameter("gender");
		System.out.println("gender : " + gender);
		p.setGender(Gender.valueOf(gender));

		if ((Boolean) request.getAttribute("errors")) {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");

			view.forward(request, response);
		} else {
			ArrayList<Passenger> pList = new ArrayList<Passenger>();
			pList.add(p);
			
			response.sendRedirect("");
		}

	}

}
