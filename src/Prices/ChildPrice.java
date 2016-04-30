package Prices;

import Program.Movie;

public class ChildPrice implements Price {

    public int getPriceCode(){

                return Movie.CHILDRENS;
    }

    public double getMoney(int daysRented){
        if (daysRented > 3) {
            return 1.5 + (daysRented - 3 ) * 1.5;
        }
        else {
            return 1.5;
        }
    }

    public int getFrequentRenterPoints(int daysRented) {

        return 1;
    }
}
