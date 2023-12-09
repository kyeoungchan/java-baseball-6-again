package baseball.view;

import baseball.consts.ResultSentence;
import baseball.consts.Sentence;
import baseball.vo.Result;

public class OutputView {
    public void announceGame() {
        System.out.println(Sentence.GAME_START.getMessage());
    }

    public void printLeadInputNumbers() {
        System.out.print(Sentence.INPUT_NUMBERS.getMessage());
    }

    public void printResult(Result result) {
        String resultSentence = ResultSentence.generateSentence(result);
        System.out.println(resultSentence);
    }

    public void printLeadInputRetry() {
        System.out.println(Sentence.INPUT_RETRY.getMessage());
    }

    public void printFinalizeGame() {
        System.out.println(Sentence.FINALIZE_GAME.getMessage());
    }

    public void printException(String message) {
        System.out.println(message);
    }
}
