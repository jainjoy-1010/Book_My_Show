package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Booking extends BaseModel{
    @ManyToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    private int amount;
    @OneToMany
    private List<Payment> payments;
}

/*
1       m
booking showseat   .. if cancelled same seat to new booking
m       m

1       1
booking user
m       1

1       m
booking payment     m bcoz of partial Payments
1       1


 */
