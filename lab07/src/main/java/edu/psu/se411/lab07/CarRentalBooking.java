package edu.psu.se411.lab07;

import java.util.Date;

public class CarRentalBooking extends Booking {

    private double dailyRate;
    private Integer numberOfDays;

    public CarRentalBooking(int bookingId, String customerName,
                            Date travelDate, String destinationCity,
                            double dailyRate) {

        super(bookingId, customerName, travelDate, destinationCity);

        this.dailyRate = dailyRate;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public double calculateTotalPrice()
            throws MissingInformationException, InvalidArgumentException {

        if (numberOfDays == null) {
            throw new MissingInformationException(
                    "Number of rental days is missing");
        }

        if (numberOfDays < Config.MIN_RENTAL_DAYS ||
            numberOfDays > Config.MAX_RENTAL_DAYS) {

            throw new InvalidArgumentException(
                    "Invalid number of rental days");
        }

        return dailyRate * numberOfDays;
    }
}