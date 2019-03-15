package com.qualityevaluationsys.demo.web;

import com.qualityevaluationsys.demo.domain.OhtaProduct;
import com.qualityevaluationsys.demo.service.OhtaProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Assisiwjj
 */
@RestController
@RequestMapping("ohtaProduct")
public class OhtaProductController extends BaseController{
    @Autowired
    private OhtaProductService ohtaProductService;

    /**
     *添加商品
     * @param product
     * @return
     */
    @RequestMapping(value = "addProduct",method = RequestMethod.POST)
    public Map<String,Object> addProduct(@RequestBody OhtaProduct product){
        msg.clear();
        try{
            if (product.getProductImage()!=null && product.getProductIntroduction()!=null
                    && product.getProductPrice()!=null && product.getProductName()!=null
                    && product.getProductType()!=null){
                int i=ohtaProductService.insert(product);
                if(i==1){
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
        }catch(Exception e) {
            msg.put("code","0");
            msg.put("message",e.getMessage());
        }
        return msg;
    }

    /**
     *修改商品信息
     * @param product
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Map<String ,Object> update(@RequestBody OhtaProduct product){
        msg.clear();
        try{
            int i = ohtaProductService.updateByPrimaryKeySelective(product);
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
     *查询所有商品信息
     * @param
     * @return
     */
    @RequestMapping(value = "allProduct",method = RequestMethod.GET)
    public Map<String ,Object> allProduct(){
        msg.clear();
        try{
            List temp = ohtaProductService.selectAllProduct();
                msg.put("code","1");
                msg.put("msg","成功");
                msg.put("data",temp);
        }
        catch (Exception e)
        {
            msg.put("code","0");
            msg.put("message",e.getMessage());
        }
        return msg;
    }
}
