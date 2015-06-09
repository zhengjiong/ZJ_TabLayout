package example.zj.com.zj_tablayout.fragment;/**
 * Created by zhengjiong on 15/6/9.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.zj.com.zj_tablayout.R;

/**
 * create by zhengjiong
 * Date: 2015-06-09
 * Time: 17:51
 */
public class RecyclerViewFragment extends Fragment{

    private RecyclerView mRecyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_fragment_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(new );
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    }
}
