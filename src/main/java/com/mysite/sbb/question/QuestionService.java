package com.mysite.sbb.question;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Page<Question> getList(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("createDate").descending());
        Page<Question> questionPage = this.questionRepository.findAll(pageable);
        return questionPage;
    }

    public Question getQuestion(Integer id) {
        Optional<Question> oq = this.questionRepository.findById(id);

        if(oq.isPresent()) {
            return oq.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String title, String content, SiteUser author) {
        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());
        question.setAuthor(author);
        this.questionRepository.save(question);
    }

    public void modify(Question question, String title, String content) {
        question.setTitle(title);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

    public void delete(Question question) {
        this.questionRepository.delete(question);
    }
}
