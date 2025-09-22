package kr.ac.kopo.wsk.springbootj_dbctest.repository;

import jakarta.persistence.Entity;
import kr.ac.kopo.wsk.springbootj_dbctest.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
