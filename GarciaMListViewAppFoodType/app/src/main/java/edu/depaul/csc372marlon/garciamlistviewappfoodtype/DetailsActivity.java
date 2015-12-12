package edu.depaul.csc372marlon.garciamlistviewappfoodtype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by marlon on 10/23/2015.
 */
public class DetailsActivity extends Activity {

    private static final String TAG = "DetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {

        Log.d(TAG, "onStart");

        super.onStart();
        // The activity is about to become visible.
        Intent intent = getIntent();
        if (intent != null) {
            TextView name = (TextView) findViewById(R.id.text1);
            TextView description = (TextView) findViewById(R.id.text2);
            ImageView icon = (ImageView) findViewById(R.id.image);
            ImageView food = (ImageView) findViewById(R.id.productImage);

            CharSequence namefood = intent.getCharSequenceExtra("Name");
            name.setText(namefood);
            description.setText(intent.getCharSequenceExtra("Description"));
            icon.setImageResource(intent.getIntExtra("Icon", -1));





            if(namefood.equals("Neapolitan Marinara Pizza")){

                food.setImageResource(R.drawable.neapolitanmarinarapizza);
            }

            else if(namefood.equals("Deep Dish Pizza")){

                food.setImageResource(R.drawable.deepdishpizza);
            }

            else if(namefood.equals("New York-Style Pizza")){

                food.setImageResource(R.drawable.newyorkstylepizza);
            }

            else if(namefood.equals("Espresso Coffee")){

                food.setImageResource(R.drawable.espressocoffee);
            }

            else if(namefood.equals("Cappuccino Coffee")){

                food.setImageResource(R.drawable.cappuccinocoffee);
            }

            else if(namefood.equals("Caffe Latte Coffee")){

                food.setImageResource(R.drawable.caffelattecoffee);
            }

            else if(namefood.equals("Corn Taco")){

                food.setImageResource(R.drawable.corntaco);
            }

            else if(namefood.equals(("Burrito"))){

                food.setImageResource(R.drawable.burrito);
            }

            else if(namefood.equals("Coca Cola Drink")){

                food.setImageResource(R.drawable.cocacola);
            }

            else if(namefood.equals("Pepsi Drink")){

                food.setImageResource(R.drawable.pepsi);
            }

            else if(namefood.equals("Pepper Drink")){

                food.setImageResource(R.drawable.drpepper);
            }

            else if(namefood.equals("Diet Papper Drink")){

                food.setImageResource(R.drawable.dietdrpepper);
            }




        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
