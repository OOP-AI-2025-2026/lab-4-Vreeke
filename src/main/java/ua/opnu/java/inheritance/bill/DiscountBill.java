package ua.opnu.java.inheritance.bill;

import java.util.List;

public class DiscountBill extends GroceryBill {
    private final boolean regularCustomer;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(Item i) {
        super.add(i);
    }

    @Override
    public double getTotal() {
        List<Item> items = getItems();
        double full = 0.0;
        double discounted = 0.0;
        for (Item it : items) {
            double price = it.getPrice();
            double disc = it.getDiscount();
            full += price;
            discounted += Math.max(0.0, price - disc);
        }
        return regularCustomer ? discounted : full;
    }

    public int getDiscountCount() {
        if (!regularCustomer) return 0;
        int count = 0;
        for (Item it : getItems()) {
            if (it.getDiscount() > 0.0) count++;
        }
        return count;
    }

    public double getDiscountAmount() {
        if (!regularCustomer) return 0.0;
        double sum = 0.0;
        for (Item it : getItems()) {
            sum += Math.min(it.getDiscount(), it.getPrice());
        }
        return sum;
    }

    public double getDiscountPercent() {
        if (!regularCustomer) return 0.0;
        double full = 0.0;
        double discounted = 0.0;
        for (Item it : getItems()) {
            double price = it.getPrice();
            double disc = it.getDiscount();
            full += price;
            discounted += Math.max(0.0, price - disc);
        }
        if (full == 0.0) return 0.0;
        return 100.0 - (discounted * 100.0) / full;
    }
}
