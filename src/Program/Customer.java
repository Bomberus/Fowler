package Program;

import java.lang.*;
import java.util.*;

public class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Program.Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getMoney()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalMoney()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalMoney() {
               double result = 0;
               Enumeration enum_rentals = rentals.elements();
               while (enum_rentals.hasMoreElements()) {
                        Rental each = (Rental) enum_rentals.nextElement();
                       result += each.getMoney();
               }
               return result;
    }

    private int getTotalFrequentRenterPoints(){
                int result = 0;
                Enumeration enum_rentals = rentals.elements();
                while (enum_rentals.hasMoreElements()) {
                        Rental each = (Rental) enum_rentals.nextElement();
                        result += each.getBonusPoints();
                    }
                return result;
    }

}
    