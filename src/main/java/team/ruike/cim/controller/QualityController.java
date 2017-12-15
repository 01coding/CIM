package team.ruike.cim.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.*;
import team.ruike.cim.service.QualityService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 质量管理控制器
 * @author 华中昊
 * @version 1.0
 */
@Controller
public class QualityController {
    @Resource
    private QualityService qualityService;
    /**
     * 品控记录页面跳转并查询数据
     * @return 记录页面jsp
     */
    @RequestMapping("/record.do")
    public String selectRecord(PurchaseStandardRecord purchaseStandardRecord, Pager<PurchaseStandardRecord> pager, HttpServletRequest request){
        qualityService.getRecordList(purchaseStandardRecord,pager);
        request.setAttribute("page1",pager);
        return "quality/record";
    }

    /**
     *根据采购批次查询
     * @param sid
     * @param purchaseStandardRecord
     * @param pager
     * @param request
     * @return
     */
    @RequestMapping("Something.do")
    public String getRecordBySomething(Integer sid,PurchaseStandardRecord purchaseStandardRecord, Pager<PurchaseStandardRecord> pager, HttpServletRequest request){
        System.out.println(sid);
        if (sid!=null){
            System.out.println(sid);
            qualityService.selectBySomething(sid,purchaseStandardRecord,pager);
            request.setAttribute("page1",pager);
        }else {
            qualityService.getRecordList(purchaseStandardRecord,pager);
            request.setAttribute("page1",pager);
        }
        return "quality/record";
    }

    /**
     * 根据记录id获取详情
     * @param pid
     */
    @RequestMapping("xiangqing.do")
    public void getXiangQing(Integer pid,PrintWriter printWriter){
        PurchaseStandardRecord purchaseStandardRecord=new PurchaseStandardRecord();
        purchaseStandardRecord.setPurchaseStandardRecordId(pid);
        Pager<PurchaseStandardRecord> pager=new Pager<PurchaseStandardRecord>();
        qualityService.getRecordList(purchaseStandardRecord,pager);

        PurchaseStandard purchaseStandard=new PurchaseStandard();
        purchaseStandard.setMateriel(pager.getList().get(0).getMateriel());
        Pager<PurchaseStandard> pager1=new Pager<PurchaseStandard>();
        qualityService.getPurchaseStandard(purchaseStandard,pager1);

        List<Object> as=new ArrayList();
        as.add(pager.getList().get(0));
        as.add(pager1.getList().get(0));

        String jeonString=JSON.toJSONString(as);
        printWriter.write(jeonString);
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 根据标准id获取详情
     * @param sid
     * @param printWriter
     */
    @RequestMapping("getStardXiang.do")
    public void getXiangBySid(Integer sid,PrintWriter printWriter){
        PurchaseStandard purchaseStandard=new PurchaseStandard();
        purchaseStandard.setPurchaseStandardId(sid);
        Pager<PurchaseStandard> pager=new Pager<PurchaseStandard>();
        qualityService.selectStandard(purchaseStandard,pager);
        List<PurchaseStandard> purchaseStandardList=pager.getList();
        purchaseStandard=purchaseStandardList.get(0);
        String jsonstring=JSON.toJSONString(purchaseStandard);
        printWriter.write(jsonstring);
        printWriter.flush();
        printWriter.close();
    }


    /**
     * 删除采购标准
     * @param purchaseStandardId
     * @param printWriter
     */
    @RequestMapping("deletePurchaseStandard.do")
    public void deletePurchaseStandard(Integer purchaseStandardId,PrintWriter printWriter){
        PurchaseStandard purchaseStandard=new PurchaseStandard();
        purchaseStandard.setPurchaseStandardId(purchaseStandardId);
        int resoult=qualityService.deleteStand(purchaseStandard);
        String jsonString =JSON.toJSONString(resoult);
        printWriter.write(jsonString);
        printWriter.flush();

        printWriter.close();
    }


    /**
     * 跳转修改 PurchaseStandard 页面
     * @param Psid
     * @param request
     * @return
     */
    @RequestMapping("toUpdate.do")
    public String toUpdate(Integer Psid,HttpServletRequest request){
        PurchaseStandard purchaseStandard=new PurchaseStandard();
        purchaseStandard.setPurchaseStandardId(Psid);
        Pager<PurchaseStandard> pager=new Pager<PurchaseStandard>();
        qualityService.selectStandard(purchaseStandard,pager);
        if (pager.getList()!=null && pager.getList().size()==1){
            request.setAttribute("PStand",pager.getList().get(0));
            return "quality/purchaseupdate";
        }else {
            return "redirect:/standard.do";
        }
    }


    /**
     * 修改标准
     * @param purchaseStandard
     * @return
     */
    @RequestMapping("updatePurchaseStandard.do")
    public String updateStand(PurchaseStandard purchaseStandard){
        qualityService.updateStand(purchaseStandard);
        return "redirect:/standard.do";
    }




    /**
     * 跳转采购标准页面
     * @return
     */
    @RequestMapping("standard.do")
    public String standard(PurchaseStandard purchaseStandard,Pager<PurchaseStandard> pager,HttpServletRequest request){
        qualityService.selectStandard(purchaseStandard,pager);
        request.setAttribute("palist",pager);
        return "quality/standard";
    }

    /**
     * 新增采购标准
     * @return
     */
    @RequestMapping("insertPurchase.do")
    public String addStandard(PurchaseStandard purchaseStandard){
        int number=qualityService.addStandard(purchaseStandard);
        if(number==1){
           return  "redirect:standard.do";
        }else {
            return  "quality/addpurchase";
        }
    }

    /**
     * 跳转新增标准页面 获取一级菜单
     * @param request
     * @return
     */
    @RequestMapping("addpurchase.do")
    public String toRecord(HttpServletRequest request){

        List<MaterielTypeLevelA> materielTypeLevelAList= qualityService.getMaterielTypeLevelA();

        MaterielTypeLevelB materielTypeLevelB=new MaterielTypeLevelB();
        materielTypeLevelB.setMaterielTypeLevelA(materielTypeLevelAList.get(0));
        List<MaterielTypeLevelB> materielTypeLevelBList=qualityService.getMaterielTypeLevelB(materielTypeLevelB);

        Materiel materiel=new Materiel();
        materiel.setMaterielTypeLevelB(materielTypeLevelBList.get(0));
        List<Materiel> materielList=qualityService.getMateriel(materiel);

        request.setAttribute("AList",materielTypeLevelAList);
        request.setAttribute("BList",materielTypeLevelBList);
        request.setAttribute("MList",materielList);
        return  "quality/addpurchase";
    }

    /**
     * 获取二级菜单
     * @param materielTypeLevelAid  一级菜单Id
     * @param printWriter
     */
    @RequestMapping("TypeB.do")
    public void getTypeB(Integer materielTypeLevelAid,PrintWriter printWriter){
        MaterielTypeLevelB materielTypeLevelB=new MaterielTypeLevelB();
        MaterielTypeLevelA materielTypeLevelA=new MaterielTypeLevelA();
        materielTypeLevelA.setMaterielTypeLevelAId(materielTypeLevelAid);

        materielTypeLevelB.setMaterielTypeLevelA(materielTypeLevelA);
        List<MaterielTypeLevelB> MaterielTypeLevelBList= qualityService.getMaterielTypeLevelB(materielTypeLevelB);
        String jeonString=JSON.toJSONString(MaterielTypeLevelBList);
        printWriter.write(jeonString);
        printWriter.flush();
        printWriter.close();

    }

    /**
     * 获取二级物料
     * @param printWriter
     * @param materielTypeLevelBId  二级菜单
     */
    @RequestMapping("materiel.do")
    public void getMateriel(PrintWriter printWriter,Integer materielTypeLevelBId){
        MaterielTypeLevelB materielTypeLevelB=new MaterielTypeLevelB();
        materielTypeLevelB.setMaterielTypeLevelBId(materielTypeLevelBId);

        Materiel materiel=new Materiel();
        materiel.setMaterielTypeLevelB(materielTypeLevelB);
        List<Materiel> materielList=qualityService.getMateriel(materiel);
        String jsonString = JSON.toJSONString(materielList);
        printWriter.write(jsonString);
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 跳转添加记录页面加载数值
     * @param request
     * @return
     */
    @RequestMapping("picitypeA.do")
    public String getPiciA(HttpServletRequest request){
        List<MaterielTypeLevelA> materielTypeLevelAList=qualityService.getMaterielTypeLevelAByDate();

        List<MaterielTypeLevelB> materielTypeLevelBList=qualityService.getMaterielTypeLevelBByDate(materielTypeLevelAList.get(0).getMaterielTypeLevelAId());

        List<Materiel> materielList=qualityService.getMaterielByDate(materielTypeLevelBList.get(0).getMaterielTypeLevelBId());

        Integer number=qualityService.getNumberByDate();

        PurchaseStandard purchaseStandard= qualityService.getpurchaseStandard(materielList.get(0).getMaterielId());
        request.setAttribute("piciA",materielTypeLevelAList);
        request.setAttribute("piciB",materielTypeLevelBList);
        request.setAttribute("piciM",materielList);
        request.setAttribute("num",number);
        request.setAttribute("pstd",purchaseStandard);
        return  "quality/addrecord";
    }

    /**
     * 物料二级菜单加载
     * @param printWriter
     * @param materielTypeLevelAid 物料一级菜单Id
     */
    @RequestMapping("picitypeB.do")
    public void getPiciB(PrintWriter printWriter,Integer materielTypeLevelAid){
        List<MaterielTypeLevelB> materielTypeLevelBS=qualityService.getMaterielTypeLevelBByDate(materielTypeLevelAid);
        String jsonString=JSON.toJSONString(materielTypeLevelBS);
        printWriter.write(jsonString);
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 根据时间加载物料信息
     * @param printWriter
     * @param materielTypeLevelBid
     */
    @RequestMapping("piciM.do")
    public void getPiciM(PrintWriter printWriter,Integer materielTypeLevelBid){
        List<Materiel> materiels=qualityService.getMaterielByDate(materielTypeLevelBid);
        String jsonString=JSON.toJSONString(materiels);
        printWriter.write(jsonString);
        printWriter.flush();
        printWriter.close();
    }


    /**
     * 根据物料查询标准
     * @param printWriter
     * @param materielId
     */
    @RequestMapping("PStand.do")
    public void getPurchaseStandard(PrintWriter printWriter,Integer materielId){
        PurchaseStandard purchaseStandard= qualityService.getpurchaseStandard(materielId);
        System.out.println(purchaseStandard.getStandardAName());
        System.out.println(purchaseStandard.getPurchaseStandardId());
        String jsonString =JSON.toJSONString(purchaseStandard);
        printWriter.write(jsonString);
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 新增记录
     * @param purchaseStandardRecord
     * @param printWriter
     */
    @RequestMapping("addpurchaseRecord.do")
    public void insertPurchaseStandard(PurchaseStandardRecord purchaseStandardRecord,PrintWriter printWriter){
        Integer result=qualityService.addPurchaseStandardRecord(purchaseStandardRecord);
        String jsonString=JSON.toJSONString(result);
        printWriter.write(jsonString);
        printWriter.flush();
        printWriter.close();
    }


}
