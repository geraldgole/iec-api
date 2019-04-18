package com.greencom.empower.importer.controller;

import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.model.exception.CustomerAgreementException;
import com.greencom.empower.importer.service.CustomerAgreementService;
import com.greencom.empower.importer.service.ImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Profile("remote")
@RestController
@RequestMapping("/import")
public class ImportController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportController.class);

    @Autowired
    private ImportService importService;

    @Autowired
    private CustomerAgreementService customerAgreementService;

    @PostMapping("/customer")
    public ResponseEntity importCustomerAgreement(@RequestParam String file) {

        try {
            FileReader fr = new FileReader(new File(file));
            importService.importCustomerAgreement(fr);
            return new ResponseEntity(HttpStatus.OK);
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found {}", file);
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity importCustomerAgreement(@RequestParam MultipartFile file) {

        try {
            InputStreamReader isr = new InputStreamReader(file.getInputStream());
            importService.importCustomerAgreement(isr);
            return new ResponseEntity(HttpStatus.OK);
        } catch (IOException e) {
            LOGGER.error("Failed to read on reader: {}", e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/customer-agreement")
    public ResponseEntity importCustomerAgreement(@RequestBody CustomerAgreement customerAgreement) {

        customerAgreementService.process(customerAgreement);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ExceptionHandler(CustomerAgreementException.class)
    public ResponseEntity<String> customerAgreementExceptionHandler(HttpServletRequest request, CustomerAgreementException
            exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
