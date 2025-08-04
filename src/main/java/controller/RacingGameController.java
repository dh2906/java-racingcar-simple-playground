package controller;

import model.Car;
import model.Cars;
import util.InputValidator;
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
        List<String> names = parseName(nameStr);

        InputValidator.validateNames(names);
        joinCars(names);

        int times = InputValidator.validateAndGetTimes(inputView.inputTimes());

        outputView.printExecuteResult();

        for (int i = 0; i < times; i++) {
            cars.moveCars();
            outputView.printProgress(cars.getCarList());
        }

        outputView.printWinners(cars.getWinners());
    }

    public void joinCars(List<String> names) {
        names.forEach(name ->
                cars.join(new Car(name))
        );
    }

    private List<String> parseName(String nameStr) {
        return NameParser.parse(nameStr);
    }


}
