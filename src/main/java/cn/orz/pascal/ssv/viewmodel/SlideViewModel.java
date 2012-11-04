package cn.orz.pascal.ssv.viewmodel;

import android.util.Log;
import android.view.View;
import cn.orz.pascal.ssv.commons.AndroidUtils;
import cn.orz.pascal.ssv.config.Environment;
import cn.orz.pascal.ssv.injector.TwitterInjector;
import cn.orz.pascal.ssv.model.BMISocialService;
import cn.orz.pascal.ssv.model.RemoteSlide;
import com.google.inject.Guice;
import com.google.inject.Injector;
import gueei.binding.Command;
import gueei.binding.observables.IntegerObservable;
import gueei.binding.observables.ObjectObservable;
import org.json.JSONException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

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
    public final IntegerObservable currentIndex = new IntegerObservable(1);

    private final RemoteSlide remoteSlide = new RemoteSlide();

    public SlideViewModel() {
        try {
            this.remoteSlide.load(new URL("http://www.slideshare.net/koduki/tokyu-ruby05"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SAXNotRecognizedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SAXNotSupportedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TransformerException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    /**
     * calculate BMI.
     */
    public final Command next = new Command() {
        @Override
        public void Invoke(View arg0, Object... arg1) {
            try {
                if (currentIndex.get() < remoteSlide.getUrls().size() - 1) {
                    currentIndex.set(currentIndex.get() + 1);
                    Log.i("debug", "onNext " + currentIndex.get());

                    String url = remoteSlide.getUrls().get(currentIndex.get());
                    slideImage.set(AndroidUtils.getBitmap(url));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public final Command prev = new Command() {
        @Override
        public void Invoke(View arg0, Object... arg1) {
            try {
                if (currentIndex.get() > 0) {
                    currentIndex.set(currentIndex.get() - 1);
                    Log.i("debug", "onNext " + currentIndex.get());

                    String url = remoteSlide.getUrls().get(currentIndex.get());
                    slideImage.set(AndroidUtils.getBitmap(url));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

}
