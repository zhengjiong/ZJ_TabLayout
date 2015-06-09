package example.zj.com.zj_tablayout;/**
 * Created by zhengjiong on 15/6/9.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * create by zhengjiong
 * Date: 2015-06-09
 * Time: 14:40
 */
public class SimpleFragment extends Fragment{
    private View mRootView;
    private TextView mTxtTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.simple_fragment_layout, container, false);
        mTxtTitle = (TextView) mRootView.findViewById(R.id.txt_title);

        String title = getArguments().getString("title");
        mTxtTitle.setText(title);

        return mRootView;
    }

    public static SimpleFragment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title", title);

        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
