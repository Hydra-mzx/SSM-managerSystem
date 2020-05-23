package com.mzx.crud.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.mzx.crud.bean.Msg;


@Controller
public class ViewController {
	
	/**
     * 单个文件上传
     * @param request
     * @return
     */
    @RequestMapping(value="/upload2",produces="text/html;charset=utf-8")
    @ResponseBody
    private String upload2(@RequestParam("file")CommonsMultipartFile partFile,HttpServletRequest request) {
        try {
            String path = request.getServletContext().getRealPath("/upload/pro1");
            //System.out.println(path);
            String name = request.getParameter("name");
            String filename = partFile.getOriginalFilename();
            File file = new File(path+"/"+filename);
            InputStream inputStream = partFile.getInputStream();
            FileUtils.copyInputStreamToFile(inputStream, file);
            if(inputStream!=null){
                inputStream.close();
            }
            return "文件上传成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传失败！";
        } 
    }
    
    @RequestMapping(value="/upload1/{proid}",produces="text/html;charset=utf-8")
    @ResponseBody
    private String upload(@RequestParam("file")CommonsMultipartFile partFile,@PathVariable("proid")int proid,HttpServletRequest request) {
    	try {
    		System.out.println(proid);
    		String path = request.getServletContext().getRealPath("/upload/pro"+proid);
    		//System.out.println(path);
    		//int id = request.getParameter("proid");
    		String filename = partFile.getOriginalFilename();
    		File file = new File(path+"/"+filename);
    		InputStream inputStream = partFile.getInputStream();
    		FileUtils.copyInputStreamToFile(inputStream, file);
    		if(inputStream!=null){
    			inputStream.close();
    		}
    		return "文件上传成功！";
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "文件上传失败！";
    	} 
    }
    
    @RequestMapping("/down1")
    private void down(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String path = request.getServletContext().getRealPath("/upload/pro1");
        File file = new File(path);
        File[] files = file.listFiles();
        String name = files[2].getName();//随机获取一个文件，实际中按需编写代码
        System.out.println("文件的名字："+name);
        response.addHeader("content-disposition", "attachment;filename="+name);
        FileUtils.copyFile(files[2], response.getOutputStream());
    }


}
