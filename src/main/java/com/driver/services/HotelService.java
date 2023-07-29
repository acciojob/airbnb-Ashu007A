package com.driver.services;

import com.driver.model.Facility;
import com.driver.model.Hotel;

import java.util.HashMap;
import java.util.List;

public class HotelService {

    // In-memory database for hotels
    private final HashMap<String, Hotel> hotelDb = new HashMap<>();

    // Add a hotel to the database
    public String addHotel(Hotel hotel) {
        if (hotel == null || hotel.getHotelName() == null) {
            return "FAILURE";
        }

        if (hotelDb.containsKey(hotel.getHotelName())) {
            return "FAILURE";
        }

        hotelDb.put(hotel.getHotelName(), hotel);
        return "SUCCESS";
    }

    // Get the hotel with the most facilities
    public String getHotelWithMostFacilities() {
        if (hotelDb.isEmpty()) {
            return "";
        }

        String hotelNameWithMostFacilities = "";
        int maxFacilities = -1;

        for (Hotel hotel : hotelDb.values()) {
            int numFacilities = hotel.getFacilities().size();
            if (numFacilities > maxFacilities || (numFacilities == maxFacilities && hotelNameWithMostFacilities.compareTo(hotel.getHotelName()) > 0)) {
                hotelNameWithMostFacilities = hotel.getHotelName();
                maxFacilities = numFacilities;
            }
        }

        return hotelNameWithMostFacilities;
    }

    // Update facilities for a hotel
    public Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {
        if (!hotelDb.containsKey(hotelName)) {
            return null;
        }

        Hotel hotel = hotelDb.get(hotelName);
        List<Facility> existingFacilities = hotel.getFacilities();

        for (Facility facility : newFacilities) {
            if (!existingFacilities.contains(facility)) {
                existingFacilities.add(facility);
            }
        }

        hotel.setFacilities(existingFacilities);
        return hotel;
    }

    public Hotel getHotelByName(String hotelName) {
        return hotelDb.get(hotelName);
    }
}