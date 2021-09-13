package com.park.parkingmanagement.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.park.parkingmanagement.domain.vehicle.Car;
import com.park.parkingmanagement.domain.vehicle.Jeep;
import com.park.parkingmanagement.domain.vehicle.Truck;

public class VehicleTest {

	@Test
	public void validTest() {
		Car c = new Car("34-SO-1988", "White");
		Assert.assertEquals("White", c.getVehicleColour());
		Assert.assertEquals("34-SO-1988", c.getVehiclePlate());
		
		Jeep j = new Jeep("34-SO-1999", "Red");
		Assert.assertEquals("Red", j.getVehicleColour());
		Assert.assertEquals("34-SO-1999", j.getVehiclePlate());
		
		Truck t = new Truck("34-SO-2000", "Black");
		Assert.assertEquals("Black", t.getVehicleColour());
		Assert.assertEquals("34-SO-2000", t.getVehiclePlate());
	
	}
}
