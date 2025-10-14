package ua.opnu.java.inheritance.bill;

public class Item {

        private final String name;
        private final double price;
        private final double discount;

        public Item(String name, double price, double discount) {
            if (name == null) throw new NullPointerException("name must not be null");
            if (price < 0) throw new IllegalArgumentException("price must be >= 0");
            if (discount < 0) throw new IllegalArgumentException("discount must be >= 0");
            this.name = name;
            this.price = price;
            this.discount = Math.min(discount, price);
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public double getDiscount() {
            return discount;
        }
    }
