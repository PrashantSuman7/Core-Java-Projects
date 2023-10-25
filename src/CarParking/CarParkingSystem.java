package CarParking;

import java.util.ArrayList;
import java.util.Scanner;

class CarParkingSystem {
	static int totalSlots, availableSlot;
	static ArrayList<String> parkedCars = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total Slots");
		totalSlots = sc.nextInt();
		availableSlot = totalSlots;

		while (true) {
			System.out.println("/What You like to Do :");
			System.out.println("1. Prak a car");
			System.out.println("2. Remove c car");
			System.out.println("3. view Prakcars");
			System.out.println("4. Exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				prakCar();
				break;
			}
			case 2: {
				removeCAr();
				break;
			}
			case 3: {
				viewParkedCars();
				break;
			}
			case 4: {
				System.exit(0);
			}
			default:
				System.out.println("Invalid Choice ,please try again");
			}
		}

	}


	public static void prakCar() {
		if (availableSlot == 0) {
			System.out.println(" Sorry , there are no available Parking Slots");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Owner name : ");
		String name = sc.nextLine();
		System.out.println("Enter the License plate Number");
		String number = sc.next();
		parkedCars.add(name);
		parkedCars.add(number);

		availableSlot--;

		System.out.println("Car Parked Successfully" + "  " + "Available Slots " + availableSlot);

	}

	public static void removeCAr() {
		if (availableSlot == totalSlots) {
			System.out.println(" There are no Parked Car ");
		}
		Scanner sc = new Scanner("Enter the Parked Car Number :");
		String number = sc.next();
		if (parkedCars.contains(number)) {
			parkedCars.remove(number);
			availableSlot++;
			System.out.println("Car Removed SuccessFully : ");
		} else {
			System.out.println("The car not Parked here ");
		}

	}
	private static void viewParkedCars() {
		if (availableSlot == totalSlots) {
			System.out.println(" There are no Parked Car ");
		}
		System.out.println("   :  Parked Cars  :  ");
		for(String license :parkedCars) {
			System.out.println("     "+license+"    ");
		}
		
	}


}
