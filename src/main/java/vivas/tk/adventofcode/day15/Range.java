package vivas.tk.adventofcode.day15;

import static vivas.tk.adventofcode.day15.TouchType.*;

record Range(int min, int max) {
    public TouchType toTouchType(Range other) {
        if (min >= other.min && max <= other.max) {
            return CONTAINED;
        }
        if (min <= other.min && max >= other.max) {
            return CONTAINS;
        }
        if (min <= other.max + 1 && min >= other.min) {
            return RIGHT;
        }
        if (max >= other.min - 1 && max <= other.max) {
            return LEFT;
        }
        return NOT_TOUCHING;
    }

    public Range combine(Range other) {
        return switch (toTouchType(other)) {
            case CONTAINS -> this;
            case CONTAINED -> other;
            case LEFT -> new Range(min, other.max);
            case RIGHT -> new Range(other.min, max);
            case NOT_TOUCHING -> null;
        };
    }

    public int getSize() {
        return max - min + 1;
    }

    public boolean isDisjoint(Range other) {
        return min > other.max + 1 || max < other.min - 1;
    }

    public boolean touches(Range other) {
        return min <= other.max + 1 && max >= other.min - 1;
    }
}
