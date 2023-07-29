package com.driver.services;

import com.driver.model.Booking;
import com.driver.model.Hotel;

import java.util.HashMap;
import java.util.UUID;

public class BookingService {

    // In-memory database for bookings
    private final HashMap<String, Booking> bookingDb = new HashMap<>();

    // Book a room
    public int bookARoom(Booking booking, Hotel hotel) {
        if (hotel == null || booking == null) {
            return -1;
        }

        int availableRooms = hotel.getAvailableRooms();
        int bookedRooms = booking.getNoOfRooms();

        if (availableRooms < bookedRooms) {
            return -1;
        }

        String bookingId = UUID.randomUUID().toString();
        booking.setBookingId(bookingId);

        int amountToBePaid = bookedRooms * hotel.getPricePerNight();
        booking.setAmountToBePaid(amountToBePaid);

        hotel.setAvailableRooms(availableRooms - bookedRooms);

        // Save booking in the database
        bookingDb.put(bookingId, booking);

        return amountToBePaid;
    }

    // Get bookings done by a person
    public int getBookingsByPerson(int aadharCardNo) {
        int count = 0;
        for (Booking booking : bookingDb.values()) {
            if (booking.getBookingAadharCard() == aadharCardNo) {
                count++;
            }
        }
        return count;
    }
}