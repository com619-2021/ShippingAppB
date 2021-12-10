package com.example.demo.orders;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table
public class Order {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private LocalDate date;
    private double width;
    private double height;
    private double draft;
    private String type;

    public Order(LocalDate date, double width, double height, double draft, String type) {
        this.date = date;
        this.width = width;
        this.height = height;
        this.draft = draft;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDraft() {
        return draft;
    }

    public String getType() {
        return type;
    }
}