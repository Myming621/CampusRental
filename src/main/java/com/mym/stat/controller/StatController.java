package com.mym.stat.controller;

import com.mym.bus.domain.Customer;
import com.mym.bus.domain.Rent;
import com.mym.bus.service.ICustomerService;
import com.mym.bus.service.IRentService;
import com.mym.stat.domain.BaseEntity;
import com.mym.stat.service.IStatService;
import com.mym.sys.utils.ExportRentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报表
 */
@RequestMapping("stat")
@Controller
public class StatController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IRentService rentService;

    @Autowired
    private IStatService statService;

    /**
     * 导出出租单
     */
    @RequestMapping("exportRent")
    public ResponseEntity<Object> exportRent(String rentid){
        //跟出租单id查询出租单
        Rent rent = rentService.queryRentByRentId(rentid);
        //根据客户的身份证号码查询客户信息
        Customer customer = customerService.queryCustomerByIdentity(rent.getIdentity());
        String fileName = customer.getCustname() + "-的出租单.xls";
        String sheetName = customer.getCustname()+"出租单";
        //通过工具类进行导出操作
        ByteArrayOutputStream bos = ExportRentUtils.exportRent(rent,customer,sheetName);

        try {
            //处理文件名称乱码
            fileName = URLEncoder.encode(fileName,"UTF-8");
            //由于要进行下载,所有要设置头信息
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //设置下载文件的名称
            headers.setContentDispositionFormData("attachment",fileName);
            //将数据组装返回
            return new ResponseEntity<Object>(bos.toByteArray(),headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 跳转到客户地区统计图标
     */
    @RequestMapping("toCustomerAreaStat")
    public String toCustomerAreaStat(){
        return "stat/customerAreaStat";
    }


    /**
     * 加载客户地区数据
     */
    @RequestMapping("loadCustomerAreaStatJson")
    @ResponseBody
    public List<BaseEntity> loadCustomerAreaStatJson(){
        return  statService.loadCustomerAreaStatList();
    }

    /**
     * 跳转公司年度月份销量统计页面
     */
    @RequestMapping("toCompanyYearGradeStat")
    public String toCompanyYearGradeStat(){
        return "stat/companyYearGradeStat";
    }

    /**
     * 加载公司年度业务统计
     */
    @RequestMapping("loadCompanyYearGradeStatJson")
    @ResponseBody
    public List<Double> loadCompanyYearGradeStatJson(String year){
        //查询一年里面每个月的销售情况,放到一个List集合中
        List<Double> entities =  statService.loadCompanyYearGradeStatList(year);
        //如果有些月没有,查询的结果是null ,手动的给这些数据设置为0.0
        for(int i = 0; i < entities.size() ; i++){
            if(null == entities.get(i)){
                entities.set(i,0.0);
            }
        }
        return entities;
    }

    /**
     * 跳转到业务员年度业务统计
     * @return
     */
    @RequestMapping("toOpernameYearGradeStat")
    public String toOpernameYearGradeStat(){
        return "stat/opernameYearGradeStat";
    }

    /**
     * 加载业务员年度销售统计
     */
    @RequestMapping("loadOpernameYearGradeStatJson")
    @ResponseBody
    public Map<String,Object> loadOpernameYearGradeStatJson(String year){
        List<BaseEntity> entities = statService.loadOpernameYearGradeStatList(year);
        Map<String,Object> map = new HashMap<>();
        //装name属性
        List<String> names = new ArrayList<>();
        //装value属性
        List<Double> values = new ArrayList<>();

        for(BaseEntity baseEntity : entities){
            names.add(baseEntity.getName());
            values.add(baseEntity.getValue());
        }
        map.put("name",names);
        map.put("value",values);
        return map;
    }
}
