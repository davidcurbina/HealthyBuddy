package co.davidurbina.haelthybuddy;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by davidurbina on 4/20/17.
 */

public class DetailActivity extends AppCompatActivity {

    public static String NAME_EXTRA = "NAME";
    public static String TYPE_EXTRA = "TYPE";
    public static String SUMMARY_EXTRA = "SUMMARY";
    public static String DAY_EXTRA = "DAY";
    public static String TIME_EXTRA = "TIME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);


    }
}
