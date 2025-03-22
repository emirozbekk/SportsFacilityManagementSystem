import java.util.ArrayList;
import java.util.TreeSet;

public class Football extends SportsFacility {
	
	private String pitchSize;
	private int teamSize;
	
	public Football() {
		
	}
	
	
	
	

	public Football(String location, boolean isIndoor, int capacity, String openingHour, String closingHour,
			boolean isAvailable, ArrayList<String> bookedBy, boolean lightingAvailability, int facilityId,
			ArrayList<String> studentsInside, ArrayList<Course> courses, TreeSet<String> reservationsSet,
			String pitchSize, int teamSize) {
		super(location, isIndoor, capacity, openingHour, closingHour, isAvailable, bookedBy, lightingAvailability,
				facilityId, studentsInside, courses, reservationsSet);
		this.pitchSize = pitchSize;
		this.teamSize = teamSize;
	}



	public String getPitchSize() {
		return pitchSize;
	}



	public int getTeamSize() {
		return teamSize;
	}



	public String toString() {
		return super.toString()
				+ "  Team Size : " + teamSize
				+ "  Pitch Size " + pitchSize;
				
	}
	
	public String distributeShirts() {
		String out ="";
		if(studentsInside.size()<super.capacity) {
			out += "Cannot distribute the shirts all player id's must be entered";
		}
		else
			out += "Shirts are distributed in" + super.capacity/2 + "have fun";
		
		return out;
	}

	@Override
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

	
	
}
