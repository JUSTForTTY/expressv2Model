package com.hundsun.jresplus.quickstart.action.center;
import org.springframework.web.multipart.MultipartFile;  

import javax.servlet.http.HttpServletRequest;  
import java.io.File;  
import java.io.IOException;  
import java.util.Date;  

/**  
 * Created by shhao.  
 * Date: 14-9-1  
 * Time:下午4:12  
 */  
public class FileUpload {  

	// public static final String FILE_PATH = "/upload/goods";  

	//文件上传  
	public static String uploadFile(MultipartFile file, HttpServletRequest request,String path) throws IOException {  
		String fileName = file.getOriginalFilename(); 
		if(file.isEmpty()){
			return null; 
		}
		else{
			File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));  
			if (!tempFile.getParentFile().exists()) {  
				tempFile.getParentFile().mkdir();  
			}   
			if (!tempFile.exists()) {  
				tempFile.createNewFile();  
			}  
			file.transferTo(tempFile);  

			return   "/upload/"+tempFile.getName();  

		} 
	}  


}  