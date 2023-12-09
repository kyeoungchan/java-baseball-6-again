package baseball.consts;

public enum ValueConstants {
    ALL_STRIKE(3),
    NUMBERS_CIPHERS(3),
    START_INCLUSIVE(1),
    END_INCLUSIVE(9),
    RETRY_CIPHER(1);

    private final int value;

    ValueConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
