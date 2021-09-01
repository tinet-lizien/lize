package com.tinet.lize.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangpc
 * @Title: 生成二维码
 * @date 2021/8/20
 */
@Slf4j
public class QRcodeUtil {

    public static void createQRCodeImage(String content, int width, int height, Color color, HttpServletResponse response) throws IOException, WriterException {
        //生成图片文件
        ImageIO.write(genBarcode(content, width, height, color), "jpg", response.getOutputStream());
        log.info("二维码生成成功！");
    }

    /**
     * 得到BufferedImage
     *
     * @param content 二维码显示的文本
     * @param width   二维码的宽度
     * @param height  二维码的高度
     * @param color  颜色
     * @return
     * @throws WriterException
     * @throws IOException
     */
    private static BufferedImage genBarcode(String content, int width, int height, Color color) throws WriterException, IOException {

        MultiFormatWriter mutiWriter = new MultiFormatWriter();
        //定义二维码内容参数
        Map<EncodeHintType, Object> hints = new HashMap<>(4);
        //设置字符集编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //设置容错等级，在这里我们使用M级别
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // 设置边距
        hints.put(EncodeHintType.MARGIN, 1);
        // 生成二维码，参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
        BitMatrix matrix = mutiWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);

        // 二维矩阵转为一维像素数组
        int[] pixels = new int[width * height];

        int colorInt = color.getRGB();
        for (int y = 0; y < matrix.getHeight(); y++) {
            for (int x = 0; x < matrix.getWidth(); x++) {
                // 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
                pixels[y * width + x] = matrix.get(x, y) ? colorInt : 16777215;
            }
        }

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        image.getRaster().setDataElements(0, 0, width, height, pixels);
        return image;
    }
}
