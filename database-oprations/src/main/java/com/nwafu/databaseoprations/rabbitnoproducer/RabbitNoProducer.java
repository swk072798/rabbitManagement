package com.nwafu.databaseoprations.rabbitnoproducer;

import com.nwafu.databaseoprations.dao.RabbitInfoMapper;
import com.nwafu.databaseoprations.entity.RabbitInfo;
import com.nwafu.databaseoprations.entity.RabbitInfoVO;
import lombok.Data;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 自动生成兔子编号
 * @author: liu qinchang
 * @create: 2020-03-31 11:39
 **/
@Data
public class RabbitNoProducer {



    private String abbreviation;
    private String year;
    private String week;
    private String num;
    private List<RabbitInfoVO> rabbitInfoVOList;
    private List<String> allRabbitNo;

    public RabbitNoProducer(){

    }

    public RabbitNoProducer(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getYearToString(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        String year = Integer.valueOf(calendar.get(Calendar.YEAR)).toString();
        return year.substring(2, 4);
    }

    public String getWeekToString(){
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();

        calendar.setFirstDayOfWeek(Calendar.MONDAY); //美国是以周日为每周的第一天 现把周一设成第一天

        calendar.setTime(date);

        String week = Integer.valueOf(calendar.get(Calendar.WEEK_OF_YEAR)).toString();
        if(week.length() < 2){
            StringBuffer finalWeek = new StringBuffer();
            finalWeek.append("0");
            finalWeek.append(week);
            return finalWeek.toString();
        }
        return week;

    }

    public List<String> getRabbitLastNum(){
        Integer num;
        if(allRabbitNo == null || allRabbitNo.size() == 0){
            num = 0;
        }else{
            String lastRabbitNo = allRabbitNo.get(allRabbitNo.size() - 1);
            allRabbitNo.clear();
            String rabbitNo = lastRabbitNo.substring(6, lastRabbitNo.length());
            num = Integer.valueOf(rabbitNo);
        }
        List<Integer> arr = new ArrayList<>(rabbitInfoVOList.size());
        for(int i = 0; i < rabbitInfoVOList.size(); i++){
            arr.add(num + i + 1);
        }
        List<String> lastNum = new ArrayList<>(rabbitInfoVOList.size());
        for(int j = 0; j < rabbitInfoVOList.size(); j++){
            StringBuffer result = new StringBuffer();
            if(arr.get(j).toString().length() < 4){
                for(int m = 0; m < 4 - arr.get(j).toString().length(); m++){
                    result.append("0");
                }
                for(int n = 0; n < arr.get(j).toString().length(); n++){
                    result.append(arr.get(j).toString().split("")[n]);
                }
                lastNum.add(result.toString());
            }else{
                lastNum.add(arr.get(j).toString());
            }
        }
        return lastNum;
    }

    public List<RabbitInfo> produceNo(){
        List<RabbitInfo> result = new ArrayList<>(rabbitInfoVOList.size());
        List<String> lastNum = getRabbitLastNum();
        for(int i = 0; i < rabbitInfoVOList.size(); i++){
            RabbitInfo rabbitInfo = new RabbitInfo(rabbitInfoVOList.get(i));
            StringBuffer s = new StringBuffer();
            s.append(abbreviation);
            s.append(getYearToString());
            s.append(getWeekToString());
            s.append(lastNum.get(i));
            rabbitInfo.setRabbitNo(s.toString());
            result.add(rabbitInfo);
        }
        return result;
    }


}
