import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static TicketManager tm;

    private static Pair<Integer, Integer> getRoomSize() {
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();

        return new Pair<>(rows, seats);
    }

    private static Pair<Integer, Integer> chooseSeat() {
        System.out.println("Enter a row number:");
        int row = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = sc.nextInt();

        return new Pair<>(row, seat);
    }

    public static void seatBooker() {
        Pair<Integer, Integer> seat = chooseSeat();
        tm.buyTicket(seat.first-1, seat.second-1);
    }

    public static void seatCancler() {
        Pair<Integer, Integer> seat = chooseSeat();
        tm.cancelTicket(seat.first-1, seat.second-1);
    }

    public static void showMenu() {
        System.out.println("Menu:");
        System.out.println("\t1. Show cinema");
        System.out.println("\t2. Book seat");
        System.out.println("\t3. Cancel seat");
        System.out.println("\t4. Show statistic");
        System.out.println("\t0. Exit");
        System.out.println("Please choose an option:");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Cinema Room Manager!");

        Pair<Integer, Integer> roomDimensions = getRoomSize();
        int rows = roomDimensions.first;
        int columns = roomDimensions.second;
        Room cinema = new Room(rows, columns);
        cinema.print();
        tm = new TicketManager(cinema);
        while(true) {
            showMenu();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    cinema.print();
                    showMenu();
                    break;
                case 2:
                    seatBooker();
                    break;
                case 3:
                    seatCancler();
                    break;
                case 4:
                    tm.showStatistic();
                    break;
                case 0:
                    System.out.println("Exiting the Manager...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option!");
                    showMenu();
                    break;
            }
        }
    }
}