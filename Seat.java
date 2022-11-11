import java.io.Serializable;
/**
 * Represents a seat object.
 * Can be assigned during booking to track occupancy.
 */
public class Seat implements Serializable
{
    /**
     * ID of seat.
     */
    private String seatID;
    /**
     * Status of assignment.
     */
    private boolean assigned;
    /**
     * Constructor for Seat object.
     * @param id Seat ID.
     */
    public Seat(String id){
        seatID = id;
        assigned = false;
    }
    /**
     * Constructor for Seat object.
     * @param id Seat ID.
     * @param assigned Occupancy of seat.
     */
    public Seat(String id, boolean assigned){
        seatID = id;
        this.assigned = assigned;
    }
    /**
     * Retrieves seat ID.
     * @return Seat ID.
     */
    public String getSeatID(){
        return seatID;
    }
    /**
     * Sets seat ID.
     * @param id Seat ID.
     */
    public void setSeatID(String id){
        seatID = id;
    }
    /**
     * Retrieves occupancy of seat.
     * @return Seat occupancy.
     */
    public boolean occupied(){
        return assigned;
    }
    /**
     * Sets occupancy of seat to assigned.
     */
    public void assignSeat(){
        assigned = true;
    }
    /**
     * Sets occupancy of seat to unassigned.
     */
    public void unassignSeat(){
        assigned = false;
    }
}