package org.junngo.admin.web;

import org.junngo.admin.web.dto.MultiParamDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloGetController {

//    localhost:8080/api/getMethod
    @RequestMapping(method = RequestMethod.GET, path="/getMethod")
    public String getRequest() {
        return "Hello World";
    }

//    localhost:8080/api/getParam?id=test&password=test123
    @GetMapping("/getParam")
    public String gerParameter(@RequestParam String id, @RequestParam(name="password") String pwd) {
        return id + pwd;
    }

//    localhost:8080/api/getMultiParam?account=test&email=test@gmail.com&page=10
    @GetMapping("/getMultiParam")
    public String getMultiParam(MultiParamDto multiParamDto) {
        return multiParamDto.getAccount() + ", " + multiParamDto.getEmail() + ", " + multiParamDto.getPage();
    }

//    localhost:8080/api/getParamRetJson?account=test&email=test@gmail.com&page=10
    @GetMapping("/getParamRetJson")
    public MultiParamDto getParamRetJson(MultiParamDto multiParamDto) {
        return multiParamDto;
    }
}
