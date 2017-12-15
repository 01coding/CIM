package team.ruike.cim.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.GoodsShelve;
import team.ruike.cim.pojo.MaterielTypeLevelB;
import team.ruike.cim.pojo.WarehouseRegion;
import team.ruike.cim.service.GoodSShelveService;
import team.ruike.cim.service.MaterielTypeLevelBService;
import team.ruike.cim.service.WareHouSereGIonService;
import team.ruike.cim.util.GenerateNumber;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.List;

/**
 * 物料区域表
 */
@Controller
public class WareHouseRegionControloler {
    @Resource
    private WareHouSereGIonService warehouseregionServer;
    @Resource
    private GoodSShelveService goodsshelveService;
    @Resource
    private MaterielTypeLevelBService materielTypeLevelBService;
    /**
     * 查询物物料区域和对应的货架
     * @param warehouseRegion
     * @param goodsShelve
     * @param pager
     * @param request
     * @return
     */
    @RequestMapping("/getwarehouseregion.do")
    public String getWarehouseregion(WarehouseRegion warehouseRegion, GoodsShelve goodsShelve,Pager<WarehouseRegion> pager, HttpServletRequest request){
        warehouseregionServer.getWareHouSereGIonServer(warehouseRegion,pager);
        List<GoodsShelve> good= goodsshelveService.getGoodsshelve(goodsShelve);
        request.setAttribute("goodsShelves",good);
        request.setAttribute("warehouseRegions",pager.getList());
        return "warehouses/warehouse_region";
    }

    /**
     * 添加物料区域
     * @param printWriter
     * @param warehouseRegion
     */
    @RequestMapping("addWarehouseRegion.do")
    public void addWarehouseRegion(PrintWriter printWriter,WarehouseRegion warehouseRegion){
        warehouseRegion.setWarehouseRegionNo(GenerateNumber.getGenerateNumber().getRandomFileName());
        warehouseregionServer.addWareHouSereGIonServer(warehouseRegion);
        if (warehouseRegion.getWarehouseRegionId()!=null&&warehouseRegion.getWarehouseRegionId()>0){
            String Stringusers= JSON.toJSONString(warehouseRegion.getWarehouseRegionId());
            printWriter.write(Stringusers);
            printWriter.flush();
            printWriter.close();
        }
    }
    @RequestMapping("getMaterielTypeLevelB.cl")
    public void getMaterielTypeLevelB(MaterielTypeLevelB materielTypeLevelB,PrintWriter printWriter){
       List<MaterielTypeLevelB> materielTypeLevelBS=  materielTypeLevelBService.getMaterielTypeLevelB(materielTypeLevelB);
        String Stringusers= JSON.toJSONString(materielTypeLevelBS);
        printWriter.write(Stringusers);
        printWriter.flush();
        printWriter.close();
    }
}
