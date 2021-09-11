package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());//생성자 주입
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();//생성자 주입
    }
}//자바 코드로 스프링빈에 등록하기
