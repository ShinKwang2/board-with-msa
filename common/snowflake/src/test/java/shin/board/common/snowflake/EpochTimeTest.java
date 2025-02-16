package shin.board.common.snowflake;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class EpochTimeTest {

    @Test
    void getEpochTime() throws Exception {
        ZonedDateTime targetDate = ZonedDateTime.of(2025, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC"));

        // Unix 타임스탬프를 초 단위로 계산
        long epochTimeSeconds = targetDate.toInstant().getEpochSecond();

        // 밀리초 단위로 변환
        long epochTimeMillis = epochTimeSeconds * 1000;

        System.out.println(epochTimeMillis);
    }
}
