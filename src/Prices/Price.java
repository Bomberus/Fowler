package Prices;

public abstract class Price {
    public abstract int getPriceCode();
    public abstract double getMoney(int daysRented);
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
