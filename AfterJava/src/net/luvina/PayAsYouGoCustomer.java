package net.luvina;

public class PayAsYouGoCustomer extends Customer{

	@Override
	public float generateMonthlyTotalCost() throws Exception {
		float monthlyUsage = 0;
		float callCost = 0.12f * this.getCallMinutes();
		float smsCost = 0.12f * this.getSmsCount();
		monthlyUsage = callCost + smsCost;
		return monthlyUsage;
	}

}
