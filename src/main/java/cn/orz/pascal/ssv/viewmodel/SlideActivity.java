package cn.orz.pascal.ssv.viewmodel;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import cn.orz.pascal.ssv.R;
import cn.orz.pascal.ssv.commons.AndroidUtils;
import gueei.binding.app.BindingActivity;

import java.io.IOException;

/**
 * Top Activity.
 *
 * @author koduki
 */
public class SlideActivity extends BindingActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // model binding.
        SlideViewModel model = new SlideViewModel();
        setAndBindRootView(R.layout.main, model);

        ImageView image = (ImageView) findViewById(R.id.imageView);
        String url = "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-1-1024.jpg";
        //画像をリソースを設定
        try {
            image.setImageBitmap(AndroidUtils.getBitmap(url));
        } catch (IOException e) {
            Log.v("error", "load image error", e);
        }

    }
}
