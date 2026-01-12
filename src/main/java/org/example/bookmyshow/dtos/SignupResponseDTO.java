package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.bookmyshow.models.User;

@Getter
@Setter
public class SignupResponseDTO {
    private User user ;
    private ResponseStatus responseStatus ;

}
