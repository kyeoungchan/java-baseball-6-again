package baseball.consts;

public enum PatternRegex {
    NUMBERS("\\d*"),
    SINGLE_NUMBER("\\d");

    private final String regex;

    PatternRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
