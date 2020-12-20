package payroll.model;

public class Emloyee {

	private String name;
	private String dob;
	private String role;
	private String startdate;
	private int jobMonths;
	private int startsal;
	private int salary;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public int getJobMonths() {
		return jobMonths;
	}

	public void setJobMonths(int jobMonths) {
		this.jobMonths = jobMonths;
	}

	public int getStartsal() {
		return startsal;
	}

	public void setStartsal(int startsal) {
		this.startsal = startsal;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Emloyee [name=" + name + ", dob=" + dob + ", role=" + role + ", startdate=" + startdate + ", jobTime="
				+ jobMonths/12 + " năm " + (jobMonths - 12*(jobMonths/12)) + " tháng" + ", startsal=" + startsal + ", salary=" + salary + ", age=" + age + "]";
	}
	
}
