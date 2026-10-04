package edu.psu.se411.lab07;

import java.util.Date;

public class TrainBooking extends Booking {

    private SeatClass seatClass;
    private Double distance;

    public TrainBooking(int bookingId, String customerName,
                        Date travelDate, String destinationCity,
                        SeatClass seatClass) {

        super(bookingId, customerName, travelDate, destinationCity);

        this.seatClass = seatClass;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public double calculateTotalPrice()
            throws MissingInformationException, InvalidArgumentException {

        if (distance == null) {
            throw new MissingInformationException(
                    "Distance is missing");
        }

        if (distance < 1 ||
            distance > Config.MAX_TRAIN_DISTANCE) {

            throw new InvalidArgumentException(
                    "Invalid train distance");
        }

        if (seatClass == SeatClass.STANDARD) {
            return distance * Config.TRAIN_STANDARD_RATE;
        } else {
            return distance * Config.TRAIN_FIRST_CLASS_RATE;
        }
    }
}