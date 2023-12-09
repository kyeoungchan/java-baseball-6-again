package baseball.controller;

import baseball.consts.BallStrike;
import baseball.consts.ValueConstants;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Numbers;
import baseball.vo.Result;
import java.util.List;
import java.util.function.Supplier;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;

    public BaseballController(InputView inputView, OutputView outputView, BaseballService baseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
    }

    public void run() {
        while (true) {
            List<Integer> inputNumbers = validatingTemplate(inputView::inputNumbers);
            Result result = baseballService.play(new Numbers(inputNumbers));
            if (isThreeStrike(result)) {
                break;
            }
        }
    }

    private boolean isThreeStrike(Result result) {
        return result.numbersMatchResult().get(BallStrike.STRIKE)
                == ValueConstants.ALL_STRIKE.getValue();
    }

    private <T> T validatingTemplate(Supplier<T> callback) {
        while (true) {
            try {
                return callback.get();
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }
}
