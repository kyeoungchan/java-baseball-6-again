package baseball.consts;

public enum ValueConstants {
    ALL_STRIKE(3);

    private final int value;

    ValueConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
