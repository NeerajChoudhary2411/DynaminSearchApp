package in.org.neeraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.org.neeraj.model.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

}
