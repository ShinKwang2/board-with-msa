package shin.board.article.consts;

public final class ArticleConstants {

    public static final Long DEFAULT_BOARD_ID = 1L;
    public static final Long DEFAULT_PAGE = 1L;
    public static final Long DEFAULT_PAGE_SIZE = 30L;

    public static final Long MAX_PAGE_SIZE = 100L;
    public static final Long MOVABLE_PAGE_COUNT = 10L;

    private ArticleConstants() {
        // 의도적으로 인스턴스화되지 않도록 명시적으로 선언
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
