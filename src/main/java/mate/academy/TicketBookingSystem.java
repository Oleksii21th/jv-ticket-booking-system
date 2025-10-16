package mate.academy;

import java.util.concurrent.Semaphore;

public class TicketBookingSystem {

    private final Semaphore seats;

    public TicketBookingSystem(int totalSeats) {
        this.seats = new Semaphore(totalSeats, true);
    }

    public BookingResult attemptBooking(String user) {
        if (seats.tryAcquire()) {
            try {
                return new BookingResult(user, true, "Booking succeed");
            } finally {

            }
        } else {
            return new BookingResult(user, false, "No available seats");
        }
    }
}
