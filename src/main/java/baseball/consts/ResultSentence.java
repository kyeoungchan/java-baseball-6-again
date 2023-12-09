package baseball.consts;

import baseball.exception.ExceptionCaller;
import baseball.vo.Result;
import java.util.Arrays;

public enum ResultSentence {
    ONLY_BALL("%d볼") {
        @Override
        boolean isApplied(int strikeCount, int ballCount) {
            return strikeCount == 0 && ballCount != 0;
        }

        @Override
        String getMessage(int strikeCount, int ballCount) {
            return String.format(this.getMessage(), ballCount);
        }
    },
    ONLY_STRIKE("%d스트라이크") {
        @Override
        boolean isApplied(int strikeCount, int ballCount) {
            return strikeCount != 0 && ballCount == 0;
        }

        @Override
        String getMessage(int strikeCount, int ballCount) {
            return String.format(this.getMessage(), strikeCount);
        }
    },
    BALL_AND_STRIKE("%d볼 %d스트라이크") {
        @Override
        boolean isApplied(int strikeCount, int ballCount) {
            return strikeCount != 0 && ballCount != 0;
        }

        @Override
        String getMessage(int strikeCount, int ballCount) {
            return String.format(this.getMessage(), ballCount, strikeCount);
        }
    },
    NOTHING("낫싱") {
        @Override
        boolean isApplied(int strikeCount, int ballCount) {
            return strikeCount == 0 && ballCount == 0;
        }

        @Override
        String getMessage(int strikeCount, int ballCount) {
            return this.getMessage();
        }
    };

    private final String message;

    ResultSentence(String message) {
        this.message = message;
    }

    public static String generateSentence(Result result) {
        return Arrays.stream(ResultSentence.values())
                .filter(resultSentence -> resultSentence.isApplied(
                        result.getBallStrikeCount(BallStrike.STRIKE),
                        result.getBallStrikeCount(BallStrike.BALL)
                ))
                .map(s -> s.getMessage(
                        result.getBallStrikeCount(BallStrike.STRIKE),
                        result.getBallStrikeCount(BallStrike.BALL)
                ))
                .findAny()
                .orElseThrow(() ->
                        ExceptionCaller.throwIllegalArgumentException(ExceptionSentence.UN_EXPECTED.getMessage()));
    }

    abstract boolean isApplied(int strikeCount, int ballCount);

    abstract String getMessage(int strikeCount, int ballCount);

    public String getMessage() {
        return message;
    }
}
