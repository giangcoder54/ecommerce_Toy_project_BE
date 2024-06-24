package org.example.ecommerce_toys_be.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "image"}))
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product_id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "description")
    private String description;
    @Column(name = "cost_Price")
    private double costPrice;

    @Column(name = "current_quantity")
    private int currentQuantity;
    @Column(name = "image")

    private String image;
    @Column(name = "category_id")

    private int category_id;

    private boolean is_deleted;
    private boolean is_activated;

}
