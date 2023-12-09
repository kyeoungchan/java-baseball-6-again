package baseball.service.domain;

import baseball.vo.Numbers;

/**
 * 현재 요구사항에서는 GamePlayer 의 역할이 크게 필요하지 않지만 확장 가능성에 대응하기 위한 도메인
 */
public class GamePlayer {
    private Numbers numbers;

    public void inputNumbers(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
