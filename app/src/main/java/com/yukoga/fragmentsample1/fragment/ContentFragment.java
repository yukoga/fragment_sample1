package com.yukoga.fragmentsample1.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yukoga.fragmentsample1.R;
import com.yukoga.fragmentsample1.Util;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

@EFragment(R.layout.fragment_content)
public class ContentFragment extends Fragment {
    @FragmentArg
    String screenName = "Default Title";

    @FragmentArg
    @ColorInt int backgroundColor = Color.TRANSPARENT;

    @ViewById(R.id.fragment_text)
    TextView tvFragmentText;

    private Util util;


    @AfterViews
    public void afterViews() {
        tvFragmentText.setText(screenName + ", Date: " + new Date());
        this.getView().setBackgroundColor(backgroundColor);
    }

    @Click(R.id.button_for_text)
    void buttonForTextClicked() {
        util.toastMessage(getContext(),
                screenName + "@ContentFragment#button has clicked.");
    }

    public ContentFragment() {
        util = new Util();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        util.toastMessage(getContext(), "ContentFragment#onCreateView() called.");
        return null;
    }

    @Override
    public void onStart() {
        util.toastMessage(getContext(), "ContentFragment#onStart() called.");
        super.onStart();
    }

    @Override
    public void onResume() {
        util.toastMessage(getContext(), "ContentFragment#onResume() called.");
        super.onResume();
    }
}
