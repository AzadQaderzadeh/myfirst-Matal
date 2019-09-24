package co.brooskasoft.matalikurdi.share_rate;


import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import co.brooskasoft.matalikurdi.R;

// how use
// PresentAppToOther pata=new PresentAppToOther(ActivityDotThis);
public class PresentAppToOther {

    public PresentAppToOther() {
    }

    public PresentAppToOther(Context ActivityDotThis) {
        if (ActivityDotThis != null) {

//            String string = ActivityDotThis.getResources().getString(ActivityDotThis.getResources().getIdentifier("market","string",ActivityDotThis.getPackageName()));
            String string = ActivityDotThis.getResources().getString(R.string.app_name);
            if (string.startsWith("BAZAAR")) {
                try {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    String shareBody = ActivityDotThis.getString(R.string.app_name)
                            + System.getProperty("line.separator")
                            + "https://cafebazaar.ir/app/"
                            + ActivityDotThis.getApplicationContext().getPackageName()
                            + System.getProperty("line.separator")
                            + "بەکاری بێنن بەرنامەیەکی چاکه";
                    // Add data to the intent, the receiving app will decide
                    // what to do with it.
                    //share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    ActivityDotThis.startActivity(Intent.createChooser(sharingIntent, "ناردن به: "));
                } catch (Throwable tr) {
                    //String hh=tr.toString();
                    Toast.makeText(ActivityDotThis, "کێشەی هەیه دوباره تاقی وەکه.", Toast.LENGTH_LONG).show();
                }
            } else {
                try {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    String shareBody = ActivityDotThis.getString(R.string.app_name)
                            + System.getProperty("line.separator")
                            + "http://market.android.com/details?id="
                            + ActivityDotThis.getApplicationContext().getPackageName()
                            + System.getProperty("line.separator")
                            + "بەکاری بێنن بەرنامەیەکی چاکه";
                    // Add data to the intent, the receiving app will decide
                    // what to do with it.
                    //share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    ActivityDotThis.startActivity(Intent.createChooser(sharingIntent, "ناردن به: "));
                } catch (Throwable tr) {
                    //String hh=tr.toString();
                    Toast.makeText(ActivityDotThis, "کێشەی هەیه دوباره تاقی وەکه.", Toast.LENGTH_LONG).show();
                }
            }

        }
    }
}
