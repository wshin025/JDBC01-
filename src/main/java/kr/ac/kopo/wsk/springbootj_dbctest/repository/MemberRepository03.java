package kr.ac.kopo.wsk.springbootj_dbctest.repository;


import jakarta.transaction.Transactional;
import kr.ac.kopo.wsk.springbootj_dbctest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository03 extends JpaRepository<Member, Integer> {

    @Transactional
    @Query(value = "select entity from Member entity")
    public List<Member> selectMethod();
}
