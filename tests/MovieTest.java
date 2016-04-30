import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest{
    @Test
    public void createTest(){
        String title = "Omas von der Müllhalde";
        int priceCode = 10;
        Movie movie = new Movie(title,priceCode);

        assertEquals("Check for correct movie title",title,movie.getTitle());
        assertEquals("Check for correct priceCode",priceCode,movie.getPriceCode());

        priceCode = 13;
        movie.setPriceCode(priceCode);
        assertEquals("Check for correct priceCode",priceCode,movie.getPriceCode());
    }
}
