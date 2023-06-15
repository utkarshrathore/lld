import entity.Ballot;
import leaderboard.LeaderBoardMainImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LeaderBoardMainImpl lbi = new LeaderBoardMainImpl();
        List<Ballot> b = Arrays.asList(
                new Ballot(Arrays.asList("A", "B", "C")), new Ballot(Arrays.asList("B", "C", "D")));
        System.out.println(lbi.getResults(b));
    }
}