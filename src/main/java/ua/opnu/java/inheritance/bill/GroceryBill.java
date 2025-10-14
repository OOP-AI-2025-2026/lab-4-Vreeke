package ua.opnu.java.inheritance.bill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroceryBill {

    private final Employee clerk;
    private final List<Item> items = new ArrayList<>();

    public GroceryBill(Employee clerk) {
        if (clerk == null) throw new NullPointerException("clerk must not be null");
        this.clerk = clerk;
    }

    public void add(Item i) {
        if (i == null) throw new NullPointerException("item must not be null");
        items.add(i);
    }

    public double getTotal() {
        double total = 0.0;
        for (Item i : items) {
            double net = i.getPrice() - i.getDiscount();
            if (net < 0) net = 0;
            total += net;
        }
        return total;
    }

    public Employee getClerk() {
        return clerk;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
