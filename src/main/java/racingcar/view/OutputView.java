package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.vo.Car;

public class OutputView {
    public static final String WINNERS_DELIMITER = ", ";
    public static final String WINNER_ANNOUNCE_MESSAGE = "%s가 최종 우승했습니다.";

    public static void printCurrentPosition(final List<Car> cars) {
        cars.forEach(OutputView::printRacingProgress);
        System.out.println();
    }

    private static void printRacingProgress(final Car car) {
        System.out.printf("%s : %s%n", car.getName(), getPositionString(car.getPosition()));
    }

    private static String getPositionString(final int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("-".repeat(Math.max(0, position)));
        return builder.toString();
    }

    public static void printWinner(final List<String> winners) {
        System.out.printf(WINNER_ANNOUNCE_MESSAGE, String.join(WINNERS_DELIMITER, winners));
    }
}
