package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.time.LocalDateTime;

@Entity
public class BookingGeneric {
    @Id
    private long id;
    private List<Characteristic> characteristics;
    private List<BookingGeneric> associateBookings;

    public BookingGeneric() {
    }

    public void addCharacteristic(Characteristic characteristic){
        this.characteristics.add(characteristic);
    }
    
    public void removeCharacteristic(Characteristic characteristic){
        this.characteristics.remove(characteristic);
    }
    
    public void addAssociateBooking(BookingGeneric booking)
    {
        this.associateBookings.add(booking);
    }
    
    public Characteristic getCharacteristic(String name){
        for (Characteristic characteristic : this.characteristics)
        {
            if (characteristic.getName().equals(name))
                return characteristic;
        }
        return null;
    }

    public long getId() {
        return id;
    }
}
