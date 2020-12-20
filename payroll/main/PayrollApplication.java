package payroll.main;

import java.util.List;

import payroll.logic.PayrollLogic;
import payroll.model.Emloyee;

public class PayrollApplication {
	public static void main(String[] args) {
		
		PayrollLogic payrollLogic = new PayrollLogic();
		
		List<Emloyee> emloyees = payrollLogic.getEmployees();

		payrollLogic.calculateSalary(emloyees);		
		
		payrollLogic.printEmployees(emloyees);
		
	}
}
