package nscc.capstone.scrapbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.*;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import android.content.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

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

    private int loopCounter = 0;


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
        for (int i = 0; i < 9; i++){
            aiImages.add("img_" + random.nextInt(48));
        }



        for(int x = 0; x < 2; x++)
        {
            //Gets a bitmap from our PhotoActivity ArrayList and sets the player image view to be that bitmap
            imageViewPlayerPhoto.setImageBitmap(PhotoActivity.bitmapList.get(x));

            //Gets the resource ID of the computers photo
            int computerImageResourceID = getResources().getIdentifier(aiImages.get(x), "drawable", getApplicationContext().getApplicationInfo().packageName);

            //Sets the computers image view to be the bitmap of the chosen computer photo
            imageViewComputerPhoto.setImageBitmap(getBitmapFromDrawable(computerImageResourceID));


            // Set the AI image from the aiImages string titles
//            imageViewComputerPhoto.setAdjustViewBounds(true);
//            imageViewComputerPhoto.setMaxWidth(400);
//            imageViewComputerPhoto.setMaxHeight(400);
//
//            imageViewPlayerPhoto.setAdjustViewBounds(true);
//            imageViewPlayerPhoto.setMaxWidth(400);
//            imageViewPlayerPhoto.setMaxHeight(400);


            //Instantiating our ColorChooser class, and calling the DetermineColor() method on both the
            //player and CPU photos.
            ColorChooser colorChooser = new ColorChooser();

            //DetermineColor() takes one parameter, the bitmap for the photo you want to test,
            //DetermineColor() will return a 1 if the photo is 'red', 2 for 'green', 3 for 'blue'
            int playerColorResult = colorChooser.DetermineColor( ((BitmapDrawable)imageViewPlayerPhoto.getDrawable()).getBitmap() );
            int computerColorResult = colorChooser.DetermineColor(((BitmapDrawable)imageViewComputerPhoto.getDrawable()).getBitmap() );


            //Instantiating our RockPaperScissors object.
            RockPaperScissors rockPaperScissors = new RockPaperScissors();

            //DetermineWinner() takes in two ints, the results of the player and computers color, and compares them.
            //Returns a 0 if the CPU wins, 1 if the player wins, 2 if it's a tie, and a -1 if there was an error
            int versusResult = rockPaperScissors.DetermineWinner(playerColorResult,computerColorResult);




            if(versusResult == 0) // CPU won
            {
                score.setComputerScore(score.getComputerScore()+1);
            }
            else if(versusResult == 1) //Player won
            {
                score.setPlayerScore(score.getPlayerScore()+1);
            }


//            imageViewPlayerPhoto.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide));
//
//            imageViewComputerPhoto.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide));


        }

        //reset the player image view to the first photo they chose
        imageViewPlayerPhoto.setImageBitmap(PhotoActivity.bitmapList.get(0) );

        //create an animation object from the animation resource folder
        final Animation playerAnimation = AnimationUtils.loadAnimation(this,R.anim.slide);

        //explicitly invoke the animation one time
        imageViewPlayerPhoto.startAnimation(playerAnimation);


        //here is where we have to use some sort of logic to make the animation run x times
        playerAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                //sets the imageview at the start of the animation
                imageViewPlayerPhoto.setImageBitmap(PhotoActivity.bitmapList.get(loopCounter) );
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                //checks to see if another animation should happen
                if(loopCounter < 8)
                {
                    //sleeps the thread to allow a little pause in the UI
                    try
                    {
                        Thread.sleep(1000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                    //increments the counter
                    loopCounter += 1;

                    //invokes the animation again
                    imageViewPlayerPhoto.startAnimation(playerAnimation);


                }
                else
                {
                    //if our counter is too high, cancel the animation
                    playerAnimation.cancel();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



        // Listeners
        btnTempGoToScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(BattleActivity.this, ScoreActivity.class); // Goto Score Activity
                i.putExtra("playerScore", score.getPlayerScore() );
                i.putExtra("computerScore", score.getComputerScore() );
                startActivityForResult(i, 1);
            }
        });



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

    public Bitmap getBundleImage(String bundleName){
        return BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra(bundleName),0,getIntent().getByteArrayExtra(bundleName).length);
    }

    public Bitmap getBitmapFromDrawable(int imageId)
    {
        return BitmapFactory.decodeResource(this.getResources(),imageId);
    }

}
