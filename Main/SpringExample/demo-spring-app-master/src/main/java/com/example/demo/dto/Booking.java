package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Booking {
    private BookingGeneric generic;
    public Booking(long companyId) {
        this.generic = new BookingGeneric();
        this.generic.addCharacteristic(new Characteristic("companyId", companyId));
        this.generic.addCharacteristic(new Characteristic("bookingState", BookingStates.UNKNOWN.ordinal()));
    }
    
    public boolean setArrival(LocalDateTime arrival) {
        Characteristic arrivalTime = this.generic.getCharacteristic("arrivalTime");
        if (arrivalTime != null) {
            this.generic.removeCharacteristic(arrivalTime);
        }
        this.generic.addCharacteristic(new Characteristic("arrivalTime", arrival));
        return isTimingsValid();
    }
    
    public boolean setDepature(LocalDateTime depature) {
        Characteristic depatureTime = this.generic.getCharacteristic("depatureTime");
        if (depatureTime != null) {
            this.generic.removeCharacteristic(depatureTime);
        }
        this.generic.addCharacteristic(new Characteristic("depatureTime", depature));
        return isTimingsValid();
    }

    public void setBookingState(BookingStates updateBookingState) {
        this.generic.removeCharacteristic(this.generic.getCharacteristic("bookingState"));
        this.generic.addCharacteristic(new Characteristic("bookingState", updateBookingState.ordinal()));
    }
    
    private boolean isTimingsValid() {
        return true; // need to implement checks to see if arrival time is before departure time
    }
    
    public BookingStates getBookingState() {
        int ordinal = (int)this.generic.getCharacteristic("bookingState").getValueLong();
        try {
            return Arrays.stream(BookingStates.values()).filter(e -> e.ordinal() == ordinal).findFirst().orElseThrow(() -> new RuntimeException("Invalid ordinal"));
        } catch (RuntimeException e) {
            return BookingStates.UNKNOWN;
        }
    }
    
    public BookingGeneric commitBooking() {
        if (isTimingsValid()) {
            return generic;
        } else {
            return null;
        }
    }
}
