package com.blog.core.speech.controller;

import com.blog.core.speech.service.PortalShowSpeechBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ShowSpeechBookController
 * @description:
 * @author: 950103
 * @create: 2019-05-28 18:09
 * @Version: 1.0
 */
@RestController
@RequestMapping("/speech")
public class PortalShowSpeechBookController {

    @Autowired
    private PortalShowSpeechBookService portalShowSpeechBookService;
}
