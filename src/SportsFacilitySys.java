import java.util.ArrayList;
import java.util.TreeSet;

public class SportsFacilitySys {
	private static ArrayList<SportsFacility> sportsFacilities = new ArrayList<>();
	
	public static void init() {
		Tennis[] t = new Tennis[5];
		ArrayList<String> booked = new ArrayList<>();
		ArrayList<String> inside = new ArrayList<>();
		TreeSet<String> rs = new TreeSet<>();
		ArrayList<Course> courses = new ArrayList<>();
		boolean randBool = true;

		t[0] = new Tennis("Hard", 91.4 , randBool, randBool, "East Campus", !randBool, 2, "10","17",!randBool,new ArrayList<String>(),randBool,975,inside,courses,new TreeSet<String>());
		t[1] = new Tennis("Grass", 90.4 , randBool, !randBool, "Main Campus", randBool, 2, "12","23",!randBool,new ArrayList<String>(),!randBool,342,inside,courses,new TreeSet<String>());
		t[2] = new Tennis("Clay", 91.7 , randBool, randBool, "Main Campus", randBool, 2, "10","19",!randBool,new ArrayList<String>(),randBool,421,inside,courses,new TreeSet<String>());
		t[3] = new Tennis("Grass", 101.4, randBool, !randBool, "Main Campus", !randBool, 2, "11","14",!randBool,new ArrayList<String>(),!randBool,134,inside,courses,new TreeSet<String>());
		t[4] = new Tennis("Hard", 87.4 , randBool, !randBool, "East Campus", !randBool, 2, "10","19",!randBool,new ArrayList<String>(),!randBool,924,inside,courses,new TreeSet<String>());

		sportsFacilities.add(t[0]);
		sportsFacilities.add(t[1]);
		sportsFacilities.add(t[2]);
		sportsFacilities.add(t[3]);
		sportsFacilities.add(t[4]);
		
		t[1].courses.add(new Course("Begginer Course", "5", 2501));
		t[2].courses.add(new Course("High level Course", "5", 2501));


	}


	public static String displayCourses() {
		String courseInfo="";
		for(int i =0; i<sportsFacilities.size();i++) {
			for(int k=0; k<sportsFacilities.get(i).getCourses().size();k++)
				courseInfo+=sportsFacilities.get(i).getCourses().get(k) + "\n";
		}
		return courseInfo;
	}

	public static String displayOutdoorFacilities() {
		String outdoor="";
		for(int i=0;i<sportsFacilities.size();i++) {
			if(sportsFacilities.get(i).isIndoor()==false) {
				outdoor+=sportsFacilities.get(i).toString() +"\n";
			}
		}
		return outdoor;
	}

	public static ArrayList<SportsFacility> getSportsFacilities() {
		return sportsFacilities;
	}

	public static void setSportsFacilities(ArrayList<SportsFacility> sportsFacilities) {
		SportsFacilitySys.sportsFacilities = sportsFacilities;
	}

	public static String deleteReservation( String time, int facilityId, String name, String stuid) {
		SportsFacility facility = searchFacilityById(facilityId);
		String result="";
		String a ="";
		if(facility!=null) {
			if(!facility.bookFacility(time)) {
			a = name +"*" +stuid +"*" +time;
			facility.getBookedBy().remove(a);
			result+="Removed reservation: Student name with the id: " + name +" " + stuid + "\nTime: " + time;
					}
			}
		else {
			result+="No reservation with the given information";
		}
			
			

		return result;

		
	}


	public static Course searchCourseByName(String courseName) {

		for(int i=0;i<sportsFacilities.size();i++) {
			for(int k=0; k<sportsFacilities.get(i).getCourses().size();k++) {
				if(sportsFacilities.get(i).getCourses().get(k).getCourseName().equalsIgnoreCase(courseName))
					return sportsFacilities.get(i).getCourses().get(k);
			}
		}
		return null;

	}



	public static boolean checkAvailibity(int facilityId)
	{
		for(int i=0;i<sportsFacilities.size();i++)
		{
			if(searchFacilityById(facilityId)==sportsFacilities.get(i))
			{
				return sportsFacilities.get(i).isAvailable;
			}


		}
		return false;

	}

	public static boolean addFacility(SportsFacility sf)
	{
		if(searchFacilityById(sf.getFacilityId()) != null)
		{
			return false;
		}
		else
		{
			sportsFacilities.add(sf);
			return true;
		}
	}


	public static SportsFacility searchFacilityById(int id)
	{
		for(int i=0;i<sportsFacilities.size();i++)
		{
			if(sportsFacilities.get(i).getFacilityId()==id)
				return sportsFacilities.get(i);
		}
		return null;

	}

	public static String displayAllFacilities() {
		String outStr = "";

		for(SportsFacility sf : sportsFacilities) {

			outStr += sf.toString() + "\n";

		}

		return outStr;
	}


	public static String displayIndoorFacilities() {
		String outStr = "";

		for(SportsFacility sf : sportsFacilities) {
			if(sf.isIndoor()) {
				outStr += sf.toString() + "\n";
			}
		}

		return outStr;
	}
	
	
	public static boolean reserveFacility(int facilityId, String name, String stuId, String time) {

		SportsFacility sf = searchFacilityById(facilityId);
		boolean booked = false;
		String s = "";
		
		if(sf != null) {
			booked = sf.bookFacility(time);
			
			if(booked) {
				s += name + "*" + stuId + "*" + time;
				
				sf.getBookedBy().add(s);
				
				sf.reservationsSet.add(s);
				
				return true;
			}
		}
		
		
		
		return false;
		
	}
	
	
	public static void calculateCourseFee(Course course) {
		//base price
		double fee = 250;
		
		
		if(course.getCourseName().contains("Football")) {
			fee += 150;
		}
		else if(course.getCourseName().contains("Squash")) {
			fee += 350;
		}
		else if(course.getCourseName().contains("Tennis")) {
			fee += 300;
		}
		else if(course.getCourseName().contains("Basketball")) {
			fee += 200;
		}
		
		course.setCourseFee(fee);
		
	}
	
	
	public static boolean addCourse(int facilityId , String CourseName, String CourseCapacity , double CourseFee) {

        Course c = new Course(CourseName,CourseCapacity,CourseFee);


        SportsFacility sf = searchFacilityById(facilityId);
        if(sf!=null) {
            sf.courses.add(c);
            return true;
            }


        return false;


    }


	 public static String displaySchedule() {
	        String reservations ="";


	        for(SportsFacility sf : sportsFacilities) {
	        	for(String s : sf.getReservationsSet()) {
	        		reservations += s;
	        	}
	        }
	        	
	        	
	        return reservations;
	    }

	

}
