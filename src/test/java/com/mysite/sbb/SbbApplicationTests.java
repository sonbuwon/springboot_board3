package com.mysite.sbb;

import com.mysite.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionService questionService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateMock() {

        for(int i=100 ;i<200; i++) {
            this.questionService.create(String.format("Test Title %s", i) , String.format("Test Content %s", i));
        }
    }
}
