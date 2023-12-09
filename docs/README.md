# 미션 - 숫자 야구 프로젝트

## 기능 목록
- [x] `Computer` 도메인은 `GamePlayer`로부터 숫자 정보를 받아 볼과 스트라이크를 카운트한다.
- [x] 3스트라이크가 나오면 게임을 종료하고 그 외의 결과가 나오면 계속 게임을 실행한다.
- [x] `Computer` 도메인은 세 자리 숫자를 랜덤으로 생성한다.
- [x] `Retry` 도메인은 게임을 계속 진행할지 여부를 입력받은 값에 따라서 판단한다.
- [x] `GamePlayer` 도메인이 세 자리 숫자를 입력할 때, 포맷에 맞게 입력했는지 검증한다.
- [ ] 게임을 계속 진행할지 여부를 입력할 때 포맷에 맞게 입력했는지 검증한다.

## 도메인 모델
### Numbers
1. status
   - List<Integer> numberData
2. behavior
   - void validate(List<Integer> numberData)
   - List<Integer> getNumberData()

### GamePlayer
1. status
   - Numbers numbers
2. behavior
   - void inputNumbers(Numbers numbers)
   - Numbers getNumbers()

### Computer
1. status
   - Numbers numbers
2. behavior
   - List<Integer> generateNumbers()
   - Result generateResult(Numbers gamePlayerNumbers)
   - EnumMap<BallStrike, Integer> calculateMatch(Numbers gamePlayerNumbers) 

### BallStrike
1. status
   - BALL
   - STRIKE

### Result
1. status
   - EnumMap<BallStrike, Integer> numbersMatchResult
2. behavior
   - EnumMap<BallStrike, Integer> getNumberMatchResult()

### Retry
1. status
2. behavior
   - validate(int number)
   - boolean ifContinue()