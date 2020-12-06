package poly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import model.Users;

@Controller
@RequestMapping(value="/taikhoan")
public class loginController {
	
	@Autowired
	SessionFactory factory;
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String login(ModelMap mm) {
	    mm.put("tk", new Users());
	    return "login";
	 
	    
	  }
	 
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public String login(@ModelAttribute(value="tk") Users tk, ModelMap mm, HttpSession session) {
			System.out.println("logi");
			System.out.println(tk.getUserName());
		 Session session1 = factory.openSession();
		 Query q = session1.createQuery("from Users where Users.userName= :tk.username and Users.passwords = :tk.password" );
		
	   if( q  != null) {
		   session.setAttribute("username", tk.getUserName());
		   return "index";
	   }
	    return "login";
	 
	    
	  }
}
