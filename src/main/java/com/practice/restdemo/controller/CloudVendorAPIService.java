package com.practice.restdemo.controller;

import com.practice.restdemo.model.CloudVendor;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping({"/cloudVendor"})
public class CloudVendorAPIService {
    CloudVendor cloudVendor;

    public CloudVendorAPIService() {
    }

    @GetMapping({"{vendorId}"})
    public CloudVendor getCloudvendorDetails(String vendorId) {
        return this.cloudVendor;
    }

    @PostMapping
    public ResponseEntity<String> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        this.cloudVendor = cloudVendor;
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(new Object[]{cloudVendor.getVendorId()}).toUri();
        return ResponseEntity.created(location).body("Cloud vendor details Created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        this.cloudVendor = cloudVendor;
        return ResponseEntity.ok("Cloud vendor details Updated successfully");
    }

    @DeleteMapping({"{vendorId}"})
    public ResponseEntity<String> deleteCloudVendorDetails(String vendorId) {
        this.cloudVendor = null;
        return ResponseEntity.ok("Cloud vendor deleted successfully");
    }
}
