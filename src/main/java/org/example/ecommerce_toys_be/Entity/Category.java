package org.example.ecommerce_toys_be.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    private boolean is_deleted;
    private boolean is_activated;

    public Category(String name){
        this.name = name;
        this.is_activated = true;
        this.is_deleted = false;
    }

}
