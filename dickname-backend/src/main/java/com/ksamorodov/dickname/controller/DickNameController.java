package com.ksamorodov.dickname.controller;

import com.ksamorodov.dickname.dao.request.GenerateDickNameRequest;
import com.ksamorodov.dickname.dao.response.GenerateDickNameResponse;
import com.ksamorodov.dickname.service.AnalyticsService;
import com.ksamorodov.dickname.service.DickNameService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DickNameController {
    private final DickNameService dickNameService;
    private final AnalyticsService analyticsService;

    @PostMapping("/generate/dickname")
    @CrossOrigin
    public GenerateDickNameResponse generateDickName(@RequestHeader(value = "User-Sesstion-Id", required = false) UUID sessionId,
                                                     @RequestHeader(value = "Host", required = false) String host,
                                                     @Valid @RequestBody GenerateDickNameRequest dickNameRequest) {
        log.debug("Request from userAgent: {}, host: {}, request: {}", sessionId != null? sessionId.toString() : null, host,
                dickNameRequest.getName());
        analyticsService.saveAnalytics(sessionId, host, dickNameRequest.getName());

        return new GenerateDickNameResponse(dickNameService.generateDickSentence(dickNameRequest.getName()));
    }

    @PostMapping("/generate/dickname/batch")
    @CrossOrigin
    public List<GenerateDickNameResponse> generateDickNames(@Valid @NotEmpty @RequestBody List<GenerateDickNameRequest> dickNameRequests) {
        return dickNameRequests.stream().map(r -> new GenerateDickNameResponse(dickNameService.generateDickSentence(r.getName()))).toList();
    }
}
