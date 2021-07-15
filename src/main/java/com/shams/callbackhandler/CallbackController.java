package com.shams.callbackhandler;

import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/callback")
public class CallbackController {

  @GetMapping
  Mono<String> callback(@RequestParam Map<String, String> params) {
    return Mono.just(print(params));
  }

  private String print(Map<String, String> params) {
    var sb = new StringBuilder();
    sb.append("<pre>");
    params.forEach(
        (key, value) -> sb.append("%s : %s".formatted(key, value)).append(System.lineSeparator()));
    sb.append("</pre>");
    return sb.toString();
  }
}
