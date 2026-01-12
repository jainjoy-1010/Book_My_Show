package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{
    private String number;
    @ManyToOne
    private SeatType SeatType;
    private int rowVal;
    private int colVal;

}
/*
1     1
seat  seattype
m        1
 */
