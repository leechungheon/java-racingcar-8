# 프리코스 - 2주차 과제

### **👉입력조건**

- 자동차 입력
    - 2대 이상 입력해야 한다.
    - 자동차는 쉼표(,)로 구분되어 입력해야 한다.
    - 잘못된 위치의 쉼표(,)는 허용되지 않는다. ~~(pobi,woni,jun,)~~
    - 자동차의 이름은 5글자 이하만 허용된다.
    - 자동차 이름은 중복이 불가능하다.
    - 이름에 공백은 허용하지 않는다.~~(pobi,woni,  jun)~~

    ```
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    ```

- 횟수 입력
    - 횟수는 양의 정수로 입력해야 한다.

    ```
    시도할 횟수는 몇 회인가요?
    5
    ```


### 👉기능

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

### 👉출력조건

- 결과문 출력
    - 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    - 전진 시마다 하이픈(-)이 추가된다.
    - 최종 우승자는 1명 이상일 수 있다.
    - 여러 명일 경우, 자동차를 쉼표(,)로 구분지어 출력한다.

        ```
        경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
        pobi,woni,jun
        시도할 횟수는 몇 회인가요?
        5
        
        실행 결과
        pobi : -
        woni :
        jun : -
        
        pobi : --
        woni : -
        jun : --
        
        pobi : ---
        woni : --
        jun : ---
        
        pobi : ----
        woni : ---
        jun : ----
        
        pobi : -----
        woni : ----
        jun : -----
        
        최종 우승자 : pobi, jun
        ```


### 💥추가한 예외사항

- 자동차 이름이 같은 경우는 허용하지 않는다.
- 자동차 이름 입력 시 공백은 허용하지 않는다. (pobi, woni,jun)
- 자동차는 2대 이상이어야 한다.
- 잘못된 구분자 위치는 허용하지 않는다. (pobi,woni,jun,)
- 시도할 횟수는 양의 정수만 허용한다.
- 모든 자동차가 0칸 이동 시, 모든 자동차가 우승한다.

### ✔️공통 피드백

- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- Java에서 제공하는 API를 적극 활용한다.
- 배열 대신 컬렉션을 사용한다.
- 좋은 메서드명을 사용해 의미없는 주석 사용을 줄이자.
- 공백을 의미있게 사용하자.
- 오류를 찾을 때 출력 함수 대신 디버거를 사용한다.
    - [[10분 테코톡] 웨지의 인텔리제이 디버깅](https://youtu.be/gkutTlwi70s)
    - [[10분 테코톡] 오리의 Intellij Debugging](https://youtu.be/JSVvhwwOvAY)
    - [[10분 테코톡] 몰리의 디버깅](https://youtu.be/leIwlemLWNc)
    - [Debugging in Visual Studio Code](https://code.visualstudio.com/docs/editor/debugging)
- 기본적인 Git 명령어를 숙지한다.
    - [[10분 깃코톡] 와일더의 Git Commands](https://youtu.be/JsRD2AWxxFg)
    - [[10분 테코톡] 주노의 git commands](https://youtu.be/6hdr9PI-3Mg)
    - [[10분 테코톡] 망쵸의 유용한 Git 명령어](https://youtu.be/jXtUUm92RiQ)
    - [[10분 테코톡] 해시, 다르의 깃 명령어 동작 원리](https://youtu.be/N4hIR6XDKQo)
- 좋은 코드리뷰를 위해 의미있게 커밋메시지를 작성한다.
    - [좋은 git 커밋 메시지를 작성하기 위한 7가지 약속](https://meetup.toast.com/posts/106)

### 📢프로그래밍 요구사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
        - [AssertJ User Guide](https://assertj.github.io/doc)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)