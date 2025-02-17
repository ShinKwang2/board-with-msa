package shin.board.article.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageCalculator {

    // (((N - 1) / K) + 1) * M * K + 1
    public static Long calculatePageLimit(Long page, Long pageSize, Long movablePageCount) {
        return ((page - 1) / movablePageCount + 1) * pageSize * movablePageCount + 1;
    }
}
