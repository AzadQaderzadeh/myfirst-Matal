package co.brooskasoft.matalikurdi.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import co.brooskasoft.matalikurdi.R;
import co.brooskasoft.matalikurdi.adapter.ViewPagerAdapter;
import co.brooskasoft.matalikurdi.fragment.FourFragment;
import co.brooskasoft.matalikurdi.fragment.OneFragment;
import co.brooskasoft.matalikurdi.fragment.ThreeFragment;
import co.brooskasoft.matalikurdi.fragment.TwoFragment;
import co.brooskasoft.matalikurdi.utils.Tools;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MobileAds.initialize(this, Key.AD_UNIT_ID);

        initToolbar();
//        initNavigationMenu();
        TabLayout tabLayout = findViewById(R.id.tablayout_id);
        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragment Here

        adapter.AddFragment(new OneFragment(), "");
        adapter.AddFragment(new TwoFragment(), "");
        adapter.AddFragment(new ThreeFragment(), "");
        adapter.AddFragment(new FourFragment(), "");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("یەکەم");
        tabLayout.getTabAt(1).setText("دووەم");
        tabLayout.getTabAt(2).setText("سێیەم");
        tabLayout.getTabAt(3).setText("چوارم");

        // Remove Shadow From action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                    drawer.closeDrawer(Gravity.RIGHT);
                } else {
                    drawer.openDrawer(Gravity.RIGHT);
                }
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
//        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle(R.string.app_name);
        Tools.setSystemBarColor(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {


            case R.id.nav_email: {
//                Intent i = new Intent(Intent.ACTION_SEND);
                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "broooskasoft@gmail.com", null));
//                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, MainActivity.this.getResources().getString(R.string.app_name));
                i.putExtra(Intent.EXTRA_SUBJECT, "ئەپی مەتەڵی کوردی");
                i.putExtra(Intent.EXTRA_TEXT, "دەقی وتار (پەیام)");
                try {
                    startActivity(Intent.createChooser(i, "ناردنی ئێمەیل ..."));
                } catch (android.content.ActivityNotFoundException ex) {

                    Toast.makeText(MainActivity.this, "هیچ بەرنامەیەکی ناردنی ئیمەیل نیه", Toast.LENGTH_LONG).show();

                }
                break;
            }
            case R.id.nav_other_app: {
//                String string = MainActivity.this.getResources().getString(MainActivity.this.getResources().getIdentifier("market","string",MainActivity.this.getPackageName()));
                String string = MainActivity.this.getResources().getString(R.string.app_name);

                if (string.startsWith("BAZAAR")) {
                    try {
                        Intent intent1 = new Intent(Intent.ACTION_VIEW);
                        intent1.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + "5533"));
                        intent1.setPackage("com.farsitel.bazaar");
                        startActivity(intent1);
                    } catch (android.content.ActivityNotFoundException anfe) {
//                        show_Toast("کافه بازار نصب نیست.");
                    }
                } else {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/developer?id=BrooskaSoft")));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:BrooskaSoft")));
                        } catch (android.content.ActivityNotFoundException anfe3) {
                        }
                    }
                }
                break;
            }
            case R.id.nav_present_to_other:
                co.brooskasoft.matalikurdi.share_rate.PresentAppToOther pata = new co.brooskasoft.matalikurdi.share_rate.PresentAppToOther(MainActivity.this);
                break;
            case R.id.nav_star_comment:
                co.brooskasoft.matalikurdi.share_rate.CommentToApp cotaap = new co.brooskasoft.matalikurdi.share_rate.CommentToApp(MainActivity.this);
                break;

            case R.id.About_Us:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
