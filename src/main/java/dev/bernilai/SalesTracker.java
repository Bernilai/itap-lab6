package dev.bernilai;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SalesTracker {

    private Set<Sale> sales;

    public SalesTracker() {
        this.sales = new HashSet<>();
    }

    public void addSale(String productName, int quantity, int price) {
        if (productName == null || productName.isEmpty() || quantity <= 0 || price <= 0) {
            throw new IllegalArgumentException("Invalid sale data.");
        }
        sales.add(new Sale(productName, quantity, price));
    }


    public void displaySales() {
        if (sales.isEmpty()) {
            System.out.println("No sales recorded.");
            return;
        }
        for (Sale sale : sales) {
            System.out.println(sale);
        }
    }


    public int calculateTotalSales() {
        int total = 0;
        for (Sale sale : sales) {
            total += sale.calculateTotal();
        }
        return total;
    }


    public String findMostPopularProduct() {
        if (sales.isEmpty()) {
            return "No sales recorded.";
        }
        Map<String, Integer> productCounts = new HashMap<>();
        for (Sale sale : sales) {
            productCounts.put(sale.getProductName(), productCounts.getOrDefault(sale.getProductName(), 0) + sale.getQuantity());
        }

        String mostPopular = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : productCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
            }
        }

        return mostPopular + " (" + maxCount + " units)";
    }



    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        tracker.addSale("Shirt", 5, 30);
        tracker.addSale("Pants", 3, 50);
        tracker.addSale("Shirt", 2, 30);
        tracker.addSale("Shoes", 1, 75);
        tracker.addSale("Pants", 2, 50);


        System.out.println("Sales list:");
        tracker.displaySales();

        int total = tracker.calculateTotalSales();
        System.out.println("Total revenue: " + total);

        String mostPopular = tracker.findMostPopularProduct();
        System.out.println("Most popular product: " + mostPopular);


    }
}