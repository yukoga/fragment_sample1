package com.yukoga.fragmentsample1.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yukoga.fragmentsample1.R;
import com.yukoga.fragmentsample1.Util;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DeprecatedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DeprecatedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//@EFragment(R.layout.fragment_content)
public class DeprecatedFragment extends Fragment {
    private Util util;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String SCREEN_NAME = "screen_name";
    private static final String BACKGROUND_COLOR = "background_color";

    // TODO: Rename and change types of parameters
    private String screenName = "DeprecatedFragment#default_screen_name";
    private @ColorInt int backgroundColor = Color.TRANSPARENT;

//    private OnFragmentInteractionListener mListener;

//    @Click(R.id.button_for_text)
//    void buttonForTextClicked() {
//        util.toastMessage(getContext(), "DeprecatedFragment#button_for_text has clicked.");
//    }

//    @ViewById(R.id.fragment_text)
//    TextView fragmentText;
//
//    @AfterViews
//    void updateText() {
//        fragmentText.setText(screenName + ", Date: " + new Date());
//    }

    public DeprecatedFragment() {
        // Required empty public constructor
        util = new Util();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param screenName Parameter 1.
     * @param backgroundColor Parameter 2.
     * @return A new instance of fragment DeprecatedFragment.
     */
    // TODO: Rename and change types and number of parameters
    @CheckResult
    public static DeprecatedFragment newInstance(String screenName, @ColorInt int backgroundColor) {
        DeprecatedFragment fragment = new DeprecatedFragment();
        Bundle args = new Bundle();
        args.putString(SCREEN_NAME, screenName);
        args.putInt(BACKGROUND_COLOR, backgroundColor);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            screenName = getArguments().getString(SCREEN_NAME);
            backgroundColor = getArguments().getInt(BACKGROUND_COLOR, Color.TRANSPARENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        util.toastMessage(getContext(), "DeprecatedFragment#onCreateView() called.");
        return inflater.inflate(R.layout.fragment_content, container, false);
//        return null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setFragmentProperty(view);
        util.toastMessage(getContext(), "DeprecatedFragment#onViewCreated() called.");
    }

    @Override
    public void onStart() {
        util.toastMessage(getContext(), "DeprecatedFragment#onStart() called.");
        super.onStart();
    }

    @Override
    public void onResume() {
        util.toastMessage(getContext(), "DeprecatedFragment#onResume() called.");
        super.onResume();
    }

    public void setFragmentProperty(View view) {
        view.setBackgroundColor(backgroundColor);
        TextView fragmentTextView = (TextView) view.findViewById(R.id.fragment_text);
        fragmentTextView.setText(screenName);
    }
    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
