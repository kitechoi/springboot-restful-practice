package me.celine.springbootdeveloper.dto;

// dto/UpdateArticleRequest
// 글 수정을 요청 받을 dto
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateArticleRequest {
    private String title;
    private String content;
}
