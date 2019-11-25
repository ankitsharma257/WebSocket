package netgloo.controllers;

import netgloo.Notification;
import netgloo.model.Emp;
import netgloo.reposotory.EmployeeService;
import netgloo.reposotory.Employeeserviceimpt;
import netgloo.reposotory.UserDal;
import netgloo.services.NotificationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class MainController {

  @Autowired
  private NotificationService notificationService;
  
  @Autowired
  EmployeeService em;
  
  

  /**
   * GET  /  -> show the index page.
   */
  @RequestMapping("/")
  public String index() {
	  System.out.println("index");
    return "index";
  }

  /**
   * GET  /notifications  -> show the notifications page.
   */
  @RequestMapping("/notifications")
  public String notifications() {
    return "notifications";
  }

  /**
   * POST  /some-action  -> do an action.
   * 
   * After the action is performed will be notified UserA.
   */
  @RequestMapping(value = "/some-action", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<?> someAction() {

	 /* ArrayList<String> arrlist2 = new ArrayList<String>(2);
	  arrlist2.add("usera");
	  arrlist2.add("userb");
	  System.out.println(arrlist2);*/
    // Do an action here
    // ...
    // Send the notification to "UserA" (by username)
	 /* for (int i=0; i<arrlist2.size(); i++) 
	  {	  
		  String user=arrlist2.get(i);*/
    notificationService.notify(
      new Notification("hello"), // notification object
      "usera"                   // username
    );
	 /* }*/
    // Return an http 200 status code
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping(value= "/create")
  @ResponseBody
  public List<Emp> create(@RequestBody List<Emp> emp) {
     // logger.debug("Saving employees.");
      List<Emp> employees = em.createEmployee(emp);
	return employees;
     // return "Employee records created.";
  }
  
  @GetMapping(value="/getall")
  @ResponseBody
  public Collection<Emp> getAll()
  {
	return em.FindbyNameAndlocations("Bangalore");
  	
  }
  
} // class MainController