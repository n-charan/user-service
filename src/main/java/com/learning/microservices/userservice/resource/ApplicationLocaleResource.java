package com.learning.microservices.userservice.resource;

import com.learning.microservices.userservice.model.ApplicationLocaleRequestDto;
import com.learning.microservices.userservice.model.ApplicationLocaleResponseDto;
import com.learning.microservices.userservice.service.ApplicationLocaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/app-locales")
public class ApplicationLocaleResource {

    private ApplicationLocaleService applicationLocaleService;

    ApplicationLocaleResource(ApplicationLocaleService applicationLocaleService) {
        this.applicationLocaleService = applicationLocaleService;
    }

    @GetMapping
    public ResponseEntity<List<ApplicationLocaleResponseDto>> getAllApplicationLocales() {
        List<ApplicationLocaleResponseDto> appLocaleList = applicationLocaleService.getAllLocales();
        return ResponseEntity.ok(appLocaleList);
    }

    @DeleteMapping("/{locale}")
    public ResponseEntity<Void> getAllApplicationLocales(@PathVariable String locale) {
        applicationLocaleService.deleteLocale(locale);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<ApplicationLocaleResponseDto> saveNewLocale(
            @Valid @RequestBody ApplicationLocaleRequestDto applicationLocaleDto) {
        ApplicationLocaleResponseDto appLocaleDto = applicationLocaleService.saveNewLocale(applicationLocaleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(appLocaleDto);
    }
}
