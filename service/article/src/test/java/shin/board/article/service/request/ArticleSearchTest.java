package shin.board.article.service.request;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import shin.board.article.consts.ArticleConstants;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ArticleSearchTest {

    @Test
    void articleSearchParamTest() {
        articleSearchParamTest(1L, 1L, 1L, 1L, 1L, 1L);
        articleSearchParamTest(null, null, null, ArticleConstants.DEFAULT_BOARD_ID, ArticleConstants.DEFAULT_PAGE, ArticleConstants.DEFAULT_PAGE_SIZE);
        articleSearchParamTest(100L, -1L, 300L, 100L, -1L, 300L);
    }

    void articleSearchParamTest(Long boardId, Long page, Long pageSize, Long expectedBoardId, Long expectedPage, Long expectedPageSize) {
        ArticleSearch articleSearch = new ArticleSearch(boardId, page, pageSize);
        assertThat(articleSearch.getBoardId()).isEqualTo(expectedBoardId);
        assertThat(articleSearch.getPage()).isEqualTo(expectedPage);
        assertThat(articleSearch.getPageSize()).isEqualTo(expectedPageSize);
    }

    @Test
    void articleSearchOffsetTest() {
        articleSearchOffsetTest(1L, -1L, 10L, (1L - 1L) * 10L);
        articleSearchOffsetTest(1L, -10000L, 10L, (1L - 1L) * 10L);
        articleSearchOffsetTest(1L, 2L, 1000L, (2L - 1) * ArticleConstants.MAX_PAGE_SIZE);
    }

    void articleSearchOffsetTest(Long boardId, Long page, Long pageSize, Long expectedOffset) {
        ArticleSearch articleSearch = new ArticleSearch(boardId, page, pageSize);
        assertThat(articleSearch.getOffset()).isEqualTo(expectedOffset);
    }

}