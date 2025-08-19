package com.voyageVault.SecurityYatra.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleSecurityController {
        @GetMapping("/") public String root() { return "OK"; }
        @GetMapping("/healthz") public String health() { return "OK"; }
}
