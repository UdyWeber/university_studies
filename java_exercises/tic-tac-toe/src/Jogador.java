public class Jogador {
    private String name;
    private int points;

    private Marker playerObject;

    public Jogador(String name, Marker playerObject) {
        this.name = name;
        this.points = 0;
        this.playerObject = playerObject;
    }

    public void incrementaPontos() {
        this.points++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Marker getPlayerObject() {
        return playerObject;
    }

    public void setPlayerObject(Marker playerObject) {
        this.playerObject = playerObject;
    }
}
