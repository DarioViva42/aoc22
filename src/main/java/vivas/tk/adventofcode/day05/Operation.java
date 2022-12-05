package vivas.tk.adventofcode.day05;

public class Operation {
    private final int amount;
    private final int from;
    private final int to;
    public Operation(String input) {
        String[] words = input.split(" ");
        amount = Integer.parseInt(words[1]);
        from = Integer.parseInt(words[3]) - 1;
        to = Integer.parseInt(words[5]) - 1;
    }

    public int getAmount() {
        return amount;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
