package leaderboard;

import entity.Ballot;

import java.util.List;

public interface ILeaderBoardMain {
    /**
     * Process a list of ballots, and
     * return all candidates sorted in descending order by their total number of points.
     *
     * Each ballot contains a list of 3 votes, 1 for each preferred candidate.
     * Points are assigned to each candidate as per the order of appearance in ballot as below.
     * Position 1: 3 points | Position 2: 2 points | Position 3: 1 point
     *
     * Example: [(A, B, C), (B, C, D)]
     * A = 3 points, B = 2+3 = 5 points, C = 1+2 = 3 points, D = 1 point
     * Order of candidates by points = [B, A, C, D]
     *
     * In case of 2 candidates have equal points, order does not matter.
     */

    List<String> getResults(List<Ballot> ballots);
}
