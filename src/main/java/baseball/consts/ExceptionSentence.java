package baseball.consts;

public enum ExceptionSentence {
    ERROR_CODE("[ERROR] "),
    NOT_VALIDATED_RETRY_INPUT("1 또는 2를 입력해주세요."),
    TOO_LONG_INPUTTED("자릿수보다 너무 많이 입력하셨습니다."),
    TOO_SHORT_INPUTTED("자릿수보다 너무 적게 입력하셨습니다."),
    EMPTY_INPUTTED("입력해주세요.."),
    NOT_NUMBERS("숫자로 입력해주세요."),
    NOT_IN_RANGE("1~9 사이의 숫자만 입력해주시기 바랍니다."),
    DUPLICATED("숫자는 중복되지 않게 입력해주셔야 합니다.");

    private final String message;

    ExceptionSentence(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
