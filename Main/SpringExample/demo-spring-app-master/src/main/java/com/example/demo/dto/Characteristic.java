package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Characteristic {
    @Id
    private String name;
    private long valueLong;
    private double valueDouble;
    private String valueString;
    private LocalDateTime valueDateTime;
    private CharacteristicType type = CharacteristicType.LONG;

    public Characteristic(String setName, long value) {
        this.name = setName;
        this.setValueLong(value);
    }

    public Characteristic(String setName, double value) {
        this.name = setName;
        this.setValueDouble(value);
    }

    public Characteristic(String setName, String value) {
        this.name = setName;
        this.setValueString(value);
    }

    public Characteristic(String setName, LocalDateTime value) {
        this.name = setName;
        this.setValueDateTime(value);
    }
    
    public void setValueLong(long setValue){
        this.type = CharacteristicType.LONG;
        this.valueLong = setValue;
    }

    public void setValue(long setValue) {
        setValueLong(setValue);
    }
    
    public void setValueDouble(double setValue){
        this.type = CharacteristicType.DOUBLE;
        this.valueDouble = setValue;
    }
    
    public void setValue(double setValue) {
        setValueDouble(setValue);
    }
    
    public void setValueString(String setValue) {
        this.type = CharacteristicType.STRING;
        this.valueString = setValue;
    }

    public void setValue(String setValue) {
        setValueString(setValue);
    }
    
    public void setValueDateTime(LocalDateTime setValue) {
        this.type = CharacteristicType.DATETIME;
        this.valueDateTime = setValue;
    }
    
    public void setValue(LocalDateTime setValue) {
        setValueDateTime(setValue);
    }
    
    public String getName() {
        return this.name;
    }
    
    public CharacteristicType getType() {
        return this.type;
    }
    
    public long getValueLong() {
        return this.valueLong;
    }
    
    public double getValueDouble() {
        return this.valueDouble;
    }
    
    public String getValueString() {
        return this.valueString;
    }
    
    public LocalDateTime getValueDateTime() {
        return this.valueDateTime;
    }
}
