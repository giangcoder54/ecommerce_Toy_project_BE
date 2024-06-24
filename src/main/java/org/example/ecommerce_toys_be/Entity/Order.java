package org.example.ecommerce_toys_be.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "shipping_fee")
    private double shippingFee;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "notes")
    private String notes;

    @Column(name = "customer_id")
    private int customerId;



}

