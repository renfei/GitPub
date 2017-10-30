package info.gitpub.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * Controller基类
 *
 * @author NeilRen
 * @version 1.0
 */
public abstract class BaseController {
    @Autowired
    protected MessageSource messageSource;
}

