/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.dto.BookingStates;
import java.time.LocalDateTime;
import java.util.Arrays;
import javax.persistence.Id;

/**
 *
 * @author bradley499
 */
public class Booking {
    @Id
    private long id;
    long companyId = -1;
    long shipId = -1;
    BookingStates bookingState = null;
    LocalDateTime depatureTime = null;
    LocalDateTime arrivalTime = null;
    boolean valid = false;
    public Booking() {
    }
    
    public Booking(BookingGeneric booking) {
        if (booking == null) {
            isValid(true);
            return;
        }
        this.companyId = booking.getCharacteristic("companyId").getValueLong();
        {
            int ordinal = (int)booking.getCharacteristic("bookingState").getValueLong();
            try {
                this.bookingState = Arrays.stream(BookingStates.values()).filter(e -> e.ordinal() == ordinal).findFirst().orElseThrow(() -> new RuntimeException("Invalid ordinal"));
            } catch (RuntimeException e) {
                this.bookingState = BookingStates.UNKNOWN;
            }
        }
        this.depatureTime = booking.getCharacteristic("depatureTime").getValueDateTime();
        this.arrivalTime = booking.getCharacteristic("arrivalTime").getValueDateTime();
        isValid(true);
    }
    
    public void setArrivalTime(LocalDateTime arrival) {
        this.arrivalTime = arrival;
        if (this.depatureTime != null) {
            isValid(true);
        }
    }
    
    public LocalDateTime getArrivalTime() {
        return this.arrivalTime;
    }
    
    public void setDepatureTime(LocalDateTime depature) {
        this.depatureTime = depature;
        if (this.arrivalTime != null) {
            isValid(true);
        }
    }
    
    public LocalDateTime getDepatureTime() {
        return this.depatureTime;
    }
    
    public void setBookingState(BookingStates state) {
        this.bookingState = state;
    }
    
    public BookingStates getBookingState() {
        return this.bookingState;
    }
    
    public void setShip(long newShipId) {
        this.shipId = newShipId;
    }
    
    public long getShip() {
        return this.shipId;
    }
    
    boolean isValid() { // non-throwing
        return isValid(false);
    }
    
    boolean isValid(boolean throwable) {
        if (companyId == -1 || bookingState == null || depatureTime == null || arrivalTime == null) {
            this.valid = false;
            if (throwable) {
                throw new RuntimeException("Incomplete Booking object");
            }
        } else if (!this.arrivalTime.isBefore(this.depatureTime)) {
            this.valid = false;
            if (throwable) {
                throw new RuntimeException("Arrival time is later than depature time");
            }
        } else {
            this.valid = true;
        }
        return this.valid;
    }
}
