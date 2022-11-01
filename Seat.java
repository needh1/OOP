public class Seat implements Serializable
{
    private String seatID;
    private boolean assigned;

    public Seat(String id){
        seatID = id;
        assigned = false;
    }

    public Seat(String id, boolean assigned){
        seatID = id;
        this.assigned = assigned;
    }

    public String getSeatID(){
        return seatID;
    }

    public void setSeatID(String id){
        seatID = id;
    }

    public boolean occupied(){
        return assigned;
    }

    public void assignSeat(){
        assigned = true;
    }

    public void unassignSeat(){
        assigned = false;
    }
}