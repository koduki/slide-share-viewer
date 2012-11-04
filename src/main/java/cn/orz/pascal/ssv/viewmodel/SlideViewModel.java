package cn.orz.pascal.ssv.viewmodel;

import android.util.Log;
import android.view.View;
import cn.orz.pascal.ssv.commons.AndroidUtils;
import cn.orz.pascal.ssv.model.RemoteSlide;
import com.google.inject.Inject;
import gueei.binding.Command;
import gueei.binding.observables.IntegerObservable;
import gueei.binding.observables.ObjectObservable;
import org.json.JSONException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import javax.xml.transform.TransformerException;
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
    public final IntegerObservable currentIndex = new IntegerObservable(1);

    @Inject
    private RemoteSlide remoteSlide;

    @Inject
    public SlideViewModel() {
    }

    public void init(String baseUrl) throws IOException, TransformerException, SAXNotSupportedException, SAXNotRecognizedException, JSONException {
        this.remoteSlide.load(new URL(baseUrl));

        currentIndex.set(0);
        String url = remoteSlide.getUrls().get(currentIndex.get());
        slideImage.set(AndroidUtils.getBitmap(url));
    }

    /**
     * change next slide.
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

    /**
     * change next slide.
     */
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
