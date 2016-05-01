package com.uciext.ws.hw2.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Util {
	
	public static void print(String data) {
		System.out.println(data);
	}

	public static void log(String data) {
		Util.print(data);
	}
	
	// Marshal an object into XML
	public static String marshalToXml(Object myObject, Class myClass) throws JAXBException {
		String responseStr = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(myClass);
			
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			StringWriter writer = new StringWriter();
			jaxbMarshaller.marshal(myObject, writer);
			responseStr = writer.toString();
	  } 
	  catch (JAXBException e) {
			e.printStackTrace();
			throw e;
	  }
	  
	  return responseStr;
	}
	
	// Unmarshal an object from XML
	public static Object unmarshalFromXml(Reader myReader, Class myClass) {
		Object myObject = null;
		try { 
			JAXBContext jaxbContext = JAXBContext.newInstance(myClass);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			myObject = jaxbUnmarshaller.unmarshal(myReader); 
	  } 
	  catch (JAXBException e) {
			e.printStackTrace();
	  }
	  return myObject;
	}
}