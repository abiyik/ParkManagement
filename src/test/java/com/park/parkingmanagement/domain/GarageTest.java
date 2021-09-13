package com.park.parkingmanagement.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.park.parkingmanagement.constant.VehicleType;
import com.park.parkingmanagement.domain.garage.Garage;
import com.park.parkingmanagement.domain.vehicle.Car;
import com.park.parkingmanagement.domain.vehicle.Jeep;
import com.park.parkingmanagement.domain.vehicle.Truck;
import com.park.parkingmanagement.domain.vehicle.Vehicle;
import com.park.parkingmanagement.exception.ParkingException;

public class GarageTest {


	@Test
	public void validTest() throws ParkingException {
		
		Garage g = new Garage(10);
		
		Vehicle v = new Car("34-SO-1988", "White");
		g.parkVehicle(v); // one spot used
				
		Vehicle v2 = new Jeep("34-SO-1984", "Red");
		g.parkVehicle(v2); // two spot used
		
		Vehicle v3 = new Truck("34-SO-1990", "Red");
		g.parkVehicle(v3);// four spot used
		
		// remaining available spots must 3
		Assert.assertEquals(3, g.availableSpots());
		
		Assert.assertEquals(v, g.findSpotbyId(0));
		Assert.assertEquals(v2, g.findSpotbyId(1));
		Assert.assertEquals(v3, g.findSpotbyId(3));
		
		Assert.assertEquals(null, g.findSpotbyId(7));
		Assert.assertEquals(null, g.findSpotbyId(8));
		Assert.assertEquals(null, g.findSpotbyId(9));
		
		Assert.assertEquals(VehicleType.Car, g.findSpotbyId(0).getVehicleType());

		Assert.assertEquals(VehicleType.Jeep, g.findSpotbyId(1).getVehicleType());
		
		Assert.assertEquals(VehicleType.Truck, g.findSpotbyId(3).getVehicleType());
	}
}
