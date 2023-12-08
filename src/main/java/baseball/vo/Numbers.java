package baseball.vo;

import java.util.List;

public class Numbers {
    List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
