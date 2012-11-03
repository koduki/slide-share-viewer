package cn.orz.pascal.ssv.model;

import junit.framework.TestCase;

import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class RemoteSlideTest extends TestCase {
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
        RemoteSlide remoteSlide = new RemoteSlide();

        List<String> actual = remoteSlide.getUrls(url);

        assertEquals(expected, actual);

    }

    public void testGenerateSlideUrl1() throws Exception {
        RemoteSlide remoteSlide = new RemoteSlide();
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

    public void testGenerateSlideUrl2() throws Exception {
        RemoteSlide remoteSlide = new RemoteSlide();
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
