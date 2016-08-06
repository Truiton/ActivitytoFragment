package com.truiton.activitytofragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.utils.IFragmentToActivity;

public class TabFragment1 extends Fragment implements View.OnClickListener {
    private IFragmentToActivity mCallback;
    private Button btnFtoA;
    private Button btnFtoF;
    private Button btnFto2A;

    String img_url =
            "https://www.google.co.nz/imgres?imgurl=https%3A%2F%2Fcloudpix.co%2Fimages%2Fhd-wallpapers-tv-shows%2Farrow-tv-show-hd-wallpapers-hd-wallpaper-movies-photo-arrow-hd-wallpaper-86e212b094c8babb094e2d140b00a364-large-1331237.jpg&imgrefurl=https%3A%2F%2Fcloudpix.co%2Farrow-tv-show-hd-wallpapers-hd-wallpaper-movies-photo-arrow-hd-wallpaper-hd-wallpapers-tv-shows-1331237.html&docid=WE8p7fb8Q4XF2M&tbnid=6ImKRlhyaMFTfM%3A&w=1440&h=900&noj=1&bih=914&biw=1883&ved=0ahUKEwiy8-GX6qzOAhWDq48KHWaTBxsQMwhSKCYwJg&iact=mrc&uact=8";
   // MyApplication app;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);
        btnFtoA = (Button) view.findViewById(R.id.button);
        btnFtoF = (Button) view.findViewById(R.id.button2);
        btnFto2A = (Button) view.findViewById(R.id.button3);
        btnFtoA.setOnClickListener(this);
        btnFtoF.setOnClickListener(this);
        btnFto2A.setOnClickListener(this);



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (IFragmentToActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement IFragmentToActivity");
        }
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }

    public void onRefresh() {
        Toast.makeText(getActivity(), "Fragment 1: Refresh called.",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                mCallback.showToast("Hello from Fragment 1");
                break;

            case R.id.button2:
                mCallback.communicateToFragment2();
                break;
            case R.id.button3:
                //mCallback.showToast("Hello  Activity 2,from Fragment 1");
                mCallback.showToast(img_url);
                /*app = (MyApplication) getActivity().getApplicationContext();
                app.setData("Hello  Activity 2,from Fragment 1");
                */
                Intent io = new Intent(getActivity().getApplicationContext(),SecondActivity.class);
                startActivity(io);
                break;
        }
    }
}
