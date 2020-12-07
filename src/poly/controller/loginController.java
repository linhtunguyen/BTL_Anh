package poly.controller;

import java.net.http.HttpRequest;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Users;

@Controller
@RequestMapping(value="/User")
public class loginController {
	
	@Autowired
	SessionFactory factory;
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String login(HttpSession sess) {
		 Users taiKhoan = (Users)sess.getAttribute("TaiKhoan");
			
			if(taiKhoan != null )
			{
				return "redirect:/image/ImageUser.html";
			}
			return "login";
	  }
	 
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public String login(ModelMap model, @RequestParam("Username") String name, @RequestParam("Passwords") String pass, HttpServletRequest request, HttpSession sess) {
		 Boolean isInvalid = false;
		 List<Users> listTK = null;
		 Users tk  = null;
			Session session = factory.openSession();

			try {
				Query query = session.createQuery("from Users where userName = :name and passwords = :pass");
				query.setParameter("name", name);
				query.setParameter("pass", pass);
				System.out.println(query);
				listTK = query.list();
			} catch (Exception e) {
				System.out.println(e);

			} finally {
				session.close();
			}
			if(listTK != null) {
				isInvalid = true;
				
			}
		 System.out.println(isInvalid);
			if(isInvalid) {
				HttpSession htppsess = request.getSession();
				htppsess.setAttribute("TaiKhoan", listTK.get(0));
				return "redirect:/image/ImageUser.html";
			}
			model.addAttribute("messenge", "Invalid info !");
			return "login";
	  }

	  
	  @RequestMapping(value = "/logout")
		public String DangXuuat(HttpSession sess) {
			
			sess.setAttribute("TaiKhoan", null);
			return "login";
		}
	  
	  @RequestMapping(value = "/Register", method = RequestMethod.GET)
	  public String Register(HttpSession sess) {
			return "singup";
	  }
	  
	  @RequestMapping(value = "/Register", method = RequestMethod.POST)
		public String Register(ModelMap model,@RequestParam("UserEmail") String mail, @RequestParam("UserName") String name, @RequestParam("Passwords") String pass, HttpServletRequest request, HttpSession sess) {
		  Boolean isInvalid = false;
			 List<Users> listTK = null;
			 Users tk  = null;
				Session session = factory.openSession();

				try {
					Query query = session.createQuery("from Users where userEmail = :mail");
					query.setParameter("mail", mail);
					listTK = query.list();
				} catch (Exception e) {
					System.out.println(e);

				} finally {
					session.close();
				}
				if(listTK != null) {
					isInvalid = true;
					
				}
				session = factory.openSession();
				Transaction tran = session.beginTransaction();

				if (listTK.size() != 0) {
					 return "singup";

				}
				else {
					Users taiKhoan = new Users();
					
					taiKhoan.setUserName(name);
					taiKhoan.setUserEmail(mail);
					taiKhoan.setPasswords(pass);
				
					
					session.save(taiKhoan);
					
					tran.commit();
					System.out.println("login");
					
					return "redirect:/User/login.html";
				}
	  }
}
