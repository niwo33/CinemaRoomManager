import java.math.BigDecimal;

public class TicketManager {
    private final Room cinema;
    private static int soldTickets = 0;
    private static int currentIncome = 0;

    public TicketManager(Room cinema) {
        this.cinema = cinema;
    }

    private static String roundAndFormat(final double value, final int frac) {
        final java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setMaximumFractionDigits(frac);
        return nf.format(new BigDecimal(value));
    }

    public void buyTicket(int row, int seat) {
        try{
            cinema.bookSeat(row, seat);
        }
        catch (SeatNotFoundException | SeatAlreadyTakenException e){
            System.out.println(e.getMessage());
            Main.seatBooker();
            return;
        }
        soldTickets++;
        int seatPrice = Pricing.seatPrice(cinema.getRows(), cinema.getSeatsInRow(), row);
        System.out.println("Ticket price: $" + seatPrice);
        currentIncome += seatPrice;
    }

    public void cancelTicket(int row, int seat) {
        try{
            cinema.cancelSeat(row, seat);
        }
        catch (SeatNotFoundException | SeatAlreadyTakenException e){
            System.out.println(e.getMessage());
            Main.seatCancler();
            return;
        }
        soldTickets--;
        int seatPrice = Pricing.seatPrice(cinema.getRows(), cinema.getSeatsInRow(), row);
        System.out.println("Price refund: $" + seatPrice);
        currentIncome -= seatPrice;
    }

    public void showStatistic() {
        double occupiedSeats = soldTickets / (double) cinema.getCapacity() * 100;
        int totalIncome = Pricing.totalIncome(cinema.getRows(), cinema.getSeatsInRow());
        System.out.println("Sold tickets: " + soldTickets);
        System.out.printf("Occupied seats: %s%% \n", roundAndFormat(occupiedSeats, 2));
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}
