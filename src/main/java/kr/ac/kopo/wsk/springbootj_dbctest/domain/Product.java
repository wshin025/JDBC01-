package kr.ac.kopo.wsk.springbootj_dbctest.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;

//    단방향 : product 에서 detail 을 참조
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="detail_id")
//    private Detail detail;

//    공유 기본키를 사용한 양방향
    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL )
    @PrimaryKeyJoinColumn
    private Detail detail;


}
