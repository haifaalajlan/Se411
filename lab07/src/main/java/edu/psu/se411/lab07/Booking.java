package edu.psu.se411.lab07;

import java.util.Date;

public abstract class Booking {

    private int bookingId;
    private String customerName;
    private Date travelDate;
    private String destinationCity;

    public Booking(int bookingId, String customerName,
                   Date travelDate, String destinationCity) {

        this.bookingId = bookingId;
        this.customerName = customerName;
        this.travelDate = travelDate;
        this.destinationCity = destinationCity;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public abstract double calculateTotalPrice()
            throws MissingInformationException, InvalidArgumentException;
}