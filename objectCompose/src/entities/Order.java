package entities;

import entities.enums.OrderStatus;
import java.util.ArrayList;
import java.util.List;
import entities.OrderItem;


import java.util.Date;

public class Order {

    private Date moment;
    private OrderStatus status;

    List<OrderItem> orderItemList = new ArrayList<>();

    public void addItem (OrderItem item) {
        orderItemList.add(item);
    }

    public void removeItem (OrderItem item) {
        orderItemList.remove(item);
    }

    public Double total () {
        for (OrderItem oi : orderItemList) {
            return oi.subTotal();
        }
        return null;
    }
}
