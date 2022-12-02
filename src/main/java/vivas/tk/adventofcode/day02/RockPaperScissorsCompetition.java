package vivas.tk.adventofcode.day02;

import java.util.List;

public class RockPaperScissorsCompetition {

    private final List<String> input;

    public RockPaperScissorsCompetition(List<String> input) {
        this.input = input;
    }

    public int calculateScore() {
        return input.stream()
                .mapToInt(round -> {
                    HandShape opponent = HandShape.ofCharacter(round.charAt(0));
                    HandShape me = HandShape.ofCharacter(round.charAt(2));

                    return calculateScore(opponent, me);
                })
                .sum();
    }

    public int calculateCorrectScore() {
        return input.stream()
                .mapToInt(round -> {
                    HandShape opponent = HandShape.ofCharacter(round.charAt(0));
                    Strategy strategy = Strategy.ofCharacter(round.charAt(2));

                    return switch (strategy) {
                        case LOOSE -> calculateScore(opponent, opponent.getLoosingHandShape());
                        case DRAW -> calculateScore(opponent, opponent);
                        case WIN -> calculateScore(opponent, opponent.getWinningHandShape());
                    };
                })
                .sum();
    }

    private int calculateScore(HandShape opponent, HandShape me) {
        int score = me.getScore();

        if (opponent.equals(me)) {
            score += 3;
        }
        if (me.winsAgainst(opponent)) {
            score += 6;
        }
        return score;
    }
}
