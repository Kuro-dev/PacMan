package game.logic.area.map;

public enum FieldIdentifier {
    PAC('p'),
    WALL('w'),
    AIR('o'),
    GHOST('g'),
    ;

    private final char identifier;

    FieldIdentifier(char identifier) {
        this.identifier = identifier;
    }

    public static FieldIdentifier valueOf(char identifier) {
        for (FieldIdentifier field : FieldIdentifier.values()) {
            if (identifier == field.identifier) {
                return field;
            }
        }
        throw new RuntimeException("Could not parse field \"" + identifier + "\"");
    }

    public char getIdentifier() {
        return identifier;
    }
}
