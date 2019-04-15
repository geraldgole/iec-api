package com.greencom.empower.importer.controller;

import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.service.ApiService;
import com.greencom.empower.importer.service.ImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/import")
public class ImportController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportController.class);

    @Autowired
    private ImportService importService;

    @Autowired
    private ApiService apiService;

    @PostMapping("/customer")
    public ResponseEntity importCustomerAgreement(@RequestParam String file) throws Exception {

        FileReader fr = new FileReader(new File("/home/gerald/files/" + file));
        importService.importCustomerAgreement(fr);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity importCustomerAgreement(@RequestParam MultipartFile file) throws Exception {

        InputStreamReader isr = new InputStreamReader(file.getInputStream());
        importService.importCustomerAgreement(isr);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/customer-agreement")
    public ResponseEntity importCustomerAgreement(@RequestBody CustomerAgreement customerAgreement) throws Exception {

        apiService.processCustomerAgreement(customerAgreement);
        return new ResponseEntity(HttpStatus.OK);
    }
}
