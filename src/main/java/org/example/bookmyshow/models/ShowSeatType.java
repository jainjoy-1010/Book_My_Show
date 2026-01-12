package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;
    private int price;

}
/*
1               1
showseattype   show
   m            1
 */
