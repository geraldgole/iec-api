package com.greencom.empower.importer.controller;

import com.greencom.empower.importer.service.ImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/import")
public class ImportController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportController.class);

    @Autowired
    private ImportService importService;

    @PostMapping("/customer")
    public ResponseEntity importCustomerAgreement(@RequestParam String file) {

        importService.importCustomerAgreement(file);

        return new ResponseEntity(HttpStatus.OK);
    }
}
