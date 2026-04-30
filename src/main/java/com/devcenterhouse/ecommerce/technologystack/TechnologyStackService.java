package com.devcenterhouse.ecommerce.technologystack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TechnologyStackService {

    TechnologyStackRepository technologyStackRepository;
    
    @Autowired
    public TechnologyStackService(TechnologyStackRepository technologyStackRepository) {
        this.technologyStackRepository = technologyStackRepository;
    }

    public Page<TechnologyStack> fetchAllTechnologyStacks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return technologyStackRepository.findAll(pageable);
    }
}
