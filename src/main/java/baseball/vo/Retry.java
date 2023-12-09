package baseball.vo;

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

    public boolean kidsOf(int code) {
        return this.code == code;
    }

    abstract public boolean ifContinue();
}
