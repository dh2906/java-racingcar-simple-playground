import model.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    public void 자동차가_정상적으로_움직이는지_테스트() {
        Car car = new Car("Car");

        car.move(4);

        assertThat(car.getPos()).isEqualTo(1);
    }

    @Test
    public void 자동차가_정상적으로_정지하는지_테스트() {
        Car car = new Car("Car");

        car.move(0);

        assertThat(car.getPos()).isEqualTo(0);
    }
}
