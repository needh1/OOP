/**
 * Represents seating layout of cinema.
 * Contains seat objects to facilitate booking.
 */
public class SeatLayout extends Cinema
{
    /**
     * Number of empty seats.
     */
    private int emptySeats;
    /**
     * Array of seat objects to represent layout of cinema. 
     */
    private Seat[][] seats;
    /**
     * Constructor of array of Seat objects.
     * @param code Cinema code.
     * @param cinemaType Cinema type.
     * @param row Number of rows of seats.
     * @param column Number of columns of seats.
     */
    public SeatLayout(String code, CinemaType cinemaType, int row, int column){
        super(code, cinemaType, row, column);
        emptySeats = row * column;
        seats = new Seat[row + 1][column + 1];
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= column; j++){
                String id = Integer.toString(i*10+j);
                Seat s = new Seat(id);
                seats[i][j] = s;
            }
        }
    }
    /**
     * Retrieves total number of seats.
     * @return Total number of seats.
     */
    public int totalSeats(){
        return getRow() * getColumn();
    }
    /**
     * Retrieves number of empty seats
     * @return Number of empty seats.
     */
    public int getEmptySeats(){
        return emptySeats;
    }
    /**
     * Retrieves seat object.
     * @param seatNum Seat number.
     * @return Seat object.
     */
    public Seat getSeat(int seatNum){
        return seats[seatNum/10][seatNum%10];
    }
    /**
     * Sets occupancy of seat to assigned.
     * @param seatNum Seat number.
     */
    public void assignSeat(int seatNum){
        if(!seats[seatNum/10][seatNum%10].occupied()){
            seats[seatNum/10][seatNum%10].assignSeat();
            emptySeats--;
        }
        else{System.out.println("Seat is already occupied");}
    }
    /**
     * Sets occupancy of seat to unassigned.
     * @param seatNum Seat number.
     */
    public void unassignSeat(int seatNum){
        if(seats[seatNum/10][seatNum%10].occupied()){
            seats[seatNum/10][seatNum%10].unassignSeat();
            emptySeats++;
        }
        else{System.out.println("Seat is already unoccupied.");}
        
    }
    /**
     * Displays layout of seats.
     */
    public void printLayout(){
        System.out.println("Seat Layout ([X] - Occupied, [O] - Available):");
        for(int i = 1; i <= getRow(); i++){
            System.out.print("|");
            for(int j = 1; j <= getColumn(); j++){
                if(seats[i][j].occupied()){System.out.print(seats[i][j].getSeatID() + "[X]|");}
                else{System.out.print(seats[i][j].getSeatID() + "[O]|");}
            }
            System.out.print("\n");
        }
        System.out.println();
    }
}