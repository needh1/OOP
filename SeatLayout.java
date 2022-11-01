public class SeatLayout
{
    private int row;
    private int column;
    private int emptySeats;
    private Seat[][] seats;

    public SeatLayout(){
        row = 10;
        column = 10;
        emptySeats = 10 * 10;
        seats = new Seat[10][10];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                seats[i][j] =  new Seat((i*10)+j);
            }
        }
    }

    public SeatLayout(int row, int column){
        this.row = row;
        this.column = column;
        emptySeats = row * column;
        seats = new Seat[row][column];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                seats[i][j] =  new Seat((i*10)+j);
            }
        }
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
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
        else{System.out.println("Seat is already unoccupied");}
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
        for(int i = 0; i < row; i++){
            System.out.print("|");
            for(int j = 0; j < column; j++){
                if(seats[i][j].occupied()){System.out.print(seats[i][j].getSeatID() + "[X]|");}
                else{System.out.print(seats[i][j].getSeatID() + "[O]|");}
            }
            System.out.print("\n");
        }
        System.out.println();
    }
}
