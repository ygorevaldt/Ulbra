public class ChampionshipManagement {
        public static void main(String[] args) {
                Team team01 = new Team("Time 1");
                team01.setWins(4);
                team01.setDefeats(2);
                team01.setDraws(1);

                Team team02 = new Team("Time 2");
                team02.setWins(7);
                team02.setDefeats(1);
                team02.setDraws(3);

                Team team03 = new Team("Time 3");
                team03.setWins(1);
                team03.setDefeats(2);
                team03.setDraws(4);

                team01.printInformations();
                team02.printInformations();
                team03.printInformations();
        }
}
