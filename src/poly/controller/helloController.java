package poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Collections;
import model.*;

@Controller
public class helloController {
	
	
	@Autowired
	SessionFactory factory;
	
	
	/*
	 * @RequestMapping("/hello") public String Index() { return "index"; }
	 */
	
	@RequestMapping("/hello")
	public String index(ModelMap model) {
		List<Users> sanPhams = null;
		Session session = factory.openSession();

		try {
			Query q = session.createQuery("from Users");
			sanPhams = q.list();
			System.out.println(sanPhams);
		} catch (Exception e) {
			System.out.println(e);

		} finally {
			session.close();
		}

		/* model.addAttribute("sanPhams", sanPhams); */

		return "index";
	}

	
	
	
}
