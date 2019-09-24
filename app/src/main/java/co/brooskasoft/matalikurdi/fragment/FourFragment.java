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


public class FourFragment extends Fragment implements ItemClickListener {

    private Dialog fourthDialog;
    private List<Matal> lstMatal;


    public FourFragment() {

    }

    @Override
    public void onPositionClicked(int position, int historyTable_id, final String name, final String phone) {
        fourthDialog.setContentView(R.layout.pop_up_dialog);

        Button imageCancelDialogAdsApp = fourthDialog.findViewById(R.id.btnCancel);
        TextView textView = fourthDialog.findViewById(R.id.walam_in_dialog);
        textView.setText(phone);
        Button share_to_my_Friend = fourthDialog.findViewById(R.id.send_To_Frinds_btn);
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

                fourthDialog.dismiss();
            }

        });
        fourthDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        fourthDialog.show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_four, container, false);

//        MobileAds.initialize(getContext(), Key.AD_UNIT_ID);
//        AdView mAdview = view.findViewById(R.id.ad_mob_banner_fourth);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdview.loadAd(adRequest);

        RecyclerView myrecyclerview = view.findViewById(R.id.fourth_recycler);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), lstMatal, FourFragment.this);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);

        fourthDialog = new Dialog(getContext());

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstMatal = new ArrayList<>();

        lstMatal.add(new Matal("شوانێک هات به پەرۆشی ، ورده ورده مەڕان دەدۆشی", "وەڵام: شانه"));
        lstMatal.add(new Matal("شەوله بانە و وا له سەر بان", "وەڵام: بانگدێت - باگردێن"));
        lstMatal.add(new Matal("به پیسی دەخورێ و به خاوێنی ناخورێ", "وەڵام: پێستی مروڤ"));
        lstMatal.add(new Matal("به خۆی له چەمایه ، خەرجی له گوندایه", "وەڵام: ئاشی ئاو"));
        lstMatal.add(new Matal("بەڕەق وەک داره ، لووتی زۆر خواره", "وەڵام: نۆک"));
        lstMatal.add(new Matal("بەدەست شێره به پێست پڵینگه", "وەڵام: بۆق"));
        lstMatal.add(new Matal("شارێکە و باری دو وڵاخه", "وەڵام: چوارتا"));
        lstMatal.add(new Matal("هەتا گەرمی کەی ، تون ئەبێتەوه", "وەڵام: هێلکه"));
        lstMatal.add(new Matal("ئەم لای گڵە و ئەو لای گڵه ناوەڕاستی فێنکی دڵه", "وەڵام: شەربەئاو"));
        lstMatal.add(new Matal("ئەوەچیه به دەموچاوتا  ئەیکێشی و نای بینی", "وەڵام: هەوایه"));
        lstMatal.add(new Matal("سوارێک هاتبوو به غارەغار رمی لێدابوو به هەزار", "وەڵام: هەنار"));
        lstMatal.add(new Matal("ئەو شته چیه بیر ناکاتەوە و راستیش ئەڵێت", "وەڵام: سەعات"));
        lstMatal.add(new Matal("کەپرەکم هەیە کەپرێکی لێی ئەبارێ به فرۆکی", "وەڵام: هێڵەگ"));
        lstMatal.add(new Matal("له چ مانگێک منداڵ کەم قسه دەکات", "وەڵام: لەمانگی شۆبات دا (کورتترین مانگی ساڵ)"));
        lstMatal.add(new Matal("هەتا نەیبەستیەوه ناڕوا", "وەڵام: پێڵاو"));
        lstMatal.add(new Matal("هەتا بڕۆی زیاد دەکات", "وەڵام: جێ پێ"));
        lstMatal.add(new Matal("خانوویەکم هەیە تەنگ و تاریکه ، پڕی له عارەب مل باریکه", "وەڵام: شاره مێرووله"));
        lstMatal.add(new Matal("ملی هەیەو سەری نیه ، پشتی هەیەو سکی نیه ، دەستی هەیەو پێی نیه", "وەڵام: کراس"));
        lstMatal.add(new Matal("مامێک هەیه له دەشت ، حەوسەد کونی وا له پشت", "وەڵام: ژووژوو"));
        lstMatal.add(new Matal("نان خۆری پڕ بەرداشه", "وەڵام: دەمو ددان"));
        lstMatal.add(new Matal("ناوەوەی ئاسنەو دەرەوەی گۆشته", "وەڵام: کەباب"));
        lstMatal.add(new Matal("ئەو شته چیه نه سەرەتای هەیەو نه کۆتایی", "وەڵام: بازنه"));
        lstMatal.add(new Matal("ئەگەر ناوەراستەکەی دەربێنیت سڕ ئەبێت", "وەڵام: وشەی سور"));
        lstMatal.add(new Matal("نە هەورو نه بارانه چکچکه له دارانه", "وەڵام: کوندەڵان"));
        lstMatal.add(new Matal("پێکانی لەسەر زەوییەو سەریشێ لە سەرووی ئەستێرەکانەوەیه", "وەڵام: ئەفسەره"));
        lstMatal.add(new Matal("هەزاران تۆن (کیلۆ) (تەن (کیلۆ))قورسایی هەڵدەگرێت بەڵام بزمارێک هەڵناگرێت", "وەڵام: ئاوه"));
        lstMatal.add(new Matal("دوێنێ نەبووه و ئەمڕۆ له دایک بووەو سبێینێش دەمرێت", "وەڵام: ئەمڕۆیه"));
        lstMatal.add(new Matal("کوڕی ئاوه ئەگەر له ناو ئاودا به جێی بێڵیت دەمرێت", "وەڵام: سەهۆڵ"));
        lstMatal.add(new Matal("هەر ئەخواو تێر نابێ", "وەڵام: موقەست"));
        lstMatal.add(new Matal("هەڵدەپەڕی پێی نیه ، سپیه هێلکه نیه ، نامێنێ غەیبیش نیه", "وەڵام: تەرزه"));
        lstMatal.add(new Matal("هەتا بڕۆی زیاد دەکات", "وەڵام: جێ پێ"));
        lstMatal.add(new Matal("هەتا نەیشکێنی ناخورێ", "وەڵام: هێلکه"));
        lstMatal.add(new Matal("هەتا بای نەدەی گەوره نابێ", "وەڵام: تەشی"));
        lstMatal.add(new Matal("هەمیشه له ماڵه جارێ شیرینه و جارێ تاڵه", "وەڵام: زمان"));
        lstMatal.add(new Matal("هەمو شتێک دەخوا ئاو نەبێت", "وەڵام: ئاگر"));
        lstMatal.add(new Matal("قەسری سپی بێ دەرگا", "وەڵام: هێلکه"));
        lstMatal.add(new Matal("قورسەو کێشی نیه و ، دەر ئەچێ و پێی نیه", "وەڵام: گیان"));
        lstMatal.add(new Matal("کانیێکم هەیه سی و دوو گەوهەری تێدایه", "وەڵام: دەمو ددان"));
        lstMatal.add(new Matal("کراسی بێ تەقەڵ کڵاوی ڕەقه ، بۆ خواردن حەقه", "وەڵام: بەڕوو"));
        lstMatal.add(new Matal("کوشتم خوێنی نەبوو کەوڵم کرد چەرمی نەبوو", "وەڵام: قڕژال"));
        lstMatal.add(new Matal("دەیکڕیت ڕەشە به کاری دێنیت سووره و دەیڕێژیت بۆره", "وەڵام: خەڵووز"));
        lstMatal.add(new Matal("خوشکی خاڵتەو پورت نیه", "وەڵام: دایکته"));
        lstMatal.add(new Matal("چەندە درێژ بێت کورت دەبێت", "وەڵام: تەمەن"));
        lstMatal.add(new Matal("تا تۆ نەڕۆی ئەویش ناڕوات", "وەڵام: سێبەر"));
        lstMatal.add(new Matal("تاقه سوار دای به دیوار بوو به هەزار", "وەڵام: هەنار"));
        lstMatal.add(new Matal("چ شتێک به هەمو زمانەکانی جیهان قسه دەکات", "وەڵام: دەنگی گریانو پێکەنین"));
        lstMatal.add(new Matal("خێرا ترین ڕێگا بۆ پڕ کردنەوەی کورسی چیه", "وەڵام: له سەری دابنیشی"));
        lstMatal.add(new Matal("بۆ چی کابان حەز له سڕینی ئاوێنە دەکات ، نەک له شوشەی پەنجەره", "وەڵام: چونکه شوشەی پەنجەرە دەبێت له هەر دوو دیوەوه بسڕێتەوه بەڵام ئاوێنه له یەک دیوەوه"));
        lstMatal.add(new Matal("بۆچی کەروێشک بەسەر کێو دا دەڕوات", "وەڵام: چونکه ناتوانێت به ژێری دا بڕوات"));
        lstMatal.add(new Matal("ئەگەر سامانی هەمو دونیا به سەر مرۆڤ دا دابەش کرێت ، یەکی چەندەی بەر دەکەوێت", "وەڵام: هەر مرۆڤێک بەشی خۆئ بەردەکەوێت"));
        lstMatal.add(new Matal("له سکی دایکی دێته دەر ، پشتی باوکی دەخورێنێ", "وەڵام: شەقاته (شەمچه) "));
        lstMatal.add(new Matal("فافۆنێکی کون کونه ، دایمه به دەستی ژنه", "وەڵام: کەوگیر"));
        lstMatal.add(new Matal("به پڕی و به بەتاڵی یەک کێشی هەیە", "وەڵام: شریتی کاسێت"));
        lstMatal.add(new Matal("به هاوینو به زستان دایدەکوتن به کوڵەمستان", "وەڵام: هەویر شێلان"));
        lstMatal.add(new Matal("بەفره ئاو نیه ، دارستانه دار نیه", "وەڵام: نەخشه"));
        lstMatal.add(new Matal("هەڵدەبەزێ و دادەبەزێ دەمی نیه و کەس ناگەزێ", "وەڵام: مەشکه"));
        lstMatal.add(new Matal("ئەو بەندینخانه کامەیە که یەک بەندکراوی تێدایه", "وەڵام: دەمە"));
        lstMatal.add(new Matal("هاوڕێکەت ئەتوانێ هەڵیگرێت بەڵام تۆ ناتوانی", "وەڵام: تۆ خۆتیت"));
        lstMatal.add(new Matal("ناوەوەی چوارەو دەرەوەی داره", "وەڵام: گوێز"));
        lstMatal.add(new Matal("تا باران نەبارێت ناکرێتەوه", "وەڵام: چەتره"));
        lstMatal.add(new Matal("ڕەشە وەک بزن ، ورده وەک هەرزەن ، به پێنج بۆی دەچن به دوان دەیدزن", "وەڵام: کێچ"));

    }
}
