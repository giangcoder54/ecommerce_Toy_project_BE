package org.example.ecommerce_toys_be.Entity;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ecommerce_toys_be.Enum.ERole;


@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "role")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    private ERole name;
}
