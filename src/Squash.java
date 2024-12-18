import java.util.ArrayList;
import java.util.TreeSet;

public class Squash extends SportsFacility{
	private String floorType;
	private boolean isDoublesCourt;
	private boolean racketAvailibility;
	
	public Squash() {
		
	}
	

	public Squash(String location, boolean isIndoor, int capacity, String openingHour, String closingHour,
			boolean isAvailable, ArrayList<String> bookedBy, boolean lightingAvailability, int facilityId,
			ArrayList<String> studentsInside, ArrayList<Course> courses, TreeSet<String> reservationsSet,
			String floorType, boolean isDoublesCourt, boolean racketAvailibility) {
		super(location, isIndoor, capacity, openingHour, closingHour, isAvailable, bookedBy, lightingAvailability,
				facilityId, studentsInside, courses, reservationsSet);
		this.floorType = floorType;
		this.isDoublesCourt = isDoublesCourt;
		this.racketAvailibility = racketAvailibility;
	}




	public String getFloorType() {
		return floorType;
	}

	public void setFloorType(String floorType) {
		this.floorType = floorType;
	}

	public boolean isDoublesCourt() {
		return isDoublesCourt;
	}

	public void setDoublesCourt(boolean isDoublesCourt) {
		this.isDoublesCourt = isDoublesCourt;
	}

	public boolean isRacketAvailibility() {
		return racketAvailibility;
	}

	public void setRacketAvailibility(boolean racketAvailibility) {
		this.racketAvailibility = racketAvailibility;
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
	

	@Override
	public String toString() {
		return "Squash FloorType=" + floorType + "\n"+", isDoublesCourt=" + isDoublesCourt + "\n"+", racketAvailibility="
				+ racketAvailibility + "\n"+", location=" + location + "\n"+", isIndoor=" + isIndoor + "\n"+", capacity=" + capacity
				+"\n"+ ", openingHour=" + openingHour + "\n"+", closingHour=" + closingHour + "\n"+", isAvailable=" + isAvailable
				+ "\n"+", bookedBy=" + bookedBy +"\n"+ ", lightingAvailability=" + lightingAvailability + "\n"+", facilityId="
				+facilityId + "\n"+", studentsInside=" + studentsInside;
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
			else {
				return true;
			}
			
		}
		return false;
		
	}

}