package com.greencom.empower.importer.service;


import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.Reader;


@Service
public class ImportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportService.class);

    @Autowired
    private CustomerAgreementService customerAgreementService;

    public void importCustomerAgreement(Reader inputReader) {

        try {


            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setValidating(false);
            XMLReader reader = factory.newSAXParser().getXMLReader();

            //reader = XMLReaderFactory.createXMLReader();
            NamespaceFilter filter = new NamespaceFilter("http://iec.ch/TC57/2009/CustomerAgreement#", true);
            filter.setParent(reader);

            InputSource is = new InputSource(inputReader);
            SAXSource ss = new SAXSource(filter, is);


            JAXBContext context = JAXBContext.newInstance(CustomerAgreements.class);


            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

            JAXBElement<CustomerAgreements> root = unmarshaller.unmarshal(ss, CustomerAgreements.class);
            CustomerAgreements customers = root.getValue();

            for (CustomerAgreement customerAgreement : customers.getCustomerAgreement()) {
                customerAgreementService.process(customerAgreement);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static class NamespaceFilter extends XMLFilterImpl {

        private String usedNamespaceUri;
        private boolean addNamespace;

        //State variable
        private boolean addedNamespace = false;

        public NamespaceFilter(String namespaceUri,
                               boolean addNamespace) {
            super();

            if (addNamespace)
                usedNamespaceUri = namespaceUri;
            else
                usedNamespaceUri = "";
            this.addNamespace = addNamespace;
        }


        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            if (addNamespace) {
                startControlledPrefixMapping();
            }
        }


        @Override
        public void startElement(String arg0, String arg1, String arg2,
                                 Attributes arg3) throws SAXException {

            super.startElement(usedNamespaceUri, arg1, arg2, arg3);
        }

        @Override
        public void endElement(String arg0, String arg1, String arg2)
                throws SAXException {

            super.endElement(usedNamespaceUri, arg1, arg2);
        }

        @Override
        public void startPrefixMapping(String prefix, String url)
                throws SAXException {


            if (addNamespace) {
                startControlledPrefixMapping();
            } else {
                //Remove the namespace, i.e. don´t call startPrefixMapping for parent!
            }

        }

        private void startControlledPrefixMapping() throws SAXException {

            if (addNamespace && !addedNamespace) {
                //We should add namespace since it is set and has not yet been done.
                super.startPrefixMapping("", usedNamespaceUri);

                //Make sure we dont do it twice
                addedNamespace = true;
            }
        }

    }
}
