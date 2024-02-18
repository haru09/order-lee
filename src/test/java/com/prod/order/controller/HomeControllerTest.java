package com.prod.order.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
// Extension 사용을 위한 어노테이션 (ex BeforeAllCallback 등 Lifecycle callbacks 호출 시)
// JUnit4에서는 RunWith, JUnit5에서는 ExtendWith
// SpringExtension.class & MockitoExtension.class 두 종류가 있음
// SpringBootTest 없이 가볍게 테스트하고 싶을 때는 MockitoExtension, 일반적인 경우는 SpringExtension (좀 더 공부 필요)
// 참고 링크 : https://stackoverflow.com/questions/60308578/what-is-the-difference-between-extendwithspringextension-class-and-extendwit

@AutoConfigureMockMvc
// MockMvc 제어하는 어노테이션
// Mock : 테스트를 위해 실제 객체와 비슷한 객체를 만드는 것
// 같은 기능을 수행하는 어노테이션으로 @WebMvcTest 존재
// @WebMvcTest는 가볍게 테스트할 때 사용, @Controller 어노테이션만 테스트 가능
// @AutoConfigureMockMvc는 @Controller 뿐만 아니라 @Service, @Repository 모두 테스트 가능
// 참고 링크 : https://we1cometomeanings.tistory.com/65

@SpringBootTest
// 테스트에 필요한 거의 모든 의존성 제공
// 사용 시 @ExtendWith(SpringExtension.class) 이미 포함하고 있기 때문에 @ExtensionWith을 사용하지 않아도 됨
// Autowired 허용하여 객체 의존성 주입
// 참고 링크 : https://www.inflearn.com/questions/211302/springboottest%EC%97%90%EC%84%9C-%EC%96%B4%EB%96%BB%EA%B2%8C-autowired%EA%B0%80-%EC%9E%91%EB%8F%99%ED%95%98%EB%8A%94%EC%A7%80-%EA%B6%81%EA%B8%88%ED%95%A9%EB%8B%88%EB%8B%A4

//https://velog.io/@gale4739/Spring-Boot-Controller-test-with-JUnit5
//@WebMvcTest(controllers = HomeController.class)
class HomeControllerTest {

    //private MockMvc mvc : 웹 API를 테스트할 때 사용하는데, 스프링 MVC 테스트의 시작점이며, 이 클래스를 통해 HTTP GET, POST 에 대한 API 테스트를 할 수 있다.
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void home이_리턴된다() throws Exception{
        String home = "home";

        //mockMvc.perform(get("/hello")) : MockMvc 를 통해 /hello 주소로 HTTP GET 요청을 하며, 체이닝이 지원되어 여러 검증 기능을 이어서 선언할 수 있다.
        //.andExpect(status().isOk()) : mvc.perform 의 결과를 검증하고 HTTP Header 의 Status 를 검증. 우리가 아는 그 200, 400, 500 같은 상태를 검증하는 것.
        //.andExpect(content().string(hello)) : mvc.perform 의 결과를검증하고, 본문의 내용을 검증한다. Controller 에서 리턴값이 맞나 확인.
        mockMvc
                .perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(content().string(home));
    }
}