package cn.orz.pascal.ssv.viewmodel;

import cn.orz.pascal.ssv.R;
import gueei.binding.app.BindingActivity;
import android.os.Bundle;

/**
 * Top Activity.
 *
 * @author koduki
 */
public class BmiActivity extends BindingActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // model binding.
        BmiViewModel model = new BmiViewModel();
        setAndBindRootView(R.layout.main, model);
    }
}
