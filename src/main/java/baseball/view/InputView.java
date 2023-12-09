package baseball.view;

import baseball.validator.InputValidator;
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

    public List<Integer> inputNumbers() {
        outputView.printLeadInputNumbers();
        String inputData = Console.readLine();
        return inputValidator.convertNumbers(inputData);
    }

    public Retry inputRetry() {
        outputView.printLeadInputRetry();
        String retryData = Console.readLine();
        return inputValidator.convertRetry(retryData);
    }
}
