package org.nilcux.ioc;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;


public class ClassPathXMLResource implements Resource{
    Document document;
    Element rootElement;
    Iterator<Element> elementIterator;
    public ClassPathXMLResource(String fileName) {
        SAXReader saxReader = new SAXReader();
        URL xmlPath = this.getClass().getClassLoader().getResource(fileName);

        try {
            this.document = saxReader.read(xmlPath);
            this.rootElement = document.getRootElement();
            this.elementIterator = this.rootElement.elementIterator();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean hasNext() {
        return this.elementIterator.hasNext();
    }
    public Object next() {
        return this.elementIterator.next();
    }
}
