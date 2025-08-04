package util;

import java.util.List;

public class InputValidator {

    public static void validateNames(List<String> names) {
        for (String name : names) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static int validateAndGetTimes(String strTimes) {
        int times;

        try {
            times = Integer.parseInt(strTimes);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력되었습니다.");
        }

        if (times < 0) {
            throw new IllegalArgumentException("시도 횟수에 음수가 입력되었습니다.");
        }

        return times;
    }
}
