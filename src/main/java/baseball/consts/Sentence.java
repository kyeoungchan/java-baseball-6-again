package baseball.consts;

public enum Sentence {
    INPUT_NUMBERS("숫자를 입력해주세요 : ");

    private final String message;

    Sentence(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
