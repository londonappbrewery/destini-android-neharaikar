package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Button mAns_1,mAns_2;
    TextView mStory;
    int mleft=0,mright=0;
    // TODO: Steps 4 & 8 - Declare member variables here:


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mAns_1=(Button)findViewById(R.id.buttonTop);
        mAns_2=(Button)findViewById(R.id.buttonBottom);
        mStory=(TextView)findViewById(R.id.storyTextView);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
         View.OnClickListener myListener =new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Destini","Top button pressed");
                mleft++;
                if((mleft==1&&mright==0)||(mleft==1&&mright==1))
                {
                    mStory.setText(R.string.T3_Story);
                    mAns_1.setText(R.string.T3_Ans1);
                    mAns_2.setText(R.string.T3_Ans2);
                }
                else if((mleft==2&&mright==0)||(mleft==2&&mright==1))
                {
                    mAns_1.setVisibility(View.GONE);
                    mAns_2.setVisibility(View.GONE);
                    mStory.setText(R.string.T6_End);
                }

            }

        };
        mAns_1.setOnClickListener(myListener);

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mAns_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Destini","Bottom button pressed");
                mright++;
                if((mleft==0&&mright==1)) {
                    mStory.setText(R.string.T2_Story);
                    mAns_1.setText(R.string.T2_Ans1);
                    mAns_2.setText(R.string.T2_Ans2);
                }
                else if((mleft==0&&mright==2))
                {
                    mAns_1.setVisibility(View.GONE);
                    mAns_2.setVisibility(View.GONE);
                    mStory.setText(R.string.T4_End);
                }
                else if((mleft==1&&mright==1)||(mleft==1&&mright==2))
                {
                    mAns_1.setVisibility(View.GONE);
                    mAns_2.setVisibility(View.GONE);
                    mStory.setText(R.string.T5_End);
                }


            }
        });
    }
}
