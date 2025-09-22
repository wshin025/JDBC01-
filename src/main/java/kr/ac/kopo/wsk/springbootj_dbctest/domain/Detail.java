package kr.ac.kopo.wsk.springbootj_dbctest.domain;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private float weight;
    private float width;
    private float height;

    @OneToOne
    @JoinColumn(name = "product_id")
    @MapsId
    private Product product;
}
