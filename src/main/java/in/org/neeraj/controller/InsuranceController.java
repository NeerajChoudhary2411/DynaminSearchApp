package in.org.neeraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.org.neeraj.constant.AppConstant;
import in.org.neeraj.criteria.InsuranceSearchCriteria;
import in.org.neeraj.model.Insurance;
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
		return "InsurancePlanSearch";
	}

	@PostMapping(AppConstant.SEARCH)
	public String getInsurancePlan(Model model, @ModelAttribute InsuranceSearchCriteria creteria) {
		List<Insurance> list = iInsuranceService.getInsurancePlans(creteria);
		model.addAttribute("list", list);
		model.addAttribute("planName", creteria.getPlanName());
		model.addAttribute("planStatus", creteria.getPlanStatus());
		return "InsurancePlanSearch";
	}

	@GetMapping(AppConstant.EXCEL)
	public ModelAndView exportXlsxInsurancePlan(@RequestParam(required = false) String planName,
			@RequestParam(required = false) String planStatus) {

		ModelAndView mav = commonExport(planName, planStatus);
		mav.setView(new InsurancePlanXlsxView());
		return mav;
	}

	@GetMapping(AppConstant.PDF)
	public ModelAndView exportPdfInsurancePlan(@RequestParam(required = false) String planName,
			@RequestParam(required = false) String planStatus) {
		ModelAndView mav = commonExport(planName, planStatus);
		mav.setView(new InsurancePlanPdfView());
		return mav;
	}

	private ModelAndView commonExport(String planName, String planStatus) {
		ModelAndView mav = new ModelAndView();
		InsuranceSearchCriteria creteria = new InsuranceSearchCriteria();
		creteria.setPlanName(planName);
		creteria.setPlanStatus(planStatus);
		return mav.addObject("list", iInsuranceService.getInsurancePlans(creteria));
	}

}
