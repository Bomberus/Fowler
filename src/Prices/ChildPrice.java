package Prices;

import Program.Movie;

public class ChildPrice extends Price {

    public int getPriceCode(){

                return Movie.CHILDRENS;
    }

    public double getCharge(int daysRented){
        if (daysRented > 3) {
            return (daysRented - 3 ) * 1.5;
        }
        else {
            return 1.5;
        }
    }

    public int getFrequentRenterPoints(int daysRented) {

        return 1;
    }
}
