public class Pricing {

        public static int totalIncome(int rows, int seats) {
            int capacity = rows * seats;

            if (capacity < 60) {
                return capacity * 10;
            } else {
                int incomeFirstHalf = (rows/2) * seats * 10;
                int incomeSecondHalf = (rows - rows/2)* seats * 8;
                return incomeFirstHalf + incomeSecondHalf;
            }
        }

    public static int seatPrice(int rows, int columns, int seatRow) {
        int capacity = rows * columns;

        if (capacity < 60) {
            return 10;
        } else {
            if (seatRow <= rows/2)
                return 10;
            else
                return 8;
        }
    }

}
