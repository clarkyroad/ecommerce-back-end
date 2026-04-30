package com.devcenterhouse.ecommerce.serviceoffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceOfferService {

    private final ServiceOfferRepository serviceOfferRepository;

    @Autowired
    public ServiceOfferService(ServiceOfferRepository serviceOfferRepository) {
        this.serviceOfferRepository = serviceOfferRepository;
    }

    public Page<ServiceOffer> fetchAllServiceOffers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return serviceOfferRepository.findAll(pageable);
    }
}
