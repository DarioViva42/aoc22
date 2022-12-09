package vivas.tk.adventofcode.day09;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.Instant;

import static vivas.tk.adventofcode.GeneralUtils.readPuzzleInput;
import static vivas.tk.adventofcode.GeneralUtils.sendPuzzleAnswer;

public class Day09 {

    private static final Logger LOGGER = LogManager.getLogger(Day09.class);

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        String input = readPuzzleInput();

        Instant start = Instant.now();

        RopeSimulation ropeSimulation = new RopeSimulation(input);

        Instant parseEnd = Instant.now();

        int partOneAnswer = ropeSimulation.runSimulation();

        Instant betweenParts = Instant.now();

        // int partTwoAnswer = ropeSimulation.runSimulation();

        Instant end = Instant.now();

        System.out.println(sendPuzzleAnswer(1, partOneAnswer));
        // System.out.println(sendPuzzleAnswer(2, partTwoAnswer));

        LOGGER.info("parsing: {}ms", Duration.between(start, parseEnd).toMillis());
        LOGGER.info("part 1: {}ms", Duration.between(parseEnd, betweenParts).toMillis());
        LOGGER.info("part 2: {}ms", Duration.between(betweenParts, end).toMillis());
        LOGGER.info("total: {}ms", Duration.between(start, end).toMillis());
    }
}