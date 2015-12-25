package com.example.stutisrivastava.cardview.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.stutisrivastava.cardview.R;
import com.example.stutisrivastava.cardview.adapter.RVAdapter;
import com.example.stutisrivastava.cardview.pojo.Person;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private List<Person> mPersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeData();

        //To obtain a handle to RecyclerView in your Activity,
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);

        //If you are sure that the size of the RecyclerView won't be changing, you can add the following to improve performance:
        rv.setHasFixedSize(true);

        /** Unlike a ListView, a RecyclerView needs a LayoutManager to manage the positioning of its items.
         You could define your own LayoutManager by extending the RecyclerView.LayoutManager class.
         However, in most cases, you could simply use one of the predefined LayoutManager subclasses:
            LinearLayoutManager
            GridLayoutManager
            StaggeredGridLayoutManager
         In this tutorial, I am going to use a LinearLayoutManager.
         This LayoutManager subclass will, by default, make your RecyclerView look like a ListView.**/
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        /**
         * initialize and use the adapter by calling the adapter's constructor and the RecyclerView's setAdapter method:
         */

        RVAdapter adapter = new RVAdapter(mPersons);
        rv.setAdapter(adapter);

    }

    // This method creates an ArrayList that has eight Person objects
        private void initializeData () {
            mPersons = new ArrayList<>();
            mPersons.add(new Person("Stuti Srivastava", "21 years old", R.drawable.ic_launcher));
            mPersons.add(new Person("Saumya Sinha", "23 years old", R.drawable.ic_launcher));
            mPersons.add(new Person("Hera Fatima", "23 years old", R.drawable.ic_launcher));
            mPersons.add(new Person("Shubham Srivastava", "23 years old", R.drawable.ic_launcher));
            mPersons.add(new Person("Ayushi Birla", "22 years old", R.drawable.ic_launcher));
            mPersons.add(new Person("Milina", "25 years old", R.drawable.ic_launcher));
            mPersons.add(new Person("Pankhudi", "19 years old", R.drawable.ic_launcher));
            mPersons.add(new Person("Satyyam Srivastava", "25 years old", R.drawable.ic_launcher));
        }



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
}
