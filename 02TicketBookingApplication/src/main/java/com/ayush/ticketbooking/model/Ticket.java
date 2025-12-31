package com.ayush.ticketbooking.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private Integer ticket_Id;
	
	@Column(name="passanger_name")
	private String passangerName;
	
	@Column(name="source_station")
	private String sourceStation;
	
	@Column(name="destination_station")
	private String destinationStation;
	
	@Column(name ="travel_date")
	private Date travelDate;
	
	private String email;

	public int getTicket_Id() {
		return ticket_Id;
	}

	public void setTicket_Id(int ticket_Id) {
		this.ticket_Id = ticket_Id;
	}

	public String getPassangerName() {
		return passangerName;
	}

	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ticket(int ticket_Id, String passangerName, String sourceStation, String destinationStation, Date travelDate,
			String email) {
		super();
		this.ticket_Id = ticket_Id;
		this.passangerName = passangerName;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.travelDate = new Date();
		this.email = email;
	}

	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ticket [ticket_Id=" + ticket_Id + ", passangerName=" + passangerName + ", sourceStation="
				+ sourceStation + ", destinationStation=" + destinationStation + ", travelDate=" + travelDate
				+ ", email=" + email + "]";
	}
	
	
	
	
}
