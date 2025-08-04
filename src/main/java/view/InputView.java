package view;

import exception.ErrorMessage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    Scanner sc = new Scanner(System.in);

    public String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return sc.nextLine();
    }

    public int inputTimes() {
        System.out.println("시도할 회수는 몇회인가요?");

        try {
            return sc.nextInt();
        } catch (InputMismatchException ex) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
