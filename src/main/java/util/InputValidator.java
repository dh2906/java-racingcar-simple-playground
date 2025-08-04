package util;

import exception.ErrorMessage;

import java.util.List;

public class InputValidator {

    public static void validateNames(List<String> names) {
        for (String name : names) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME);
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
            }
        }
    }

    public static int validateTimes(int times) {
        if (times < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_ATTEMPT_COUNT);
        }

        return times;
    }
}
