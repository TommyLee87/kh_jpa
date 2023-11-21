package com.kh.totalJpaSample.repository;
import com.kh.totalJpaSample.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
// 네이밍 규칙에 의해서 API를 작성하면 맞는 쿼리문을 하이버네이트가 구현 해줌
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    Member findByPassword(String pwd);
    Member findByEmailAndPassword(String email, String pwd);
    boolean existsByEmail(String email);
}
