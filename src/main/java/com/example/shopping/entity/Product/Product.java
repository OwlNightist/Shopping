package com.example.shopping.entity.Product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tblProduct")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Column(name = "name")
     String name;

    @Column(name = "price")
     double price;

    @Column(name = "sku")
    String sku;

    @Column(name = "image_URL")
    String imageURL;

    @Column(name = "description")
    String description;

    @Column(name = "quanlity")
    int quantity;

    @Column(name = "created_date")
    Date createDate;

    @Column(name = "updated_date")
    Date updateDate;

    @Column(name = "is_delete")
    boolean isDelete;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "brand_id")
    Brand brand;

}
