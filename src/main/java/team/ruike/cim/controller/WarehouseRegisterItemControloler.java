package team.ruike.cim.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.*;
import team.ruike.cim.service.*;
import team.ruike.cim.service.impl.MaterielTypeLevelBServiceImpl;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.List;

/**
 * 物料入库记录项
 */
@Controller
public class WarehouseRegisterItemControloler {
    @Resource
    private WarehouseRegisterItemService warehouseRegisterItemService;
    @Resource
    private MaterielTypeLevelBServiceImpl materielTypeLevelBService;
    @Resource
    private WareHouSereGIonService warehouseregionServer;
    @Resource
    private GoodSShelveService goodSShelveService;
    @Resource
    private WarehouseService warehouseService;
    @Resource
    private MaterielService materielService;

    /**
     * 查看入库记录页面
     */
    @RequestMapping("/getWarehouseRegisterItem.do")
    public String getWarehouseRegisterItem(HttpServletRequest request, WarehouseRegisterItem warehouseRegisterItem, Pager<WarehouseRegisterItem> pager) {
        warehouseRegisterItemService.getWarehouseRegisterItemByWarehouseId(warehouseRegisterItem,pager);
        request.setAttribute("RegisterItemPager", pager);
        return "warehouses/materiel_register";
    }

    /**
     * 跳转入库记录页面
     * @param request
     * @param materielTypeLevelB
     * @return
     */
    @RequestMapping("lodaddProducts.do")
    public String lodaddProducts(HttpServletRequest request, MaterielTypeLevelB materielTypeLevelB,int wid){
        request.setAttribute("Mb",materielTypeLevelBService.getMaterielTypeLevelB(materielTypeLevelB));//加载物料列表
        request.setAttribute("whid",wid);
        return "warehouses/addproduct_warehouse_register_item";
    }

    /**
     * 根据物料id查询对应的区域
     * @param warehouseRegion
     * @param pager
     */
    @RequestMapping("getQuyu.do")
    public void getQuyu(WarehouseRegion warehouseRegion, Pager<WarehouseRegion> pager,PrintWriter printWriter){
        warehouseregionServer.getWareHouSereGIonServer(warehouseRegion,pager);
        String Stringusers= JSON.toJSONString(pager.getList());
        printWriter.write(Stringusers);
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 通过区域id 查询可用空货架
     */
    @RequestMapping("gethuojia.do")
    public void  gethuojia(Integer warehouseRegionId,PrintWriter printWriter){
        List<GoodsShelve> goodsShelveList= goodSShelveService.selectByWarehouseRegionId(warehouseRegionId);
        String joins=JSON.toJSONString(goodsShelveList);
        printWriter.write(joins);
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 根据2级物料id获取三级物料列表
     */
    @RequestMapping("/getMateriel.do")
    public void getMateriel(PrintWriter printWriter,Materiel materiel ,Pager<Materiel> pager){
        materielService.getMaterielList(materiel,pager);
        List<Materiel> materiels=pager.getList();
        String joins=JSON.toJSONString(materiels);
        printWriter.write(joins);
        printWriter.flush();
        printWriter.close();
    }
    public void getPlanid(){

    }
    public String addWarehouseRegisterItem(HttpServletRequest request,List<WarehouseRegisterItem> items){

        return "";
    }
}
