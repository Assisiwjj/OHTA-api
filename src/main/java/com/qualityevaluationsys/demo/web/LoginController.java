package com.qualityevaluationsys.demo.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {
    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> login(HttpServletRequest request){
        msg.clear();
        String password = request.getParameter("password");
        try{
            if (password!=null) {
                if (password.equals("123")){
                    msg.put("code", "1");
                    msg.put("msg", "成功");
                }else {
                    msg.put("code", "0");
                    msg.put("msg", "失败");
                }
            }else {
                msg.put("code", "0");
                msg.put("msg", "参数不合法");
            }
        } catch(Exception e) {
            msg.put("code","0");
            msg.put("message",e.getMessage());
        }
        return msg;
    }
}
