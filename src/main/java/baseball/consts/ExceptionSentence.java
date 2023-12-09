package baseball.consts;

public enum ExceptionSentence {
    ERROR_CODE("[ERROR] "),
    NOT_VALIDATED_RETRY_INPUT("1 또는 2를 입력해주세요.");

    private final String message;

    ExceptionSentence(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
