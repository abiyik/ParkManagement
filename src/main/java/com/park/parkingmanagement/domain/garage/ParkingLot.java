package com.park.parkingmanagement.domain.garage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.park.parkingmanagement.constant.InfoMessage;
import com.park.parkingmanagement.constant.SlotCount;
import com.park.parkingmanagement.domain.vehicle.Vehicle;
import com.park.parkingmanagement.exception.ParkingException;

@Component
public class ParkingLot {

	private static final Logger logger = LoggerFactory.getLogger(ParkingLot.class);
    private final Garage garage;
    
    public ParkingLot() {
        garage = new Garage(SlotCount.SLOT_COUNT.getValue());
        logger.info("Created " + SlotCount.SLOT_COUNT.getValue() + " " + "spots");
    }

    public String parkVehicle(Vehicle vehicle) throws ParkingException{
        logger.info(" ------------------------------------ ");

        if (garage.parkVehicle(vehicle)) {
            logger.info("VEHICLE PARKED " + vehicle.getSpotsNeeded());
            return (InfoMessage.ALLOCATED_SLOTS.toString().replace("#SlotCount", Integer.toString(vehicle.getSpotsNeeded()))).replace("#Singularity", (vehicle.getSpotsNeeded()>1?"s":""));
        }
        logger.warn("PARKING FULL");
        return InfoMessage.GARAGE_IS_FULL.toString();
    }

    public void leaveVehicle(Vehicle vehicle) {
        garage.spotFreed(vehicle);
        logger.info("Spot freed and exited  " + vehicle.getVehiclePlate());
    }

    public String status() {
        return garage.status();
    }
    
    public Vehicle getParkingLotWithId(int id) {
        return garage.findSpotbyId(id);
    }
}
