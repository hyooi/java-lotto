# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
- [ ] 6개 숫자를 가질 수 있는 로또티켓 클래스를 생성한다. 6개를 넘어가면 IllegalArgumentException을 발생시킨다.
- [ ] client에게 구입 금액을 받는 로또판매기계 클래스를 생성한다. 구입 가능한 티켓을 생성해서 반환한다.
- [ ] 입력받은 구입 금액이 숫자가 아니거나(NumberFormatException), 0미만인 경우(IllegalArgumentException) 예외를 발생시킨다.
- [ ] client에게 당첨번호와 구매한 티켓 리스트를 받는 로또매니저 클래스를 생성한다. 당첨 통계 내역을 만들어 반환한다.
- [ ] 입력받은 당첨번호가 숫자가 아니거나(NumberFormatException), 6개가 아니면(IllegalArgumentException) 예외를 발생시킨다.
- [ ] 보너스 번호가 숫자가 아니면(NumberFormatException) 예외를 발생시킨다.