package cn.orz.pascal.ssv.model;

import junit.framework.TestCase;
import org.ccil.cowan.tagsoup.Parser;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class SlideDownloaderTest extends TestCase {

    public void test1() throws Exception {
        Document doc = getDocument("http://www.slideshare.net/govonimarco/linkedin-a-great-new-opportunity");
        String pageJsonText = doc.getElementById("page-json").getFirstChild().getNodeValue();
        String json = getJsonString(pageJsonText);
        System.out.println(json);

        JSONObject rootObject = new JSONObject(json);

        String imgeUrl = rootObject.getJSONObject("slideshow").getString("pin_image_url");
        int totalSlidesCount = rootObject.getInt("totalSlides");

        System.out.println(imgeUrl);
        System.out.println(totalSlidesCount);

    }

    private String getJsonString(String pageJsonText) {
        return pageJsonText.replaceAll("\r", "").replaceAll("\n", "").replaceAll(".*slideshare_object = ", "").replaceAll("; var .*", "");
    }

    private Document getDocument(String url) throws IOException, SAXNotRecognizedException, SAXNotSupportedException, TransformerException {
        URL u = new URL(url);

        InputStream in = u.openStream();
        InputSource source = new InputSource(in);

        XMLReader reader = new Parser();
        reader.setFeature(Parser.namespacesFeature, false);
        reader.setFeature(Parser.namespacePrefixesFeature, false);

        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();

        DOMResult result = new DOMResult();
        transformer.transform(new SAXSource(reader, source), result);

        return (Document) result.getNode();
    }
}
