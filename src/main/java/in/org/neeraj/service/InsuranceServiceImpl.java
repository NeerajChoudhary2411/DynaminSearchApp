package in.org.neeraj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.org.neeraj.model.Insurance;
import in.org.neeraj.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements IInsuranceService {
	@Autowired
	private InsuranceRepository insuranceRepository;

	@Override
	public List<Insurance> getAllInsurancePlan() {
		System.out.println("SERS");
		return insuranceRepository.findAll();
	}

	@Override
	public List<Insurance> getAllInsurancePlanByPlanName(String planName) {
		return insuranceRepository.getInsurancePlanByPlanName(planName);
	}

	@Override
	public List<Insurance> getAllInsurancePlanByPlanStatus(String planStatus) {
		return insuranceRepository.getInsurancePlanByPlanStatus(planStatus);
	}

	@Override
	public List<Insurance> getAllInsurancePlanByPlanNameAndStatus(String planName, String planStatus) {
		return insuranceRepository.getInsurancePlanByPlanNameAndStatus(planName, planStatus);
	}

}
