package in.org.neeraj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.org.neeraj.criteria.InsuranceSearchCriteria;
import in.org.neeraj.model.Insurance;
import in.org.neeraj.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements IInsuranceService {
	@Autowired
	private InsuranceRepository insuranceRepository;

	@Override
	public List<Insurance> getInsurancePlans(InsuranceSearchCriteria creteria) {

//		StringBuilder builder = new StringBuilder("SELECT * FROM INSURANCE_PLAN_TAB WHERE 1=1");
//
//		if (creteria.getPlanName() != null && creteria.getPlanName() != "") {
//			builder.append("AND PLAN_NAME=:" + creteria.getPlanName());
//		}
//		if (creteria.getPlanStatus() != null && creteria.getPlanStatus() != "") {
//			builder.append("AND PLAN_STATUS=:" + creteria.getPlanStatus());
//		}
		
		Insurance insurance=new Insurance();
		
		if (creteria.getPlanName() != null && creteria.getPlanName() != "") {
			insurance.setPlanName(creteria.getPlanName());
		}
		if (creteria.getPlanStatus() != null && creteria.getPlanStatus() != "") {
			insurance.setPlanStatus(creteria.getPlanStatus());
		}
		
		Example<Insurance> example = Example.of(insurance);
		List<Insurance> list = insuranceRepository.findAll(example);
		return list;
	}

}
