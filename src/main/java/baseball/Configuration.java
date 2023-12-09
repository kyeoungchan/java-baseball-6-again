package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.service.domain.Computer;
import baseball.service.domain.GamePlayer;
import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Configuration {
    public static BaseballController getBaseballController() {
        return new BaseballController(getInputView(), getOutputView(), new BaseballService(getComputer(), getGamePlayer()));
    }

    private static GamePlayer getGamePlayer() {
        return new GamePlayer();
    }

    private static Computer getComputer() {
        return new Computer();
    }

    private static OutputView getOutputView() {
        return new OutputView();
    }

    private static InputView getInputView() {
        return new InputView(getOutputView(), getInputValidator());
    }

    private static InputValidator getInputValidator() {
        return new InputValidator();
    }
}
