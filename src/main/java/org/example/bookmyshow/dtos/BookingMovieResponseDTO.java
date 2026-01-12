package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.bookmyshow.models.Booking;

@Getter
@Setter

public class BookingMovieResponseDTO {
    private Booking booking;
    private ResponseStatus responseStatus;
}
