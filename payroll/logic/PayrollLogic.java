package payroll.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import payroll.model.Emloyee;

public class PayrollLogic {
	private final String DELIMITER = ",";
	private final double SALARY_MULTIPLIER = 1.06;

	public List<Emloyee> getEmployees() {
		List<Emloyee> emloyees = new ArrayList<Emloyee>();
		List<String> csvLines = readFileCSV();
		emloyees = parseCSVLines(csvLines);
		for (Emloyee emloyee : emloyees) {
			int age = calculateAge(emloyee.getDob());
			int jobMonths = calculteJobTime(emloyee.getStartdate());
			emloyee.setAge(age);
			emloyee.setJobMonths(jobMonths);
		}
		return emloyees;
	}

	private int calculteJobTime(String startdate) {
		DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;  
		LocalDate now = LocalDate.now(); 
		LocalDate start = LocalDate.parse(startdate, dtf);
		int jobMonths = Period.between(start, now).getYears()*12 + Period.between(start, now).getMonths();
		return jobMonths;
	}

	private int calculateAge(String dob) {
		DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;  
		LocalDate now = LocalDate.now(); 
		LocalDate birthday = LocalDate.parse(dob, dtf);
		int age = Period.between(birthday, now).getYears();
		return age;
	}

	private List<Emloyee> parseCSVLines(List<String> csvLines) {
		List<Emloyee> emloyees = new ArrayList<Emloyee>();
		try {
			for (String csvLine : csvLines) {
				Emloyee emloyee = new Emloyee();
				String[] splitData = csvLine.split(DELIMITER);
				emloyee.setName(splitData[0]);
				emloyee.setDob(splitData[1]);
				emloyee.setRole(splitData[2]);
				emloyee.setStartdate(splitData[3]);
				emloyee.setStartsal(Integer.parseInt(splitData[4]));
				emloyees.add(emloyee);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return emloyees;
	}

	private List<String> readFileCSV() {
		List<String> csvLines = new ArrayList<String>();
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader("D:/Luvina/payroll/src/employee.csv"));

			while ((line = br.readLine()) != null) {
				csvLines.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException crunchifyException) {
				crunchifyException.printStackTrace();
			}
		}
		return csvLines;
	}

	public void calculateSalary(List<Emloyee> emloyees) {
		for (Emloyee emloyee : emloyees) {
			int salary = 0;
			if (emloyee.getJobMonths() < 12) {
				salary = emloyee.getStartsal();
			} else {
				salary = (int) (emloyee.getStartsal()
						* (Math.pow(SALARY_MULTIPLIER, (double) emloyee.getJobMonths() / 12)));
			}
			emloyee.setSalary(salary);
		}
	}

	public void printEmployees(List<Emloyee> emloyees) {
		for (Emloyee emloyee : emloyees) {
			System.out.println(emloyee.toString());
		}
	}

}
