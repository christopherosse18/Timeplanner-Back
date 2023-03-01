package com.pce.timeplanner.controllers;

import com.pce.timeplanner.implementation.Service;
import com.pce.timeplanner.repository.ServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/service")
@CrossOrigin(origins="*")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping("/getServiceById")
    public Service getServiceById(@RequestParam int id) {
        return serviceRepository.findByIdService(id);
    }

    @GetMapping("/getAllServices")
    public List<Service> getAllServices(){
        return serviceRepository.findAll();
    }
}
