package cn.orz.pascal.ssv.model;

import cn.orz.pascal.ssv.config.Environment;
import cn.orz.pascal.ssv.injector.TwitterInjector;
import cn.orz.pascal.ssv.model.BMISocialService;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import junit.framework.TestCase;

import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import twitter4j.Status;
import twitter4j.User;

import static org.mockito.Mockito.*;

public class BMISocialServiceTest extends TestCase {

    public void testTweet1(){
        String name = "koduki";

        BMISocialService bmiSocialService = createInstance();
        Status result = bmiSocialService.tweet(24.3374);

        assertEquals(name, result.getUser().getScreenName());
        assertEquals("うわっ…私のBMI、高すぎ(BMI:24.3)", result.getText());
    }

    public void testTweet2(){
        String name = "koduki";

        BMISocialService bmiSocialService = createInstance();
        Status result = bmiSocialService.tweet(19.5074);

        assertEquals(name, result.getUser().getScreenName());
        assertEquals("うわっ…私のBMI、低すぎ(BMI:19.5)", result.getText());
    }

    private BMISocialService createInstance() {
        Injector injector = Guice.createInjector(new TwitterInjector(Environment.Profile.DEV));
        return injector.getInstance(BMISocialService.class);
    }
}
