package nscc.capstone.scrapbook;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.ColorInt;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class ColorChooser {

    public ColorChooser(){}

    public int DetermineColor(int imgId ,Context context)
    {
        try
        {

            //Loading an image into memory

            /////
            //Drawable img = image.getDrawable();
            //Bitmap bit = Bitmap.createBitmap(img.getIntrinsicWidth(), img.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Bitmap bit = BitmapFactory.decodeResource(context.getResources(),imgId);
            /////


            //Getting the amount of total pixels in an image, which is used to determine the percentage of colour a photo is
            //long totalPixels = (long) img.getMinimumWidth() * img.getMinimumHeight();
            long totalPixels = (long)bit.getWidth() * bit.getHeight();

            //The program currently adds the RGB Value straight into the variables when counting.
            //Ex a pixel with RGB (255,20,50) would increment the red count by 255, blue by 20, and green by 50
            //??May be simpler to compare the pixels each time and only increment the greatest by 1, but would probably take more memory??
            long redPixels = 0;
            long bluePixels = 0;
            long greenPixels = 0;


            //When comparing every pixel, these are what the RGB values are put into
            int redPixelValue = 0;
            int bluePixelValue = 0;
            int greenPixelValue = 0;



            //Nested for loops that will go through each individual pixel in an image
            for(int x = 1; x < bit.getWidth(); x++)
            {
                for(int y = 1; y < bit.getHeight(); y++)
                {

                    //Using a color object to get the RGB value from the current pixel in the loop
                   int color = bit.getPixel(x,y);



                    //Currently the RGB value for each color gets incremented every count.
                    //EX: RGB = 255, 50, 20 => redPixels += 255, greenPixels += 50, bluePixels += 20
//                    redPixels += Color.red(color);
//                    greenPixels += Color.green(color);
//                    bluePixels += Color.blue(color);

                    redPixelValue += Color.red(color);
                    greenPixelValue += Color.green(color);
                    bluePixelValue += Color.blue(color);


                    //Right now if a pixel is NOT red,blue or green, each pixel count gets incremented
                    if(redPixelValue > bluePixelValue && redPixelValue > greenPixelValue)
                    {
                        redPixels ++;
                    }
                    else if(bluePixelValue > redPixelValue && bluePixelValue > greenPixelValue)
                    {
                        bluePixels ++;
                    }
                    else if(greenPixelValue > redPixelValue && greenPixelValue > bluePixelValue)
                    {
                        greenPixels ++;
                    }
                    else {
                        redPixels++;
                        bluePixels++;
                        greenPixels++;
                    }
                }
            }


            //Once all the pixels have been analyzed and added, compare them to determine which is the greatest value
            if(redPixels > bluePixels && redPixels > greenPixels)
            {
                return 1; //picture is 'red'
            }
            else if(greenPixels > redPixels && greenPixels > bluePixels)
            {
                return 2; //picture is 'green'
            }
            else if(bluePixels > redPixels && bluePixels > greenPixels)
            {
                return 3; // picture is 'blue'
            }
            else
            {
                //if none of those statements were true, means we have a tie.
                //in that case, picks a random number between 1 and 3
                Random random = new Random();
                return (random.nextInt(3)) + 1;
            }



        }
        catch(Exception e)
        {
            System.out.println(e);
            return 0;
        }
    }

}
