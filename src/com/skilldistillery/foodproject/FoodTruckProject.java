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
//for loop to determine if # of truck >=5
//if not add new truck array to and ask for info
		int maxTruck = 5;
		int numberOfTrucks = 0;
		trucks = new FoodTruck[maxTruck];
		for (int i = 0; i < trucks.length; i++) {

			System.out.println("Please enter details on the foodtruck you would like to rate");
			System.out.println("Truck name: ");
			String name = kb.next();

			// should break if truck is named quit but doesnt
			if (name.equals("quit")) {
				break;
			}

			System.out.println("");
			System.out.println("What type of food does this truck sell?");
			String food = kb.next();

			System.out.println("");
			System.out.println("From a scale of 1 to 5, 5 being the highest, what rating would you give this truck?");
			double rating = kb.nextDouble();

			// test info to call

			FoodTruck truck = new FoodTruck(name, food, rating);
//	truck.displayTruck();
			trucks[i] = truck;
			// should get average of food trucks by taking total of ratings / by total
			// number of truck ID
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
				menu();
				choice = kb.nextInt();

			} else if (choice == 2) {
				System.out.println("");
				averageRating();
				System.out.println("");
				menu();
				choice = kb.nextInt();
			} else if (choice == 3) {
				System.out.println("");
				System.out.println("(∩_∩)"); // Highest Rated
				System.out.println("");
				menu();
				choice = kb.nextInt();
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
				menu();
				choice = kb.nextInt();
			}
		}

		// TODO Auto-generated method stub

	}

	public void listAllTruckInfo() {
		for (int i = 0; i < trucks.length; i++) {
			System.out.println(trucks[i].toString());
		}
	}

	private void averageRating() {
		double average = 0.0;
		for (int i = 0; i < trucks.length; i++) {
			double total = 0.0;
			trucks[i].getRating();
			total = total + trucks[i].getRating();
			average = total / trucks.length;
		}
		System.out.println("The average rating of all food trucks is " + average);
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("");
		System.out.println("  ************************************");
		System.out.println("1 ********* List Food Trucks ********");
		System.out.println("2 **** See Average of all Trucks ****");
		System.out.println("3 **** See Highest Rated  Trucks ****");
		System.out.println("4 *************** Exit **************");
		System.out.println("  ***********************************");
		menuChoice();
	}
}
