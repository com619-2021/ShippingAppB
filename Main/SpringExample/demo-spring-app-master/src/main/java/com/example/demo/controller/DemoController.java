package com.example.demo.controller;

import BusinessLogicLayer.*;
import RestfulComms.ServiceCaller;
import com.example.demo.dto.Demo;
import com.example.demo.dto.Result;
import com.example.demo.repository.DemoRepository;
import io.swagger.v3.core.util.Json;
import lombok.extern.java.Log;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Optional;

@RestController
@Log
public class DemoController {

    private final DemoRepository demoRepository;

    /**
     * Alternative to autowiring, use an autowire constructor.
     * @param demoRepository demo repository for spring boot to autowire
     */
    public DemoController(DemoRepository demoRepository)
    {
        this.demoRepository = demoRepository;
    }

    @GetMapping("/api/demo/")
    public Demo getDemo(@RequestParam(name="id") String id) {
        log.info("Demo endpoint accessed.");
        Optional<Demo> result = this.demoRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            log.warning("ID Could not be found in database");
            return null;
        }
    }

    @PostMapping("/api/demo")
    public Result postDemo(@RequestBody Demo demo) {
        this.demoRepository.save(demo);
        log.info("Demo with ID " + demo.getId() + " added to database");
        return new Result( "You POSTed a Demo object with an id of: " + demo.getId());
    }

    @GetMapping("/BookPilot")
    public String bookPilot()
    {
        var book = new BookPilot();
        return book.bookPilot();
    }

    @PostMapping("/OrderShipment")
    public String orderShipment(@RequestParam(value="details") String details)
    {
        try
        {
            var urlConfig = JsonParser.loadUrlConfig("/home/data");
            var shipmentDetails = JsonParser.GetShipmentDetails(details);
            var serviceCaller = new ServiceCaller();
            var portService = new PortService(serviceCaller);
            var harbourService = new HarbourService(serviceCaller);
            var stevedoreService = new StevedoreService(serviceCaller);

            var orderShipment = new OrderShipment(shipmentDetails, portService, harbourService, stevedoreService, urlConfig);
            var result = orderShipment.PlaceOrder();

            return result;
        }
        catch(Exception e)
        {
            return "Error:" + e.getMessage();
        }
    }
}
