package sample.customer.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import sample.customer.biz.domain.Customer;
import sample.customer.biz.service.CustomerService;
import sample.customer.biz.service.DataNotFoundException;

@Controller
@RequestMapping("/customer/{customerId}")
@SessionAttributes(value = "editCustomer")
public class CustomerEditController {

	//未入力の場合に空文字ではなくnull値が設定されるようになる
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/edit", method = GET)
	public String redirectToEntryform(
			@PathVariable int customerId, Model model)
				throws DataNotFoundException {
		Customer customer = customerService.findById(customerId);
		model.addAttribute("editCustomer", customer);
		return "redirect:enter";
	}

	@RequestMapping(path = "/enter", method = GET)
	public String showEntryForm() {
		return "customer/edit/enter";
	}

	@RequestMapping(
			path = "/enter", params = "_event_proceed", method = POST)
	public String verify(
			@Valid @ModelAttribute("editCustomer") Customer customer,
			Errors errors) {
		if(errors.hasErrors()) {
			return "customer/edit/enter";
		}
		return "redirect:review";
	}

	@RequestMapping(path = "/review", method = GET)
	public String showReview() {
		return "customer/edit/review";
	}

	@RequestMapping(
			path="/review", params="_event_confirmed", method=POST)
	public String edit(
			@ModelAttribute("editCustomer") Customer customer)
				throws DataNotFoundException{
		customerService.update(customer);
		return "redirect:edited";
	}

	@RequestMapping(path="/edited", method=GET)
	public String showEdited(
			SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "customer/edit/edited";
	}
}
