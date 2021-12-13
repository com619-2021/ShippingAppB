package com.example.demo.orders;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
//@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(
//            name = "user_sequence",
//            sequenceName = "user_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "user_sequence"
//    )
    private Long id;
    private LocalDate date;
    private Double width;
    private Double  height;
    private Double  draft;
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

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDraft() {
        return draft;
    }

    public void setDraft(Double draft) {
        this.draft = draft;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", date=" + date + ", width=" + width + ", height=" + height + ", draft=" + draft + ", type=" + type + '}';
    }

}
