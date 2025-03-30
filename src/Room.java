public class Room {
    boolean[][] seats;

    public Room(int rows, int columns) {
        seats = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = false;
            }
        }
    }

    public void print() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < seats[0].length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        int rowCount = 1;
        for (boolean[] row: seats) {
            System.out.print(rowCount++ + " ");
            for (boolean seat: row)
                System.out.print((seat ? 'B' : 'S') + " ");
            System.out.println();
        }
    }

    public int getRows() {
        return seats.length;
    }

    public int getSeatsInRow() {
        return seats[0].length;
    }

    public int getCapacity() {
        return seats.length * seats[0].length;
    }

    public void bookSeat(int row, int column) {
        if (row <= 0 || row > seats.length || column <= 0 || column > seats[0].length)
            throw new SeatNotFoundException("Couldn't find the seat!");
        else if (!seats[row][column])
            seats[row][column] = true;
        else
            throw new SeatAlreadyTakenException("This Seat is already booked!");
    }

    public void cancelSeat(int row, int column) {
        if (row <= 0 || row > seats.length || column <= 0 || column > seats[0].length)
            throw new SeatNotFoundException("Couldn't find the seat!");
        else if (seats[row][column])
            seats[row][column] = false;
        else
            throw new SeatAlreadyTakenException("Seat is not booked!");
    }

    public static void main(String[] args) {
        Room cinema1 = new Room(7, 8);
        cinema1.print();
    }
}
