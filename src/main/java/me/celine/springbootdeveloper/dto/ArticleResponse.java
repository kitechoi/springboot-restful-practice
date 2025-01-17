package me.celine.springbootdeveloper.dto;

// 컨트롤러가 요청에 응답할 때 필요한 DTO
// GET(조회) 시 사용

import lombok.Getter;
import me.celine.springbootdeveloper.domain.Article;

@Getter
public class ArticleResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }

}

