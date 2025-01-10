package me.celine.springbootdeveloper.dto;

// dto는 단순하게 데이터를 옮기기 위해 사용하는 전달자 역할이다
// 컨트롤러가 POST(생성)할 때 필요하다

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.celine.springbootdeveloper.domain.Article;

@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자
@Getter

public class AddArticleRequest {

    private String title;
    private String content;

    // toEntity(): 빌더 패턴으로 DTO를 엔티티로 만들어주는 메서드
    public Article toEntity() { // 생성자를 사용해 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
