package utils;

public class Player {
    private String name;
    private char marker;

    public Player(char marker, String name) {
        this.marker = marker;
        this.name = name;
    }

    public char getMarker() {
        return marker;
    }

    public String getName() {
        return name;
    }
}
