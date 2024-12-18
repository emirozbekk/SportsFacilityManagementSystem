
public class Course {
	private String courseName;
	private String courseCapacity;
	private double courseFee;
	
	public Course(String courseName, String courseCapacity, double courseFee) {
		this.courseName = courseName;
		this.courseCapacity = courseCapacity;
		this.courseFee = courseFee;
	}

	public Course() {
		super();
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCapacity() {
		return courseCapacity;
	}

	public void setCourseCapacity(String courseCapacity) {
		this.courseCapacity = courseCapacity;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	
	public String toString() {
		return "\nCourse Name " + courseName
				+"\nCourse Capacity: " + courseCapacity +
				"\nCourse Fee : " + courseFee;
				
				
	}
	
	
}
