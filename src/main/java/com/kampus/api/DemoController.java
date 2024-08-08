package com.kampus.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
@RequiredArgsConstructor
public class DemoController {

    @GetMapping()
    public ResponseEntity<String> sayHello() {
        //throw new BusinessException(request);
        return ResponseEntity.ok("Hello From Endpoint");
    }
}
