package baseball.view;

import baseball.consts.Sentence;
import baseball.validator.InputValidator;
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
}
