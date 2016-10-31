package edu.aca.onlineshop.publicuser;

public class Address {

	private double latitude;
	private double longitude;
	
	public Address(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
	
	@Override
	public String toString(){
		return "Address{" +
				"latitude=" + latitude +
				", longitude=" + longitude +
				'}';
	}
}
