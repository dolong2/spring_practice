package hello.hellospring.service;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    private EntityManager em;

    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em){
        this.dataSource=dataSource;
        this.em = em;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());//생성자 주입
    }
    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);//생성자 주입
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}//자바 코드로 스프링빈에 등록하기
