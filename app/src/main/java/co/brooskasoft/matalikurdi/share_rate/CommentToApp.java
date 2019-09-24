package co.brooskasoft.matalikurdi.share_rate;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import co.brooskasoft.matalikurdi.R;


// how use
// CommentToApp cotaap=new CommentToApp( ActivityDotThis);
public class CommentToApp {

    public  CommentToApp(){

    }

    public   CommentToApp(Context ActivityDotThis) {
        if(ActivityDotThis!=null) {
//            String string = ActivityDotThis.getResources().getString(ActivityDotThis.getResources().getIdentifier("market","string",ActivityDotThis.getPackageName()));
            String string = ActivityDotThis.getResources().getString(R.string.app_name);
            if (string.startsWith("BAZAAR")) {
                try {
                    Intent abuot = new Intent(Intent.ACTION_EDIT);
                    abuot.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    abuot.setData(Uri.parse("bazaar://details?id=" + ActivityDotThis.getApplicationContext().getPackageName()));
                    abuot.setPackage("com.farsitel.bazaar");
                    ActivityDotThis.startActivity(abuot);
                } catch (Throwable tr) {
                    Toast.makeText(ActivityDotThis, "بەرنامەی کافه بازار لەسەر مۆبایلەکەت نیه", Toast.LENGTH_LONG).show();
                }
            } else {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("http://play.google.com/store/apps/details?id=" + ActivityDotThis.getApplicationContext().getPackageName()));
                    intent.setPackage("com.android.vending");
                    ActivityDotThis.startActivity(intent);
                } catch (Throwable tr) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + ActivityDotThis.getApplicationContext().getPackageName()));
                        ActivityDotThis.startActivity(intent);
                    } catch (Throwable trrr) {
                        Toast.makeText(ActivityDotThis, "هیچ مارکێتێک لەسەر مۆبایلەکەت نیه", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }
}
