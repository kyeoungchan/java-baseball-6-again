package baseball.service;

import baseball.service.domain.Computer;
import baseball.service.domain.GamePlayer;
import baseball.vo.Numbers;
import baseball.vo.Result;

public class BaseballService {
    private Computer computer;
    private final GamePlayer gamePlayer;

    public BaseballService(Computer computer, GamePlayer gamePlayer) {
        this.computer = computer;
        this.gamePlayer = gamePlayer;
    }

    public void startGame() {
        computer = new Computer();
    }

    public Result play(Numbers inputtedNumbers) {
        setGamePlayerNumbers(inputtedNumbers);
        Numbers gamePlayerNumbers = gamePlayer.getNumbers();
        return computer.generateResult(gamePlayerNumbers);
    }

    private void setGamePlayerNumbers(Numbers inputtedNumbers) {
        gamePlayer.inputNumbers(inputtedNumbers);
    }
}
