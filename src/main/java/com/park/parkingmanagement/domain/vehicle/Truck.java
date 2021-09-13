package com.park.parkingmanagement.domain.vehicle;

import com.park.parkingmanagement.constant.VehicleType;
import com.park.parkingmanagement.constant.VehicleWidth;

public class Truck extends Vehicle {

    public Truck(String vehiclePlate, String vehicleColour) {
        spotsNeeded = VehicleWidth.TRUCK.getValue();
        this.vehiclePlate = vehiclePlate;
        this.vehicleColour = vehicleColour;
        vehicleType = VehicleType.Truck;
    }
}