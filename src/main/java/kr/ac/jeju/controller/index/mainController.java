package kr.ac.jeju.controller.index;


import kr.ac.jeju.model.ProductItem;
import kr.ac.jeju.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String index(ModelMap model,
                        @CookieValue(value = "userName", required = false) Cookie userCookie) throws UnsupportedEncodingException {

        String cookieName = null;
        if(userCookie != null){
            cookieName = URLDecoder.decode(userCookie.getValue(), "UTF-8");
        }

        List<ProductItem> list = productService.list();

        model.addAttribute("userId", cookieName );
        model.addAttribute("productList", list);
        return "index";
    }
}
