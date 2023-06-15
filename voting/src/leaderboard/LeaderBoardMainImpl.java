package leaderboard;

import entity.Ballot;
import entity.CandiadateVotes;
import util.VoteCalculator;

import java.util.*;

class SortByVotes implements Comparator<CandiadateVotes> {
    public int compare(CandiadateVotes a, CandiadateVotes b) {
        return b.getVotes() - a.getVotes();
    }
}
public class LeaderBoardMainImpl implements ILeaderBoardMain {

    private Map<String, Integer> candidateToVoteCounter;

    public Map<String, Integer> getCandidateToVoteCounter() {
        return candidateToVoteCounter;
    }

    public void setCandidateToVoteCounter(Map<String, Integer> candidateToVoteCounter) {
        this.candidateToVoteCounter = candidateToVoteCounter;
    }

    public LeaderBoardMainImpl() {
        this.candidateToVoteCounter = new HashMap<>();
    }

    @Override
    public List<String> getResults(List<Ballot> ballots) {
        List<String> candidatesListByVotes = new LinkedList();
        for(Ballot ballot: ballots) {
            List<String> votes = ballot.getVotes();
            for(int i=0; i<votes.size();i++) {
                String candidate = votes.get(i);
                int newVote = VoteCalculator.calculatePointsBasedOnIndex(i);
                if(candidateToVoteCounter.containsKey(candidate)) {
                    candidateToVoteCounter.put(candidate,
                            candidateToVoteCounter.get(candidate) + newVote);
                } else {
                    candidateToVoteCounter.put(candidate, newVote);
                }
            }
        }

        List<CandiadateVotes> voterList = new LinkedList();

        for(String candidate : candidateToVoteCounter.keySet()) {
            voterList.add(new CandiadateVotes(candidate, candidateToVoteCounter.get(candidate)));
        }

        Collections.sort(voterList, new SortByVotes());

        for(CandiadateVotes c : voterList) {
            candidatesListByVotes.add(c.getCandidate());
        }

        return candidatesListByVotes;
    }
}
