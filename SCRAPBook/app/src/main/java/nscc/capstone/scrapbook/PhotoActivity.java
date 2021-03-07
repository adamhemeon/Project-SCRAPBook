package nscc.capstone.scrapbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.*;
import android.provider.MediaStore;
import android.view.*;
import android.widget.*;
import android.content.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PhotoActivity extends AppCompatActivity {

    // Controls
    TextView textViewSelectionHeader, textViewNumPhotos;
    Button btnCamera, btnGallery, btnStart;
    ImageView imageViewPhoto1, imageViewPhoto2, imageViewPhoto3,
            imageViewPhoto4, imageViewPhoto5, imageViewPhoto6,
            imageViewPhoto7, imageViewPhoto8, imageViewPhoto9;
    ClipData cd;
    ArrayList<Bitmap> bitmapList = new ArrayList<Bitmap>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        // Controls
        textViewSelectionHeader = findViewById(R.id.textViewSelectionHeader);
        textViewNumPhotos = findViewById(R.id.textViewNumPhotos);
        btnCamera = findViewById(R.id.btnCamera);
        btnGallery = findViewById(R.id.btnGallery);
        btnStart = findViewById(R.id.btnStart);

        //btnStart.setEnabled(false);
        btnStart.setEnabled(true);

        imageViewPhoto1 = findViewById(R.id.imageViewPhoto1);
        imageViewPhoto2 = findViewById(R.id.imageViewPhoto2);
        imageViewPhoto3 = findViewById(R.id.imageViewPhoto3);
        imageViewPhoto4 = findViewById(R.id.imageViewPhoto4);
        imageViewPhoto5 = findViewById(R.id.imageViewPhoto5);
        imageViewPhoto6 = findViewById(R.id.imageViewPhoto6);
        imageViewPhoto7 = findViewById(R.id.imageViewPhoto7);
        imageViewPhoto8 = findViewById(R.id.imageViewPhoto8);
        imageViewPhoto9 = findViewById(R.id.imageViewPhoto9);

        // Listeners
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(PhotoActivity.this, BattleActivity.class); // Goto Battle Activity
                // TODO: Pack Bundle - send to Intent
                //Bundle extras = new Bundle();
                //extras.putParcelableArrayList("bitmapList", bitmapList); // Example: Bundle a name
                // i.putExtras(extras); // Put bundle in the intent
                startActivityForResult(i, 1);
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");

                // TODO: Photo select limit; non-necessary, but more polished
                i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                i.setAction(Intent.ACTION_GET_CONTENT);

                try {
                    startActivityForResult(Intent.createChooser(i,"Select Image"), 2);
                } catch (ActivityNotFoundException e) {

                }
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // TODO: Camera functionality
                try {
                    startActivityForResult(i, 3);
                } catch (ActivityNotFoundException e) {

                }
            }
        });


    }//end onCreate

    @Override
    protected void onActivityResult(int requestCode, int result, Intent intent) {
        super.onActivityResult(requestCode, result, intent);

        Bitmap bitmap;
        int photoCount = bitmapList.size();

        if(requestCode == 2) {
            bitmapList.clear();
            cd = ClipData.newPlainText("", "");
            cd = intent.getClipData();

            int cdSize = cd.getItemCount();

            for (int i = 0; i < cdSize; i++) {
                if (result == Activity.RESULT_OK) {
                    ClipData.Item item = cd.getItemAt(i);
                    Uri targetUri = item.getUri();
                    try {
                        // TODO: get width from somewhere else
                        bitmap = Bitmap.createScaledBitmap(BitmapFactory.
                                        decodeStream(getContentResolver().openInputStream(targetUri)),
                                imageViewPhoto1.getWidth(),
                                imageViewPhoto1.getHeight(), true);

                        bitmapList.add(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (requestCode == 3) {
            Bundle extras = intent.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("bitmapList");
            bitmapList.add(imageBitmap);

        }

        photoCount = bitmapList.size();

        if (photoCount <= 9) {
            for (int j = 0; j < photoCount; j++) {
                switch (j) {
                    case 0:
                        imageViewPhoto1.setImageBitmap(bitmapList.get(j));
                        break;
                    case 1:
                        imageViewPhoto2.setImageBitmap(bitmapList.get(j));
                        break;
                    case 2:
                        imageViewPhoto3.setImageBitmap(bitmapList.get(j));
                        break;
                    case 3:
                        imageViewPhoto4.setImageBitmap(bitmapList.get(j));
                        break;
                    case 4:
                        imageViewPhoto5.setImageBitmap(bitmapList.get(j));
                        break;
                    case 5:
                        imageViewPhoto6.setImageBitmap(bitmapList.get(j));
                        break;
                    case 6:
                        imageViewPhoto7.setImageBitmap(bitmapList.get(j));
                        break;
                    case 7:
                        imageViewPhoto8.setImageBitmap(bitmapList.get(j));
                        break;
                    case 8:
                        imageViewPhoto9.setImageBitmap(bitmapList.get(j));
                        break;
                    }
            }
            if(photoCount == 9) {
                btnStart.setEnabled(true);
            }
            textViewNumPhotos.setText(photoCount + "/9");
        }else{
            btnStart.setEnabled(false);
            Context context = getApplicationContext();
            CharSequence text = "Too many images selected!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
    }


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
