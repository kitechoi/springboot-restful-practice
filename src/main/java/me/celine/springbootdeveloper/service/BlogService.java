package me.celine.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.celine.springbootdeveloper.domain.Article;
import me.celine.springbootdeveloper.dto.AddArticleRequest;
import me.celine.springbootdeveloper.dto.UpdateArticleRequest;
import me.celine.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
        // save()는 JpaRepository에서 지원하는 메서드.
            // AddArticleRequest 클래스에 저장된 값들을 article 데이터베이스에 저장.
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 블로그 글 전체 조회 메서드
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 블로그 글 하나 조회 메서드
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 글 삭제
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 글 수정 <- dto UpdateArticleRequest를 받아서 씀
    @Transactional  // 매칭한 메서드를 하나의 트랜잭션으로 묶는 역할을 함
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));
        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
