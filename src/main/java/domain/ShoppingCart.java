package domain;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShoppingCart {
    Map<Product, Integer> productList;
    Double totalPrice;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    Double taxRate;

    public Map<Product, Integer> getProductList() {
        return productList;
    }

    public ShoppingCart() {
        this.productList = new HashMap<>();
        this.taxRate = 12.5;
    }

    public Double calculateTotalPrice() {
        this.totalPrice = 0.0;
        for (Product product : productList.keySet()) {
            int quantity = productList.get(product);
            Double price = product.getPrice();
            totalPrice += price * quantity;
        }
        return Double.valueOf(df.format(this.totalPrice + ((totalPrice * this.taxRate)/100)));
    }

    public void addItem(Product product, int quantity) {
        if(productList.containsKey(product)){
            int newQuantity = productList.get(product) + quantity;
            productList.put(product, newQuantity);
        } else {
            productList.put(product, quantity);
        }
    }

    public Double calculateTax(){
        Double totalPrice = this.calculateTotalPrice();
        return Double.valueOf(df.format((totalPrice * this.taxRate) /100));
    }
}
