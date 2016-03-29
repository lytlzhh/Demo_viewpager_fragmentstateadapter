package com.example.llw.demo_viewpager_fragmentstateadapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewpagerId;
    private LinearLayout linearlayoutId;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;


    private BlankFragment blankFragment;
    private BlankFragment_two blankFragment_two;
    private BlankFragment_three blankFragment_three;
    private BlankFragment_four blankFragment_four;


    private ArrayList<Fragment> list;

    private void assignViews() {
        viewpagerId = (ViewPager) findViewById(R.id.viewpager_id);
        linearlayoutId = (LinearLayout) findViewById(R.id.linearlayout_id);
        btnOne = (Button) findViewById(R.id.btn_one);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnThree = (Button) findViewById(R.id.btn_three);
        btnFour = (Button) findViewById(R.id.btn_four);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        initviewpager();
    }

    public void initviewpager() {
        list = new ArrayList<>();
        blankFragment = new BlankFragment();
        blankFragment_two = new BlankFragment_two();
        blankFragment_three = new BlankFragment_three();
        blankFragment_four = new BlankFragment_four();

        list.add(blankFragment);
        list.add(blankFragment_two);
        list.add(blankFragment_three);
        list.add(blankFragment_four);

        Mypagerstateadapter mypagerstateadapter = new Mypagerstateadapter(getSupportFragmentManager(), list);
        viewpagerId.setAdapter(mypagerstateadapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_one:
                viewpagerId.setCurrentItem(0);
                break;
            case R.id.btn_two:
                viewpagerId.setCurrentItem(1);
                break;
            case R.id.btn_three:
                viewpagerId.setCurrentItem(2);
                break;
            case R.id.btn_four:
                viewpagerId.setCurrentItem(3);
                break;
        }
    }

    public class Mypagerstateadapter extends FragmentStatePagerAdapter {
        private ArrayList<Fragment> list;

        public Mypagerstateadapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return 4;
        }
    }


}
