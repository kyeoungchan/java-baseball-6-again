package baseball.view;

import baseball.consts.Sentence;

public class OutputView {
    public void printException(String message) {
        System.out.println(message);
    }

    public void printLeadInputNumbers() {
        System.out.print(Sentence.INPUT_NUMBERS);
    }

    public void printLeadInputRetry() {
        System.out.println(Sentence.INPUT_RETRY);
    }
}
