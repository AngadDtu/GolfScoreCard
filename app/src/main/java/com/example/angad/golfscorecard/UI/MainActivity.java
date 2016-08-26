package com.example.angad.golfscorecard.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.angad.golfscorecard.R;
import com.example.angad.golfscorecard.model.Hole;
import com.example.angad.golfscorecard.model.ScoreCard;

public class MainActivity extends AppCompatActivity {
   private ScoreCard mScoreCard ;
    private Hole[] holes=new Hole[18];
ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=(ListView)findViewById(R.id.listView);
        int ScoreCount=0;
        for(int i=0;i<18;i++){
            holes[i]=new Hole(i+1,ScoreCount);
        }
        mScoreCard=new ScoreCard();
        mScoreCard.setHoles(holes);
        CustomArrayAdapter adapter=new CustomArrayAdapter(this,mScoreCard.getHoles());
        mListView.setAdapter(adapter);
    }
}
