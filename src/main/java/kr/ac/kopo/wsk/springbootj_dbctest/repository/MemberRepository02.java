package kr.ac.kopo.wsk.springbootj_dbctest.repository;


import kr.ac.kopo.wsk.springbootj_dbctest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository02 extends JpaRepository<Member, Integer> {

}