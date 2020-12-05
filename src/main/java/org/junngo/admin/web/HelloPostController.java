package org.junngo.admin.web;

import org.junngo.admin.web.dto.MultiParamDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class HelloPostController {

//    localhost:8080/postMethod
    @PostMapping("/postMethod")
    public MultiParamDto postMethod(@RequestBody MultiParamDto multiParamDto) {
        return multiParamDto;
    }
}
