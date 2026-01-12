package org.example.bookmyshow.services;

import org.example.bookmyshow.models.SeatType;
import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeat;
import org.example.bookmyshow.models.ShowSeatType;
import org.example.bookmyshow.repositories.ShowSeatRepository;
import org.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {

    ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculationService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> showSeats, Show show) {

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        int totalAmont = 0;

        for(ShowSeat showSeat : showSeats) {
            SeatType seatType = showSeat.getSeat().getSeatType();

            for(ShowSeatType showSeatType : showSeatTypes) {
                if(showSeatType.getSeatType().equals(seatType)) {
                    totalAmont += showSeatType.getPrice();
                    break;
                }
            }
        }
        return totalAmont;
    }
}
