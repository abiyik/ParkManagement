package com.park.parkingmanagement.constant;

public enum InfoMessage {
	GARAGE_IS_FULL
	{
		@Override
        public String toString() {
            return "Garage is full.";
        }
    },
	ALLOCATED_SLOTS
	{
		@Override
        public String toString() {
            return "Allocated #SlotCount slot#Singularity.";
        }
    },VEHICLE_IS_LEFT
	{
		@Override
        public String toString() {
            return "Vehicle left.";
        }
    }
}
