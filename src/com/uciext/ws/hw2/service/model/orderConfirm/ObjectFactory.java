//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.01 at 01:23:42 PM EDT 
//


package com.uciext.ws.hw2.service.model.orderConfirm;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.uciext.ws.hw2.service.model.orderConfirm package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _VendorCode_QNAME = new QName("", "vendorCode");
    private final static QName _ConfirmNumber_QNAME = new QName("", "confirmNumber");
    private final static QName _Price_QNAME = new QName("", "price");
    private final static QName _ProductSku_QNAME = new QName("", "productSku");
    private final static QName _OrderNumber_QNAME = new QName("", "orderNumber");
    private final static QName _OrderQuantity_QNAME = new QName("", "orderQuantity");
    private final static QName _TotalOrderPrice_QNAME = new QName("", "totalOrderPrice");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.uciext.ws.hw2.service.model.orderConfirm
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderConfirm }
     * 
     */
    public OrderConfirm createOrderConfirm() {
        return new OrderConfirm();
    }

    /**
     * Create an instance of {@link ProductConfirm }
     * 
     */
    public ProductConfirm createProductConfirm() {
        return new ProductConfirm();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "vendorCode")
    public JAXBElement<String> createVendorCode(String value) {
        return new JAXBElement<String>(_VendorCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "confirmNumber")
    public JAXBElement<Integer> createConfirmNumber(Integer value) {
        return new JAXBElement<Integer>(_ConfirmNumber_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "price")
    public JAXBElement<BigDecimal> createPrice(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Price_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "productSku")
    public JAXBElement<String> createProductSku(String value) {
        return new JAXBElement<String>(_ProductSku_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "orderNumber")
    public JAXBElement<Integer> createOrderNumber(Integer value) {
        return new JAXBElement<Integer>(_OrderNumber_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "orderQuantity")
    public JAXBElement<Integer> createOrderQuantity(Integer value) {
        return new JAXBElement<Integer>(_OrderQuantity_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "totalOrderPrice")
    public JAXBElement<BigDecimal> createTotalOrderPrice(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TotalOrderPrice_QNAME, BigDecimal.class, null, value);
    }

}