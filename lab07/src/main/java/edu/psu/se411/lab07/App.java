package edu.psu.se411.lab07;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    // Logger
    static Logger logger = LoggerFactory.getLogger(App.class);


    // Polymorphism method
    public static double computeTotalPrice(Booking booking)
            throws MissingInformationException, InvalidArgumentException {

        return booking.calculateTotalPrice();
    }


    public static void main(String[] args) {

        // Log application start
        logger.info("Application is starting...");

        try {

            // ---------------- FLIGHT ----------------

            FlightBooking flight =
                    new FlightBooking(
                            1001,
                            "John Doe",
                            new Date(),
                            "New York",
                            200,
                            20
                    );

            flight.setLuggageWeight(30);

            System.out.println(
                    "Flight price: " +
                    computeTotalPrice(flight)
            );


            // ---------------- CAR RENTAL ----------------

            CarRentalBooking car =
                    new CarRentalBooking(
                            1002,
                            "Jane Smith",
                            new Date(),
                            "Los Angeles",
                            50
                    );

            car.setNumberOfDays(10);

            System.out.println(
                    "Car Rental price: " +
                    computeTotalPrice(car)
            );


            // ---------------- TRAIN ----------------

            TrainBooking train =
                    new TrainBooking(
                            1003,
                            "Alice Johnson",
                            new Date(),
                            "Chicago",
                            SeatClass.STANDARD
                    );

            train.setDistance(100);

            System.out.println(
                    "Train price: " +
                    computeTotalPrice(train)
            );


        } catch (MissingInformationException |
                 InvalidArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

            // Log exception
            logger.error("Exception occurred", e);
        }


        // Log application stop
        logger.info("Application is stopping...");
    }
}