package com.park.parkingmanagement;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.park.parkingmanagement.constant.InfoMessage;
import com.park.parkingmanagement.domain.vehicle.Car;
import com.park.parkingmanagement.domain.vehicle.Jeep;
import com.park.parkingmanagement.domain.vehicle.Truck;
import com.park.parkingmanagement.domain.vehicle.Vehicle;
import com.park.parkingmanagement.exception.ParkingException;
import com.park.parkingmanagement.service.ParkService;

@SpringBootTest
class ParkingManagementApplicationTests {

	@Autowired
	ParkService parkService;

	@Test
	public void integrationTest() throws ParkingException {

		Vehicle c1 = new Car("61-AB-765","White");
		Vehicle c2 = new Truck("61-AB-1765","Red");
		Vehicle c3 = new Car("61-AB-2765","White");
		Vehicle c4 = new Car("61-AB-3765","Black");
		Vehicle c5 = new Truck("61-AB-4765","White");
		Vehicle c6 = new Car("61-AB-7655","White");
		Vehicle c7 = new Car("61-AB-7645","Red");
		Vehicle c8 = new Car("61-AB-221","White");
		Vehicle c9 = new Jeep("61-AB-365","White");
		Vehicle c10 = new Car("61-AB-4865","White");
		parkService.park(c1);
		parkService.park(c2);
		parkService.park(c3);
		parkService.leaveVehicle(c2);
		parkService.park(c4);
		parkService.park(c5);
		parkService.park(c6);
		parkService.park(c7);
		parkService.park(c8);
		Assert.assertEquals(InfoMessage.GARAGE_IS_FULL.toString(), parkService.park(c9));
		Assert.assertEquals(InfoMessage.GARAGE_IS_FULL.toString(), parkService.park(c10));
		parkService.leaveVehicle(c3);
		parkService.park(c9);
		parkService.status();
	}

}
