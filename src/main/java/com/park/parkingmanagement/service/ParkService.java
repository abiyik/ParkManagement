package com.park.parkingmanagement.service;

import com.park.parkingmanagement.domain.vehicle.Vehicle;
import com.park.parkingmanagement.exception.ParkingException;

public interface ParkService {

    /* ---- Parking Actions ----- */

    public String park(Vehicle vehicle) throws ParkingException;
    
    public String leaveVehicle(Vehicle vehicle) throws ParkingException;

    public String status() throws ParkingException;

	public String leave(int id) throws ParkingException;
}
