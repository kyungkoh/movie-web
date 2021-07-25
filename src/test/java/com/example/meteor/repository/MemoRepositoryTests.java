package com.example.meteor.repository;

import com.example.meteor.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    //스프링에서 정상처리되고, 의존성에 문제 없는지 확인
    /*public void testClass(){
        System.out.println(memoRepository.getClass().getName());
    }*/

    //100개의 더미 테케 생성하고 save 함수를 통해 insert 하는 함수
    /*public void testInsertDummies(){
        IntStream.rangeClosed(1,100).forEach(i ->{
            Memo memo = Memo.builder().memoText("Sample..."+i).build();
            memoRepository.save(memo);
        });
    }*/

   //객체를 조회하는 함수
   /* @Transactional
    @Test
    public void testSelect(){
        Long mno = 100L;
        Memo memo = memoRepository.getOne(mno);
        System.out.println("=============================");
        System.out.println(memo);
    }*/

    // 100번의 memo 객체의 memo_text를 업데이트하는 함수
    /*@Test
    public void testUpdate(){
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
        System.out.println(memoRepository.save(memo));
    }*/

    //100번째 객체 삭제 함수
    @Test
    public void testDelete(){
        Long mno = 100L;
        memoRepository.deleteById(mno);
    }
}
