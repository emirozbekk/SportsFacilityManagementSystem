import java.util.ArrayList;
import java.util.TreeSet;

public class Tennis extends SportsFacility{

	private String surfaceType;
	private double netHeight;
	private boolean isDoublesCourt;
	private boolean racketAvailability;
	
	
	

	public Tennis() {
		super();
	}

	

	public Tennis(String location, boolean isIndoor, int capacity, String openingHour, String closingHour,
			boolean isAvailable, ArrayList<String> bookedBy, boolean lightingAvailability, int facilityId,
			ArrayList<String> studentsInside, ArrayList<Course> courses, TreeSet<String> reservationsSet,
			String surfaceType, double netHeight, boolean isDoublesCourt, boolean racketAvailability) {
		super(location, isIndoor, capacity, openingHour, closingHour, isAvailable, bookedBy, lightingAvailability,
				facilityId, studentsInside, courses, reservationsSet);
		this.surfaceType = surfaceType;
		this.netHeight = netHeight;
		this.isDoublesCourt = isDoublesCourt;
		this.racketAvailability = racketAvailability;
	}


	public String getSurfaceType() {
		return surfaceType;
	}



	public void setSurfaceType(String surfaceType) {
		this.surfaceType = surfaceType;
	}



	public double getNetHeight() {
		return netHeight;
	}



	public void setNetHeight(double netHeight) {
		this.netHeight = netHeight;
	}



	public boolean isDoublesCourt() {
		return isDoublesCourt;
	}



	public void setDoublesCourt(boolean isDoublesCourt) {
		this.isDoublesCourt = isDoublesCourt;
	}



	public boolean isRacketAvailability() {
		return racketAvailability;
	}

	
	public void setRacketAvailability(boolean racketAvailability) {
		this.racketAvailability = racketAvailability;
	}

	
	public String toString() {
		return super.toString()
				+ "\nSurface Type: " + surfaceType
				+ "\nNet Height: " + netHeight
				+ "\nDouble Court: " + isDoublesCourt
				+"\nRacket Availability: " + racketAvailability;
	}



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
			else {
				return true;
			}
			
		}
		return false;
	}
	
	

}
