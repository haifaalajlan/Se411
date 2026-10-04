package edu.psu.se411.lab07;

import java.util.Date;

public class FlightBooking extends Booking {

    private double basePrice;
    private double includedLuggageWeight;
    private Double luggageWeight;

    public FlightBooking(int bookingId, String customerName,
                         Date travelDate, String destinationCity,
                         double basePrice,
                         double includedLuggageWeight) {

        super(bookingId, customerName, travelDate, destinationCity);

        this.basePrice = basePrice;
        this.includedLuggageWeight = includedLuggageWeight;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    @Override
    public double calculateTotalPrice()
            throws MissingInformationException, InvalidArgumentException {

        if (luggageWeight == null) {
            throw new MissingInformationException(
                    "Luggage weight is missing");
        }

        if (luggageWeight < 0 ||
            luggageWeight > Config.MAX_LUGGAGE_WEIGHT) {

            throw new InvalidArgumentException(
                    "Invalid luggage weight");
        }

        double extraWeight = Math.max(
                0,
                luggageWeight - includedLuggageWeight
        );

        double price =
                basePrice +
                (extraWeight * Config.EXTRA_LUGGAGE_RATE);

        return price * (1 + Config.TAX_RATE);
    }
}