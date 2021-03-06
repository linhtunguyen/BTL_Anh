package poly.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.*;

@Controller
@RequestMapping("/image")
public class imageController {

	@Autowired
	SessionFactory factory;
	

	@RequestMapping("/ImageUser")
	public String index(ModelMap model,HttpSession sess) {
	
           Users taiKhoan = (Users)sess.getAttribute("TaiKhoan");
		
		if(taiKhoan == null )
		{
			
			return "redirect:User/login";
		}
		Session session = factory.openSession();
		Users user = null;
		try {

//			Lấy ả thanhông qua đối tượng User

			user = (Users) session.get(Users.class, taiKhoan.getUserId());
			System.out.println(taiKhoan.getUserId());
//			Query q = session.createQuery("from Images ");
			for (int i = 0; i < user.getImageses().size(); i++) {
				Images images = (Images) user.getImageses().toArray()[i];
				System.out.println("Id_anh: " + images.getImageId() + " User_Id: " + images.getUsers().getUserId());
			}
		} catch (Exception e) {
			System.out.println(e);

		} finally {
			session.close();
		}

		/* model.addAttribute("sanPhams", sanPhams); */
		model.addAttribute("User",user);
		model.addAttribute("Images", user.getImageses());
		return "ImageUser";
	}
	
	
	@RequestMapping("/AlbumUser")
	public String index1(ModelMap model,HttpSession sess) {
		// List<Users> sanPhams = null;
	    Users taiKhoan = (Users)sess.getAttribute("TaiKhoan");
		
			if(taiKhoan == null )
			{
				
				return "redirect:User/login";
			}
		Session session = factory.openSession();
		Users user = null;
		Images imag= null;
		Albums album =null;
		try {
			

//			Lấy ả thanhông qua đối tượng User
			user = (Users) session.get(Users.class, taiKhoan.getUserId());
			album =(Albums) session.get(Albums.class, taiKhoan.getUserId());
			
			imag= (Images) session.get(Images.class, album.getAlbumId());
			
			System.out.println("daylaimage :" +imag);
//			Query q = session.createQuery("from Images ");
			for (int i = 0; i < user.getAlbumses().size(); i++) {
				Albums albums = (Albums) user.getAlbumses().toArray()[i];
				
				//System.out.println("Id_anh: " + albums.getAlbumId() + " User_Id: " + albums.getUsers().getUserId());
				
			}
			System.out.println("Id_anh: " +imag );
		} catch (Exception e) {
			System.out.println(e);

		} finally {
			session.close();
		}

		/* model.addAttribute("sanPhams", sanPhams); */
		model.addAttribute("User",user);
		model.addAttribute("Albums", user.getAlbumses());
		model.addAttribute("Image", imag);
		return "AlbumUser";
	}
	
	@RequestMapping("/AlbumImage")
	public String index2(ModelMap model,HttpSession sess) {
		// List<Users> sanPhams = null;
		  Users taiKhoan = (Users)sess.getAttribute("TaiKhoan");
			
			if(taiKhoan == null )
			{
				
				return "redirect:User/login";
			}
		Session session = factory.openSession();
		Albums albums = null;
		try {

//			Lấy ảnh thanhông qua đối tượng User
           
			albums = (Albums) session.get(Albums.class, taiKhoan.getUserId());
			System.out.println(albums);
//			Query q = session.createQuery("from Images ");
			for (int i = 0; i < albums.getImageses().size(); i++) {
				Images images = (Images) albums.getImageses().toArray()[i];
				System.out.println("Id_anh: " + images.getImageId()+ " User_Id: " + albums.getUsers().getUserId());
			}
		} catch (Exception e) {
			System.out.println(e);

		} finally {
			session.close();
		}

		/* model.addAttribute("sanPhams", sanPhams); */
		model.addAttribute("Album",albums);
		model.addAttribute("Images",albums.getImageses() );
		return "AlbumImage";
	}
	
	@RequestMapping(value="/addImage", method= RequestMethod.POST)
	public String index3( @RequestParam("ImageID") int ImageID, @RequestParam("UserID") String userEmail) {
		Session session = factory.openSession();
		Images image = null;
		Shared share=null;
		Users user=null;

		
		Transaction tran = session.beginTransaction();
		try {
			 List<Users> listTK = null;
			Query query = session.createQuery("from Users where userEmail = :userEmail");
			query.setParameter("userEmail", userEmail);
			listTK = query.list();
			image = (Images) session.get(Images.class,ImageID );
			user =(Users) session.get(Users.class,listTK.get(0).getUserId() );
			share= new Shared();
			share.setImages(image);
			share.setUsers(user);
			
			
			session.save(share);
			
			tran.commit();
			
			return "redirect:/image/ImageUser.html";
		} catch (Exception e) {
			
		} finally {
			session.close();
			
		}
		
		return "redirect:/ImageUser.html";
}
	
	
	@RequestMapping("/AlbumShare")
	public String index5(ModelMap model,HttpSession sess) {
		  Users taiKhoan = (Users)sess.getAttribute("TaiKhoan");
		  Users user= null;
		  Albums album=null;
		  Users userShare=null;
			if(taiKhoan == null )
			{
				
				return "redirect:User/login";
			}
		Session session = factory.openSession();
		Albums albums = null;
		
		try {

//			Lấy ả thanhông qua đối tượng User
			List<Users> listTK = null;
			user = (Users) session.get(Users.class,taiKhoan.getUserId());
			System.out.println("shredai" + user.getShareds());
//			Query query = session.createQuery("from Shared where userID = :userID");
//			query.setParameter("userID", user.getUserId());
//			listTK = query.list();
//			userShare =(Users) session.get(Users.class,listTK.getUserId());
//			
//
//			
//			userShare= user.getShareds();
//			System.out.println("shredai" +userShare);
//			for (int i = 0; i < user.getAlbumses().size(); i++) {
//				 albums = (Albums) user.getAlbumses().toArray()[i];
//				
//			}
		} catch (Exception e) {
			System.out.println(e);

		} finally {
			session.close();
		}

		/* model.addAttribute("sanPhams", sanPhams); */
		model.addAttribute("User",user);
		model.addAttribute("AlbumShare", user.getShareds());
		return "AlbumShare";
	}
	
	
	
}
