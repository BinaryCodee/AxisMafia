package it.axis.mafia.scoreboard.domain.model;

public class BoardLine {
    private final int score;
    private final String content;

    public BoardLine(int score, String content) {
        this.score = score;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getScore() {
        return score;
    }
}
