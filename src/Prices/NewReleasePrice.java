package Prices;

import Program.Movie;

public class NewReleasePrice implements Price{
    public int getPriceCode(){
        return Movie.NEW_RELEASE;
    }

    public double getMoney(int daysRented){
        return (daysRented * 3 );
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
