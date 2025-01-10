package me.celine.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 생성자 대체
public class Article {

    // 필드들
    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)   // 'title'이라는 not null 칼럼과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    //
    @Builder // 빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // domain.Article
    // 글 수정 메서드 (엔티티에 요청받은 내용으로 값을 수정하는 메서드)
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}