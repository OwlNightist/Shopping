package com.example.shopping.entity.Cart;

import com.example.shopping.entity.Product.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tblCart")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItem {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @CreatedDate
    Instant createdDate;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "product_id")
    Product product;

    @Column(name = "quantity")
    int quantity;

}
