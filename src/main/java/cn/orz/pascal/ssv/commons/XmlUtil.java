package cn.orz.pascal.ssv.commons;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: koduki
 * Date: 12/11/03
 * Time: 23:24
 * To change this template use File | Settings | File Templates.
 */
public class XmlUtil {
    public static String toString(Document doc) throws TransformerException {
        StringWriter sw = new StringWriter();
        TransformerFactory tfactory = TransformerFactory.newInstance();
        Transformer transformer = tfactory.newTransformer();
        transformer.transform(new DOMSource(doc), new StreamResult(sw));

        return sw.toString();
    }

    public static Document load(String src) throws IOException, SAXException, ParserConfigurationException {
        Document doc = null;
        InputSource is = new InputSource(new StringReader(src));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        doc = docBuilder.parse(is);

        return doc;
    }
}
