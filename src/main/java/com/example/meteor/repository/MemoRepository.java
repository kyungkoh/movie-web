package com.example.meteor.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.meteor.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long>{

    //Table에 SQL없이 CRUD 가능
}
