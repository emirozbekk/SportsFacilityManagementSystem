import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeSet;

public abstract class SportsFacility implements FacilityInterface{
	protected String location;
	protected boolean isIndoor;
	protected int capacity;
	protected String openingHour;
	protected String closingHour;
	protected boolean isAvailable;
	protected ArrayList<String> bookedBy = new ArrayList<>();
	protected boolean lightingAvailability;
	protected int facilityId;
	protected ArrayList<String> studentsInside = new ArrayList<>();
	protected ArrayList<Course> courses =  new ArrayList<>();
	protected TreeSet<String> reservationsSet = new TreeSet<>();
	protected static final int FACILITYCOUNT = 0;
	
	
	public TreeSet<String> getReservationsSet() {
		return reservationsSet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(facilityId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SportsFacility other = (SportsFacility) obj;
		return facilityId == other.facilityId;
	}

	public void setReservationsSet(TreeSet<String> reservationsSet) {
		this.reservationsSet = reservationsSet;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public SportsFacility() {
		
	}
	
	

	public SportsFacility(String location, boolean isIndoor, int capacity, String openingHour, String closingHour,
			boolean isAvailable, ArrayList<String> bookedBy, boolean lightingAvailability, int facilityId,
			ArrayList<String> studentsInside, ArrayList<Course> courses, TreeSet<String> reservationsSet) {
		super();
		this.location = location;
		this.isIndoor = isIndoor;
		this.capacity = capacity;
		this.openingHour = openingHour;
		this.closingHour = closingHour;
		this.isAvailable = isAvailable;
		this.bookedBy = bookedBy;
		this.lightingAvailability = lightingAvailability;
		this.facilityId = facilityId;
		this.studentsInside = studentsInside;
		this.courses = courses;
		this.reservationsSet = reservationsSet;
		
		
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isIndoor() {
		return isIndoor;
	}

	public void setIndoor(boolean isIndoor) {
		this.isIndoor = isIndoor;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getOpeningHour() {
		return openingHour;
	}

	public void setOpeningHour(String openingHour) {
		this.openingHour = openingHour;
	}

	public String getClosingHour() {
		return closingHour;
	}

	public void setClosingHour(String closingHour) {
		this.closingHour = closingHour;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public ArrayList<String> getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(ArrayList<String> bookedBy) {
		this.bookedBy = bookedBy;
	}

	public boolean isLightingAvailability() {
		return lightingAvailability;
	}

	public void setLightingAvailability(boolean lightingAvailability) {
		this.lightingAvailability = lightingAvailability;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public ArrayList<String> getStudentsInside() {
		return studentsInside;
	}

	public void setStudentsInside(ArrayList<String> studentsInside) {
		this.studentsInside = studentsInside;
	}
	
	public String toString() {
		return "Location: " + location
				+"\nIs Indoor: " + isIndoor
				+"\nCapacity: " + capacity
				+"\nOpening & Closing Hour: " + openingHour + "-" + closingHour
				+"\nIs Available: " + isAvailable
				+"\nLighting Availability: " + lightingAvailability
				+"\nFacility Id: " + facilityId;
	}
	
	public abstract TreeSet<String> displayUpcomingReservations();
	
	
	

}