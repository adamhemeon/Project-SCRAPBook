package nscc.capstone.scrapbook;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    // Controls
    Button btnReturnToMenu;
    TextView textViewAboutHeader, textViewAboutMessage,
            textViewAboutPermissionsHeader, textViewAboutPermissionsMessage,
            textViewAboutPhotosHeader, textViewAboutPhotosMessage,
            textViewAboutWinHeader, textViewAboutWinMessage, textViewAboutWinBeatsMessage,
            textViewAboutFriendsHeader, textViewAboutFriendsMessage,
            textViewAboutWhoHeader, textViewAboutWhoMessage, textViewAboutWhoGroupMessage,
            textViewAboutCodeHeader, textViewAboutCodeMessage, textViewAboutCodeGitHubLink;

    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Controls
        btnReturnToMenu = findViewById(R.id.btnReturnToMenu);

        textViewAboutHeader = findViewById(R.id.textViewAboutHeader);
        textViewAboutMessage = findViewById(R.id.textViewAboutMessage);
        textViewAboutPermissionsHeader = findViewById(R.id.textViewAboutPermissionsHeader);
        textViewAboutPermissionsMessage = findViewById(R.id.textViewAboutPermissionsMessage);
        textViewAboutPhotosHeader = findViewById(R.id.textViewAboutPhotosHeader);
        textViewAboutPhotosMessage = findViewById(R.id.textViewAboutPhotosMessage);
        textViewAboutWinHeader = findViewById(R.id.textViewAboutWinHeader);
        textViewAboutWinMessage = findViewById(R.id.textViewAboutWinMessage);
        textViewAboutWinBeatsMessage = findViewById(R.id.textViewAboutWinBeatsMessage);
        textViewAboutFriendsHeader = findViewById(R.id.textViewAboutFriendsHeader);
        textViewAboutFriendsMessage = findViewById(R.id.textViewAboutFriendsMessage);
        textViewAboutWhoHeader = findViewById(R.id.textViewAboutWhoHeader);
        textViewAboutWhoMessage = findViewById(R.id.textViewAboutWhoMessage);
        textViewAboutWhoGroupMessage = findViewById(R.id.textViewAboutWhoGroupMessage);
        textViewAboutCodeHeader = findViewById(R.id.textViewAboutCodeHeader);
        textViewAboutCodeMessage = findViewById(R.id.textViewAboutCodeMessage);
        textViewAboutCodeGitHubLink = findViewById(R.id.textViewAboutCodeGitHubLink);

        // Set link
        textViewAboutCodeGitHubLink.setMovementMethod(LinkMovementMethod.getInstance());

        // Animations
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        // Listeners
        btnReturnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Do Animations
                btnReturnToMenu.startAnimation(scaleUp);
                btnReturnToMenu.startAnimation(scaleDown);

                // Go back to Title Activity
                Intent i = new Intent(AboutActivity.this, TitleActivity.class); // Goto Title Activity
                startActivityForResult(i,1);
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


}
