package shin.board.article.service.request;

import lombok.Getter;
import lombok.ToString;
import shin.board.article.consts.ArticleConstants;
import shin.board.article.service.PageCalculator;

@Getter
@ToString
public class ArticleSearch {

    private Long boardId;
    private Long page;
    private Long pageSize;

    public ArticleSearch(Long boardId, Long page, Long pageSize) {
        this.boardId = boardId == null ? ArticleConstants.DEFAULT_BOARD_ID : boardId;
        this.page = page == null ? ArticleConstants.DEFAULT_PAGE : page;
        this.pageSize = pageSize == null ? ArticleConstants.DEFAULT_PAGE_SIZE : pageSize;
    }

    public Long getOffset() {
        return (Math.max(1L, page) - 1) * Math.min(pageSize, ArticleConstants.MAX_PAGE_SIZE);
    }

    public Long getCountLimit() {
        return PageCalculator.calculatePageLimit(page, pageSize, ArticleConstants.MOVABLE_PAGE_COUNT);
    }
}
