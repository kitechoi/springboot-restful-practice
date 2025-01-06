package me.celine.springbootdeveloper.repository;

import me.celine.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

// BlogRepository 인터페이스
// JpaRepository 클래스를 상속받을 때 <엔티티 Article, 이 엔티티의 PK 타입인 Long>를 인수로 넣음.

public interface BlogRepository extends JpaRepository<Article, Long> {
}
