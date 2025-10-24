package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readCarNames() {
        return Console.readLine();
    }
    public int readTryCount() {
        String input = Console.readLine();
        try{
            int number = Integer.parseInt(input);
            if (number <= 0) {
                throw new IllegalArgumentException("양의 정수만 입력할 수 있습니다.");
            }
            return number;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
