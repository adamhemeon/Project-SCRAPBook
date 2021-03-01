package nscc.capstone.scrapbook;

public class RockPaperScissors {
    public RockPaperScissors() {}


    //Function that given two integer results, returns who won the duel.
    //Returns -1 for error, 0 for a computer win, 1 for player win, and 2 for a tie
    public int DetermineWinner(int playerResult, int computerResult)
    {
        if(playerResult == 1) // red
        {
            if(computerResult == 1) // red
            {
                return 2; // tie
            }
            else if(computerResult == 2) // green
            {
                return 1; // player wins
            }
            else if(computerResult == 3) // blue
            {
                return 0; // cpu wins
            }
        }
        else if(playerResult == 2) // green
        {
            if(computerResult == 2) // green
            {
                return 2; //tie
            }
            else if(computerResult == 3) // blue
            {
                return 1; //player wins
            }
            else if(computerResult == 1)// red
            {
                return 0; //cpu wins
            }
        }
        else if(playerResult == 3) //blue
        {
            if(computerResult == 3) // blue
            {
                return 2;//tie
            }
            else if(computerResult == 1) //red
            {
                return 1;//player wins
            }
            else if(computerResult == 2) // green
            {
                return 0;//cpu wins
            }
        }

        return -1; //if it gets here there was an error, returns -1

    }
}
