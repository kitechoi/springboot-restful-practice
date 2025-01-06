package me.celine.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.celine.springbootdeveloper.domain.Article;
import me.celine.springbootdeveloper.dto.AddArticleRequest;
import me.celine.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    // HTTP 메서드가 POST일 때 전달받은 URL과 동일하면 메서드로 매핑
        // 지금의 경우, /api/articles는 addArticle() 메서드에 매핑함
    @PostMapping("/api/articles")
    // HTTP 요청한 응답에 해당하는 값을 @RequestBody 붙은 객체(AddArticleRequest)에 매핑
        // addArticle()은 블로그 글을 생성하는 save()를 호출한 뒤, 생성된 블로그 글을 반환함.
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)    // 201 Created
                .body(savedArticle);
    }
}
