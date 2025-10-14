package ua.opnu.java.inheritance.bill;

import java.util.List;

public class DiscountBill2 {
    private final GroceryBill bill;
    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    public void add(Item item) {
        bill.add(item);
        if (regularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    public double getTotal() {
        double total = 0.0;
        List<Item> items = bill.getItems();
        for (Item i : items) {
            if (regularCustomer) {
                total += i.getPrice() - i.getDiscount();
            } else {
                total += i.getPrice();
            }
        }
        return total;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer) return 0.0;
        double fullPrice = 0.0;
        double discountedPrice = 0.0;
        for (Item i : bill.getItems()) {
            fullPrice += i.getPrice();
            discountedPrice += i.getPrice() - i.getDiscount();
        }
        if (fullPrice == 0.0) return 0.0;
        return 100.0 - (discountedPrice * 100.0 / fullPrice);
    }

    public Employee getClerk() {
        return bill.getClerk();
    }
}
