package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class FligthService
 */
@Stateful(name = "flightStateful")
public class FlightServiceStatefulBean implements FlightLocal_ejb1 {

	/**
	 * Default constructor.
	 */
	public FlightServiceStatefulBean() {
		// TODO Auto-generated constructor stub
	}

	private Integer id = 2348357;
	private String from = "Colombo";
	private String to = "London";
	private Integer price = 400;
	private Integer numOfSeats = 250;
	private String airplaneModel = "Boeing 787";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(Integer numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public String getAirplaneModel() {
		return airplaneModel;
	}

	public void setAirplaneModel(String airplaneModel) {
		this.airplaneModel = airplaneModel;
	}

	@Override
	public String toString() {
		return "FligthService [id=" + id + ", from=" + from + ", to=" + to + ", price=" + price + ", numOfSeats="
				+ numOfSeats + ", airplaneModel=" + airplaneModel + "]";
	}

}
