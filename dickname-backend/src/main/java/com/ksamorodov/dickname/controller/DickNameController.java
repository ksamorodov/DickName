package com.ksamorodov.dickname.controller;

import com.ksamorodov.dickname.dao.request.GenerateDickNameRequest;
import com.ksamorodov.dickname.dao.response.GenerateDickNameResponse;
import com.ksamorodov.dickname.service.DickNameService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DickNameController {
    private final DickNameService dickNameService;

    @PostMapping("/generate/dickname")
    @CrossOrigin
    public GenerateDickNameResponse generateDickName(@Valid @RequestBody GenerateDickNameRequest dickNameRequest) {
        return new GenerateDickNameResponse(dickNameService.generateDickSentence(dickNameRequest.getName()));
    }

    @PostMapping("/generate/dickname/batch")
    @CrossOrigin
    public List<GenerateDickNameResponse> generateDickNames(@Valid @NotEmpty @RequestBody List<GenerateDickNameRequest> dickNameRequests) {
        return dickNameRequests.stream().map(r -> new GenerateDickNameResponse(dickNameService.generateDickSentence(r.getName()))).toList();
    }
}
