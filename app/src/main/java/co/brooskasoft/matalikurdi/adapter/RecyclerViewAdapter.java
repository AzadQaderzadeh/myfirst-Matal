package co.brooskasoft.matalikurdi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.brooskasoft.matalikurdi.R;
import co.brooskasoft.matalikurdi.itemClickListener.ItemClickListener;
import co.brooskasoft.matalikurdi.model.Matal;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Matal> mData;
    private int lastPosition = 0;
    //    private InterstitialAd mInterstitialAd;
    private ItemClickListener itemClickListener;


    public RecyclerViewAdapter(Context mContext, List<Matal> mData, ItemClickListener itemClickListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_matal, parent, false);
        MyViewHolder vHolder = new MyViewHolder(view, itemClickListener);
//        mInterstitialAd = newInterstitialAd();
//        loadInterstitial();
        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_matal.setText(mData.get(position).getMatal());
        holder.tv_wallam.setText(mData.get(position).getWallam());
        setAnimation(holder.itemView, position);

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private LinearLayout item_matal;
        private TextView tv_matal;
        private TextView tv_wallam;
        ItemClickListener itemClickListener;


        public MyViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;
            item_matal = itemView.findViewById(R.id.matal_item_id);
            tv_matal = itemView.findViewById(R.id.matal_name);
            tv_wallam = itemView.findViewById(R.id.wallami_matal);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String matal = (String) tv_matal.getText();
            String wallam = (String) tv_wallam.getText();

//            showRandom();
            itemClickListener.onPositionClicked(-1, 0, matal, wallam);
        }
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
        viewToAnimate.startAnimation(animation);
        lastPosition = position;
    }
//
//    private InterstitialAd newInterstitialAd() {
//        InterstitialAd interstitialAd = new InterstitialAd(mContext);
//        interstitialAd.setAdUnitId(Key.Miyani_MatalKurdi);
//        interstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
////                share_to_my_Friend.setEnabled(true);
//            }
//
//            @Override
//            public void onAdFailedToLoad(int errorCode) {
////                share_to_my_Friend.setEnabled(true);
//            }
//
//            @Override
//            public void onAdClosed() {
//                // Proceed to the next level.
//            }
//        });
//        return interstitialAd;
//    }
//
//    private void showInterstitial() {
//        // Show the ad if it's ready. Otherwise toast and reload the ad.
//        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
//            mInterstitialAd.show();
//        }
////        else {
////            Toast.makeText(getContext(), "Ad did not load", Toast.LENGTH_SHORT).show();
////        }
//    }
//
//    private void loadInterstitial() {
//        // Disable the next level button and load the ad.
//        AdRequest adRequest = new AdRequest.Builder()
//                .setRequestAgent("android_studio:ad_template").build();
//        mInterstitialAd.loadAd(adRequest);
//    }

//    private void showRandom(){
//        int min = 1;
//        int max = 5;
//
//        Random r = new Random();
//        int randNum = r.nextInt(max - min + 1) + min;
//        if (randNum == 2) {
//
//            showInterstitial();
//
//        } else {
//
//        }
//    }
}
