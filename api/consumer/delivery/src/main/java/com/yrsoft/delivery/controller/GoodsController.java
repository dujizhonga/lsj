package com.yrsoft.delivery.controller;

import com.yrsoft.common.exception.NullParamException;
import com.yrsoft.common.json.JSONObject;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.delivery.service.GoodsService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @author Yhq
 * @date 2019/2/23 14:25
 */
@RestSchema(schemaId = "goods")
@RequestMapping(path = "api/goods", produces = MediaType.APPLICATION_JSON)
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 查询货运单对应地址及保证金接口
     *
     * @param paramStr
     * @return
     */
    @PostMapping("get/bond/addr")
    public JsonResult getBondAndAddress(@RequestParam("paramStr") String paramStr) {
        try {
            Map map = JSONObject.paramStrToBean(paramStr, Map.class);
            String invoiceId = StringUtils.objToStr(map.get("invoiceId"));
            if (StringUtils.isEmpty(invoiceId)) {
                throw new NullParamException(201, "invoiceId为空");
            }
            return JsonResult.success(goodsService.getBondAndAddress(invoiceId));
        } catch (NullParamException n) {
            return JsonResult.error(n.getCode(), n.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error(500, "[系统错误]");
        }
    }

    /**
     * 查询运费接口
     *
     * @param paramStr
     * @return
     */
    @PostMapping("get/freight/moneys")
    public JsonResult getFreightMoneys(@RequestParam("paramStr") String paramStr) {
        try {
            Map map = JSONObject.paramStrToBean(paramStr, Map.class);
            String ids = StringUtils.objToStr(map.get("ids"));
            if (StringUtils.isEmpty(ids)) {
                return JsonResult.error(201, "运单id集合不能为空");
            }
            return JsonResult.success(goodsService.getFreightMoney(ids));
        } catch (NullParamException n) {
            return JsonResult.error(n.getCode(), n.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error(500, "[系统错误]");
        }
    }
}
