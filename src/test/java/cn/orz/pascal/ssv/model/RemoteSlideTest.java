package cn.orz.pascal.ssv.model;

import cn.orz.pascal.ssv.commons.LogSource;
import cn.orz.pascal.ssv.commons.StandardLogSource;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;


@RunWith(RobolectricTestRunner.class)
public class RemoteSlideTest {
    private RemoteSlide remoteSlide;

    @Before
    public void inject() throws Exception {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(LogSource.class).to(StandardLogSource.class);
            }
        });
        this.remoteSlide = injector.getInstance(RemoteSlide.class);
    }

    @Test
    public void testGetUrls1() throws Exception {
        List<String> expected = Arrays.asList(
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-1-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-2-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-3-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-4-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-5-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-6-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-7-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-8-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-9-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-10-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-11-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-12-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-13-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-14-1024.jpg"
        );
        URL url = new URL("http://www.slideshare.net/koduki/tokyu-ruby05");
        remoteSlide.load(url);
        List<String> actual = remoteSlide.getUrls();

        assertEquals(expected, actual);

    }

    @Test
    public void testGenerateSlideUrl1() throws Exception {
        String baseUrl = "//image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-1-1024.jpg";
        int totalSlidesCount = 14;
        List<String> expected = Arrays.asList(
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-1-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-2-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-3-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-4-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-5-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-6-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-7-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-8-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-9-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-10-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-11-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-12-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-13-1024.jpg",
                "http://image.slidesharecdn.com/tokyuruby05-120729164050-phpapp01/95/slide-14-1024.jpg"
        );
        List<String> actual = remoteSlide.generateSlideUrl(baseUrl, totalSlidesCount);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateSlideUrl2() throws Exception {
        String baseUrl = "//image.slidesharecdn.com/poilite-110718023441-phpapp02/95/slide-1-1024.jpg";
        int totalSlidesCount = 3;
        List<String> expected = Arrays.asList(
                "http://image.slidesharecdn.com/poilite-110718023441-phpapp02/95/slide-1-1024.jpg",
                "http://image.slidesharecdn.com/poilite-110718023441-phpapp02/95/slide-2-1024.jpg",
                "http://image.slidesharecdn.com/poilite-110718023441-phpapp02/95/slide-3-1024.jpg"
        );
        List<String> actual = remoteSlide.generateSlideUrl(baseUrl, totalSlidesCount);

        assertEquals(expected, actual);
    }

}
