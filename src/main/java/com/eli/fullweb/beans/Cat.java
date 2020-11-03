package com.eli.fullweb.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cats")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Color color;
    private LocalDate date;

    public Cat(String name, Color color,LocalDate date) {
        setName(name);
        setColor(color);
        setDate(date);
    }
}
