package in.org.neeraj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.org.neeraj.constant.AppConstant;
import in.org.neeraj.service.IInsuranceService;
import in.org.neeraj.view.InsurancePlanPdfView;
import in.org.neeraj.view.InsurancePlanXlsxView;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {
	@Autowired
	private IInsuranceService iInsuranceService;
	
	@GetMapping(AppConstant.SHOW)
	public String showSearchForm() {
		System.out.println("NEW GIT PUSH");
		return "InsurancePlanSearch";
	}
	
	@GetMapping(AppConstant.SEARCH)
	public String getInsurancePlans(Model model,
									@RequestParam(required = false) String planName,
									@RequestParam(required=false) String planStatus) 
	{
		if(planName !="" && planStatus !="") {
			model.addAttribute("list", iInsuranceService.getAllInsurancePlanByPlanNameAndStatus(planName, planStatus));
			model.addAttribute("planName", planName);
			model.addAttribute("planStatus", planStatus);
		}
		else if(planStatus !="") {
			model.addAttribute("list", iInsuranceService.getAllInsurancePlanByPlanStatus(planStatus));
			model.addAttribute("planStatus", planStatus);
		}
		else if(planName !="") {
			model.addAttribute("list", iInsuranceService.getAllInsurancePlanByPlanName(planName));
			model.addAttribute("planName", planName);
		}
		else {
		model.addAttribute("list", iInsuranceService.getAllInsurancePlan());
		}
		return "InsurancePlanSearch";	
	}
	
	@GetMapping(AppConstant.EXCEL)
	public ModelAndView exportXlsxInsurancePlan(@RequestParam(required = false) String planName,
												@RequestParam(required=false) String planStatus) 
	{
		ModelAndView mav = commonExport(planName, planStatus);
		mav.setView(new InsurancePlanXlsxView());
		return mav;
	} 
	
	@GetMapping(AppConstant.PDF)
	public ModelAndView exportPdfInsurancePlan(@RequestParam(required = false) String planName,
												@RequestParam(required=false) String planStatus) 
	{
		ModelAndView mav = commonExport(planName, planStatus);
		mav.setView(new InsurancePlanPdfView());
		return mav;
	} 
	
	//Common code which is for reusing purpose
	public ModelAndView commonExport(String planName,String planStatus) {
		ModelAndView mav=new ModelAndView();
		if(planName !="" && planStatus !="") {
			mav.addObject("list",iInsuranceService.getAllInsurancePlanByPlanNameAndStatus(planName, planStatus));
		}
		else if(planStatus !="") {
			mav.addObject("list", iInsuranceService.getAllInsurancePlanByPlanStatus(planStatus));
		}
		else if(planName !="") {
			mav.addObject("list", iInsuranceService.getAllInsurancePlanByPlanName(planName));
		}
		else {
			mav.addObject("list", iInsuranceService.getAllInsurancePlan());
		}
		return mav;	
	}
	
	

}
