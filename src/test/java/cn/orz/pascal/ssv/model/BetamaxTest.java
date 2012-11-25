package cn.orz.pascal.ssv.model;

/**
 * Created with IntelliJ IDEA.
 * User: koduki
 * Date: 12/11/26
 * Time: 7:44
 * To change this template use File | Settings | File Templates.
 */
import co.freeside.betamax.httpclient.BetamaxRoutePlanner;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import org.junit.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class BetamaxTest {
    @Rule public Recorder recorder = new Recorder();

    @Betamax(tape="my tape")
    @Test
    public void testMethodThatAccessesExternalWebService()throws Exception{
        // URL接続
        HttpURLConnection con = (HttpURLConnection)new URL("http://www.google.com/").openConnection();
        con.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

        // HTMLソースの表示
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }

        // URL切断
        br.close();
        con.disconnect();
    }
}
