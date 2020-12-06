package poly.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.*;

@Controller
@RequestMapping("/image")
public class imageController {

	@Autowired
	SessionFactory factory;

	@RequestMapping("/ImageUser")
	public String index(ModelMap model) {
		// List<Users> sanPhams = null;
		Session session = factory.openSession();
		Users user = null;
		try {

//			Lấy ả thanhông qua đối tượng User

			user = (Users) session.get(Users.class, 3);
			System.out.println(user);
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
	public String index1(ModelMap model) {
		// List<Users> sanPhams = null;
		Session session = factory.openSession();
		Users user = null;
		try {

//			Lấy ả thanhông qua đối tượng User

			user = (Users) session.get(Users.class, 3);
			System.out.println(user);
//			Query q = session.createQuery("from Images ");
			for (int i = 0; i < user.getAlbumses().size(); i++) {
				Albums albums = (Albums) user.getAlbumses().toArray()[i];
				System.out.println("Id_anh: " + albums.getAlbumId() + " User_Id: " + albums.getUsers().getUserId());
			}
		} catch (Exception e) {
			System.out.println(e);

		} finally {
			session.close();
		}

		/* model.addAttribute("sanPhams", sanPhams); */
		model.addAttribute("User",user);
		model.addAttribute("Albums", user.getAlbumses());
		return "AlbumUser";
	}
	
	@RequestMapping("/AlbumImage")
	public String index2(ModelMap model) {
		// List<Users> sanPhams = null;
		Session session = factory.openSession();
		Albums albums = null;
		try {

//			Lấy ả thanhông qua đối tượng User
           
			albums = (Albums) session.get(Albums.class, 3);
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
	
}
