package Dealership.Class;

import Dealership.Enum.VehicleType;

import java.util.Date;

// Note: Change the return methods to the Dealership.class

class Vehicle {
    private String plateNumber;
    private VehicleType type;
    private boolean isRented;
    private Date lastRentedDate;

    public Vehicle(String plateNumber, VehicleType type) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.isRented = false;
        this.lastRentedDate = null;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public boolean isRented() {
        return isRented;
    }

    public Date getLastRentedDate() {
        return lastRentedDate;
    }

    public void rentVehicle(Date rentDate) {
        if (!isRented) {
            this.isRented = true;
            this.lastRentedDate = rentDate;
        }
    }

    public double returnVehicle(Date returnDate) {
        if (isRented) {
            // Calculate the rental duration in days
            long rentalDuration = (returnDate.getTime() - lastRentedDate.getTime()) / (24 * 60 * 60 * 1000);

            // Calculate the rental price based on vehicle type
            double rentalPrice = 0.0;
            switch (type) {
                case SMALL:
                    rentalPrice = rentalDuration * 100.0;
                    break;
                case MEDIUM:
                    rentalPrice = rentalDuration * 150.0;
                    break;
                case SUV:
                    rentalPrice = rentalDuration * 200.0;
                    break;
            }

            this.isRented = false;
            this.lastRentedDate = null;
            return rentalPrice;
        }
        return 0.0; // Vehicle was not rented
    }
}