package cn.orz.pascal.ssv.commons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: koduki
 * Date: 12/11/04
 * Time: 0:47
 * To change this template use File | Settings | File Templates.
 */
public class AndroidUtils {
    public static Bitmap getBitmap(String url) throws IOException {
        URL u = new URL(url);
        return BitmapFactory.decodeStream(u.openStream());
    }
}
