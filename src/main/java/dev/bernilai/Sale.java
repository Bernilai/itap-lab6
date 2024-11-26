package dev.bernilai;

import java.util.Objects;

class Sale {
    private String productName;
    private int quantity;
    private int price;

    public Sale(String productName, int quantity, int price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }


    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }


    public int calculateTotal() {
        return quantity * price;
    }


    @Override
    public String toString() {
        return productName + ": " + quantity + " units, Total: " + calculateTotal();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sale sale = (Sale) obj;
        return Double.compare(sale.price, price) == 0 && quantity == sale.quantity && Objects.equals(productName, sale.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, quantity, price);
    }
}
