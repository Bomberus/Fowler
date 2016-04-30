package Prices;

public interface Price {
    abstract int getPriceCode();
    abstract double getMoney(int daysRented);
    abstract int getFrequentRenterPoints(int daysRented);
}
