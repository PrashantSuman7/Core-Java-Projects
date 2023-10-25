package OnlineReservationforGuest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ReservatonSystemUI {

	private ReservationSystem reservationSystem = new ReservationSystem();

	public void start() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. Make a Reservation");
			System.out.println("2. View All Reservation");
			System.out.println("3.Cencle Reservation");
			System.out.println("4. Exit");

			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1: {
				System.out.print("Name :  ");
				String name = sc.nextLine();
				System.out.println("Date :  ");
				String date = sc.nextLine();
				System.out.println("Number Of Guest ");
				int numberOfGuest = sc.nextInt();
				sc.nextLine();

				Reservation reservation = reservationSystem.makeReservation(name, date, numberOfGuest);
				System.out.println("Reservation made With Id " + reservation.getId());
			}
				break;

			case 2: {
				System.out.println("Reservation ");
				for (Reservation reservation : reservationSystem.getReservations()) {
					System.out.println(reservation.getId() + "-" + reservation.getName() + "-" + reservation.getDate()
							+ "-" + reservation.getNumberOfGuest());
				}
			}
				break;
			case 3: {
				System.out.println("Reservation Id To Cancle :");
				int id = sc.nextInt();
				sc.nextLine();

				if (reservationSystem.cancleReservation(id)) {
					System.out.println("Reservation Cancle Successfully");
				} else {
					System.out.println("Reservation not Found on This ID");
				}
			}
				break;
			case 4: {
				return;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

	public static void main(String[] args) {
		ReservatonSystemUI systemUI = new ReservatonSystemUI();
		systemUI.start();

	}

}

class Reservation {
	private int id;
	private String name;
	private String date;
	private int numberOfGuest;

	public Reservation(int id, String name, String date, int numberOfGuest) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.numberOfGuest = numberOfGuest;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public int getNumberOfGuest() {
		return numberOfGuest;
	}

}

class ReservationSystem {
	private List<Reservation> reservations = new ArrayList<>();
	private int nextId = 1;

	public Reservation makeReservation(String name, String date, int numberOfGuest) {
		Reservation reservation = new Reservation(nextId++, name, date, numberOfGuest);
		reservations.add(reservation);
		return reservation;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public Reservation getReservationById(int id) {
		for (Reservation reservation : reservations) {
			if (reservation.getId() == id) {
				return reservation;
			}
		}
		return null;
	}

	public boolean cancleReservation(int id) {
		Reservation reservation = getReservationById(id);
		if (reservation != null) {
			reservations.remove(reservation);
			return true;
		}
		return false;
	}
}
