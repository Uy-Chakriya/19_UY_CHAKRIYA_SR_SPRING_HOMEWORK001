package org.chakriya._9_uy_chakriya_sr_spring_homework001.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    public Integer ticketId = 1;
    public String passengerName;
    public LocalDate travelDate;
    public String sourceStation;
    public String destinationStation;
    public Double price;
    public String paymentStatus;
    public String ticketStatus;
    public int seatNumber;

}
