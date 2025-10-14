package ua.opnu.java.inheritance.account;

public class BankingAccount {
    private int balance;
    private final Startup startup;

    public BankingAccount(Startup s) {
        if (s == null) throw new NullPointerException("Startup must not be null");
        this.startup = s;
        this.balance = s.getBalance();
    }

    public void debit(Debit d) {
        if (d == null) throw new NullPointerException("Debit must not be null");
        balance += d.getBalance();
    }

    public void credit(Credit c) {
        if (c == null) throw new NullPointerException("Credit must not be null");
        balance += c.getBalance();
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingAccount that = (BankingAccount) o;
        return balance == that.balance;
    }

    @Override
    public String toString() {
        return "BankingAccount{balance=" + balance + "}";
    }
}
