package kr.ac.jeju.controller.product;

import kr.ac.jeju.model.ProductItem;
import kr.ac.jeju.repository.ProductDaoMapper;
import kr.ac.jeju.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
public class ProductInfoController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/productInfo", method = RequestMethod.GET )
    public String productInfo(Model model,
                              @RequestParam(value = "id", required = false) int id,
                              @CookieValue(value = "userName", required = false)Cookie userCookie){

        ProductItem item = productService.printProductInfo(id);
        item.setDescription(item.getDescription().replace("\r\n", "<br>"));

        String cookieName = null;
        if(userCookie != null){
            try {
                cookieName = URLDecoder.decode(userCookie.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }

        model.addAttribute("productInfo", item);
        model.addAttribute("userId", cookieName);

        return "product/productInfo";
    }
}
