package ro.fasttrackit.course12.enums;

public enum CardinalPoints {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private final String symbol;

    CardinalPoints(String symbol) {
        this.symbol = symbol;
    }

    public static CardinalPoints fromSymbol(String symbol) {
        if (symbol == null) {
            return null;
        }

        for (CardinalPoints cardinalPoint : CardinalPoints.values()) {
            if (cardinalPoint.getSymbol().equalsIgnoreCase(symbol)) {
                return cardinalPoint;
            }
        }

        return null;
    }

    public static CardinalPoints fromName(String name) {
        if (name == null) {
            return null;
        }

        CardinalPoints[] values = CardinalPoints.values();
        for (CardinalPoints cardinalPoint : values) {
            if (cardinalPoint.name().equalsIgnoreCase(name)) {
                return cardinalPoint;
            }
        }

        return null;
    }

    public String toDirection() {
        return switch (this) {
            case NORTH -> "UP";
            case SOUTH -> "DOWN";
            case EAST -> "RIGHT";
            case WEST -> "LEFT";
        };
    }

    public String getSymbol() {
        return symbol;
    }
}
