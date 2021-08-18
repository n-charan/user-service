package com.learning.microservices.userservice.resource;

import com.learning.microservices.userservice.model.ApplicationLocaleDto;
import com.learning.microservices.userservice.service.ApplicationLocaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app-locales")
public class ApplicationLocaleResource {

    private ApplicationLocaleService applicationLocaleService;

    ApplicationLocaleResource(ApplicationLocaleService applicationLocaleService) {
        this.applicationLocaleService = applicationLocaleService;
    }

    @GetMapping
    public ResponseEntity<List<ApplicationLocaleDto>> getAllApplicationLocales() {
        List<ApplicationLocaleDto> appLocaleList = applicationLocaleService.getAllLocales();
        return ResponseEntity.ok(appLocaleList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> getAllApplicationLocales(@PathVariable(name = "id") Long appLocalId) {
        applicationLocaleService.removeLocaleById(appLocalId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<ApplicationLocaleDto> saveNewLocale(
            @RequestBody ApplicationLocaleDto applicationLocaleDto) {
        ApplicationLocaleDto appLocaleDto = applicationLocaleService.saveNewLocale(applicationLocaleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(appLocaleDto);
    }
}
