package entity;

public class CandiadateVotes {
    private String candidate;
    private int votes;

    public CandiadateVotes(String candidate, int votes) {
        this.candidate = candidate;
        this.votes = votes;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
