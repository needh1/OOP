public class SeatLayout extends Cinema
{
    private int emptySeats;
    private Seat[][] seats;

    public SeatLayout(String code, CinemaType cinemaType, int row, int column){
        super(code, cinemaType, row, column);
        emptySeats = row * column;
        seats = new Seat[row][column];
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= column; j++){
                String id = Integer.toString(i*10+j);
                Seat s = new Seat(id);
                seats[i][j] = s;
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
            seats[seatNum/10][seatNum%10].assignSeat();
            emptySeats--;
        }
        else{System.out.println("Seat is already occupied");}
    }

    public void unassignSeat(int seatNum){
        if(seats[seatNum/10][seatNum%10].occupied()){
            seats[seatNum/10][seatNum%10].unassignSeat();
            emptySeats++;
        }
        else{System.out.println("Seat is already unoccupied.");}
        
    }

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