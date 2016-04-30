public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        priceCode = newpriceCode;
    }
    public int getPriceCode() {
        return priceCode;
    }
    public void setPriceCode(int arg) {
        priceCode = arg;
    }
    public String getTitle (){
        return title;
    }
    public double getMoney(int days_rented){
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (days_rented > 2)
                    result += (days_rented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += days_rented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (days_rented > 3)
                    result += (days_rented - 3) * 1.5;
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints( int days_rented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) &&  days_rented > 1) {
            return 2;
        }
        return 1;
    }
}