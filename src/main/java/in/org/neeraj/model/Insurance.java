package in.org.neeraj.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="INSURANCE_PLAN_TAB")
public class Insurance {
	
	@Id
	@GeneratedValue(generator = "seq_gen")
	@Column(name="PLAN_ID")
	@SequenceGenerator(name="seq_gen",sequenceName = "ins_plan_seq",allocationSize = 1)
	public Integer planId;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_STATUS")
	private String planStatus;
	
	@Column(name="PLAN_START_DATE")
	private LocalDate startDate;
	
	@Column(name="PLAN_END_DATE")
	private LocalDate endDate;
	
	@Column(name="PLAN_HOLDER_NAME")
	private String holderName;
	
	@Column(name="PLAN_HOLDER_SSN",length = 11)
	private Integer holderSSN;

}
