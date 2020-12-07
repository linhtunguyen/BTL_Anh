package poly.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.*;

@Controller
@RequestMapping(value="/image")
public class uploadController {
	private static String UPLOADED_FOLDER = "F:/Kì 7/T6_LapTrinhNangCao/BTL_Anh/WebContent/Images/";
	
	@Autowired
	SessionFactory factory;
	
	 @RequestMapping(value = "/uploadImage", method=RequestMethod.POST)
	  public String uploadImage(HttpSession sess, @RequestParam("ImageFiles")  MultipartFile file){
		 Users tk = (Users)sess.getAttribute("TaiKhoan");
		 if(tk == null) {
				System.out.println("login");
			 return "redirect:User/login";
		 }
		 
		try {
			if(file == null) {
				return "redirect:/image/ImageUser.html";
			}
			byte[] bytes = file.getBytes();
	       Path path = Paths.get(UPLOADED_FOLDER+tk.getUserId()+"/" + file.getOriginalFilename());
	        Files.write(path, bytes);
			System.out.println(path);
	        
	        Session session = factory.openSession();
	        Images img = new Images();
	        
			img.setImageUrl(file.getOriginalFilename());
			img.setUsers(tk);
			session.save(img);
		 }
		 catch (IOException e) {
	            e.printStackTrace();
	        }

		System.out.println("ex");
		return "redirect:/image/ImageUser.html";
	  }
}
