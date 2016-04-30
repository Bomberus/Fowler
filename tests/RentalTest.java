import org.junit.Test;
import static org.junit.Assert.*;

public class RentalTest {
    @Test
    public void createTest(){
        Movie movie = new Movie("Marlene Mortler und die Drogenaffäre",Movie.REGULAR);
        Rental rental = new Rental(movie, 10);

        assertEquals(10,rental.getDaysRented());
        assertEquals(movie,rental.getMovie());
    }

    @Test
    public void getMoneyTest(){
        String title = "XXL dreckiges Geschirr";
        for (int i = 0; i < 100; i++){
            int pricecode = (int)(Math.random()*3);
            int days_rented = (int)(Math.random()*100);
            Movie movie = new Movie(title,pricecode);
            Rental rental = new Rental(movie, days_rented);

            assertEquals(calcMoney(pricecode,days_rented),rental.getMoney(),0.0);

        }
    }

    @Test
    public void getBonusPointsTest(){
        String title = "XXL dreckiges Geschirr";
        for (int i = 0; i < 100; i++){
            int pricecode = (int)(Math.random()*3);
            int days_rented = (int)(Math.random()*100);
            Movie movie = new Movie(title,pricecode);
            Rental rental = new Rental(movie, days_rented);

            assertEquals(calcBonus(pricecode,days_rented),rental.getBonusPoints());

        }
    }

    private int calcBonus(int pricecode, int days_rented) {
        if (pricecode == Movie.NEW_RELEASE && days_rented > 0) {
            return 2;
        }
        return 1;
    }

    private double calcMoney(int pricecode, int days_rented) {
        double result = 0.0;
        switch (pricecode) {
            case 0:
                result += 2;
                if (days_rented > 2)
                    result += (days_rented - 2) * 1.5;
                break;
            case 1:
                result += days_rented * 3;
                break;
            case 2:
                result += 1.5;
                if (days_rented > 3)
                    result += (days_rented - 3) * 1.5;
                break;
        }
        return result;
    }




}
