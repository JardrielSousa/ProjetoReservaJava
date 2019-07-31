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
	public String updateDates(Date checkIn ,Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now) ) {
			return "Erro na Reserva : Preencha com datas futuras";
		}else if(!checkOut.after(checkIn)) {
			return "Erro na Reserva : Data de checkIn n�o pode ser menor que a de checkOut";
		}else {
			
		this.checkin = checkIn;
		this.checkout = checkOut;
		}
		return null;
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

