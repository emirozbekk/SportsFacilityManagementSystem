import java.util.ArrayList;
import java.util.TreeSet;

public class Basketball extends SportsFacility{
	private String floorType;
	private double hoopHeight;
	private int teamSize;
	private boolean ballAvailability;
	
	public Basketball() {
		super();
	}
	
	
	
	public Basketball(String location, boolean isIndoor, int capacity, String openingHour, String closingHour,
			boolean isAvailable, ArrayList<String> bookedBy, boolean lightingAvailability, int facilityId,
			ArrayList<String> studentsInside, ArrayList<Course> courses, TreeSet<String> reservationsSet,
			String floorType, double hoopHeight, int teamSize, boolean ballAvailability) {
		super(location, isIndoor, capacity, openingHour, closingHour, isAvailable, bookedBy, lightingAvailability,
				facilityId, studentsInside, courses, reservationsSet);
		this.floorType = floorType;
		this.hoopHeight = hoopHeight;
		this.teamSize = teamSize;
		this.ballAvailability = ballAvailability;
	}



	public String getFloorType() {
		return floorType;
	}
	public void setFloorType(String floorType) {
		this.floorType = floorType;
	}
	public double getHoopHeight() {
		return hoopHeight;
	}
	public void setHoopHeight(double hoopHeight) {
		this.hoopHeight = hoopHeight;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public boolean isBallAvailability() {
		return ballAvailability;
	}
	public void setBallAvailability(boolean ballAvailability) {
		this.ballAvailability = ballAvailability;
	}
	
	public String toString() {
		return super.toString()
				+ "\nFloor Type: " + floorType
				+ "\nHoop Height: " + hoopHeight
				+ "\nTeam Size: " + teamSize
				+"\nBall Availability: " + ballAvailability;
	}

	@Override
	public TreeSet<String> displayUpcomingReservations() {
		// TODO Auto-generated method stub
		ArrayList<String> reservations = new ArrayList<>();
		String[] splitted = new String[3];
		
		
		for(String s : super.bookedBy) {
			splitted = s.split("\\*");
			
			super.reservationsSet.add("Facility is booked at " + splitted[2] + " by " + splitted[0] + "(" + splitted[1] + ")\n");
		}
		
		return super.reservationsSet;
		
	}
	
	
	public boolean bookFacility(String time) {
		String[] s=new String[3];
		for(int i=0; i<bookedBy.size(); i++)
		{
			s=bookedBy.get(i).split("\\*");
			if(time.equalsIgnoreCase(s[2]))
			{
				return false;
			}
			
			
		}
		
		
		return true;
		
	}
}