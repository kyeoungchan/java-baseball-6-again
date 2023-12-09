package baseball.view;

import baseball.validator.InputValidator;
import baseball.vo.Numbers;
import baseball.vo.Retry;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public InputView(OutputView outputView, InputValidator inputValidator) {
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public Numbers inputNumbers() {
        outputView.printLeadInputNumbers();
        String inputData = Console.readLine().trim();
        List<Integer> numbersData = inputValidator.convertNumbers(inputData);
        return new Numbers(numbersData);
    }

    public Retry inputRetry() {
        outputView.printLeadInputRetry();
        String retryData = Console.readLine().trim();
        return inputValidator.convertRetry(retryData);
    }
}
