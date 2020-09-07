package com.skilldistillery.foodproject;

public class FoodTruck {
	private static int id=1;
	private String name;
	private String food;
	private double rating;
	private double averageRating;
	private int truckId;
	
	public FoodTruck (String name, String food, double rating){
		this.name=name;
		this.food=food;
		this.rating=rating;
		truckId=id++;
	}
//	public FoodTruck (int id, String name, String food, double rating){
//		this(name, food, rating);
//		id=id++;

//	}
	
	public FoodTruck(){
	}
	
	public int getId() {
		return truckId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	

	@Override
	public String toString() {
		return "Truck Number = " + truckId + " Truck Name = " + name + ", Food Sold = " + food + ", Rating = " + rating;
	}

	public void displayTruck() {
		String truckData = this.toString();
		System.out.println(truckData);
	}
}


