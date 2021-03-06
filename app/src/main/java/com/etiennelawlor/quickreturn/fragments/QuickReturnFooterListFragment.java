package com.etiennelawlor.quickreturn.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.etiennelawlor.quickreturn.R;
import com.etiennelawlor.quickreturn.enums.QuickReturnType;
import com.etiennelawlor.quickreturn.listeners.QuickReturnListViewOnScrollListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by etiennelawlor on 6/23/14.
 */
public class QuickReturnFooterListFragment extends ListFragment {

    // region Member Variables
    private String[] mValues;
    private boolean isActionUp = false;

    @InjectView(android.R.id.list) ListView mListView;
    @InjectView(R.id.quick_return_tv) TextView mQuickReturnTextView;
    // endregion

    // region Constructors
    public static QuickReturnFooterListFragment newInstance() {
        QuickReturnFooterListFragment fragment = new QuickReturnFooterListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public QuickReturnFooterListFragment() {
    }
    // endregion

    // region Lifecycle Methods
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_quick_return_footer, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mValues = getResources().getStringArray(R.array.countries);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.list_item, R.id.item_tv, mValues);

        mListView.setAdapter(adapter);

        int footerHeight = getActivity().getResources().getDimensionPixelSize(R.dimen.footer_height);
        mListView.setOnScrollListener(new QuickReturnListViewOnScrollListener(QuickReturnType.FOOTER, null, 0, mQuickReturnTextView, footerHeight));

//        mListView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch(event.getAction())
//                {
//
//                    case MotionEvent.ACTION_DOWN:
//                        isActionUp = false;
//                        Log.d("QuickReturnFooterListFragment", "onTouch() : ACTION_DOWN");
////                        return true;
//                    case MotionEvent.ACTION_CANCEL:
////                        Log.d("QuickReturnFooterListFragment", "onTouch() : ACTION_CANCEL");
//                    case MotionEvent.ACTION_OUTSIDE:
////                        Log.d("QuickReturnFooterListFragment", "onTouch() : ACTION_OUTSIDE");
////                        return true;
//                    case MotionEvent.ACTION_UP:
//                        if(isActionUp){
//                            Log.d("QuickReturnFooterListFragment", "onTouch() : ACTION_UP : mDiffTotal - "+mDiffTotal);
//                            Log.d("QuickReturnFooterListFragment", "onTouch() : mFooterHeight - "+mFooterHeight);
//
//
//                            if(-mDiffTotal <= mFooterHeight/2){
//                                Log.d("QuickReturnFooterListFragment", "onTouch() : slide up");
////                            mQuickReturnTextView.startAnimation(-mDiffTotal);
//
////                            Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_footer_down);
////                            mQuickReturnTextView.startAnimation(animation);
//
//
////                            mQuickReturnTextView.setTranslationY(0);
//
//                                mAnim = new TranslateAnimation(0, 0, mDiffTotal,
//                                        0);
////                                mAnim.setFillAfter(true);
//
////                            mAnim.setFillAfter(true);
//
////                            mAnim.setFillBefore(true);
//
//                            mAnim.setAnimationListener(new Animation.AnimationListener() {
//                                @Override
//                                public void onAnimationStart(Animation animation) {
//
//                                }
//
//                                @Override
//                                public void onAnimationEnd(Animation animation) {
////                                    mAnim.setFillAfter(true);
//
////                                    ((RelativeLayout.LayoutParams)v4.getLayoutParams()).bottomMargin = mbar4.getHeight();
////                                    v4.requestLayou();
//
////                                    mQuickReturnTextView.getLayoutParams().height = 200;
////                                    mQuickReturnTextView.requestLayout();
//
//                                    RelativeLayout parent = (RelativeLayout) mQuickReturnTextView.getParent();
////                                    mQuickReturnTextView.layout(0, parent.getHeight()-mQuickReturnTextView.getHeight(), mQuickReturnTextView.getWidth() , mQuickReturnTextView.getHeight());
//
////                                    mQuickReturnTextView.layout(0, parent.getHeight()-QuickReturnUtils.dp2px(getActivity(), 80), mQuickReturnTextView.getWidth() , QuickReturnUtils.dp2px(getActivity(), 80));
//
//                                    mQuickReturnTextView.layout(0, -parent.getHeight()+QuickReturnUtils.dp2px(getActivity(), 80), mQuickReturnTextView.getWidth() , QuickReturnUtils.dp2px(getActivity(), 80));
//
//                                }
//
//                                @Override
//                                public void onAnimationRepeat(Animation animation) {
//
//                                }
//                            });
//                                mAnim.setDuration(100);
//                                mQuickReturnTextView.startAnimation(mAnim);
//                            } else {
////                            mQuickReturnTextView.setTranslationY(mFooterHeight);
//
////                                mAnim = new TranslateAnimation(0, 0, mDiffTotal,
////                                        -mFooterHeight);
//////                            mAnim.setFillAfter(true);
//////                            mAnim.setFillBefore(true);
////                                mAnim.setDuration(100);
////                                mQuickReturnTextView.startAnimation(mAnim);
//
//                                Log.d("QuickReturnFooterListFragment", "onTouch() : slide down");
//
//                            }
//
////                        v.setBackgroundDrawable(null);
////                        Intent myIntent = new Intent(v.getContext(), SearchActivity.class);
////                        startActivity(myIntent);
//
////                            return true;
//                        }
//
//                        isActionUp = true;
//
//                }
//                return false;
//            }
//
//
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
    // endregion

}
