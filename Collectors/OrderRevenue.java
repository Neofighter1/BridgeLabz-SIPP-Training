package Collectors;

import java.util.*;
import java.util.stream.*;

class Order {
    String customer;
    double amount;
    Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }
    String getCustomer() { return customer; }
    double getAmount() { return amount; }
}

public class OrderRevenue {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Ram", 200.5),
            new Order("Shyam", 300.0),
            new Order("Ram", 150.0)
        );

        Map<String, Double> revenue = orders.stream()
            .collect(Collectors.groupingBy(
                Order::getCustomer,
                Collectors.summingDouble(Order::getAmount)
            ));

        System.out.println(revenue);
    }
}