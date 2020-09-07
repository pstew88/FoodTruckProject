package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckProject {

	FoodTruck[] trucks;

	public static void main(String[] args) {
		FoodTruckProject ftp = new FoodTruckProject();
		ftp.run();
	}

	private void run() {

		Scanner kb = new Scanner(System.in);
		int maxTruck = 5;
		int numberOfTrucks = 0;
		trucks = new FoodTruck[maxTruck];
		for (int i = 0; i < trucks.length; i++) {

			System.out.println("------------------------------------------------------------");
			System.out.println("Please enter details on the foodtruck you would like to rate");
			System.out.println("");
			System.out.println("Truck name: ");
			String name = kb.next();

			if (name.equals("quit")) {
				break;
			}

			System.out.println("");
			System.out.println("What type of food does this truck sell?");
			String food = kb.next();

			System.out.println("");
			System.out.println("From a scale of 1 to 5, 5 being the highest, what rating would you give this truck?");
			double rating = kb.nextDouble();
			System.out.println("");

			FoodTruck truck = new FoodTruck(name, food, rating);
			trucks[i] = truck;
		}
		menu();
	}

	private void menuChoice() {
		Scanner kb = new Scanner(System.in);
		boolean repeat = true;
		int choice = kb.nextInt();
		while (repeat == true) {

			if (choice == 1) {
				System.out.println("");
				listAllTruckInfo();
				System.out.println("");

			} else if (choice == 2) {
				System.out.println("");
				averageRating();
				System.out.println("");
			} else if (choice == 3) {
				System.out.println("");
				listHighestRated();
				System.out.println("");
			} else if (choice == 4) {
				System.out.println("");
				System.out.println("*****************");
				System.out.println("Have a Great Day!");
				System.out.println("*****************");
				repeat = false;
				break;

			} else {
				System.out.println("**************");
				System.out.println("Invalid Option");
				System.out.println("**************");
			}
			menu();
			break;
		}
	}

	private void listHighestRated() {
		double highestRating = trucks[0].getRating();

		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {
				if (trucks[i].getRating() > highestRating) {

					highestRating = trucks[i].getRating();
				}
			}
		}

		int ties = 0;
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {

				if (highestRating == trucks[i].getRating()) {
					ties++;
				}
			}
		}
		if (ties > 1) {
			System.out.println(ties + " food trucks tie for the highest-rated:");
		} else {
			System.out.println("The highest-rated food truck is:");
		}

		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {

				if (highestRating == trucks[i].getRating()) {
					System.out.println(trucks[i].toString());
				}
			}
		}
	}

	public void listAllTruckInfo() {
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {

				System.out.println(trucks[i].toString());
			}
		}
	}

	private void averageRating() {
		double average = 0.0;
		double total = 0.0;
		int numberOfTrucks = 0;
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {
				numberOfTrucks++;

				total = total + trucks[i].getRating();
			}
		}
		average = total / numberOfTrucks;
		System.out.println("");
		System.out.println("The average rating of all food trucks is " + average);
	}

	private void menu() {
		System.out.println("");
		System.out.println("  ***********************************");
		System.out.println("1 ********* List Food Trucks ********");
		System.out.println("2 **** See Average of all Trucks ****");
		System.out.println("3 **** See Highest Rated  Trucks ****");
		System.out.println("4 *************** Exit **************");
		System.out.println("  ***********************************");
		menuChoice();
	}
}