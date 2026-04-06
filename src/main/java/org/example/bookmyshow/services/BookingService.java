package org.example.bookmyshow.services;

import org.example.bookmyshow.exceptions.SeatNotAvailableException;
import org.example.bookmyshow.exceptions.ShowNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFounfException;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repositories.ShowRepository;
import org.example.bookmyshow.repositories.ShowSeatRepository;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    UserRepository userRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;
    PriceCalculationService priceCalculationService;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculationService priceCalculationService) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculationService = priceCalculationService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)  // this is the lock approach 1 in notebook
    public Booking bookMovie(long userId, long showId, List<Long> showSeatIds) throws UserNotFounfException, ShowNotFoundException, SeatNotAvailableException {

        Optional<User> optionalUser = userRepository.findById(userId);   // check user
        if(optionalUser.isEmpty()){
            throw new UserNotFounfException("User "+userId+ " not found");
        }
        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showId);     // check show
        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException("Show "+showId+ " not found");
        }
        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);    // check showSeat

        if(showSeats.size()==0){                                                   // if list empty
            throw new RuntimeException("No seat selected for this show please select a seat");
        }
        for(ShowSeat showSeat : showSeats){                                         // check if available
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException("Some seats are not available");
            }
        }

        for(ShowSeat showSeat : showSeats){                                       //change seat stats to blocked
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculationService.calculatePrice(showSeats,show));

        //move to payment page
        // if payment success seat confirm
        // if payment fails make seats available from blocked

        return booking;
    }
}