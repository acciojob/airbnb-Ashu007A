package com.driver.repositories;

import com.driver.model.Hotel;

import java.util.HashMap;
import java.util.Map;

public class HotelRepository {

    // In-memory database for hotels
    private final Map<String, Hotel> hotelDb = new HashMap<>();

    // Add a hotel to the database
    public boolean addHotel(Hotel hotel) {
        if (hotel == null || hotel.getHotelName() == null) {
            return false;
        }

        if (hotelDb.containsKey(hotel.getHotelName())) {
            return false;
        }

        hotelDb.put(hotel.getHotelName(), hotel);
        return true;
    }

    // Get a hotel by name
    public Hotel getHotelByName(String hotelName) {
        return hotelDb.get(hotelName);
    }

    // Update a hotel in the database
    public void updateHotel(Hotel hotel) {
        if (hotelDb.containsKey(hotel.getHotelName())) {
            hotelDb.put(hotel.getHotelName(), hotel);
        }
    }
}