package kr.ac.kopo.wsk.springbootj_dbctest.repository;

import kr.ac.kopo.wsk.springbootj_dbctest.domain.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailReopsitory extends JpaRepository<Detail, Integer> {


}
