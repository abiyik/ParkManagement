package com.park.parkingmanagement.domain.vehicle;

import com.park.parkingmanagement.constant.VehicleType;
import com.park.parkingmanagement.constant.VehicleWidth;

public class Jeep extends Vehicle{
    public Jeep(String vehiclePlate, String vehicleColour){
        spotsNeeded = VehicleWidth.JEEP.getValue();
        this.vehiclePlate = vehiclePlate;
        this.vehicleColour = vehicleColour;
        vehicleType = VehicleType.Jeep;
    }
}
