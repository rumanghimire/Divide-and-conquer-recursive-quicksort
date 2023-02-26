public class Team {
    private String name;
    private int wins;
    private int draws;
    private int losses;
    private int points;
/**
 * sets the name 
 * @param name
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 * set the winning score
 * @param wins
 */
    public void setWins(int wins) {
        this.wins = wins;
    }
/**
 * set the drawing score
 * @param draws
 */
    public void setDraws(int draws) {
        this.draws = draws;
    }
/**
 * set the loosing score
 * @param losses
 */
    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public int getPoints() {
        return points;
    }

    public Team() {
    }

    public void addWin() {
        this.wins++;
        this.points += 3;
    }

    public void addDraw() {
        this.draws++;
        this.points += 1;
    }

    public void addLoss() {
        this.losses++;
    }

    public void calculatePoints() {
        int points = 0;

        points += wins * 3;
        points += draws;

        this.points = points;
    }

    public int compareTo(Team pivot) {
        if (this.points > pivot.getPoints()) {
            return -1;
        } else if (this.points < pivot.getPoints()) {
            return 1;
        } else {
            if (this.wins > pivot.wins) {
                return -1;
            } else if (this.wins < pivot.wins) {
                return 1;
            } else {
                return this.name.compareTo(pivot.getName());
            }
        }
    }

    public String toString() {    // Display the final output of the program
        String toReturn = String.format("%-15s%2d  %2d  %2d  %2s  %2d", name, wins, draws, losses, "", points);
        return toReturn;
    }
}