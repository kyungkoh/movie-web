package com.example.meteor.repository;

import com.example.meteor.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    //스프링에서 정상처리되고, 의존성에 문제 없는지 확인
    /*public void testClass(){
        System.out.println(memoRepository.getClass().getName());
    }*/

    //100개의 더미 테케 생성하고 save 함수를 통해 insert 하는 함수
    public void testInsertDummies(){
        IntStream.rangeClosed(1,100).forEach(i ->{
            Memo memo = Memo.builder().memoText("Sample..."+i).build();
            memoRepository.save(memo);
        });
    }

}
