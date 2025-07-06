package model;

public class Receipt {
    private double totalCost;
    private double amountGiven;
    private double changeDue;
    private String cashier;

    public Receipt(double totalCost, double amountGiven, double changeDue, String cashier) {
        this.totalCost = totalCost;
        this.amountGiven = amountGiven;
        this.changeDue = changeDue;
        this.cashier = cashier;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getAmountGiven() {
        return amountGiven;
    }

    public double getChangeDue() {
        return changeDue;
    }

    public String getCashier() {
        return cashier;
    }

    @Override
    public String toString() {
        return String.format("Receipt:%nTotal Cost: $%.2f%nAmount Given: $%.2f%nChange Due: $%.2f%nCashier: %s", 
                           totalCost, amountGiven, changeDue, cashier);
    }
}