package cn.orz.pascal.ssv.model;

import android.util.Log;
import cn.orz.pascal.ssv.commons.XmlUtil;
import org.ccil.cowan.tagsoup.Parser;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: koduki
 * Date: 12/11/03
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public class RemoteSlide {
    private List<String> urls = new ArrayList<String>();

    public void load(URL url) throws IOException, SAXNotRecognizedException, SAXNotSupportedException, TransformerException, JSONException {
        long start = System.currentTimeMillis();
        JSONObject json = this.getJson(this.getDocument(url));

        String baseUrl = json.getJSONObject("slideshow").getString("pin_image_url");
        int totalSlidesCount = json.getInt("totalSlides");

        this.urls = this.generateSlideUrl(baseUrl, totalSlidesCount);
        long end = System.currentTimeMillis();
        Log.d("trace", "load(), time=" + (end - start) + "ms");
    }

    public List<String> getUrls() {
        return this.urls;
    }

    List<String> generateSlideUrl(String baseUrl, int totalSlidesCount) {
        String[] base = baseUrl.split("95/slide-1");

        List<String> list = new ArrayList<String>(totalSlidesCount);
        for (int i = 0; i < totalSlidesCount; i++) {
            list.add("http:" + base[0] + "95/slide-" + (i + 1) + base[1]);
        }

        return list;
    }

    JSONObject getJson(Document doc) throws IOException, SAXNotRecognizedException, SAXNotSupportedException, TransformerException, JSONException {
        long start = System.currentTimeMillis();

        String pageJsonText = doc.getElementById("page-json").getFirstChild().getNodeValue();
        String json = getJsonString(pageJsonText);

        long end = System.currentTimeMillis();
        Log.d("trace", "getJson(), time=" + (end - start) + "ms");

        return new JSONObject(json);
    }

    String getJsonString(String pageJsonText) {
        return pageJsonText
                .replaceAll("\r", "").replaceAll("\n", "")
                .replaceAll(".*slideshare_object = ", "").replaceAll("; var .*", "");
    }

    Document getDocument(URL url) throws IOException, SAXNotRecognizedException, SAXNotSupportedException, TransformerException {
        long start = System.currentTimeMillis();

        URLConnection uc = url.openConnection();
        uc.setDoOutput(true);//POST可能にする

        uc.setRequestProperty("User-Agent", "@IT java-tips URLConnection");//

        InputStream in = uc.getInputStream();
        InputSource source = new InputSource(in);

        XMLReader reader = new Parser();
        reader.setFeature(Parser.namespacesFeature, false);
        reader.setFeature(Parser.namespacePrefixesFeature, false);

        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();

        DOMResult result = new DOMResult();
        transformer.transform(new SAXSource(reader, source), result);

        long end = System.currentTimeMillis();

        Log.d("trace", "getDocument(), time=" + (end - start) + "ms");
        return (Document) result.getNode();
    }
}
