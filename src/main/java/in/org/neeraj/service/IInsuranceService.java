package in.org.neeraj.service;

import java.util.List;

import in.org.neeraj.model.Insurance;

public interface IInsuranceService {
	
	List<Insurance> getAllInsurancePlan();
	
	List<Insurance> getAllInsurancePlanByPlanName(String planName);

	List<Insurance> getAllInsurancePlanByPlanStatus(String planStatus);
	
	List<Insurance> getAllInsurancePlanByPlanNameAndStatus(String planName,String planStatus);
	
}
