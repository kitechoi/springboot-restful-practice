package me.celine.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.celine.springbootdeveloper.domain.Article;
import me.celine.springbootdeveloper.dto.AddArticleRequest;
import me.celine.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

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
}
