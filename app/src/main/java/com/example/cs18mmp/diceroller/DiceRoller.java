package com.example.cs18mmp.diceroller;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class DiceRoller extends AppCompatActivity {

    TextView dice;
    TextView point;
    EditText InputNumber;
    int count = 0;
    TextView score;
    int randomNum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        score = (TextView) this.findViewById(R.id.userpoints);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dice_roller, menu);
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

    //LEVEL 1//
    public int randnum() {

        Random r = new Random();
        int number = r.nextInt(6);
        return  number;
    }

    //LEVEL 2 & 3//
    public void clickTheButton(View view){
        TextView tv = (TextView) this.findViewById(R.id.myTextView);
        point = (TextView) this. findViewById(R.id.userpoints);
        randomNum = randnum();
        Context context = DiceRoller.this;

        tv.setText(Integer.toString(randomNum));

        InputNumber = (EditText) this.findViewById(R.id.roll);

      int num = Integer.parseInt(InputNumber.getText().toString());
      if(num == randomNum){
          count++;
          score.setText(Integer.toString(count));
          String textToShow = "Congratualtions on matching the number!";
          Toast.makeText(context, textToShow,Toast.LENGTH_SHORT).show();

      }

    }
}





