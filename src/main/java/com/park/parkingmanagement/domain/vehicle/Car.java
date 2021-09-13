package com.park.parkingmanagement.domain.vehicle;

import com.park.parkingmanagement.constant.VehicleType;
import com.park.parkingmanagement.constant.VehicleWidth;

public class Car extends Vehicle{
    public Car(String vehiclePlate, String vehicleColour){
        spotsNeeded = VehicleWidth.CAR.getValue();
        this.vehiclePlate = vehiclePlate;
        this.vehicleColour = vehicleColour;
        vehicleType = VehicleType.Car;
    }
}
