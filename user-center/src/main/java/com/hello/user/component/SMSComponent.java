package com.hello.user.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @AUTHOR: raymond
 * @DATETIME: 2020/5/17  16:54
 * DESCRIPTION:
 **/
@ConfigurationProperties(prefix = "spring.config.sms")
@Data
@Component
public class SMSComponent {

    private String host;
    private String path;
    private String appcode;
    private String templateId;

    public void sendSMSCode(String phone, String code) {
        System.out.println("host = " + host + "    " + "appcode = " + appcode);
//        String method = "POST";
//        Map<String, String> headers = new HashMap<>();
//        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
//        Map<String, String> querys = new HashMap<>();
//        querys.put("receive", phone);
//        querys.put("tag", code);
//        querys.put("templateId", templateId);
//        Map<String, String> bodys = new HashMap<>();
//
//        try {
//            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
//            System.out.println(response.toString());
//            //获取response的body
//            //System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

