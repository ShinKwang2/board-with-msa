package shin.board.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shin.board.article.entity.Article;
import shin.board.article.repository.ArticleRepository;
import shin.board.article.service.request.ArticleCreateRequest;
import shin.board.article.service.request.ArticleSearch;
import shin.board.article.service.request.ArticleUpdateRequest;
import shin.board.article.service.response.ArticlePageResponse;
import shin.board.article.service.response.ArticleResponse;
import shin.board.common.snowflake.Snowflake;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final Snowflake snowflake = new Snowflake();
    private final ArticleRepository articleRepository;

    @Transactional
    public ArticleResponse create(ArticleCreateRequest request) {
        Article article = articleRepository.save(
                Article.create(
                        snowflake.nextId(),
                        request.getTitle(),
                        request.getContent(),
                        request.getBoardId(),
                        request.getWriterId()
                )
        );
        return ArticleResponse.from(article);
    }

    @Transactional
    public ArticleResponse update(Long articleId, ArticleUpdateRequest request) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        article.update(request.getTitle(), request.getContent());
        return ArticleResponse.from(article);
    }

    public ArticleResponse read(Long articleId) {
        return ArticleResponse.from(articleRepository.findById(articleId).orElseThrow());
    }

    @Transactional
    public void delete(Long articleId) {
        articleRepository.deleteById(articleId);
    }

    public ArticlePageResponse readAll(ArticleSearch search) {
        return ArticlePageResponse.of(
                articleRepository.findAll(search.getBoardId(), search.getOffset(), search.getPageSize()).stream()
                        .map(ArticleResponse::from)
                        .toList(),
                articleRepository.count(
                        search.getBoardId(),
                        search.getCountLimit()
                )
        );
    }
}
