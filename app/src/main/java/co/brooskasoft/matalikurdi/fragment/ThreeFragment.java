package co.brooskasoft.matalikurdi.fragment;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.brooskasoft.matalikurdi.R;
import co.brooskasoft.matalikurdi.adapter.RecyclerViewAdapter;
import co.brooskasoft.matalikurdi.itemClickListener.ItemClickListener;
import co.brooskasoft.matalikurdi.model.Matal;

public class ThreeFragment extends Fragment implements ItemClickListener {

    private Dialog fourDialog;
    private List<Matal> lstMatal;

    public ThreeFragment() {

    }

    @Override
    public void onPositionClicked(int position, int historyTable_id, final String name, final String phone) {
        fourDialog.setContentView(R.layout.pop_up_dialog);
        Button imageCancelDialogAdsApp = fourDialog.findViewById(R.id.btnCancel);
        TextView textView = fourDialog.findViewById(R.id.walam_in_dialog);
        textView.setText(phone);
        Button share_to_my_Friend = fourDialog.findViewById(R.id.send_To_Frinds_btn);
        share_to_my_Friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    String shareBody = name
                            + System.getProperty("line.separator")
                            + "\n"
                            + phone;
//                    MobileAds.initialize(getContext(), Key.AD_UNIT_ID);

                    // Add data to the intent, the receiving app will decide
                    // what to do with it.
                    //share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    getActivity().startActivity(Intent.createChooser(sharingIntent, "دابەش کردن بە: "));
                } catch (Throwable tr) {
                    //String hh=tr.toString();
                    // Toast.makeText(ActivityDotThis, "خطا رخ داده دوباره تلاش نمایید.", Toast.LENGTH_LONG).show();
                }
            }

        });

        imageCancelDialogAdsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fourDialog.dismiss();
            }

        });
        fourDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        fourDialog.show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_three, container, false);

//        MobileAds.initialize(getContext(), Key.AD_UNIT_ID);
//        AdView mAdview = view.findViewById(R.id.ad_mob_banner_three);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdview.loadAd(adRequest);

        RecyclerView myrecyclerview = view.findViewById(R.id.three_recycler);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getActivity(), lstMatal, ThreeFragment.this);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);

        fourDialog = new Dialog(getContext());


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstMatal = new ArrayList<>();

        lstMatal.add(new Matal("پشتی ڕەقه بەرد نیه هێلکه دەکە مریشک نیه ، سەری درێژه مار نیه", "وەڵام: کیسەڵ"));
        lstMatal.add(new Matal("پێنجەو نابێ به شەش", "وەڵام: نوێژه فەڕزەکانه"));
        lstMatal.add(new Matal("پێستی مەڕەو بازنی خڕه ، پیا داکێشی دەنگی پڕه", "وەڵام: دەف"));
        lstMatal.add(new Matal("به گەرما ئەیبەسێ بە سەرما نایبەسێ", "وەڵام: هێلکه"));
        lstMatal.add(new Matal("کڵاو قازی له ناو ڕەزی هەڵدەبەزی", "وەڵام: تەرزه"));
        lstMatal.add(new Matal("بە ئاو درست دەبی ودەمرێ", "وەڵام: خوێ"));
        lstMatal.add(new Matal("به هەوا ئەژی و به ئاو دەمری", "وەڵام: ئاگر"));
        lstMatal.add(new Matal("به دوو ئەشکەوت دیوارێکیان هەیە", "وەڵام: لووت"));
        lstMatal.add(new Matal("به سەد برا ڕیخۆڵەیێکیان هەیه", "وەڵام: تەسبێح"));
        lstMatal.add(new Matal("بوڵینده وەک حوشتر (وشتر) شیرینه وەک شەکر", "وەڵام: داره توو"));
        lstMatal.add(new Matal("باڵای زەردەو ڕووی سپیەو چاوی زەرده", "وەڵام: گوڵی نێرگز"));
        lstMatal.add(new Matal("ئەگەر پڕ بێ ناتەواوه و ئەگەر ناتەواو بێ پڕه", "وەڵام: مانگ"));
        lstMatal.add(new Matal("ئەمری هەر پێتەوەیه ، زیندوشی هەر پێتەوەیه", "وەڵام: ناو"));
        lstMatal.add(new Matal("ئەڕوا به ڕێوه پێی نیه ، هاوار ئەکات ، زمانی نیه ، فرمێسک ئەڕێژێ چاوی نیه", "وەڵام: هەور"));
        lstMatal.add(new Matal("ئەوه چیه له ڕانیه دەست پێ دەکات و له هەولێر کۆتایی پێ دێت", "وەڵام: پیتی ر"));
        lstMatal.add(new Matal("ئەوه کێیه ئەستێره به شان هەڵدەگرێ", "وەڵام: ئەفسەر "));
        lstMatal.add(new Matal("به دوازده برا ، سی دڵیان هەیە", "وەڵام: ساڵ"));
        lstMatal.add(new Matal("بەڕۆژ ڕازاوەو به شەو ڕووتاوه", "وەڵام: نوێن"));
        lstMatal.add(new Matal("ئەوه چیه تا دوو جار نەیکوڵێنی نایخۆی", "وەڵام: ساوەر"));
        lstMatal.add(new Matal("کارت پێی هەبێ فڕێی دەدەی ، کارت پێی نەبێ هەڵی دەگری", "وەڵام: تۆڕی ئاو (تۆڕی ماسی)"));
        lstMatal.add(new Matal("ئەگەر بڕوات ناگەڕێتەوه", "وەڵام: تەمەن"));
        lstMatal.add(new Matal("ئەگەر ڕەش بێت ، خاوێنو سپی بێت پیسه", "وەڵام: تەختەی ڕەش"));
        lstMatal.add(new Matal("ئەم لای پەرژین ئەولای پەرژین ، ناوەڕاستی کۆترێکی نەخشین", "وەڵام: چاو"));
        lstMatal.add(new Matal("ئاوی پیاکه تەڕ نابێ ، خەنجەری پیاکه شەق نابێ", "وەڵام: سێبەر"));
        lstMatal.add(new Matal("ئەملای دیوار و ئەولای دیوار تیایەتی سەگێکی هار", "وەڵام: زمان"));
        lstMatal.add(new Matal("چ کاتێک چێشتلێنەر بێ بەزەیییە", "وەڵام: له کاتێک دا هێلکه دەشکێنێت و له کاتێک دا هەویر دەشێلێ"));
        lstMatal.add(new Matal("سووره وەک هەنار ، هەناریش نیه و تەپڵ لێ دەدات دەروێشیش نیه", "وەڵام: دڵ"));
        lstMatal.add(new Matal("تا بیبەخشیت زیاد دەکات", "وەڵام: زانست"));
        lstMatal.add(new Matal("تا سەری نەبڕی قسە ناکات", "وەڵام: پینووس"));
        lstMatal.add(new Matal("بستێکه دووسەد کیلۆ هەڵدەگرێ", "وەڵام: ناڵه"));
        lstMatal.add(new Matal("به قەد مشتێکە و پڕ به ژوورێکه", "وەڵام: چرا"));
        lstMatal.add(new Matal("به جاحێلی سپیه و به پیری ڕەشه", "وەڵام: ترێ"));
        lstMatal.add(new Matal("به گەرمایه جل دەکڕێت و بەسەرمایه ڕووت دەکرێتەوه", "وەڵام: سێری نان"));
        lstMatal.add(new Matal("هەزاران زیندەوەری پیا دەڕوا ، پەنجەی مرۆڤی پیا ناڕوا", "وەڵام: شاره مێروله"));
        lstMatal.add(new Matal("لەگەڵ بادا دەڕوا", "وەڵام: کولاره"));
        lstMatal.add(new Matal("لەی دەکەیتەوه سەوزه دەیخۆی سووره ، فڕێی دەدەی ڕەشه", "وەڵام: شووتیه"));
        lstMatal.add(new Matal("له ئاسمان دێته خوار دانه دانه ، دەیدا به زەوی دا وەک", "وەڵام: تەرزەیه"));
        lstMatal.add(new Matal("دەڕوا پێی نیه ،دەبیستێ و گوێی نیه", "وەڵام: ماره"));
        lstMatal.add(new Matal("دارێکم هەیە بێ گوڵه ، بەرەکەی شیرینەو خڕه", "وەڵام: هەنجیر"));
        lstMatal.add(new Matal("دوانیان له خۆره و سییانیان له سێبەر", "وەڵام: نوێژه کان"));
        lstMatal.add(new Matal("به دەست دەچێندرێ و به چاو هەڵدەگێڕێتەوه", "وەڵام: نووسین"));
        lstMatal.add(new Matal("ئەو شته چیه پڕ له درزه و ئاویش هەڵدەگرێ", "وەڵام: ئیسفەنجه"));
        lstMatal.add(new Matal("به دایه پێک ناکەوێ و به بابه پێک دەکەوێ", "وەڵام: لێو"));
        lstMatal.add(new Matal("ئەم شته چیه ، ناتوانێت به درێژایی ژیانت بیگری ، هەروەها لە موو ناسکتر", "وەڵام: هەناسه"));
        lstMatal.add(new Matal("بە دەرکەیەکدا دەچییه ژوورەوه به دوان دا دێیه دەرەوه", "وەڵام: شەروال - پانتۆڵ"));
        lstMatal.add(new Matal("بزنه گەڕێ هەڵدەگەڕێ دادەگەڕێ نالەوەڕێ", "وەڵام: سێبەر"));
        lstMatal.add(new Matal("خانوویەکم هەیه ، گەچگەچینه ، نه پای هەیە نه پاچینه", "وەڵام: هێلکه"));
        lstMatal.add(new Matal("ئەمه چییه ، چی نییه ، هەڵئەپەڕێ  پای نیه", "وەڵام: تۆپ"));
        lstMatal.add(new Matal("دارێکم هەیه دوانزه لقه ، هەر لقەی سی پەلکه", "وەڵام: ساڵو مانگو ڕۆژ"));
        lstMatal.add(new Matal("داری چەماوه ، به پێسته خۆش کراوه ، گیاندارێکی له ناوه", "وەڵام: قەفەز و کەو"));
        lstMatal.add(new Matal("دەیبەستیتەوه دڕوا نایبەستیتەوه ناڕوا", "وەڵام: پێڵاو"));
        lstMatal.add(new Matal("دەڕوا پێی نیه شوێن پێکەشی دیاره", "وەڵام: دروومان"));
        lstMatal.add(new Matal("دەنگی هەیەو رەنگی نیه بیشی گری کێشی نیه", "وەڵام: با"));
        lstMatal.add(new Matal("دەڕوا پێی نیا دەخوورێ تامی نیه ، دەڕژێ بۆنی نیه", "وەڵام: ئاو"));
        lstMatal.add(new Matal("دوو باز له پاڵ چیایەکدان یەک نابینن ، بیانگری دەمرن ، بەریاندەی دەفڕن", "وەڵام: چاو"));
        lstMatal.add(new Matal("زیندوو به مردوو ئەنووسێ", "وەڵام: قەڵەم"));
        lstMatal.add(new Matal("زەرده زەرده له بن بەرده", "وەڵام: دووپشک"));
        lstMatal.add(new Matal("زەرده وەک زەعفەران ، سپیه وەک بەفری کەلان", "وەڵام: نێرگز "));
        lstMatal.add(new Matal("سەری خڕه و بنی بڵاوه ، گەر نازانی لاوه لاوه", "وەڵام: کڵاوه"));
    }
}
