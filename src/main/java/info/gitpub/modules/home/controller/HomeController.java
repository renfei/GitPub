package info.gitpub.modules.home.controller;

import info.gitpub.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class HomeController extends BaseController {
    @RequestMapping("/")
    public ModelAndView getHome(Locale locale) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
