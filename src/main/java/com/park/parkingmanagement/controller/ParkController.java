package com.park.parkingmanagement.controller;

import com.park.parkingmanagement.domain.vehicle.Vehicle;
import com.park.parkingmanagement.exception.ParkingException;
import com.park.parkingmanagement.service.ParkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkingManagement")
public class ParkController {

	@Autowired
	ParkService parkService;

    @RequestMapping(value = "/park", method = RequestMethod.POST)
    public String park(@RequestBody Vehicle vehicle) throws ParkingException {
    	return parkService.park(vehicle);
    }

    @RequestMapping(value = "/leaveVehicle" ,method = RequestMethod.DELETE)
    public String leaveVehicle(@RequestBody Vehicle vehicle) throws ParkingException {
    	return parkService.leaveVehicle(vehicle);
    }
  
	@RequestMapping(value = "/leave" ,method = RequestMethod.DELETE)
    public String leave(@RequestBody int leaveCarId) throws ParkingException {
		return parkService.leave(leaveCarId);
    }
    
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String status() throws ParkingException {
    	return parkService.status();
    }
}
