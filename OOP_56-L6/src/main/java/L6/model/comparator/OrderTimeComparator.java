package L6.model.comparator;

import L6.model.Order;

import java.util.Comparator;

public class OrderTimeComparator implements Comparator<Order> {
    @Override
    public int compare(Order r1, Order r2) {
        return r1.getOrderTime().compareTo(r2.getOrderTime());
    }
}