package com.tingkelai.sys.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysButtonApi;
import com.tingkelai.domain.sys.Button;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SysButtonController extends BaseCRUDController<Button, Long> implements SysButtonApi<Button> {

    @Override
    public ApiResponseMessage<List<Button>> sysButtonListGet(HttpServletRequest request, Button body) {
        return getEntityList();
    }
}
