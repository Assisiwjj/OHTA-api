package com.qualityevaluationsys.demo.web;

import com.qualityevaluationsys.demo.domain.OhtaOrder;
import com.qualityevaluationsys.demo.service.OhtaOrderService;
import com.qualityevaluationsys.demo.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Assisiwjj
 */
@RestController
@RequestMapping("ohtaOrder")
public class OhtaOrderController extends BaseController{
    @Autowired
    private OhtaOrderService ohtaOrderService;

    /**
     *查询未完成订单列表
     *
     * @return
     */
    @RequestMapping(value = "unfinshed",method = RequestMethod.GET)
    public Map<String,Object> unfinshed(HttpServletRequest request){
        msg.clear();
        try
        {
            Integer limit = Integer.parseInt(request.getParameter("limit"));
            Integer page = Integer.parseInt(request.getParameter("page"));
            PageBean pageBean = ohtaOrderService.getPageUnfinshed(limit,page);
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
     *查询完成订单列表
     *
     * @return
     */
    @RequestMapping(value = "finshed",method = RequestMethod.GET)
    public Map<String,Object> finshed(HttpServletRequest request){

        msg.clear();
        try
        {
            Integer limit = Integer.parseInt(request.getParameter("limit"));
            Integer page = Integer.parseInt(request.getParameter("page"));
            String time = request.getParameter("time");
            PageBean pageBean = ohtaOrderService.getPageFinshed(limit, page, time);
            msg.put("code", "1");
            msg.put("msg", "成功");
            msg.put("data", pageBean);
        }
        catch (Exception e)
        {
            msg.put("code","0");
            msg.put("message",e.getMessage());
        }
        return msg;
    }

    /**
     *查询订单
     * @param pojo
     * @return
     */
    @RequestMapping(value = "getOrder",method = RequestMethod.GET)
    public Map<String,Object> getOrder(@ModelAttribute OhtaOrder pojo){
        msg.clear();
        try
        {
            List<OhtaOrder> list= ohtaOrderService.selectByExampleOrder(pojo);
            if (list!=null) {
                msg.put("code", "1");
                msg.put("msg", "成功");
                msg.put("data", list);
            }else {
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
     * 查询用户已完成历史订单
     * @param pojo
     * @return
     */
    @RequestMapping(value = "getUserOrder",method = RequestMethod.GET)
    public Map<String,Object> getUserOrder(@ModelAttribute OhtaOrder pojo){
        msg.clear();
        try
        {
            List<OhtaOrder> list= ohtaOrderService.selectByExampleUser(pojo);
            if (list!=null) {
                msg.put("code", "1");
                msg.put("msg", "成功");
                msg.put("data", list);
            }else {
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
     * 查询用户未完成订单
     * @param pojo
     * @return
     */
    @RequestMapping(value = "getUnfinshed",method = RequestMethod.GET)
    public Map<String,Object> getUnfinshed(@ModelAttribute OhtaOrder pojo){
        msg.clear();
        try
        {
            List<OhtaOrder> list= ohtaOrderService.selectByExampleUserUnfinshed(pojo);
            if (list!=null) {
                msg.put("code", "1");
                msg.put("msg", "成功");
                msg.put("data", list);
            }else {
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
     * 添加订单
     * @param ohtaOrder
     * @return
     */
    @RequestMapping(value = "addOrder",method = RequestMethod.POST)
    public Map<String,Object> addOrder(@ModelAttribute OhtaOrder ohtaOrder){
        msg.clear();
        try{
            int i=ohtaOrderService.insert(ohtaOrder);
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
            msg.put("code","0");
            msg.put("message",e.getMessage());
        }
        return msg;
    }

    /**
     * 修改订单状态
     * @param order
     * @return
     */
    @RequestMapping(value = "updateStatus",method = RequestMethod.PATCH)
    public Map<String ,Object> updateStatus(@RequestBody OhtaOrder order){
        msg.clear();
        try{
            if (order.getPkId()!=null || order.getStatus()!=null){
                int i = ohtaOrderService.updateByExampleSelective(order);
                if(i==1)
                {
                    msg.put("code","1");
                    msg.put("msg","成功");
                }else {
                    msg.put("code","0");
                    msg.put("msg","失败");
                }
            }else {
                msg.put("code","0");
                msg.put("msg","参数不合法");
            }
        }catch (Exception e) {
            msg.put("code","0");
            msg.put("message",e.getMessage());
        }
        return msg;
    }
}
