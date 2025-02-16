package shin.board.article.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shin.board.article.service.ArticleService;
import shin.board.article.service.request.ArticleCreateRequest;
import shin.board.article.service.request.ArticleUpdateRequest;
import shin.board.article.service.response.ArticleResponse;

@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/v1/articles/{articleId}")
    public ArticleResponse read(@PathVariable Long articleId) {
        return articleService.read(articleId);
    }

    @PostMapping("/v1/articles")
    public ArticleResponse create(@RequestBody ArticleCreateRequest request) {
        return articleService.create(request);
    }

    @PutMapping("/v1/articles/{articleId}")
    public ArticleResponse update(@PathVariable Long articleId, @RequestBody ArticleUpdateRequest request) {
        return articleService.update(articleId, request);
    }

    @DeleteMapping("/v1/articles/{articleId}")
    public void delete(@PathVariable Long articleId) {
        articleService.delete(articleId);
    }
}
