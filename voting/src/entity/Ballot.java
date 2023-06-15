package entity;

import java.util.List;

public class Ballot {
    private List<String> votes;

    public Ballot(List<String> votes) {
        this.votes = votes;
    }

    public List<String> getVotes() {
        return votes;
    }

    public void setVotes(List<String> votes) {
        this.votes = votes;
    }
}
