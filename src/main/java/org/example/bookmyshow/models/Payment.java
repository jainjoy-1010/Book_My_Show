package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseModel {
    private int amount;

    private String referenceNo;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode PaymentMode;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus PaymentStatus;

}
