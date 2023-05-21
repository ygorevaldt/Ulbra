public class Team {
    private String Name;
    private int Wins;
    private int Defeats;
    private int Draws;

    public Team(String name) {
        this.Name = name;
        this.Wins = 0;
        this.Defeats = 0;
        this.Draws = 0;
    }

    public String getName() {
        return this.Name;
    }

    public int getWins() {
        return this.Wins;
    }

    public int getDefeats() {
        return this.Defeats;
    }

    public int getDraws() {
        return this.Draws;
    }

    public int getTotalGames() {
        return this.Wins + this.Defeats + this.Draws;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setWins(int number) {
        this.Wins = number;
    }

    public void setDefeats(int number) {
        this.Defeats = number;
    }

    public void setDraws(int number) {
        this.Draws = number;
    }

    public void registerWin() {
        this.Wins++;
    }

    public void registerDefeat() {
        this.Defeats++;
    }

    public void registerDraw() {
        this.Draws++;
    }

    public void printInformations() {
        System.out.println(this.Name + " - " + "Total de jogos: " + this.getTotalGames() + " ---> Vitórias: " + this.Wins + " Derrotas: "
                + this.Defeats + " Empates: " + this.Draws);
    }
}