package entities;

import entities.enums.OrderStatus;
import java.util.ArrayList;
import java.util.List;
import entities.OrderItem;
import java.util.Date;

public class Order {

    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> orderItemList = new ArrayList<OrderItem>();

    public Order () {

    }

    public Order (Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem (OrderItem item) {
        orderItemList.add(item);
    }

    public void removeItem (OrderItem item) {
        orderItemList.remove(item);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double total () {
        double sum = 0;
        for (OrderItem oi : orderItemList) {
           sum += oi.subTotal();
        }
        return sum;
    }
}
