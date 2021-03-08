package nscc.capstone.scrapbook;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import java.util.ArrayList;
import java.util.Random;

public class BattleActivity extends AppCompatActivity {

    // Controls
    TextView textViewPlayerWins, textViewComputerWins, textViewBattleVS;
    ImageView imageViewPlayerPhoto, imageViewComputerPhoto;
    Button btnTempGoToScore;

    // AI Images
    Random random = new Random();
    ArrayList<String> aiImages = new ArrayList<>();

    //Creating a new ScoreKeeper instance to keep score.
    ScoreKeeper score = new ScoreKeeper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        // Controls
        textViewPlayerWins = findViewById(R.id.textViewPlayerWins);
        textViewComputerWins = findViewById(R.id.textViewComputerWins);
        textViewBattleVS = findViewById(R.id.textViewBattleVS);

        imageViewPlayerPhoto = findViewById(R.id.imageViewPlayerPhoto);
        imageViewComputerPhoto = findViewById(R.id.imageViewComputerPhoto);
        btnTempGoToScore = findViewById(R.id.btnTempGoToScore);

         //Randomly get 10 photo names
        for (int i = 0; i < 10; i++){
            aiImages.add("img_" + random.nextInt(49));
        }

        // *For Testing Purposes* Set a random photo for the users picture selection
        imageViewPlayerPhoto.setAdjustViewBounds(true);
        imageViewPlayerPhoto.setMaxWidth(400);
        imageViewPlayerPhoto.setMaxHeight(400);
        imageViewPlayerPhoto.setImageResource(getResources().getIdentifier(aiImages.get(3), "drawable", getApplicationContext().getApplicationInfo().packageName));

        //this is a variable that gets passed into the ColorChooser.determineColor() function,
        //the variable is the ID of the drawable image
        int playerImageResourceID = getResources().getIdentifier(aiImages.get(3), "drawable", getApplicationContext().getApplicationInfo().packageName);


        // Set the AI image from the aiImages string titles
        imageViewComputerPhoto.setAdjustViewBounds(true);
        imageViewComputerPhoto.setMaxWidth(400);
        imageViewComputerPhoto.setMaxHeight(400);
        imageViewComputerPhoto.setImageResource(getResources().getIdentifier(aiImages.get(0), "drawable", getApplicationContext().getApplicationInfo().packageName));

        //this is a variable that gets passed into the ColorChooser.determineColor() function,
        //the variable is the ID of the drawable image
        int computerImageResourceID = getResources().getIdentifier(aiImages.get(0), "drawable", getApplicationContext().getApplicationInfo().packageName);


        //Instantiating our ColorChooser class, and calling the DetermineColor() method on both the
        //player and CPU photos.
        ColorChooser colorChooser = new ColorChooser();

        //DetermineColor() takes two parameters, the resource ID for the photo you want to test, and a context object
        //DetermineColor() will return a 1 if the photo is 'red', 2 for 'green', 3 for 'blue'
        int playerColorResult = colorChooser.DetermineColor(playerImageResourceID,this);
        int computerColorResult = colorChooser.DetermineColor(computerImageResourceID,this);

        //Instantiating our RockPaperScissors object.
        RockPaperScissors rockPaperScissors = new RockPaperScissors();

        //DetermineWinner() takes in two ints, the results of the player and computers color, and compares them.
        //Returns a 0 if the CPU wins, 1 if the player wins, 2 if it's a tie, and a -1 if there was an error
        int versusResult = rockPaperScissors.DetermineWinner(playerColorResult,computerColorResult);


        if(versusResult == 0) // CPU won
        {
            btnTempGoToScore.setText("CPU Wins");
            score.setComputerScore(score.getComputerScore()+1);
        }
        else if(versusResult == 1) //Player won
        {
            btnTempGoToScore.setText("Player wins");
            score.setPlayerScore(score.getPlayerScore()+1);
        }
        else if(versusResult == 2) //Tie game
        {
            btnTempGoToScore.setText("It was a tie!");
        }
        else
        {
            btnTempGoToScore.setText("Error :(");
        }


        //Added the photos by code, was having issues doing it by GUI
//        imageViewPlayerPhoto.setImageResource(R.drawable.img_42);
//        imageViewPlayerPhoto.setAdjustViewBounds(true);
//        imageViewPlayerPhoto.setMaxWidth(400);
//        imageViewPlayerPhoto.setMaxHeight(400);
//        imageViewComputerPhoto.setImageResource(R.drawable.img_17);
//        imageViewComputerPhoto.setAdjustViewBounds(true);
//        imageViewComputerPhoto.setMaxHeight(400);
//        imageViewComputerPhoto.setMaxWidth(400);



//        ColorChooser colorChooser = new ColorChooser();
//        int playerColorResult = colorChooser.DetermineColor(imageViewPlayerPhoto,,this);
//        int computerColorResult = colorChooser.DetermineColor(imageViewComputerPhoto,R.id.imageViewComputerPhoto,this);
//
//        RockPaperScissors rockPaperScissors = new RockPaperScissors();
//        int versusResult = rockPaperScissors.DetermineWinner(playerColorResult,computerColorResult);



        // Listeners
        btnTempGoToScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(BattleActivity.this, ScoreActivity.class); // Goto Score Activity
                startActivityForResult(i, 1);
            }
        });

        // Randomly get 10 photo names
//        for (int i = 0; i < 10; i++){
//            aiImages.add("img_" + random.nextInt(49));
//        }
//
//        // Set the AI image from the aiImages string titles
//        imageViewComputerPhoto.setAdjustViewBounds(true);
//        imageViewComputerPhoto.setMaxWidth(400);
//        imageViewComputerPhoto.setMaxHeight(400);
//        imageViewComputerPhoto.setImageResource(getResources().getIdentifier(aiImages.get(0), "drawable", getApplicationContext().getApplicationInfo().packageName));


    }//end onCreate

    /* ---- Stubs for Activity Lifestyle Code ---- */
    @Override
    protected void onStart(){
        super.onStart();

        // Put onStart code here

        // Test
        // Toast notification on start
        // Toast.makeText(TitleActivity.this,"On Start",Toast.LENGTH_SHORT).show();

    }//end onStart

    @Override
    protected void onResume(){
        super.onResume();

        // Put onResume code here

        // Test
        // Toast notification on resume
        // Toast.makeText(TitleActivity.this,"On Resume",Toast.LENGTH_SHORT).show();

    }//end onResume

    @Override
    protected void onPause(){
        super.onPause();

        // Put onPause code here

        // Test
        // Toast notification on pause
        // Toast.makeText(TitleActivity.this,"On Pause",Toast.LENGTH_SHORT).show();

    }//end onPause

    @Override
    protected void onRestart(){
        super.onRestart();

        // Put onRestart code here

        // Test
        // Toast notification on restart
        // Toast.makeText(TitleActivity.this,"On Restart",Toast.LENGTH_SHORT).show();

    }//end onRestart

    @Override
    protected void onStop(){
        super.onStop();

        // Put onStop code here

        // Test
        // Toast notification on stop
        // Toast.makeText(TitleActivity.this,"On Stop",Toast.LENGTH_SHORT).show();

    }//end onStop

    @Override
    protected void onDestroy(){
        super.onDestroy();

        // Put onDestroy code here

        // Test
        // Toast notification on destroy
        // Toast.makeText(TitleActivity.this,"On Destroy",Toast.LENGTH_SHORT).show();

    }//end onDestroy


}
