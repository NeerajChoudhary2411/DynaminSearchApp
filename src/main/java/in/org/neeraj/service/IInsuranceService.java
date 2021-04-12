package in.org.neeraj.service;

import java.util.List;

import in.org.neeraj.criteria.InsuranceSearchCriteria;
import in.org.neeraj.model.Insurance;

public interface IInsuranceService {

	List<Insurance> getInsurancePlans(InsuranceSearchCriteria creteria);
	
}
