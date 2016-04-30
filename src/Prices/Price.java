package Prices;

abstract class Price {
    abstract int getPriceCode();
    abstract double getMoney(int daysRented);
    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
