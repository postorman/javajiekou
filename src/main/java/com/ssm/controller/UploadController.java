package com.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.pojo.Upload;
import com.ssm.service.UploadService;

/**
 *
 * @版权 : Copyright (c) 2017-2018 个人
 * @author: xujunhao(一般是写姓名的拼音)
 * @E-mail: 982488409@qq.com
 * @版本: 1.0
 * @创建日期: 2020年2月21日 下午5:21:02
 * @ClassName UploadController
 * @类描述-Description: TODO(这里用一句话描述这个方法的作用)
 * @修改记录:
 * @版本: 1.0
 */
@Controller
@RequestMapping("/user1")
public class UploadController {
	@Autowired
	private UploadService al;

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String UploadIn(Upload up, HttpServletRequest request, Model model) throws Exception {
		System.out.println(request.getParameter("bookname"));
		// 保存数据库的路径
		String sqlPath = null;
		// 定义文件保存的本地路径
		String localPath = "D:\\File\\";
		// 定义 文件名
		String filename = null;
		if (!up.getFile().isEmpty()) {
			// 生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType = up.getFile().getContentType();
			// 获得文件后缀名
			String suffixName = contentType.substring(contentType.indexOf("/") + 1);
			// 得到 文件名
			filename = uuid + "." + suffixName;
			System.out.println(filename);
			// 文件保存路径
			up.getFile().transferTo(new File(localPath + filename));
		}
		// 把图片的相对路径保存至数据库
		sqlPath = "/images/" + filename;
		System.out.println(sqlPath);
		// user.setId(1);
		up.setBookname(request.getParameter("bookname"));
		up.setPrice(Double.parseDouble(request.getParameter("price")));
		up.setStock(Integer.parseInt(request.getParameter("stock")));
		up.setImg(sqlPath);
		al.addGoods(up);
		model.addAttribute("books", up);

		return "gg";
	}

	@RequestMapping(value = "/saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> importData(@RequestParam MultipartFile file, HttpServletRequest req)
			throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (file.isEmpty()) {
			System.out.print("文件为空");
			map.put("msg", "文件为空");
			return map;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		String format = sdf.format(new Date());
		String realPath = "D:/upload/temp" + format;
		System.out.println("!!!!!!!!!!!!!!!!!!realPath" + realPath);
		System.out.println("!!!!!!!!!!!!!!!!!!realPath" + file.getContentType());
		File folder = new File(realPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		String oldName = file.getOriginalFilename();
		System.out.println("!!!!!!!!!!!!!!!!!!realPath" + oldName);
		String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));

		String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload" + format
				+ newName;
		System.out.println(url);
		try {
			file.transferTo(new File(folder, newName));
			map.put("url", url);
			map.put("type", "ojbk");
			return map;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		map.put("type", "上传失败");
		return map;
	}
}
