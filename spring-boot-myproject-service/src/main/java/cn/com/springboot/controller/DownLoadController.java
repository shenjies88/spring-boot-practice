package cn.com.springboot.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author shenjies88
 * @since 2019-04-16-15:52
 */
public class DownLoadController {

    public void downLoad(HttpServletResponse response) throws UnsupportedEncodingException {

        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("企业基础信息.xlsx", "UTF-8"));
        response.setHeader("fileName", URLEncoder.encode("企业基础信息.xlsx", "UTF-8"));
//        Files.copy(path, response.getOutputStream());

    }
}