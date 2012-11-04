package cn.orz.pascal.ssv.viewmodel;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import cn.orz.pascal.ssv.R;
import cn.orz.pascal.ssv.commons.AndroidLogSource;
import cn.orz.pascal.ssv.commons.AndroidUtils;
import cn.orz.pascal.ssv.commons.LogSource;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import gueei.binding.app.BindingActivity;
import org.json.JSONException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URL;

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
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(LogSource.class).to(AndroidLogSource.class);
            }
        });

        SlideViewModel model = injector.getInstance(SlideViewModel.class);
        setAndBindRootView(R.layout.main, model);

        try {
            model.init("http://www.slideshare.net/koduki/tokyu-ruby05");
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
}
