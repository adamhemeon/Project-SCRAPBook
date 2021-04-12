
package nscc.capstone.scrapbook;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.*;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import android.content.*;
import java.util.ArrayList;
import java.util.Random;

public class BattleActivity extends AppCompatActivity {

    // Constants
    final int NUM_PHOTOS = 9;
    final int NUM_IMG_RESOURCES = 48;

    // Controls
    TextView textViewPlayerWins, textViewComputerWins, textViewBattleVS;
    ImageView imageViewPlayerPhoto, imageViewComputerPhoto;
    Button btnGoToScore;

    // Animations
    Animation scaleUp, scaleDown;

    // Animators and AnimatorSets
    ObjectAnimator playerSlideIn, computerSlideIn, playerPause, computerPause, playerSlideOut, computerSlideOut;
    AnimatorSet slideInSet = new AnimatorSet();
    AnimatorSet pauseSet = new AnimatorSet();
    AnimatorSet slideOutSet = new AnimatorSet();

    // AI Images
    Random random = new Random();
    ArrayList<String> aiImages = new ArrayList<>();

    //Instantiating our ColorChooser class, and calling the DetermineColor() method on both the
    //player and CPU photos.
    ColorChooser colorChooser = new ColorChooser();

    //Creating a new ScoreKeeper instance to keep score.
    ScoreKeeper score = new ScoreKeeper();

    //Instantiating our RockPaperScissors object and an array to hold the win sequence
    RockPaperScissors rockPaperScissors = new RockPaperScissors();
    int[] winSequence = new int[NUM_PHOTOS];

    // Variables
    int loopCounter = 0;
    boolean singular = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        // Create an animation object from the animation resource folder
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        // Controls
        textViewPlayerWins = findViewById(R.id.textViewPlayerWins);
        textViewComputerWins = findViewById(R.id.textViewComputerWins);
        textViewBattleVS = findViewById(R.id.textViewBattleVS);
        imageViewPlayerPhoto = findViewById(R.id.imageViewPlayerPhoto);
        imageViewComputerPhoto = findViewById(R.id.imageViewComputerPhoto);
        btnGoToScore = findViewById(R.id.btnGoToScore);

        // -- Animators --
        // Slide In
        playerSlideIn = ObjectAnimator.ofFloat(imageViewPlayerPhoto, "translationX", -1500f, 0f);
        computerSlideIn = ObjectAnimator.ofFloat(imageViewComputerPhoto, "translationX", 1500f, 0f);
        playerSlideIn.setDuration(1500);
        computerSlideIn.setDuration(1500);
        slideInSet.playTogether(playerSlideIn, computerSlideIn);

        // Pause
        playerPause = ObjectAnimator.ofFloat(imageViewPlayerPhoto, "translationX", 0f, 0f);
        computerPause = ObjectAnimator.ofFloat(imageViewComputerPhoto, "translationX", 0f, 0f);
        playerPause.setDuration(1500);
        computerPause.setDuration(1500);
        pauseSet.playTogether(playerPause, computerPause);

        // Slide Out
        playerSlideOut = ObjectAnimator.ofFloat(imageViewPlayerPhoto, "translationX", 0f, 1500f);
        computerSlideOut = ObjectAnimator.ofFloat(imageViewComputerPhoto, "translationX", 0f, -1500f);
        playerSlideOut.setDuration(1500);
        computerSlideOut.setDuration(1500);
        slideOutSet.playTogether(playerSlideOut, computerSlideOut);


        // Hide the winning text views
        textViewPlayerWins.setVisibility(View.VISIBLE);
        textViewComputerWins.setVisibility(View.INVISIBLE);

        // Get the computer images and add them to the array list
        getComputerImages();

        // run the score at the beginning before doing the animations
        generateScore();

        // Start player image view to the first photo they chose
        imageViewPlayerPhoto.setImageBitmap(PhotoActivity.bitmapList.get(0));

        // Start computer photo to first in the list
        //Gets the resource ID of the computers photo
        int computerImageResourceID = getResources().getIdentifier(aiImages.get(0),
                "drawable", getApplicationContext().getApplicationInfo().packageName);

        //Set the image view at the start of the animation
        //Sets the computers image view to be the bitmap of the chosen computer photo
        imageViewComputerPhoto.setImageBitmap(getBitmapFromDrawable(computerImageResourceID));

        // Slide In set
        slideInSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

                // Displays what player won.
                switch (winSequence[loopCounter])
                {
                    case 0: // COMPUTER
                        textViewPlayerWins.setText(R.string.conputerwins);
                        textViewPlayerWins.setTextColor(Color.rgb(230, 24, 9));
                        break;
                    case 1: // PLAYER
                        textViewPlayerWins.setText(R.string.playerwins);
                        textViewPlayerWins.setTextColor(Color.rgb(9, 38, 230));
                        break;
                    case 2: // TIE
                        textViewPlayerWins.setText(R.string.tie);
                        textViewPlayerWins.setTextColor(Color.rgb(230, 186, 9));
                        break;
                    default: // ERROR
                        textViewPlayerWins.setText(R.string.error);
                        break;
                }

                //sets the imageview at the start of the animation
                imageViewPlayerPhoto.setImageBitmap(PhotoActivity.bitmapList.get(loopCounter));

                //Gets the resource ID of the computers photo
                int computerImageResourceID = getResources().getIdentifier(aiImages.get(loopCounter),
                        "drawable", getApplicationContext().getApplicationInfo().packageName);

                //Set the image view at the start of the animation
                //Sets the computers image view to be the bitmap of the chosen computer photo
                imageViewComputerPhoto.setImageBitmap(getBitmapFromDrawable(computerImageResourceID));
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //increments the counter and starts next animation
                if (loopCounter < (NUM_PHOTOS-1)) {
                    loopCounter += 1;
                    pauseSet.start();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                // Unused
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // Unused
            }
        });

        // Pause listener
        pauseSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // Unused
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                slideOutSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                // unsused
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // Unused
            }
        });

        slideOutSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // Unused
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                slideInSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                // Unused
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // Unused
            }
        });

        // Listeners
        btnGoToScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Send the score to the score Activity
                Intent i = new Intent(BattleActivity.this, ScoreActivity.class); // Goto Score Activity
                i.putExtra("playerScore", score.getPlayerScore() );
                i.putExtra("computerScore", score.getComputerScore() );

                // Play Animation
                btnGoToScore.startAnimation(scaleUp);
                btnGoToScore.startAnimation(scaleDown);

                // Start the Score Activity
                startActivityForResult(i, 1);
            }
        });

    }//end onCreate

    @Override
    protected void onStart(){
        super.onStart();
        // Start first animations
        slideInSet.start();
    }//end onStart

    /* ---- Stubs for Activity Lifestyle Code ---- */
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

    public Bitmap getBundleImage(String bundleName){
        return BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra(bundleName),0,getIntent().getByteArrayExtra(bundleName).length);
    }

    public Bitmap getBitmapFromDrawable(int imageId)
    {
        return BitmapFactory.decodeResource(this.getResources(),imageId);
    }


    /**
     * Summary: Retrieve the image names for the computer and add them to the array list.
     */
    private void getComputerImages()
    {
        //Randomly get 9 photo names
        for (int i = 0; i < NUM_PHOTOS; i++){
            aiImages.add("img_" + random.nextInt(NUM_IMG_RESOURCES));
        }
    }

    /**
     * Summary: Will generate a score from the two bitmap lists.
     */
    private void generateScore()
    {
        for(int i = 0; i < NUM_PHOTOS; i++)
        {
            //Gets the resource ID of the computer photo
            int computerImageResourceID = getResources().getIdentifier(aiImages.get(i),
                    "drawable", getApplicationContext().getApplicationInfo().packageName);

            //DetermineColor() takes one parameter, the bitmap for the photo you want to test,
            //DetermineColor() will return a 1 if the photo is 'red', 2 for 'green', 3 for 'blue'
            int playerColorResult = colorChooser.DetermineColor(PhotoActivity.bitmapList.get(i));
            int computerColorResult = colorChooser.DetermineColor(getBitmapFromDrawable(computerImageResourceID));

            //DetermineWinner() takes in two ints, the results of the player and computers color, and compares them.
            //Returns a 0 if the CPU wins, 1 if the player wins, 2 if it's a tie, and a -1 if there was an error
            int versusResult = rockPaperScissors.DetermineWinner(playerColorResult,computerColorResult);

            // Adjust the score
            switch (versusResult)
            {
                case 0: // COMPUTER WINS
                    score.setComputerScore(score.getComputerScore()+1);
                    winSequence[i] = 0;
                    break;
                case 1: // PLAYER WINS
                    score.setPlayerScore(score.getPlayerScore()+1);
                    winSequence[i] = 1;
                    break;
                case 2: // TIE
                    winSequence[i] = 2;
                    break;
                default: // ERROR
                    winSequence[i] = -1;
                    break;
            }
        }
    }
}