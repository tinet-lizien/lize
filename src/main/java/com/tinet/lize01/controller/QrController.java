package com.tinet.lize01.controller;

import com.tinet.lize01.utils.QRcodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;

/**
 * @author lize
 * @date 2021年09月01日 15:14
 */
@RestController
@Slf4j
public class QrController {

    @GetMapping("/qr_code")
    public void genQRCode(String accessId, HttpServletResponse response) {
        // 获取生成的链接，用链接生成二维码。
        StringBuilder appUrlBuilder = new StringBuilder();
        appUrlBuilder.append("https").append("://").append("www.baidu.com").append("/index.html").
                append("?accessId=").append(accessId).append("&type=1");
        String url = appUrlBuilder.toString();
        try {
            QRcodeUtil.createQRCodeImage(url, 100, 100, Color.BLACK, response);
        } catch (Exception e) {
            log.error("生成模二维码失败");
        }
    }
}
