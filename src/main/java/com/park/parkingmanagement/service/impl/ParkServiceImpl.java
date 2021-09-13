package com.park.parkingmanagement.service.impl;

import com.park.parkingmanagement.constant.InfoMessage;
import com.park.parkingmanagement.constant.SlotCount;
import com.park.parkingmanagement.constant.VehicleType;
import com.park.parkingmanagement.domain.garage.ParkingLot;
import com.park.parkingmanagement.domain.vehicle.Car;
import com.park.parkingmanagement.domain.vehicle.Jeep;
import com.park.parkingmanagement.domain.vehicle.Truck;
import com.park.parkingmanagement.domain.vehicle.Vehicle;
import com.park.parkingmanagement.exception.ExceptionCode;
import com.park.parkingmanagement.exception.ParkingException;
import com.park.parkingmanagement.service.ParkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkServiceImpl implements ParkService {

	@Autowired
	ParkingLot parkingLot;
	
    @Override
    public String park(Vehicle vehicle) throws ParkingException {
    	if(vehicle==null)
    		throw new ParkingException(ExceptionCode.VEHICLE_EMPTY.getMessage(), ExceptionCode.VEHICLE_EMPTY);
    	
    	if (vehicle.getVehicleType().equals(VehicleType.Car)) 
    		return parkingLot.parkVehicle(new Car(vehicle.vehiclePlate ,vehicle.vehicleColour));
    	else if (vehicle.getVehicleType().equals(VehicleType.Jeep))
    		return parkingLot.parkVehicle(new Jeep(vehicle.vehiclePlate ,vehicle.vehicleColour));
    	else if (vehicle.getVehicleType().equals(VehicleType.Truck))
    		return parkingLot.parkVehicle(new Truck(vehicle.vehiclePlate ,vehicle.vehicleColour));
    	else 
    		throw new ParkingException(ExceptionCode.UNDEFINED_VEHICLE_TYPE.getMessage(), ExceptionCode.UNDEFINED_VEHICLE_TYPE);
    }

    @Override
    public String leaveVehicle(Vehicle vehicle) throws ParkingException {
    	if(vehicle==null)
    		throw new ParkingException(ExceptionCode.VEHICLE_EMPTY.getMessage(), ExceptionCode.VEHICLE_EMPTY);
    	parkingLot.leaveVehicle(vehicle);
    	return InfoMessage.VEHICLE_IS_LEFT.toString();
    }

 
    @Override
    public String leave(int id) throws ParkingException {
    	if (id > SlotCount.SLOT_COUNT.getValue())
    		throw new ParkingException(ExceptionCode.VEHICLE_ID_CANNOT_BE_GRATER_TEN.getMessage(),ExceptionCode.VEHICLE_ID_CANNOT_BE_GRATER_TEN);
 
    	Vehicle vhcl = parkingLot.getParkingLotWithId(id);
    	if (vhcl == null)
    		throw new ParkingException(ExceptionCode.VEHICLE_CANNOT_BE_FOUND.getMessage(),ExceptionCode.VEHICLE_CANNOT_BE_FOUND);
    	parkingLot.leaveVehicle(vhcl);
    	return InfoMessage.VEHICLE_IS_LEFT.toString();
    }
    
    @Override
    public String status() throws ParkingException{   
    	return parkingLot.status();
    }

}