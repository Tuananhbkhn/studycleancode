package net.luvina;

public class Main {

    public static void main(String[] args) throws Exception {
    	Customer payAsYouGoCustomer = new PayAsYouGoCustomer();
    	payAsYouGoCustomer.setCallMinutes(100);
    	payAsYouGoCustomer.setSmsCount(500);
    	System.out.println(payAsYouGoCustomer.generateMonthlyTotalCost());
    }
}
