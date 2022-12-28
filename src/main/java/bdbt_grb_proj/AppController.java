package bdbt_grb_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private SalesOfferDAO salesOfferDao;
	@Autowired
	private HorseDAO horseDao;
	@Autowired
	private EmployeeDAO employeeDao;
	
	
	@RequestMapping("/")
	public String showLoginForm() {
		return "login";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public String login(String username, String password) {
		List<Employee> listEmployee = employeeDao.list();
		for (Employee employee : listEmployee) {
			if (employee.getFirstName().equals(username) && employee.getLastName().equals(password))
				if (employee.getPositionId()==2) //2 is for stud farm's administrator
					return "redirect:/home";
				else { // other employees
					int id=employee.getId();					
					return "redirect:/userhome/"+id;
				}
		}
		return "redirect:/"; // person not allowed to login
		
		/*if (username.equals("admin") && password.equals("admin"))
			return "redirect:/home";
		else
			return "redirect:/";*/
	}
	
	@RequestMapping("/userhome/{id}") // for userview
	public ModelAndView viewUserHomePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("user_index");
		Employee employee = employeeDao.get(id);
		mav.addObject("employee",employee);
		return mav;
	}
	
	@RequestMapping("/home")
	public String viewAdminHomePage() {
		return "admin_index";
	}
	
	
	/* Sales Offers */
	@RequestMapping("/sales_offers")
	public String viewSalesOffers(Model model) {
		List<SalesOffer> listSalesOffer = salesOfferDao.list();
		model.addAttribute("listSalesOffer", listSalesOffer);
		return "sales_offers";
	}
	
	@RequestMapping("/new")
	public String showNewForm(Model model) {
		SalesOffer salesOffer = new SalesOffer();
		model.addAttribute("salesOffer", salesOffer);
		return "sales_offer_new_form";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("salesOffer") SalesOffer salesOffer) {
		salesOfferDao.save(salesOffer);
		return "redirect:/sales_offers";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("sales_offer_edit_form");
		SalesOffer salesOffer = salesOfferDao.get(id);
		mav.addObject("salesOffer",salesOffer);
		return mav;	
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("salesOffer") SalesOffer salesOffer) {
		salesOfferDao.update(salesOffer);
		return "redirect:/sales_offers";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") int id) {
		salesOfferDao.delete(id);
		return "redirect:/sales_offers";
	}
	
	
	/* Employees */
	@RequestMapping("/employees")
	public String viewEmployees(Model model) {
		List<Employee> listEmployee = employeeDao.list();
		model.addAttribute("listEmployee", listEmployee);
		return "employees";
	}
	
	@RequestMapping("/userhome/{id}/employee_edit_form_userview/{id}") // for userview
	public ModelAndView showEditEmployeeUserviewForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("employee_edit_form_userview");
		Employee employee = employeeDao.get(id);
		mav.addObject("employee",employee);
		return mav;	
	}
	
	@RequestMapping(value="/userhome/update_employee_userview", method=RequestMethod.POST) // for userview
	public String updateEmployeeUserview(@ModelAttribute("employee") Employee employee) {
		employeeDao.update(employee);
		return "redirect:/userhome/"+employee.getId();
	}

	
	@RequestMapping("/new_employee")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee_new_form";
	}
	
	@RequestMapping(value="/save_employee", method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeDao.save(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping("/edit_employee/{id}")
	public ModelAndView showEditEmployeeForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("employee_edit_form");
		Employee employee = employeeDao.get(id);
		mav.addObject("employee",employee);
		return mav;	
	}
	
	@RequestMapping(value="/update_employee", method=RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee) {
		employeeDao.update(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping("/delete_employee/{id}")
	public String deleteEmployee(@PathVariable(name="id") int id) {
		employeeDao.delete(id);
		return "redirect:/employees";
	}
	
	
	/* Horses */
	@RequestMapping("/horses")
	public String viewHorses(Model model) {
		List<Horse> listHorse = horseDao.list();
		model.addAttribute("listHorse", listHorse);
		return "horses";
	}
	
	@RequestMapping("/userhome/{id}/horses_userview") // for userview
	public ModelAndView viewHorsesUserview(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("horses_userview");
		Employee employee = employeeDao.get(id);
		mav.addObject("employee",employee);
		List<Horse> listHorse = horseDao.list();
		mav.addObject("listHorse", listHorse);
		return mav;	
	}

	
	@RequestMapping("/new_horse")
	public String showNewHorseForm(Model model) {
		Horse horse = new Horse();
		model.addAttribute("horse", horse);
		return "horse_new_form";
	}
	
	@RequestMapping(value="/save_horse", method=RequestMethod.POST)
	public String saveHorse(@ModelAttribute("horse") Horse horse) {
		horseDao.save(horse);
		return "redirect:/horses";
	}
	
	@RequestMapping("/edit_horse/{id}")
	public ModelAndView showEditHorseForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("horse_edit_form");
		Horse horse = horseDao.get(id);
		mav.addObject("horse",horse);
		return mav;	
	}
	
	@RequestMapping(value="/update_horse", method=RequestMethod.POST)
	public String updateHorse(@ModelAttribute("horse") Horse horse) {
		horseDao.update(horse);
		return "redirect:/horses";
	}
	
	@RequestMapping("/delete_horse/{id}")
	public String deleteHorse(@PathVariable(name="id") int id) {
		horseDao.delete(id);
		return "redirect:/horses";
	}
	
	
}
