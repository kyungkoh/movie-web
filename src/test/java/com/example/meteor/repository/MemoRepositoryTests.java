package com.example.meteor.repository;

import com.example.meteor.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

   //객체를 조회하는 함수 (Select)
   /* @Transactional
    @Test
    public void testSelect(){
        Long mno = 100L;
        Memo memo = memoRepository.getOne(mno);
        System.out.println("=============================");
        System.out.println(memo);
    }*/

    // 100번의 memo 객체의 memo_text를 업데이트하는 함수 (Update)
    /*@Test
    public void testUpdate(){
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
        System.out.println(memoRepository.save(memo));
    }*/

    //100번째 객체 삭제 함수 (Delete)
    /*@Test
    public void testDelete(){
        Long mno = 100L;
        memoRepository.deleteById(mno);
    }*/

    //Paging 처리 함수
    /*@Test
    public void testPageDefault(){
        //1페이지 10개
        Pageable pageable = PageRequest.of(0,10);
        Page<Memo> result = memoRepository.findAll(pageable);
        System.out.println(result);

        System.out.println("-------------------------------");
        System.out.println("Total pages: "+result.getTotalPages()); //총 몇페이지
        System.out.println("Total Count: "+result.getTotalElements()); //전체 개수
        System.out.println("Page Number: "+result.getNumber()); //현재 페이지 번호
        System.out.println("Page Size: "+ result.getSize()); //페이지당 데이터 개수
        System.out.println("has next page?: "+result.hasNext()); //다음 페이지 개수
        System.out.println("first page?: "+result.isFirst()); //시작페이지(0) 여부

        System.out.println("--------------------------------");
        // 실제 페이지의 데이터 조회
        for (Memo memo : result.getContent()){
            System.out.println(memo);
        }
    } */

    //정렬 조건 추가 (내림차순)
    @Test
    public void testSort(){
        Sort sort1 = Sort.by("mno").descending();
        Sort sort2 = Sort.by("memoText").ascending();
        Sort sortAll = sort1.and(sort2);
        //Pageable pageable = PageRequest.of(0,10,sort1);
        Pageable pageable = PageRequest.of(0,20,sortAll);
        Page<Memo> result = memoRepository.findAll(pageable);

        result.get().forEach(memo ->{
            System.out.println(memo);
        });
    }

    }

