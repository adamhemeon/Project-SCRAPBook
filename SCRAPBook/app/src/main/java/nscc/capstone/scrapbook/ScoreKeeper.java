package nscc.capstone.scrapbook;

public class ScoreKeeper {

    private int playerScore;
    private int computerScore;

    public ScoreKeeper()
    {
        this.setComputerScore(0);
        this.setPlayerScore(0);
    }

    public int getPlayerScore()
    {
        return playerScore;
    }

    public void setPlayerScore(int playerScore)
    {
        this.playerScore = playerScore;
    }

    public int getComputerScore()
    {
        return computerScore;
    }

    public void setComputerScore(int computerScore)
    {
        this.computerScore = computerScore;
    }
}
