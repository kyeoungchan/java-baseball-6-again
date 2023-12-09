package baseball.consts;

public enum Sentence {
    INPUT_NUMBERS("숫자를 입력해주세요 : "),
    INPUT_RETRY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    Sentence(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
