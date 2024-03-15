package com.ksamorodov.dickname.controller;

import com.ksamorodov.dickname.dao.request.GenerateDickNameRequest;
import com.ksamorodov.dickname.dao.response.GenerateDickNameResponse;
import com.ksamorodov.dickname.service.DickNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DickNameController {
    private final DickNameService dickNameService;

    @PostMapping("/generate/dickname")
    @CrossOrigin
    public GenerateDickNameResponse generateDickName(@RequestBody GenerateDickNameRequest dickNameRequest) {
        return new GenerateDickNameResponse(dickNameService.createDickName(dickNameRequest.getName()));
    }
}
