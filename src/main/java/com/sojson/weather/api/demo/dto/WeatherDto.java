package com.sojson.weather.api.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

/**
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * 高级天气API 返回实体   （15天）
 * <p>
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2017年08月23日 23:10 　<br/>
 *
 * @author zhou-baicheng
 * @version 1.0<br/>
 * @email so@sojson.com
 */
@lombok.Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDto implements Serializable {






    private String message;
    private int status;
    //第一天时间
    private String date;
    private String time;
    //当前主题信息
    private CityInfo cityInfo;

    private WeatherData data;


    public boolean isSuccess(){
        return this.status == 200;
    }
    /**
     * 当前城市信息
     */
    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class CityInfo implements Serializable {
        //城市name 如 茶陵
        private String city;
        //城市id
        private String citykey;
        //父级城市，比如市级，省级
        private String parent;
        //更新时间
        private String updateTime;


    }
    //限号的城市
    private List<Xianhao> xianhao = new ArrayList<>();
    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Xianhao  implements Serializable {
        private String date;//日期
        private String number;//限制的车牌号码3,8
        private String cityId;//城市ID
        private String title;//标题 ：限制



    }



    ///////////////////////////  天气主体信息 ///////////////////////////////////
    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class WeatherData  implements Serializable{

        //兼容字段
        private String shidu;
        private Double pm25;
        private Double pm10;
        private String quality;
        private String wendu;
        private String ganmao;


      




        //空气质量
        private AirQuality air;
        //当天天气其他说明
        private Expand expand;

        //各种指数
        private List<Index> indexes = new ArrayList<>();

        //15天天气预报
        //限号的城市

        private List<Forecast> forecast = new ArrayList<>();


        //昨天，从forecast取一条放到 yesterday
        private Forecast yesterday;

        //24小时天气
        private List<Hour> hour24 = new ArrayList<>();


        //空气质量相关evn
        @lombok.Data
        public static class AirQuality  implements Serializable {
            private String no2;
            private String mp;
            private String pm25;
            private String o3;
            private String so2;
            private String aqi;
            private String pm10;
            private String suggest;//如：各类人群可自由活动",
            private String time;//更新时间":"22:00:00",
            private String co;
            private String quality;//":"优"
        }


        /**
         * 当天天气拓展
         */
        @lombok.Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Expand  implements Serializable {
            /**
             * 湿度
             */
            private String humidity;
            /**
             * 天气
             */
            private String weather;
            //天气类型  如：2
            private Integer weatherType;
            //更新时间
            private String updateTime;
            //体感温度
            private String stemp;
            //风速
            private String windPower;
            //风向
            private String windDirection;

        }




        /**
         * 小时天气
         */
        @lombok.Data
        public static class Hour  implements Serializable {
            /**
             * 温度
             */
            private Integer temperature;
            /**
             * 湿度
             */
            private String humidity;
            //风速
            private String windPower;
            //风向
            private String windDirection;
            private String weather;
            //天气类型  如：2
            private Integer weatherType;
            //时间 如：201708241900
            private String time;


        }


        /**
         * 天气预报，一天
         */
        @lombok.Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Forecast implements Serializable {

            //日期
            private String date;
            //最高温度，最低温度
            private String high;
            private String low;
            private String ymd;
            private String week;
            //日出 & 日落
            private String sunrise;
            private String sunset;
            //空气质量
            private Integer aqi;
            //白天天气
            private Day day;
            //晚上天气
            private Day night;



            //兼容字段
            //风向
            private String fx;
            //风力
            private String fl;
            //天气类型
            private String type;
            private String notice;



        }

        //白天 & 晚上 天气描述
        @lombok.Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Day implements Serializable {
            //风速
            private String windPower;
            //风向
            private String windDirection;

            //公告    如："悠悠的云里有淡淡的诗"
            private String notice;
            //天气描述  如：多云
            private String weather;




        }





        /**
         * 各种指数
         */
        @lombok.Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Index  implements Serializable {
            //指数图标
            private String icon;
            //指数值          如：较适宜
            private String value;
            //指数名称
            private String name;
            //指数简单描述    如：较适宜晨练
            private String tips;
            //指数详细描述
            private String description;




        }


    }




}


