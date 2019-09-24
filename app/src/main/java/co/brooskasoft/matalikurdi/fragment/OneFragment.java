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

public class OneFragment extends Fragment implements ItemClickListener {
    private Dialog oneDialog;
    private List<Matal> lstMatal;

    public OneFragment() {
    }

    @Override
    public void onPositionClicked(int position, int historyTable_id, final String name, final String phone) {
        //دیالوگ تو کاستوم شده هست من یه دیالوگ پیش فرض تعریف می کنم تا کدها رو تست کنیم ببینیم درست کار می کنند بعد خودت می تونی کاستوم دیالوگت رو کد نویسی بکنی
        oneDialog.setContentView(R.layout.pop_up_dialog);
        Button imageCancelDialogAdsApp = oneDialog.findViewById(R.id.btnCancel);
        TextView textView = oneDialog.findViewById(R.id.walam_in_dialog);
        textView.setText(phone);
        Button share_to_my_Friend = oneDialog.findViewById(R.id.send_To_Frinds_btn);
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

                oneDialog.dismiss();
            }

        });
        oneDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        oneDialog.show();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

//        MobileAds.initialize(getContext(), Key.AD_UNIT_ID);
//        AdView mAdview = view.findViewById(R.id.ad_mob_banner_one);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdview.loadAd(adRequest);

        RecyclerView myrecyclerview = view.findViewById(R.id.one_recycler);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), lstMatal, OneFragment.this);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        oneDialog = new Dialog(getContext());

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstMatal = new ArrayList<>();
        //new matal
        lstMatal.add(new Matal("سەری له ورگی گەوره تره", "وەڵام: مێرووله"));
        lstMatal.add(new Matal("سی سوار هاتنه شار ، خۆیانکرد به همو ماڵێکدا", "وەڵام: ڕەمەزان"));
        lstMatal.add(new Matal("سەیری خەڵکی دەکا و درۆ لەگەڵ کەس ناکات", "وەڵام: ئاوێنه"));
        lstMatal.add(new Matal("سەد قوتو له قوتیەکدایه", "وەڵام: پیاز"));
        lstMatal.add(new Matal("سەر سپیه و مووی نیه  هەڵدەپەڕێ و پێی نیه", "وەڵام: تەرزه"));
        lstMatal.add(new Matal("سەر پۆشاکی بن خۆری گەر نەیزانی هەرنەمری", "وەڵام: کڵاش"));
        lstMatal.add(new Matal("سەری مەبڕە و بیخۆ", "وەڵام: ماسی"));
        lstMatal.add(new Matal("سێ خانەی تەنگ و سێ نانی تەنک", "وەڵام: تەڵەمشک"));
        lstMatal.add(new Matal("سەوزه وەک خەیار ، بەرزه وەک چنار ، ترشه وەک هەنار", "وەڵام: ڕێواس"));
        lstMatal.add(new Matal("سەد کەسی کڵاو سوورو سپی له ژوورێکا ڕاکشاون", "وەڵام: شەقاته (شەمچه)"));
        lstMatal.add(new Matal("شیشەکەی گۆشته و کەبابەکەی ئاسنه", "وەڵام: پەنجەو موستیله (ئەنگوستیله)"));
        lstMatal.add(new Matal("شیرینه هەنگوین نیه ، تاڵه ژەهری مار نیه ، له ئەشکەوتایه دێو نیه", "وەڵام: زمان"));
        lstMatal.add(new Matal("سەری دەبڕی و بۆی دەگری", "وەڵام: پیاز"));
        lstMatal.add(new Matal("سەری تەسکه و بنی بڵاوه ، گەر نازانی لاچۆ لەم ناوه", "وەڵام: کڵاوه"));
        lstMatal.add(new Matal("سوارێک هاتبوو به غارەغار رمی لێدابوو به هەزار", "وەڵام: هەنار"));
        lstMatal.add(new Matal("شارەکەمان بێماڵه ، دەریاکەشمان بێ ئاوه ، شاخیشمان تەختی ئاوه", "وەڵام: نەخشه"));
        lstMatal.add(new Matal("شتێک هەیە ڕەحمەتە ، لای خەڵکی زەحمەته", "وەڵام: باران"));
        lstMatal.add(new Matal("خڕه وەک گۆیه ، ترشه وەک دۆیه ، ئاقڵ لیمۆیه", "وەڵام: لیمۆ"));
        lstMatal.add(new Matal("ئەو شته چیه به کار ناهێندرێ هەتا نەیشکینی", "وەڵام: هێلکه"));
        lstMatal.add(new Matal("شتێک خۆی نابینایە و رێگا به کەسی تر پیشان دەدات", "وەڵام: گاڵۆک"));
        lstMatal.add(new Matal("ئەو شته چیه له شاخەوه  دێته خوار و ناجووڵێت", "وەڵام: جاده "));
        lstMatal.add(new Matal("چەماوەی چەماوه ، مردی زیندووی تێکرواه", "وەڵام: قەفەزی کەو"));
        lstMatal.add(new Matal("سەری سەوزه  لەشی ڕەشه ، ناوی سپیە و دڵی گەشه", "وەڵام: باینجان"));
        lstMatal.add(new Matal("ئەمە چیه یەکەو نابێ به دوو", "وەڵام: خودا"));
        lstMatal.add(new Matal("سێیەو(3) نابێ به چوار(4)", "وەڵام: تەڵاق"));
        lstMatal.add(new Matal("نه گەڵی هەیه نە گوان ، شیر ئەدا به گشت جیهان", "وەڵام: هەور"));
        lstMatal.add(new Matal("شەشە نابێ به حەوت", "وەڵام: شەشەڵان"));
        lstMatal.add(new Matal("کاوڕه لەڕێ له بن مەڕێ هەر هەڵئەپەرێ", "وەڵام: تەرزه"));
        lstMatal.add(new Matal("ڕەشە وەکوو قیر ، سپییه ووکو شیر ، ڕاسته وەکوو تیر", "وەڵام: سنگی سووچەڕ"));
        lstMatal.add(new Matal("قەڵای گەچی لێی دەرناچی", "وەڵام: هێلکه"));
        lstMatal.add(new Matal("چاوی کراوەی هەیە بەڵام ناشبینێ", "وەڵام: دەرزی"));
        lstMatal.add(new Matal("بارهەڵگرە و سێ قاچه", "وەڵام: سێ کوچکە"));
        lstMatal.add(new Matal("شل و نەرم و بێ موه له ناو ئاو دایەو زیندوه", "وەڵام: بۆق"));
        lstMatal.add(new Matal("شەش بەن و دوو قاپ و دارێکه", "وەڵام: تەرازوو - قەپان"));
        lstMatal.add(new Matal("له کاتی خەوتن دا پێڵاوەکانی داناکەنێت", "وەڵام: ئەسپ"));
        lstMatal.add(new Matal("ئەو شته چیه نیمچه قسه کەرێکه بەڵام لاڵه", "وەڵام: وێنەی فۆتۆگراف"));
        lstMatal.add(new Matal("چ مانگێک بیستو هشت (28) ڕۆژی تێدایه", "وەڵام: هەموو مانگەکان بیست وهەشت(28) ڕۆژیان تێدایه"));
        lstMatal.add(new Matal("چ ژمارەیەک کەم دەکات  ئەگەر هەڵت گێڕایەوه", "وەڵام: ژوماره هەشت (8)"));
        lstMatal.add(new Matal("له بازار ڕەشه ، له ماڵەوه سووره ، وەک فڕی دەدەی سپیه", "وەڵام: خەڵوزه"));
        lstMatal.add(new Matal("شەش پەڕ و دوو چاوه دوژمنی خۆر و هەتاوه", "وەڵام: ماسی"));
        lstMatal.add(new Matal("لەپەنجەرەوه ئەچێته ژوور ، له درگاوه دێته دەر", "وەڵام: نامەو پۆست"));
        lstMatal.add(new Matal("قورسه و کێشی نیه  و دەرئەچێ و پێی نیه", "وەڵام: گیان"));
        lstMatal.add(new Matal("قسه دەکات و دەمی نیه ، شاران دەگەڕێ و پێی نیه", "وەڵام: قەڵەم"));
        lstMatal.add(new Matal("شەش پەڕ و دوو چاوه دوژمنی خۆر و هەتاوه", "وەڵام: ماسی"));
        lstMatal.add(new Matal("شتێکم هەیە بچووکه ،لای میوانان دەڵێی بووکه", "وەڵام: چرا"));
        lstMatal.add(new Matal("ئەوه چیه هەندێک له ئاژەڵەکان له ناو دمیان دایه ، و هەندێک ناوکلکیان دایه", "وەڵام: گەستن (پێوه دان)"));
        lstMatal.add(new Matal("ئەوه چیه تا زیادتر بیکێشیت کورتتر دەبێتەوه", "وەڵام: جگەره (سیگار)"));
        lstMatal.add(new Matal("ئەوه چیه تا زیادتر بیکێشیت درێژتر دەبێت", "وەڵام: خەت"));
        lstMatal.add(new Matal("ئەوه چیه دوەو نابێ به سێ", "وەڵام: شەو و رۆژ"));
        lstMatal.add(new Matal("ئەوه کام دەیه یه که نابێت به یازده", "وەڵام: قامکەکانی دەست"));
        lstMatal.add(new Matal("ئەوه چیه هی خۆتەو بۆخۆت کەمتر به کاری دێنیت", "وەڵام: ناو"));
        lstMatal.add(new Matal("ئەوه چیه چوارەو نابێ به پێنج", "وەڵام: چوار ورزی ساڵ"));
        lstMatal.add(new Matal("سێ دوکان له ناو یەک ، یەکەمیان چەرم فرۆش ، دوهەمیان پەرده فرۆش سێهەمیان یاقوت فرۆش", "وەڵام: ئەنار(هەنار)"));
        lstMatal.add(new Matal("ئەو کام حەوتەیەو نابێ به هەشت", "وەڵام: حەوت تەبەقی ئاسمان، حەوت ڕۆژی هەفته"));
        lstMatal.add(new Matal("ئەوه چیه که دایدەنەی بێدەنگه و هەڵی ئەگری دەنگی هەیه", "وەڵام: زەنگوڵه"));
        lstMatal.add(new Matal("ئەوه چیه هەر چی زیادتر لێی هەڵگری ، گەوره تر دەبێت", "وەڵام: چاڵ"));
        lstMatal.add(new Matal("ئەڕواتو سەری به بەرددا دەدرێت", "وەڵام: ئاو"));
        lstMatal.add(new Matal("ئەوه چیه دو قاچی هەیه و دوانی کەش به قەرز وەردەگرێت و کەسیش پێی ناگاتەوه", "وەڵام: بایسیکل (پاسکیل)(دوچەرخه)"));
        lstMatal.add(new Matal("ئەوه کام رازدارەیه تا سەری نەبڕی راز دەرنابڕێت", "وەڵام: نامە"));
        lstMatal.add(new Matal("ئەوه چیه بەقەد هەرمێێکه هەم سوره و هەم سپی و هەم سەوز و هەم شین ، تەم و مژ نیه و وەکو مانگ ڕوناکه ، بێگیانە ، هەمیشه ناو بۆلێک(حوباب) دایه", "وەڵام: گڵۆپ (لامپ - لایت)"));
        lstMatal.add(new Matal("کاتێک کۆلۆمبێس ئەمریکای دۆزییەوه لەسەر چی وەستا", "وەڵام: لەسەر قاچەکانی"));

    }
}


