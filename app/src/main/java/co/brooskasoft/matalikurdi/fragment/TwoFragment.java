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


public class TwoFragment extends Fragment implements ItemClickListener {
    private Dialog twoDialog;
    private List<Matal> lstMatal;

    public TwoFragment() {

    }

    @Override
    public void onPositionClicked(int position, int historyTable_id, final String name, final String phone) {
//برای این که تو این فرگمنت هم کار کنه باید همون کارها رو اینجا هم پیست کنی
        //دیالوگ تو کاستوم شده هست من یه دیالوگ پیش فرض تعریف می کنم تا کدها رو تست کنیم ببینیم درست کار می کنند بعد خودت می تونی کاستوم دیالوگت رو کد نویسی بکنی
        twoDialog.setContentView(R.layout.pop_up_dialog);
        Button imageCancelDialogAdsApp = twoDialog.findViewById(R.id.btnCancel);
        TextView textView = twoDialog.findViewById(R.id.walam_in_dialog);
        textView.setText(phone);
        Button share_to_my_Friend = twoDialog.findViewById(R.id.send_To_Frinds_btn);
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

                twoDialog.dismiss();
            }

        });
        twoDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        twoDialog.show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

//        MobileAds.initialize(getContext(), Key.AD_UNIT_ID);
//        AdView mAdview = view.findViewById(R.id.ad_mob_banner_two);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdview.loadAd(adRequest);

        RecyclerView myrecyclerview = view.findViewById(R.id.two_recycler);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), lstMatal, TwoFragment.this);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);

        twoDialog = new Dialog(getContext());

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstMatal = new ArrayList<>();

        lstMatal.add(new Matal("ئەینم پێتەوە لێت ناوێتەوە", "وەڵام: ناو"));
        lstMatal.add(new Matal("ئەیکەی یا ئەییەی", "وەڵام: نوێژ و بانگ"));
        lstMatal.add(new Matal("دار تاشیاو ، نەجار نەدیوه ، ئارد هارپیاو ئاسیاو نەدیده ، کەوای دوریاو خەیات نەدیده", "وەڵام: سرینچک"));
        lstMatal.add(new Matal("خڕەو ڕەقه وەک کەلا ، چوار منداڵ له زکیدایه", "وەڵام: گوێز"));
        lstMatal.add(new Matal("ئەگەر بەردێکی سوور بخەیته نێو ئاوی دەریاوه ، چ دەبێت", "وەڵام: هیچ نابێت بەردەکه تەڕ دەبێت"));
        lstMatal.add(new Matal("ئۆخەی ئۆخەی لپ و لچ،خوا کارێکی کرد نەتیکرده کچ", "وەڵام: کوڕ"));
        lstMatal.add(new Matal("هۆی سەرەکی تەڵاق چیه", "وەڵام: زوەاج و زەماوەند کردن"));
        lstMatal.add(new Matal("خانم پەڕۆ قن", "وەڵام: کەنوو "));
        lstMatal.add(new Matal("خۆمان هەمانه خوا نیەتی", "وەڵام: خوا"));
        lstMatal.add(new Matal("خۆر له خۆرئاوا ، ئاو له ئەفتاوه ، هەرکەس بیزانێ عەقڵێ تەواوه", "وەڵام: نوێژه"));
        lstMatal.add(new Matal("حەوزێکم هەس مارێکی ها تیا ، حەوزێکه له مارەکه ئەخوا ، مارەکه له حەوزەکا ئەخوا", "وەڵام: لامپا"));
        lstMatal.add(new Matal("حەواییلکه ، حەوا ئەکا ، وه دەس و پا سەما ئەکا ، کولێره بۆ کوڕ پاوشا ئەکا", "وەڵام: هەنگ"));
        lstMatal.add(new Matal("حەزرەت پەنجه کێشی کوڕ چ پێغەمبەرێک بوو", "وەڵام: تەنوور"));
        lstMatal.add(new Matal("جوتێک عەسحابەی حەق ئافەریده ، هەم زەحمەتکێش و سەحرا چەریده", "وەڵام: گای جووت"));
        lstMatal.add(new Matal("پێنج فەرزەو ((بسم الله))ی تیا نییه", "وەڵام: بانگ"));
        lstMatal.add(new Matal("پانێ له بان پانێ ، قنجێ له ناو کوناکەی ،دەستی ئەگرێ وەلاکەی ، خولی ئەدا بۆ کاکەی ", "وەڵام: هاره"));
        lstMatal.add(new Matal("تەواوی دونیا بیهێنی سەر ملی هیچی لێ نایێ ، بیخەیته ناو ئاو ئەشکێ ", "وەڵام: کاغەز (لێنووس)"));
        lstMatal.add(new Matal("تەپێک و بانێ ، چوار بزنو شوانێ", "وەڵام: دەست"));
        lstMatal.add(new Matal("تانجیه زەردەی ئەڵقه له گوێ ، دەوران ئەکا له دەوری دێ", "وەڵام: تەرازو"));
        lstMatal.add(new Matal("تاڵێ هاوریشم ، هەتا بەغا ئەیکێشم", "وەڵام: ڕێگا"));
        lstMatal.add(new Matal("بونگسێ له کاورا ، جفتێ له ژن", "وەڵام: نوێژ"));
        lstMatal.add(new Matal("براکەم ها له عەرەوشه ، بار کەرەکەی درەوشه", "وەڵام: ژوو"));
        lstMatal.add(new Matal("بەچکەکەی شیر ئەدات به دایکی", "وەڵام: کووره ی نەوتی"));
        lstMatal.add(new Matal("بەری له بەحرانه ، پشتی له کێوانه ، خواردنی خەل و خەرمانه", "وەڵام: ئاش"));
        lstMatal.add(new Matal("بەری بەرخه ، پشتی کاره ، دەمی موقەسته ، کلکی ماره", "وەڵام: قشقەڕه"));
        lstMatal.add(new Matal("به سێ براوه ڕیخۆڵێکەیان هەیه", "وەڵام: تەزبێح"));
        lstMatal.add(new Matal("باوک سێ ساڵان کوڕی ئەچێ بۆ شار", "وەڵام: ترێ"));
        lstMatal.add(new Matal("بانێکه و بنبانێکه ، چوار مەڕو  شوانێکه", "وەڵام: دەست"));
        lstMatal.add(new Matal("سەرەوەی گۆشتەو ژێری موو", "وەڵام: لووت"));
        lstMatal.add(new Matal("باڵی هەیه نافڕێ ، قونی هەیه ناتڕێ", "وەڵام: ماسی"));
        lstMatal.add(new Matal("گەر بچێته ناو ئاو تەر نابێت ، گەر بچێته ناو ڕۆن دا چەور نابێت", "وەڵام: سێبەر"));
        lstMatal.add(new Matal("بێ گیانە و گیاندارە", "وەڵام: مار"));
        lstMatal.add(new Matal("ئەیکەیتە خۆتا حەزی پێ ئەکەی", "وەڵام: کەوچک"));
        lstMatal.add(new Matal("ئەوەڵ گردە دووەم پانە،ئەرێ کەر نیت بێژە نانە", "وەڵام: نان"));
        lstMatal.add(new Matal("ئەوە چییە هەر روو ئەکا لە خوا", "وەڵام: کولانجە"));
        lstMatal.add(new Matal("ئەو شتە چییە، بێ قاچ و باڵە، هەر کات بمرێ گۆشتی حەڵاڵە", "وەڵام: ماسی"));
        lstMatal.add(new Matal("ئەمە چییە، ئەستەغفیرەڵڵا، خوایش ئەنێتە ژێر", "وەڵام: قەڵەم"));
        lstMatal.add(new Matal("ئەمە چییە چی بە چییە،کابرایێکی قاچاخ چییە", "وەڵام: مشک"));
        lstMatal.add(new Matal("ئەچێتە دەرەوەر پڕە، دێتە ماڵەوە خاڵییە", "وەڵام: کەوش"));
        lstMatal.add(new Matal("له کام شەڕەدا ناپلێئون کۆچی دوایی کرد", "وەڵام: له دواهەمین شەڕی دا"));
        lstMatal.add(new Matal("ئەگەر هەشت کەس له ده کاژێردا بتوانن دیوارێک ساز بکەن ، چوار کەس له چەند کاژێر دەتوانن ئەو دیواره ساز بکەن", "وەڵام: هیچ ، چونکه ئەو هەشت کەسه له پێشتر ئەو دیوارەیان ساز کردوه"));
        lstMatal.add(new Matal("نامەی سەربەخۆیی ئەمریکا له کوێ ئیمزا کرا", "وەڵام: له خواری نامەکەدا"));
        lstMatal.add(new Matal("هۆی سەرەکی سەرنەکەوتن چیه", "وەڵام: تاقی کاری (تاقی کردنەوه)(ئیمتیحانات)"));
        lstMatal.add(new Matal("چ شتانێک ناتوانیت له چێشتهەنگاو(نانی بەیانیان) بخۆیت", "وەڵام: نانی نیوەڕۆو  و نانی شەو (شێو)"));
        lstMatal.add(new Matal("مرۆڤێک چۆن دەتوانێت هەشت ڕۆژ نەخەوێت", "وەڵام: کێشەنیه ، شەوانه دەخەوێت"));
        lstMatal.add(new Matal("ئەگەرلە دەستێکتدا سێ سێوو چوار پرتەقاڵت هەبێت و لەدەستەکەی دیکەت دا سێ پرتەقاڵو چوار سێوت هەبێت چیت هەیه", "وەڵام: دەستانێکی زۆر زۆر گەوره"));
        lstMatal.add(new Matal("ئەوە چیه خڕەو چکۆلەیەو ، هەڵواستراوه ، درێژە", "وەڵام: هێشوی ترێ"));
        lstMatal.add(new Matal("لە من و تۆ چیرۆک ئەگێڕێتەوه ، ئەوه چیه بێزمانەو قسان دەکان ، بێ ترس باسی ئەمو ئەوان دەکات ، بی ێەویەی که زمانو لێوو ددانی ببێ ، بێ ئامانج ئەکوتێک و قسەی دڵ دەکات", "وەڵام: کتێب"));
        lstMatal.add(new Matal("ئەوەچیه هەندێک له ئاژەڵان ناو دەمیان دایه و هەندێکی دیکەش له کلکیان دایه ", "وەڵام: (نیش - کوتانی ژار (ژەهر))"));
        lstMatal.add(new Matal("ئەوه چیه شەش پیتی خۆشناوه ، هەومان ئاواتەخوازی هەن ، دنیایێکی سەیرو سەمەرەیه ، دوپیتی لێ لابەی دەبێته هەشت", "وەڵام: بەهەشت"));
        lstMatal.add(new Matal("ئەوه کام زەویەیه که لەوەتی هەیه تا کو ئێستا یەک جار خۆری هەتاوی لێ دراوه", "وەڵام: (ئاوی چۆمی نیل (چەمی نیل))"));
        lstMatal.add(new Matal("ئەوه چیه خودا به ژنی نەداوه", "وەڵام: پێغەمبەری"));
        lstMatal.add(new Matal("ئەوه چیه هەوان خواردویانه جگه له حەزرەتی ئادەم (د . س)", "وەڵام: شیری دایک"));
        lstMatal.add(new Matal("ئەوه چیه خوێنی ڕەش دەخواتو به ڕێگای سپی دا دەروات", "وەڵام: قەڵەم نەی (قامیش)"));
        lstMatal.add(new Matal("ژنو مێردێک 7 کوڕیان هەیه ، هەر کوڕێک یەک خوشکی هەیه ، ئەو بنەماڵەیه چند کەسن", "وەڵام: 10 کەس"));
        lstMatal.add(new Matal("ئەوه چیه له داره و بەڵام نابڕدرێتەوه", "وەڵام: ئارده مشار"));
        lstMatal.add(new Matal("ئەوه چیه من ئەڕۆم ئەو دەمێنێتەوه", "وەڵام: جێ قاچ (لاق)(پا)"));
        lstMatal.add(new Matal("ئەوه چیه هەموو کەس دەیبینێت بەڵام خوا نایبینێت", "وەڵام: خەو"));
        lstMatal.add(new Matal("ئەوه چیه هەمو مرۆڤێک خواردویەتی جگه له حەزرەتی ئادەم", "وەڵام: شیری دایک"));
        lstMatal.add(new Matal("ئەوه چیه دو چاوی هەیه ، کاتێک که دەست دەکەیت به چاوەکانیا گۆێکانی (گۆێچکه) تیژ دەبێت", "وەڵام: موقەست (قەیچی)"));
    }
}
