package baseball.vo;

import baseball.consts.BallStrike;
import java.util.EnumMap;

public record Result(EnumMap<BallStrike, Integer> numbersMatchResult) {
    public int getBallStrikeCount(BallStrike ballStrike) {
        return numbersMatchResult.getOrDefault(ballStrike, 0);
    }
}
