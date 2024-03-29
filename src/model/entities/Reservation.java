package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNamber;
	private Date checkIn;
	private Date checkOut;
	
	// Declarando e instanciando um objeto SimpleDateFormat com uma máscara de dia, mês e ano.
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	// Construtor lançando as possíveis exceções e referenciando os atributos roomNamber, checkIn e checkOut.
	public Reservation(Integer roomNamber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new DomainException("check-out date must be after check-in date");
		}
		this.roomNamber = roomNamber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	// Método Getters e Setters para manipular os atributos.
	public Integer getRoomNamber() {
		return roomNamber;
	}

	public void setRoomNamber(Integer roomNamber) {
		this.roomNamber = roomNamber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	// Método que calcula a duração em dias com base no checkOut e checkIn.
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	// Método lançando as possíveis exeções e atualiza o checkIn e checkOut.
	public void  updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("check-out date must be after check-in date");
		}
		this.checkIn = checkIn; 
		this.checkOut = checkOut;
	}
	
	// Método toString.
	@Override
	public String toString() {
		return "Room "
				+ roomNamber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
}
