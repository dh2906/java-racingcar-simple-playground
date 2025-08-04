import exception.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.InputValidator;
import util.NameParser;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @ParameterizedTest
    @MethodSource("provideEmptyCarNames")
    public void 이름이_비어있는_경우_예외를_발생한다(List<String> names) {
        assertThatThrownBy(() -> InputValidator.validateNames(names))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageContaining(ErrorMessage.EMPTY_CAR_NAME);
    }

    @ParameterizedTest
    @MethodSource("provideOverLengthCarNames")
    public void 이름이_5자를_초과한_경우_예외를_발생한다(List<String> names) {
        assertThatThrownBy(() -> InputValidator.validateNames(names))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_LENGTH);
    }

    @Test
    public void 횟수에_음수를_입력받은_경우_예외를_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateTimes(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NEGATIVE_ATTEMPT_COUNT);
    }

    static Stream<List<String>> provideEmptyCarNames() {
        return Stream.of(
                NameParser.parse("neo"),
                NameParser.parse(" "),
                NameParser.parse("  ")
        );
    }

    static Stream<List<String>> provideOverLengthCarNames() {
        return Stream.of(
                NameParser.parse("asd,qweqwe"),
                NameParser.parse("qwerty,ads")
        );
    }
}
