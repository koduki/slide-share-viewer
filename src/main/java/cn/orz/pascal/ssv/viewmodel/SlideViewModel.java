package cn.orz.pascal.ssv.viewmodel;

import android.util.Log;
import android.widget.ImageView;
import cn.orz.pascal.ssv.R;
import cn.orz.pascal.ssv.commons.AndroidUtils;
import cn.orz.pascal.ssv.config.Config;
import cn.orz.pascal.ssv.config.Environment;
import cn.orz.pascal.ssv.injector.TwitterInjector;
import cn.orz.pascal.ssv.model.BMI;
import cn.orz.pascal.ssv.model.BMISocialService;

import cn.orz.pascal.ssv.model.RemoteSlide;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import gueei.binding.Command;
import gueei.binding.bindingProviders.ImageViewProvider;
import gueei.binding.observables.DoubleObservable;
import gueei.binding.observables.ObjectObservable;
import gueei.binding.observables.StringObservable;
import android.view.View;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.net.URL;

/**
 * BMI Activity View Model.
 *
 * @author koduki
 */
public class SlideViewModel {
    /**
     *
     */
    public final ObjectObservable slideImage = new ObjectObservable();
    /**
     * body height.
     */
    public final StringObservable height = new StringObservable();
    /**
     * body weight.
     */
    public final StringObservable weight = new StringObservable();
    /**
     * BMI value.
     */
    public final StringObservable bmi = new StringObservable("0");


    /**
     * calculate BMI.
     */
    public final Command next = new Command() {
        private int currentIndex = 1;

        @Override
        public void Invoke(View arg0, Object... arg1) {
            //画像をリソースを設定
            try{
                this.currentIndex += 1;
                Log.i("debug", "onNext " + this.currentIndex);

                String url = new RemoteSlide().getUrls(new URL("http://www.slideshare.net/koduki/tokyu-ruby05")).get(this.currentIndex);

                slideImage.set(AndroidUtils.getBitmap(url));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };

    private BMISocialService createBmiSocialService() {
        Injector injector = Guice.createInjector(new TwitterInjector(Environment.getInstance().getProfile()));
        return injector.getInstance(BMISocialService.class);
    }
}
