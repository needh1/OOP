public class SeatLayout extends Cinema
{
    private int emptySeats;
    private Seat[][] seats;

    public SeatLayout(String code, CinemaType cinemaType, int row, int column){
        super(code, cinemaType, row, column);
        emptySeats = row * column;
        seats = new Seat[row][column];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                seats[i][j] =  new Seat((i*10)+j);
            }
        }
    }

    public int totalSeats(){
        return getRow() * getColumn();
    }

    public int getEmptySeats(){
        return emptySeats;
    }

    public void assignSeat(int seatNum){
        if(!seats[seatNum/10][seatNum%10].occupied()){
            seats[seatNum/10][seatNum%10].assign();
            emptySeats--;
        }
        else{System.out.println("Seat is already occupied");}
    }

    public void unassignSeat(int seatNum){
        if(seats[seatNum/10][seatNum%10].occupied()){
            seats[seatNum/10][seatNum%10].unassign();
            emptySeats++;
        }
        else{System.out.println("Seat is already unoccupied.");}
        
    }

    public void printLayout(){
        System.out.println("Seat Layout ([X] - Occupied, [O] - Available):");
        for(int i = 0; i < getRow(); i++){
            System.out.print("|");
            for(int j = 0; j < getColumn(); j++){
                if(seats[i][j].occupied()){System.out.print(seats[i][j].getSeatID() + "[X]|");}
                else{System.out.print(seats[i][j].getSeatID() + "[O]|");}
            }
            System.out.print("\n");
        }
        System.out.println();
    }
}