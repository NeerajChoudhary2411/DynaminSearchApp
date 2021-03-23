package in.org.neeraj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.org.neeraj.model.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
	
	@Query("SELECT ip FROM Insurance ip WHERE ip.planName=:planName")
	List<Insurance> getInsurancePlanByPlanName(String planName);
	
	@Query("SELECT ip FROM Insurance ip WHERE ip.planStatus=:planStatus")
	List<Insurance> getInsurancePlanByPlanStatus(String planStatus);
	
	@Query("SELECT ip FROM Insurance ip WHERE ip.planName=:planName AND ip.planStatus=:planStatus")
	List<Insurance> getInsurancePlanByPlanNameAndStatus(String planName,String planStatus);
	
	

}
