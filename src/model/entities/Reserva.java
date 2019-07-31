package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	public int roomNumber;
	public Date checkin;
	public Date checkout;
	
	public Reserva(int roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}	
	
	public long duration() {
		long diff =  checkout.getTime() - checkin.getTime() ;
		return TimeUnit.DAYS.convert(diff, TimeUnit.DAYS.MILLISECONDS);
	}
	public void updateDates(Date CheckIn ,Date CheckOut) {
		this.checkin = CheckIn;
		this.checkout = CheckOut;
	}
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	
	@Override
	public String toString() {
		return "Room " + roomNumber +
			   " , checkIn: " + sdf.format(checkin) + 
			   " , checkOut: " + sdf.format(checkout) +
			   "," + duration() + " nigths"; 
	}
}

