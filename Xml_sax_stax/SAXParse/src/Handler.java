import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class Handler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.println("Start: " + qName);
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End: " + qName);
    }
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch,start,length).trim());
    }
}

