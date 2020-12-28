package net.luvina;

public class Customer implements iMonthlyUsage {
	private int callMinutes;
	private int smsCount;
	
	public int getCallMinutes() {
		return callMinutes;
	}
	
	public void setCallMinutes(int callMinutes) {
		this.callMinutes = callMinutes;
	}
	
	public int getSmsCount() {
		return smsCount;
	}
	
	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}

	@Override
	public float generateMonthlyTotalCost() throws Exception {
		return 0;
	}
	
}
