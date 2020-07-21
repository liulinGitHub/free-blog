package com.blog.core.speech.service.impl;

import com.blog.core.speech.dao.PortalShowSpeechBookMapper;
import com.blog.core.speech.service.PortalShowSpeechBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: ShowSpeechBookServiceImpl
 * @description:
 * @author: 950103
 * @create: 2019-05-28 18:08
 * @Version: 1.0
 */
@Service("portalShowSpeechBookService")
public class PortalShowSpeechBookServiceImpl implements PortalShowSpeechBookService {

    @Autowired
    private PortalShowSpeechBookMapper portalShowSpeechBookMapper;
}
