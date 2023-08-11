package com.mysite.sbb;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class RepositoryTest {

    @Autowired
    public QuestionRepository questionRepository;

    @Test
    public void testCreate() {
        Question question = new Question();
        question.setTitle("스프링부트 점점 속에 익다?!");
        question.setContent("스프링부트 좋아여!");
        question.setCreateDate(LocalDateTime.now());

        this.questionRepository.save(question);
    }

    @Test
    public void testByTitle() {
        Question question = this.questionRepository.findByTitleLike("%Spring%");
        log.info("Question: " + question.getTitle());
    }
}
