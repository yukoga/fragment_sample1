package com.yukoga.fragmentsample1;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.yukoga.fragmentsample1.fragment.ContentFragment;
import com.yukoga.fragmentsample1.fragment.ContentFragment_;
import com.yukoga.fragmentsample1.fragment.DeprecatedFragment;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.navigation)
    BottomNavigationView bottomNavigationView;

    private Util util;
    private ContentFragment frg, frg1, frg2;

    public void MainActivity() {
        util = new Util();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // Set Fragment
        if (savedInstanceState==null) {
            frg1 = new ContentFragment_().builder()
                    .screenName("hoge").backgroundColor(Color.RED).build();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container1, frg1, "Hoge");
            transaction.commit();
        }
        util.toastMessage(this, "MainActivity#onCreate() called.");
    }

    @Override
    protected void onPostCreate(final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            frg1 = new ContentFragment_().builder()
                    .screenName("hoge").backgroundColor(Color.RED).build();
            frg2 = new ContentFragment_().builder()
                    .screenName("fuga").backgroundColor(Color.BLUE).build();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.contents:
                                frg = frg1;
                                util.toastMessage(
                                    getBaseContext(), "nav contents selected");
                                break;
                            case R.id.settings:
                                frg = frg2;
                                util.toastMessage(
                                    getBaseContext(), "nav settings selected");
                                break;
                        }
                        FragmentTransaction transaction =
                            getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.container1, frg, "Hoge");
                        transaction.commit();
                        return true;
                    }
                }
        );
    }
}
