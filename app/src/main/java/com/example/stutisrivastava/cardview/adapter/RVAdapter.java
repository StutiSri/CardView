package com.example.stutisrivastava.cardview.adapter;

/**
 * Created by stutisrivastava on 31/10/15.
 */

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stutisrivastava.cardview.R;
import com.example.stutisrivastava.cardview.pojo.Person;

import java.util.List;

/**
 * To create an adapter that a RecyclerView can use, you must extend RecyclerView.Adapter.
 * This adapter follows the view holder design pattern, which means that it you to define a custom class that
 * extends RecyclerView.ViewHolder. This pattern minimizes the number of calls to the costly findViewById method.
 * Earlier in this example, we defined the XML layout for a CardView that represents a person.
 * We are going to reuse that layout now. Inside the constructor of our custom ViewHolder,
 * initialize the views that belong to the items of our RecyclerView.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

    /**
     *  Add a constructor to the custom adapter so that it has a handle to the data that the RecyclerView displays.
     *  As we will be giving our data as List of Person objects, use the following code:-
     *  You can use any other data structure as per your requirement.
     */
    List<Person> persons;

    public RVAdapter(List<Person> persons){
        this.persons = persons;
    }

    /**
     * Next, override the onCreateViewHolder method. As its name suggests, this method is called when the custom
     * ViewHolder needs to be initialized. We specify the layout that each item of the RecyclerView should use.
     * This is done by inflating the layout using LayoutInflater, passing the output to the constructor of the
     * custom ViewHolder.
     */

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_layout, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    /**
     * Override the onBindViewHolder to specify the contents of each item of the RecyclerView.
     * This method is very similar to the getView method of a ListView's adapter. In our example, here's where
     * you have to set the values of the name, age, and photo fields of the CardView.
     */

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(persons.get(i).getName());
        personViewHolder.personAge.setText(persons.get(i).getAge());
        personViewHolder.personPhoto.setImageResource(persons.get(i).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

}
