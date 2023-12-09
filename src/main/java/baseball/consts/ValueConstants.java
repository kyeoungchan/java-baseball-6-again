package baseball.consts;

public enum ValueConstants {
    ALL_STRIKE(3),
    NUMBER_CIPHERS(3),
    START_INCLUSIVE(1),
    END_INCLUSIVE(9);

    private final int value;

    ValueConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
