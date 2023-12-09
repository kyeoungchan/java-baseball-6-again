package baseball.controller;

import baseball.consts.BallStrike;
import baseball.consts.ValueConstants;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Numbers;
import baseball.vo.Result;
import baseball.vo.Retry;
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
        do {
            beforeGame();
            playGame();
        } while (ifRetry());
    }

    private void beforeGame() {
        outputView.announceGame();
        baseballService.startGame();
    }

    private boolean ifRetry() {
        Retry retry = validatingTemplate(inputView::inputRetry);
        return retry.ifContinue();
    }

    private void playGame() {
        while (true) {
            Numbers inputNumbers = validatingTemplate(inputView::inputNumbers);
            Result result = baseballService.play(inputNumbers);
            outputView.printResult(result);
            if (isThreeStrike(result)) {
                outputView.printFinalizeGame();
                break;
            }
        }
    }

    private boolean isThreeStrike(Result result) {
        return result.getBallStrikeCount(BallStrike.STRIKE)
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
