package info.gitpub.modules.global.controller;

import info.gitpub.common.controller.BaseController;
import info.gitpub.common.entity.JsonObject;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 多语言设置
 */
@Controller
@RequestMapping("/global")
public class GlobalController extends BaseController {
    /**
     * 获取所有支持的语言
     *
     * @return
     */
    @RequestMapping("")
    public ModelAndView getGlobal() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    /**
     * 设置当前的语言
     *
     * @param lang
     * @param request
     * @param response
     */
    @RequestMapping(value = "set", method = RequestMethod.POST)
    @ResponseBody
    public JsonObject setLanguage(@RequestParam String lang, HttpServletRequest request, HttpServletResponse response) {
        JsonObject jsonObject=new JsonObject();
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (localeResolver == null) {
            jsonObject.setState(500);
            jsonObject.setMessage("No LocaleResolver found: not in a DispatcherServlet request?");
            return jsonObject;
        }
        LocaleEditor localeEditor = new LocaleEditor();
        localeEditor.setAsText(lang);
        localeResolver.setLocale(request, response, (Locale) localeEditor.getValue());
        jsonObject.setState(200);
        jsonObject.setMessage("Change Language Success!");
        return jsonObject;
    }
}
