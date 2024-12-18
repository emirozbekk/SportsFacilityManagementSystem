import java.util.ArrayList;
import java.util.TreeSet;

public class Football extends SportsFacility {
	
	private String teamAName;
	private String teamBName;
	private int shirts;
	
	public Football() {
		
	}
	
	
	
	

	public Football(String location, boolean isIndoor, int capacity, String openingHour, String closingHour,
			boolean isAvailable, ArrayList<String> bookedBy, boolean lightingAvailability, int facilityId,
			ArrayList<String> studentsInside, ArrayList<Course> courses, TreeSet<String> reservationsSet,
			String teamAName, String teamBName, int shirts) {
		super(location, isIndoor, capacity, openingHour, closingHour, isAvailable, bookedBy, lightingAvailability,
				facilityId, studentsInside, courses, reservationsSet);
		this.teamAName = teamAName;
		this.teamBName = teamBName;
		this.shirts = shirts;
	}






	public String getTeamAName() {
		return teamAName;
	}

	public void setTeamAName(String teamAName) {
		this.teamAName = teamAName;
	}

	public String getTeamBName() {
		return teamBName;
	}

	public void setTeamBName(String teamBName) {
		this.teamBName = teamBName;
	}

	public int getShirts() {
		return shirts;
	}

	public String toString() {
		return super.toString()
				+ "\nTeam A : " + teamAName
				+ "\nTeam B: " + teamBName;
				
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
			else {
				return true;
			}
			
		}
		return false;
		
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
