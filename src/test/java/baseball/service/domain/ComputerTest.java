package baseball.service.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.consts.BallStrike;
import baseball.vo.Numbers;
import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComputerTest {
    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("입력한 값에 따라서 스트라이크의 개수를 Result에 담아서 반환한다.")
    void strikeCountTest(List<Integer> gamePlayerNumbers, List<Integer> computerNumbers, int index
    ) {
        List<Integer> strikeResults = List.of(0, 1, 0, 2, 0, 1, 3);
        Assertions.assertRandomNumberInRangeTest(() -> {
                    Computer computer = new Computer();
                    Numbers numbers = new Numbers(gamePlayerNumbers);
                    int calculateCount = computer.generateResult(numbers)
                            .getBallStrikeCount(BallStrike.STRIKE);
                    assertThat(calculateCount).isEqualTo(strikeResults.get(index));
                },
                computerNumbers.get(0),
                computerNumbers.get(1),
                computerNumbers.get(2));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("입력한 값에 따라서 볼의 개수를 Result에 담아서 반환한다.")
    void ballCountTest(List<Integer> gamePlayerNumbers, List<Integer> computerNumbers, int index
    ) {
        List<Integer> ballResults = List.of(0, 0, 1, 0, 3, 2, 0);
        Assertions.assertRandomNumberInRangeTest(() -> {
                    Computer computer = new Computer();
                    Numbers numbers = new Numbers(gamePlayerNumbers);
                    int calculateCount = computer.generateResult(numbers)
                            .getBallStrikeCount(BallStrike.BALL);
                    assertThat(calculateCount).isEqualTo(ballResults.get(index));
                },
                computerNumbers.get(0),
                computerNumbers.get(1),
                computerNumbers.get(2));
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 6), 0), // 0s 0b
                Arguments.of(List.of(1, 2, 3), List.of(1, 4, 5), 1), // 1s 0b
                Arguments.of(List.of(1, 2, 3), List.of(2, 4, 5), 2), // 0s 1b
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 6), 3), // 2s 0b
                Arguments.of(List.of(1, 2, 3), List.of(3, 1, 2), 4), // 3b
                Arguments.of(List.of(1, 2, 3), List.of(1, 3, 2), 5), // 2b, 1s
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 6) // 3s
        );
    }
}