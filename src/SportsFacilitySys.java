import java.util.ArrayList;
import java.util.TreeSet;

public class SportsFacilitySys {
	private static ArrayList<SportsFacility> sportsFacilities = new ArrayList<>();

	public static void init() {
		Tennis[] t = new Tennis[3];
		ArrayList<String> booked = new ArrayList<>();
		ArrayList<String> inside = new ArrayList<>();
		TreeSet<String> rs = new TreeSet<>();
		ArrayList<Course> courses = new ArrayList<>();
		boolean randBool = true;
		Basketball[] b = new Basketball[5];
		
		b[0] = new Basketball("East Campus",randBool,10,"10","17",!randBool,new ArrayList<>(),!randBool,123,inside,new ArrayList<>(),new TreeSet<>(),"Hardwood",3.05,5,randBool);
		b[1] = new Basketball("East Campus",!randBool,10,"10","17",randBool,new ArrayList<>(),randBool,145,inside,new ArrayList<>(),new TreeSet<>(),"Concrete",3.05,5,randBool);
		b[2] = new Basketball("Main Campus",randBool,10,"9","17",!randBool,new ArrayList<>(),randBool,167,inside,new ArrayList<>(),new TreeSet<>(),"Rubber",3.05,5,randBool);
		b[3] = new Basketball("Main Campus",!randBool,10,"9","17",randBool,new ArrayList<>(),!randBool,189,inside,new ArrayList<>(),new TreeSet<>(),"Asphalt",2.74,5,randBool);
		b[4] = new Basketball("Main Campus",randBool,10,"9","17",!randBool,new ArrayList<>(),randBool,212,inside,new ArrayList<>(),new TreeSet<>(),"Hardwood",3.05,5,randBool);
		
		sportsFacilities.add(b[0]);
		sportsFacilities.add(b[1]);
		sportsFacilities.add(b[2]);
		sportsFacilities.add(b[3]);
		sportsFacilities.add(b[4]);
		
		Course c2 = new Course("Basketball","20",0);
		calculateCourseFee(c2);
		b[0].courses.add(c2);
		b[1].courses.add(c2);
		b[2].courses.add(c2);
		b[3].courses.add(c2);
		b[4].courses.add(c2);
		
		
		

		t[0] = new Tennis("Hard", 91.4 , randBool, randBool, "East Campus", !randBool, 2, "10","17",!randBool,new ArrayList<String>(),randBool,975,inside,courses,new TreeSet<String>());
		t[1] = new Tennis("Grass", 90.4 , randBool, !randBool, "Main Campus", randBool, 2, "12","23",!randBool,new ArrayList<String>(),!randBool,342,inside,courses,new TreeSet<String>());
		t[2] = new Tennis("Clay", 91.7 , randBool, randBool, "Main Campus", randBool, 2, "10","19",!randBool,new ArrayList<String>(),randBool,421,inside,courses,new TreeSet<String>());
		
		
		
		sportsFacilities.add(t[0]);
		sportsFacilities.add(t[1]);
		sportsFacilities.add(t[2]);
		
		
		
		
		Football[] f = new Football[2];
		
		f[0] = new Football("Main Campus", !randBool, 14 , "10.00" , "23.00" , randBool, new ArrayList<>(), randBool, 310 , inside , new ArrayList<>() ,  new TreeSet<>() , "Half Pitch" , 7 );
		f[1] = new Football("East Campus", !randBool, 20 , "10.00" , "23.00" , randBool, new ArrayList<>(), randBool, 410 , inside , new ArrayList<>() ,  new TreeSet<>() , "Full Pitch" , 10);	
				
		sportsFacilities.add(f[0]);
		sportsFacilities.add(f[1]);
		
		

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

	/*public static String deleteReservation( String time, int facilityId, String name, String stuid) {
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


	}*/


	public static String deleteReservation(String time, int facilityId, String name, String stuid ) {
		SportsFacility facility = searchFacilityById(facilityId);
		String result="";
		String listStr ="";
		String rSetStr="";
		if(facility!=null) {
			if(!facility.bookFacility(time)) {
				listStr = name +"*" +stuid +"*" +time;
				if(facility.getBookedBy().remove(listStr)) {
				rSetStr="Facility is booked at " + time + " by " + name + "(" + stuid + ")\n";
				facility.getReservationsSet().remove(rSetStr);
				result+="Removed reservation: Student name with the id: " + name +" " + stuid + "\nTime: " + time;}
				else {
					result+="No reservation with the given information";
				}
			}

			else {
				result+="No reservation with the given information";
			}
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
		String rSetStr = "";

		if(sf != null) {
			booked = sf.bookFacility(time);

			if(booked) {
				s += name + "*" + stuId + "*" + time;

				sf.getBookedBy().add(s);

				rSetStr="Facility is booked at " + time + " by " + name + "(" + stuId + ")\n";
				
				sf.reservationsSet.add(rSetStr);

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
