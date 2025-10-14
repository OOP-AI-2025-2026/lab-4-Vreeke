package ua.opnu.java.inheritance.bill;

public class Employee {

        private final String name;

        public Employee(String name) {
            if (name == null) throw new NullPointerException("name must not be null");
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
