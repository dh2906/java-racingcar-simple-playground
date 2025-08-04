package controller;

import model.Car;
import model.Cars;
import util.NameParser;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingGameController {

    private final Cars cars = new Cars();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        String nameStr = inputView.inputNames();
        joinCars(nameStr);

        int times = inputView.inputTimes();

        outputView.printExecuteResult();

        for (int i = 0; i < times; i++) {
            cars.moveCars();
            outputView.printProgress(cars.getCarList());
        }

        outputView.printWinners(cars.getWinners());
    }

    public void joinCars(String nameStr) {
        List<String> names = NameParser.parse(nameStr);

        names.forEach(name ->
                cars.join(new Car(name))
        );
    }
}
