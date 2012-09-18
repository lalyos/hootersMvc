package com.acme.hooters.model;

public class Order {

    private static long ID_GENERATOR = 0;
    
    private long id;
    private String customer;
    private Girl girl;
    private String food;
    private OrderState state;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public Girl getGirl() {
        return girl;
    }
    public void setGirl(Girl girl) {
        this.girl = girl;
    }
    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }
    public Order(long id, String customer, Girl girl, String food) {
        super();
        this.id = id;
        this.state = OrderState.CREATED;
        this.customer = customer;
        this.girl = girl;
        this.food = food;
        
    }
    public Order(String customer, Girl girl, String food) {
        this(ID_GENERATOR++, customer, girl, food);
    }
    
    public void fullfill() {
        this.state = OrderState.FULLFILLED;
    }

    public void approove() {
        this.state = OrderState.APPROOVED;
    }
@Override
    public String toString() {
        return "Order [id=" + id + ", customer=" + customer + ", girl=" + girl + ", food=" + food + ", state=" + state
                + "]";
    }
    public boolean getIsFulfilled() {
        // TODO Auto-generated method stub
        return this.state == OrderState.FULLFILLED;
    }
    public OrderState getState() {
        return state;
    }
    public void setState(OrderState state) {
        this.state = state;
    }
    
}
