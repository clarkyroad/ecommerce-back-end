package com.devcenterhouse.ecommerce.serviceoffer;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOfferController {

    private final ServiceOfferService serviceOfferService;
    
    public ServiceOfferController(ServiceOfferService serviceOfferService) {
        this.serviceOfferService = serviceOfferService;
    }

    @GetMapping("api/v1/service-offers")
    public Page<ServiceOffer> fetchAllServiceOffers(@RequestParam (defaultValue = "0") int page,
                                                    @RequestParam (defaultValue = "10") int size) {
        return serviceOfferService.fetchAllServiceOffers(page, size);
    }
}
