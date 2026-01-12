package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.BookingMovieRequestDTO;
import org.example.bookmyshow.dtos.BookingMovieResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.Booking;
import org.example.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class BookingController {

    private BookingService bookingService;

    BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

     public BookingMovieResponseDTO bookMovie(BookingMovieRequestDTO bookingMovieRequestDTO) {
         BookingMovieResponseDTO bookingMovieResponseDTO = new BookingMovieResponseDTO();

         try{
             Booking booking = bookingService.bookMovie(
                     bookingMovieRequestDTO.getUserId(),
                     bookingMovieRequestDTO.getShowId(),
                     bookingMovieRequestDTO.getShowSeatIds()
             );

             bookingMovieResponseDTO.setBooking(booking);
             bookingMovieResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
             return bookingMovieResponseDTO;
         }catch (Exception e){
             bookingMovieResponseDTO.setResponseStatus(ResponseStatus.FAILED);
             return bookingMovieResponseDTO;
         }

     }
}
