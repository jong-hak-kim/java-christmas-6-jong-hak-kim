# 미션 - 크리스마스 프로모션

## 🔍 기능 구현 목록
- [x] 날짜 입력 폼 출력
- [x] 예외 사항
    - [x] 입력 값이 1 이상 31 이하인가?
    - [x] 입력 값이 숫자인가?
    - [x] 아무 입력이 안 된 경우

- [x] 주문할 메뉴 개수 입력 폼 출력
- [x] 예외 사항
    - [x] 메뉴판에 없는 메뉴일 경우("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    - [x] 1 미만의 개수를 입력했을 경우("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    - [x] 메뉴 형식에 안 맞을 경우("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    - [x] 중복 메뉴가 있을 경우("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    - [x] 음료만 주문하였을 경우
    - [x] 메뉴 개수가 20개 이상일 경우
    - [x] 아무 입력이 안 된 경우

- [ ] 이벤트 혜택

    - [x] 이벤트 대상 확인
        - [x] 할인 전 총 주문 금액이 10,000원 이상인지 확인

    - [x] 크리스마스 디데이 할인
	- [x] 크리스마스 디데이 기간 여부 확인
        - [x] 남은 디데이에 따라 100원씩 할인 금액 증가

    - [x] 증정 이벤트
        - [x] 할인 전 총 주문 금액이 12만 원 이상인지 확인

    - [x] 평일 할인, 주말 할인 여부 확인
        - [x] 평일 할인(일요일 ~ 목요일)
            - [x] 주문에 디저트 메뉴 존재 여부 확인
            - [x] 디저트 메뉴 1개당 2,023원씩 할인
        - [x] 주말 할인(금요일 ~ 토요일)
            - [x] 주문에 메인 메뉴 존재 여부 확인
            - [x] 메인 메뉴 1개당 2,023원씩 할인

    - [x] 특별 할인(달력에 별 있는 날 : 3일, 10일, 17일, 24일, 25일, 31일)
        - [x] 고객이 위에 해당하는 날을 선택하였는지 확인
	- [x] 총 주문 금액에서 1,000원 할인

    - [x] 이벤트 배지
        - [x] 혜택 금액 총합이 각 조건에 맞는지 확인
    

- [x] 주문 받은 메뉴 출력
- [x] 할인 전 총주문 금액 출력
- [x] 증정 메뉴 출력
- [x] 혜택 내역 출력
- [x] 총혜택 금액 출력
- [x] 할인 후 예상 결제 금액 출력
- [x] 12월 이벤트 배지 출력


## 🗂️ 디렉터리 구조
📦src<br/>
 ┣ 📂main<br/>
 ┃ ┗ 📂java<br/>
 ┃ ┃ ┗ 📂christmas<br/>
 ┃ ┃ ┃ ┣ 📂constant<br/>
 ┃ ┃ ┃ ┃ ┗ 📜ConstantMessage.java<br/>
 ┃ ┃ ┃ ┣ 📂controller<br/>
 ┃ ┃ ┃ ┃ ┗ 📜ChristmasController.java<br/>
 ┃ ┃ ┃ ┣ 📂exception<br/>
 ┃ ┃ ┃ ┃ ┗ 📜ErrorMessage.java<br/>
 ┃ ┃ ┃ ┣ 📂model<br/>
 ┃ ┃ ┃ ┃ ┣ 📜Event.java<br/>
 ┃ ┃ ┃ ┃ ┣ 📜Food.java<br/>
 ┃ ┃ ┃ ┃ ┣ 📜FoodBuilder.java<br/>
 ┃ ┃ ┃ ┃ ┣ 📜Menu.java<br/>
 ┃ ┃ ┃ ┃ ┗ 📜Order.java<br/>
 ┃ ┃ ┃ ┣ 📂parser<br/>
 ┃ ┃ ┃ ┃ ┗ 📜Parser.java<br/>
 ┃ ┃ ┃ ┣ 📂validate
 ┃ ┃ ┃ ┃ ┗ 📜InputValidate.java<br/>
 ┃ ┃ ┃ ┣ 📂view<br/>
 ┃ ┃ ┃ ┃ ┣ 📜InputView.java<br/>
 ┃ ┃ ┃ ┃ ┗ 📜OutputView.java<br/>
 ┃ ┃ ┃ ┗ 📜Application.java<br/>
 ┗ 📂test<br/>
 ┃ ┗ 📂java<br/>
 ┃ ┃ ┗ 📂christmas<br/>
 ┃ ┃ ┃ ┣ 📂model<br/>
 ┃ ┃ ┃ ┃ ┗ 📜EventTest.java<br/>
 ┃ ┃ ┃ ┣ 📂parser<br/>
 ┃ ┃ ┃ ┃ ┗ 📜ParserTest.java<br/>
 ┃ ┃ ┃ ┣ 📂view<br/>
 ┃ ┃ ┃ ┃ ┗ 📜InputViewTest.java<br/>
 ┃ ┃ ┃ ┗ 📜ApplicationTest.java<br/>
