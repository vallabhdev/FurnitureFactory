package plot.venue;

import org.joda.time.DateTime;
import plot.enums.ParkingTicketStatus;

public class ParkingTicket {
    private String ticketNumber;
    private DateTime issuedAt;
    private DateTime payedAt;
    private double payedAmount;
    private ParkingTicketStatus status;
}
