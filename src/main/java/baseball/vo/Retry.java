package baseball.vo;

import baseball.consts.ExceptionSentence;
import baseball.exception.ExceptionCaller;
import java.util.Arrays;

public enum Retry {
    CONTINUE(1) {
        @Override
        public boolean ifContinue() {
            return true;
        }
    },
    FINISH(2) {
        @Override
        public boolean ifContinue() {
            return false;
        }
    };

    private final int code;

    Retry(int code) {
        this.code = code;
    }

    public static Retry from(int code) {
        return Arrays.stream(Retry.values())
                .filter(r -> r.code == code)
                .findAny()
                .orElseThrow(() -> ExceptionCaller.throwIllegalArgumentException(ExceptionSentence.NOT_VALIDATED_RETRY_INPUT.getMessage()));
    }

    abstract public boolean ifContinue();
}
