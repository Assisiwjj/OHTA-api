package com.qualityevaluationsys.demo.web;

import com.qualityevaluationsys.demo.domain.OhtaUser;
import com.qualityevaluationsys.demo.service.OhtaUserService;
import com.qualityevaluationsys.demo.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Assisiwjj
 */
@RestController
@RequestMapping("ohtaUser")
public class OhtaUserController extends BaseController{
    @Autowired
    private OhtaUserService ohtaUserService;

    /**
     *所有用户列表
     * @param
     * @return
     */
    @RequestMapping(value = "getAllUser",method = RequestMethod.GET)
    public Map<String,Object>getAllUser(HttpServletRequest request){
        msg.clear();
        try
        {
            Integer limit = Integer.parseInt(request.getParameter("limit"));
            Integer page = Integer.parseInt(request.getParameter("page"));
            PageBean pageBean = ohtaUserService.getAllUser(limit,page);
            if (pageBean!=null) {
                msg.put("code", "1");
                msg.put("msg", "成功");
                msg.put("data", pageBean);
            } else {
                msg.put("code", "0");
                msg.put("msg", "失败");
            }
        }
        catch (Exception e)
        {
            msg.put("code","0");
            msg.put("message",e.getMessage());
        }
        return msg;
    }

    /**
     *添加用户
     * @param ohtaUser
     * @return
     */
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public Map<String,Object>addUser(@ModelAttribute OhtaUser ohtaUser){
        msg.clear();
        try{
            int i=ohtaUserService.insert(ohtaUser);
            if(i==1){
                msg.put("code","1");
                msg.put("msg","成功");
            }
            else
            {
                msg.put("code","0");
                msg.put("msg","失败");
            }
        }
        catch(Exception e)
        {
            msg.put("msg","error");
            msg.put("message",e.getMessage());
        }
        return msg;
    }

//    /**
//     *所有用户列表
//     * @param pojo
//     * @return
//     */
//    @RequestMapping(value = "getUser",method = RequestMethod.GET)
//    public Map<String,Object>getUser(@ModelAttribute OhtaUser pojo){
//        msg.clear();
//        try{
//            List<OhtaUser> temp= ohtaUserService.selectByExample(pojo) ;
//            msg.put("code","1");
//            msg.put("msg","成功");
//            msg.put("data",temp);
//        }
//        catch(Exception e)
//        {
//            msg.put("code","0");
//            msg.put("message",e.getMessage());
//        }
//        return msg;
//    }

    /**
     *更改用户积分
     * @param ohtaUser
     * @return
     */
    @RequestMapping(value = "updatePoint",method = RequestMethod.PATCH)
    public Map<String,Object>updatePoint(@ModelAttribute OhtaUser ohtaUser){
        msg.clear();
        try{
            int i = ohtaUserService.update(ohtaUser);
            if(i==1)
            {
                msg.put("code","1");
                msg.put("msg","成功");
            }
            else
            {
                msg.put("code","0");
                msg.put("msg","失败");
            }
        }
        catch (Exception e)
        {
            msg.put("code","0");
            msg.put("message",e.getMessage());
        }
        return msg;
    }

    /**
     *用户修改信息
     * @param user
     * @return
     */
    @RequestMapping(value = "updateUser",method = RequestMethod.PUT)
    public Map<String,Object>updateUser(@ModelAttribute OhtaUser user){
        msg.clear();
        try{
            if (user.getOpenId()!=null) {
                int i = ohtaUserService.update(user);
                if (i == 1) {
                    msg.put("code", "1");
                    msg.put("msg", "成功");
                } else {
                    msg.put("code", "0");
                    msg.put("msg", "失败");
                }
            }else {
                msg.put("code", "0");
                msg.put("msg", "参数不合法");
            }
        }
        catch (Exception e)
        {
            msg.put("code","0");
            msg.put("message",e.getMessage());
        }
        return msg;
    }
}
