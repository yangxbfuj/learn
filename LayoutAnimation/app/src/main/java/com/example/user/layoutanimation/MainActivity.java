package com.example.user.layoutanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout = null;

    private LayoutTransition mLayoutTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addABtn();
            }
        });

        //创建
        mLayoutTransition = new LayoutTransition();

        relativeLayout.setLayoutTransition(mLayoutTransition);

        mLayoutTransition.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 30);

        mLayoutTransition.setStagger(LayoutTransition.CHANGE_APPEARING, 30);

        //动画持续时间500ms
        mLayoutTransition.setDuration(500);

        ObjectAnimator mAnimatorAppearing = ObjectAnimator.ofFloat(null, "rotationY", 90.0f,0.0f)
                .setDuration(mLayoutTransition.getDuration(LayoutTransition.APPEARING));

        mLayoutTransition.setAnimator(LayoutTransition.APPEARING,mAnimatorAppearing);

        mAnimatorAppearing.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                View view = (View) ((ObjectAnimator)animation).getTarget();
                view.setRotationY(0.0f);
            }
        });

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

    private void addABtn(){

    }
}
