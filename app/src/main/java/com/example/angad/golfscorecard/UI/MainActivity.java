package com.example.angad.golfscorecard.UI;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.angad.golfscorecard.R;
import com.example.angad.golfscorecard.model.Hole;
import com.example.angad.golfscorecard.model.ScoreCard;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_PREFS ="com.example.angad.golfscorecard.UI" ;
    private static final String KEY_HOLE ="Hole " ;
    private ScoreCard mScoreCard ;
    private Hole[] holes=new Hole[18];
    ListView mListView;
    private  CustomArrayAdapter adapter;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=(ListView)findViewById(R.id.listView);
        mSharedPreferences=getSharedPreferences(FILE_PREFS,MODE_PRIVATE);
        mEditor=mSharedPreferences.edit();
        int ScoreCount=0;
        for(int i=0;i<18;i++){
            ScoreCount= mSharedPreferences.getInt(KEY_HOLE+i,0);
            holes[i]=new Hole(i+1,ScoreCount);
        }
        mScoreCard=new ScoreCard();
        mScoreCard.setHoles(holes);
         adapter=new CustomArrayAdapter(this,mScoreCard.getHoles());
        mListView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        for(int i=0;i<18;i++) {
            mEditor.putInt(KEY_HOLE+i, holes[i].getCount());
        }
        mEditor.apply();
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
        if (id == R.id.action_clear_count) {
            mEditor.clear();
            mEditor.apply();
            for(Hole hole: holes){
                hole.setCount(0);
            }
            adapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
