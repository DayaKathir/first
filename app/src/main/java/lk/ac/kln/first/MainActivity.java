package lk.ac.kln.first;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter = 100;
    private  boolean running=false;
    private boolean wasRunning=false;
    private  static  final String CURRENT_COUNTER="counter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            counter=savedInstanceState.getInt(CURRENT_COUNTER);
        }
        //running=true;
        countdown();
    }

    @Override
    public void onSaveInstanceState(Bundle SavedInstanceState){
        super.onSaveInstanceState(SavedInstanceState);
       // savedInstanceState.putInt(CURRENT_COUNTER,counter);
    }

    private void countdown() {
        final TextView textview = findViewById(R.id.textView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                //reset the counter
                if(counter==0){
                    counter=99;
                }
                textview.setText(Integer.toString(counter));

                if (running){
                    counter--;
                }

                handler.postDelayed(this, 1000);
            }
        });


    }

    protected void startCounter(View view){
        running = true;
    }

    public void stopCounter(View view) {
        running = false;
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        running = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        wasRunning = true;
    }


}
