package nscc.capstone.scrapbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingsActivity extends Activity {

    // Controls
    TextView textViewSettingsHeader;
    Button btnReturnToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        // Controls
        textViewSettingsHeader = findViewById(R.id.textViewSettingsHeader);
        btnReturnToMenu = findViewById(R.id.btnReturnToMenu);

        // Listeners
        btnReturnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent("TitleActivity"); // Goto Quiz Activity
                startActivityForResult(i,1);
            }
        });
    }//end onCreate
}
