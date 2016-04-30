import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void createTest(){
        String title = "Beathe Uhse";
        Customer customer = new Customer(title);
        assertEquals("Check for the name of the customer",title,customer.getName());
    }

    @Test
    public void testStatement(){
        String movie_title = "Maria poliert ihre Glocken";
        String customer_title = "Beathe Uhse";
        int pricecode = Movie.NEW_RELEASE;
        int pricecode_notNew = Movie.REGULAR;
        int days_rented = 10;
        double price_amountNew = 30.0;
        double price_amountReg = 14.0;

        Customer customer = new Customer(customer_title);

        Movie movie = new Movie(movie_title,pricecode);
        Rental rental = new Rental(movie,days_rented);

        assertEquals("Test when no rentals:",makeStatus("",0,0,customer_title,0.0,0),customer.statement());
        customer.addRental(rental);
        assertEquals("Test when customer has rentals and new Release:",makeStatus(movie_title,days_rented,pricecode,customer_title,price_amountNew,2),customer.statement());

        customer = new Customer(customer_title);
        movie = new Movie(movie_title,pricecode_notNew);
        rental = new Rental(movie,days_rented);
        customer.addRental(rental);
        assertEquals("Test when customer has rentals and regular Release:",makeStatus(movie_title,days_rented,pricecode,customer_title,price_amountReg,1),customer.statement());

        customer = new Customer(customer_title);
        movie = new Movie(movie_title,pricecode_notNew);
        rental = new Rental(movie,0);
        customer.addRental(rental);
        assertEquals("Test when customer has rented for less a day",makeStatus(movie_title,0,pricecode,customer_title,2.0,1),customer.statement());


    }

    private String makeStatus(String movie_title, int days_rented, int pricecode, String customer_title, double amount,int freq_renter_points){
        String status = "Rental Record for " + customer_title + "\n";
        status += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        if (!movie_title.isEmpty()) {
            status += "\t" + movie_title + "\t" + "\t" + days_rented + "\t" + String.valueOf(amount) + "\n";
        }
        status += "Amount owed is " + String.valueOf(amount) + "\n";
        status += "You earned " + String.valueOf(freq_renter_points) + " frequent renter points";

        return status;
    }
}
