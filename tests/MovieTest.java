import Program.Movie;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MovieTest{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void createTest(){
        String title = "Omas von der Müllhalde";
        int priceCode = 1;
        Movie movie = new Movie(title,priceCode);

        assertEquals("Check for correct movie title",title,movie.getTitle());
        assertEquals("Check for correct priceCode",priceCode,movie.getPriceCode());

        priceCode = 2;
        movie.setPriceCode(priceCode);
        assertEquals("Check for correct priceCode",priceCode,movie.getPriceCode());

        priceCode = 20;
        exception.expect(IllegalArgumentException.class);
        movie.setPriceCode(priceCode);

        assertEquals("Check for correct priceCode",priceCode,movie.getPriceCode());
    }
}
