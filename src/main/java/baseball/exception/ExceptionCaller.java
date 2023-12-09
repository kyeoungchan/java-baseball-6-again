package baseball.exception;

import baseball.consts.ExceptionSentence;

public class ExceptionCaller {
    public static IllegalArgumentException throwIllegalArgumentException(String message) {
        String generateMessage = generateErrorMessage(message);
        return new IllegalArgumentException(generateMessage);
    }

    public static IllegalArgumentException throwIllegalArgumentException(String message, Throwable t) {
        String generateMessage = generateErrorMessage(message);
        return new IllegalArgumentException(generateMessage, t);
    }

    private static String generateErrorMessage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(ExceptionSentence.ERROR_CODE.getMessage());
        sb.append(message);
        return sb.toString();
    }
}
