package com.gsomogyi.testsender.web.controller;

import com.gsomogyi.testsender.web.config.AppConfig;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/common/")
public class CommonController {

    private final AppConfig appConfig;

    public CommonController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/version")
    @ResponseStatus(HttpStatus.OK)
    public String getAppVersion() {
        return appConfig.getAppVersion();
    }
}
