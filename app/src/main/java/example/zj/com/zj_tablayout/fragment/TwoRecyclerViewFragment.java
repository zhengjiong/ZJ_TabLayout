package example.zj.com.zj_tablayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import example.zj.com.zj_tablayout.R;

/**
 *
 * create by zhengjiong
 * Date: 2015-06-09
 * Time: 17:51
 */
public class TwoRecyclerViewFragment extends Fragment{

    private RecyclerView mRecyclerView1;
    private RecyclerView mRecyclerView2;
    private ArrayList<String> mItemTitles = new ArrayList<>();
    private ArrayList<String> mItemTitles2 = new ArrayList<>();

    public static TwoRecyclerViewFragment newInstance() {
        Bundle args = new Bundle();

        TwoRecyclerViewFragment fragment = new TwoRecyclerViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_recyclerview_fragment_layout, container, false);
        mRecyclerView1 = (RecyclerView) view.findViewById(R.id.list_brand);
        mRecyclerView2 = (RecyclerView) view.findViewById(R.id.list);
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        for (int i = 0; i < 40; i++) {
            mItemTitles.add(String.valueOf(i));
        }

        mRecyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView1.setAdapter(new MyAdapter());


        for (int i = 0; i < 40; i++) {
            mItemTitles2.add(String.valueOf(i));
        }

        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView2.setAdapter(new MyAdapter());
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private View mView;
        private TextView mTxtTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mTxtTitle = (TextView) itemView.findViewById(R.id.txt_title);
        }

        public void bindData(String value){
            mTxtTitle.setText(value);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout, viewGroup, false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder viewHolder, int i) {
            viewHolder.bindData(String.valueOf(i));


            TypedValue typedValue = new TypedValue();
            getActivity().getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);

            viewHolder.mView.setBackgroundResource(typedValue.resourceId);
            viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(viewHolder.mView, "onclick", Snackbar.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mItemTitles.size();
        }
    }
}
