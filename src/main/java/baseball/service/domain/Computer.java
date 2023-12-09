package baseball.service.domain;

import baseball.consts.BallStrike;
import baseball.consts.NumberIndexes;
import baseball.consts.ValueConstants;
import baseball.vo.Numbers;
import baseball.vo.Result;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Computer {
    private final Numbers numbers;

    public Computer() {
        this.numbers = new Numbers(generateNumbers());
    }

    private List<Integer> generateNumbers() {
        List<Integer> newNumbers = new ArrayList<>();
        while (newNumbers.size() < ValueConstants.NUMBER_CIPHERS.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(
                    ValueConstants.START_INCLUSIVE.getValue(),
                    ValueConstants.END_INCLUSIVE.getValue()
            );
            if (!newNumbers.contains(randomNumber)) {
                newNumbers.add(randomNumber);
            }
        }
        return newNumbers;
    }

    public Result generateResult(Numbers gamePlayerNumbers) {
        return new Result(calculateMatch(gamePlayerNumbers));
    }

    private EnumMap<BallStrike, Integer> calculateMatch(Numbers gamePlayerNumbers) {
        EnumMap<BallStrike, Integer> ballStrikeResults = new EnumMap<>(BallStrike.class);
        List<Integer> gamePlayerNumbersValue = gamePlayerNumbers.getNumbers();
        List<Integer> computerNumbers = numbers.getNumbers();

        NumberIndexes.indexes.forEach(i -> {
            if (isStrike(gamePlayerNumbersValue, computerNumbers, i)) {
                addBallStrike(ballStrikeResults, BallStrike.STRIKE);
            }
            if (isBall(gamePlayerNumbersValue, computerNumbers, i)) {
                addBallStrike(ballStrikeResults, BallStrike.BALL);
            }
        });
        return ballStrikeResults;
    }

    private void addBallStrike(EnumMap<BallStrike, Integer> ballStrikeResults, BallStrike ballStrike) {
        ballStrikeResults.put(ballStrike, ballStrikeResults.getOrDefault(ballStrike, 0) + 1);
    }

    private boolean isStrike(List<Integer> gamePlayerNumbers, List<Integer> computerNumbers, int index) {
        return gamePlayerNumbers.get(index).equals(computerNumbers.get(index));
    }

    private boolean isBall(List<Integer> gamePlayerNumbers, List<Integer> computerNumbers, int index) {
        return !isStrike(gamePlayerNumbers, computerNumbers, index)
                && computerNumbers.contains(gamePlayerNumbers.get(index));
    }
}
