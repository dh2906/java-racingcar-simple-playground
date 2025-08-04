package view;

import model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printExecuteResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printProgress(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPos()));
        }

        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNameStr = winners.stream()
                                       .map(Car::getName)
                                       .collect(Collectors.joining(", "));

        System.out.println(winnerNameStr + "가 최종 우승했습니다.");
    }
}
