package edu.depaul.csc372marlon.garciamlistviewappfoodtype;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new GuateRestaurantAdapter());
    }

    class GuateRestaurantAdapter extends BaseAdapter {

        private LayoutInflater inflater;

        @Override
        public int getCount() {
            return FOODS.length;
        }

        @Override
        public Object getItem(int i) {
            return FOODS[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView (int position, View convertView, ViewGroup parent) {

            View row = convertView;

            if (convertView == null) {
                if (inflater == null)
                    inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.restaurant_list_item, parent, false);
            }

            ImageView icon = (ImageView) row.findViewById(R.id.image);
            TextView name = (TextView) row.findViewById(R.id.text1);
            TextView description = (TextView) row.findViewById(R.id.text2);

            GuatemalaRestaurant food = FOODS[position];
            name.setText(food.getName());
            description.setText(food.getShortDescription());
            icon.setImageResource(GuatemalaRestaurant.getIconResource(food.getType()));
            return row;
        }
    }

    private static final GuatemalaRestaurant[] FOODS = {
            new GuatemalaRestaurant("Neapolitan Marinara Pizza",
                    GuatemalaRestaurant.Type.Pizza,
                    "original Italian creation pizza",
                    "Marinara, also known as tomato pie, received its name due to its lack of cheese. Traditional Toppings: Tomato, oregano, garlic, and extra virgin olive oil."),

            new GuatemalaRestaurant("Deep Dish Pizza",
                    GuatemalaRestaurant.Type.Pizza,
                    "Chicago deep dish founding location, Chicago, IL",
                    "Chicago deep dish, is named for its founding location, Chicago, IL. Traditional Toppings: Cheese, meat, vegetables, and diced tomatoes or chunky marinara sauce "),

            new GuatemalaRestaurant("New York-Style Pizza",
                    GuatemalaRestaurant.Type.Pizza,
                    "New York-style thin crust pizza",
                    "Chicago deep dish, is named for its founding location, Chicago, IL. Traditional Toppings: Cheese, meat, vegetables, and diced tomatoes or chunky marinara sauce "),

            new GuatemalaRestaurant("Espresso Coffee",
                    GuatemalaRestaurant.Type.Coffee,
                    "Espresso is a strong black coffee",
                    "strong black coffee made by forcing steam through dark-roast aromatic coffee beans at high pressure in an espresso machine. A perfectly brewed espresso will have a thick, golden-brown crema (foam) on the surface. If the crema is good, the sugar you add will float on the surface for a couple of seconds before slowly sinking to the bottom. "),

            new GuatemalaRestaurant("Cappuccino Coffee",
                    GuatemalaRestaurant.Type.Coffee,
                    "steamed milk and milk froth",
                    "This hugely popular coffee drink has become a staple that even the most common of corner coffee shops carries (or at least a version of it). A true cappuccino is a combination of equal parts espresso, steamed milk and milk froth. This luxurious drink, if made properly, can double as a dessert with its complex flavors and richness. "),

            new GuatemalaRestaurant("Caffe Latte Coffee",
                    GuatemalaRestaurant.Type.Coffee,
                    "three parts of steamed milk",
                    "A caffe latte is a single shot of espresso to three parts of steamed milk. "),

            new GuatemalaRestaurant("Corn Taco",
                    GuatemalaRestaurant.Type.Taco,
                    "Soft Corn Tacos",
                    "Fill three crispy corn shells with your choice of meat or sofritas, salsa, guacamole, sour cream or cheese, and romaine lettuce"),

            new GuatemalaRestaurant("Burrito",
                    GuatemalaRestaurant.Type.Taco,
                    "Flour tortilla with meat",
                    "Flour tortilla with your choice of meat or sofritas, rice, beans or fajita, veggies, salsa, guacamole, and sour cream or cheese"),

            new GuatemalaRestaurant("Coca Cola Drink",
                    GuatemalaRestaurant.Type.Soda,
                    "Coca-Cola 20 oz",
                    "Coca-Cola 20 oz Great, authentic taste for at home or on the go."),

            new GuatemalaRestaurant("Pepsi Drink",
                    GuatemalaRestaurant.Type.Soda,
                    "Pepsi- 20 oz",
                    "Pepsi- 20 oz  the bold, refreshing, robust cola. Perfect for parties, meals, and celebrations big and small."),

            new GuatemalaRestaurant("Pepper Drink",
                    GuatemalaRestaurant.Type.Soda,
                    "Dr Pepper-20 oz",
                    "23 unrivaled flavors and 125 years of authenticity. There's nothing like a Pepper."),

            new GuatemalaRestaurant("Diet Papper Drink",
                    GuatemalaRestaurant.Type.Soda,
                    "Diet Dr Pepper-20 oz",
                    "23 flavors. Zero calories. Diet Dr Pepper- it's unbelievably satisfying.")

    };




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Log.d(TAG, "onListItemClick position=" + position + " id=" + id + " " + FOODS[position].getName());
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("Name", FOODS[position].getName());
        intent.putExtra("Description", FOODS[position].getLongDescription());
        intent.putExtra("Icon", GuatemalaRestaurant.getIconResource(FOODS[position].getType()));
        startActivity(intent);
    }
}
