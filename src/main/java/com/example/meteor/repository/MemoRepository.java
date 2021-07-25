package com.example.meteor.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.meteor.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//Table에 SQL없이 CRUD 가능
public interface MemoRepository extends JpaRepository<Memo, Long>{

    //쿼리메서드를 이용하기 위한 메서드
    // A,B 값 사이의 객체들을 구하고 mno의 역순으로 정렬
    List <Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

    //쿼리메서도와 Pageable을 결합하기 위한 메서드 선언
    Page <Memo> findByMnoBetween(Long from, Long to, Pageable pageable);

    //delteBy로 시작하는 삭제 처리

    void deleteMemoByMnoLessThan(Long num);
}
