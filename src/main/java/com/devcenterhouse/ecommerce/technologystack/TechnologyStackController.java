package com.devcenterhouse.ecommerce.technologystack;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnologyStackController {
    
    private final TechnologyStackService technologyStackService;

    public TechnologyStackController(TechnologyStackService technologyStackService) {
        this.technologyStackService = technologyStackService;
    }

    @GetMapping("api/v1/technology-stacks")
    public Page<TechnologyStack> fetchAllTechnologyStacks(@RequestParam (defaultValue = "0") int page,
                                                        @RequestParam (defaultValue = "10") int size) {
        return technologyStackService.fetchAllTechnologyStacks(page, size);
    }
}
