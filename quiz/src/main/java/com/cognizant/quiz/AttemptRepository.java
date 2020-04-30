package com.cognizant.quiz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.quiz.model.Attempt;

public interface AttemptRepository extends JpaRepository<Attempt,Integer> {
	@Query(value="Select sum(o.op_score) from Question q, Options o ,attempt_option ao where q.qt_id = o.op_qt_id and o.op_id = ao.ao_op_id and ao.ao_selected=1 and o.op_score<>0", nativeQuery = true)
	double getScore();
	
	@Query(value ="Select qt_id,qt_text,op_text,op_score,ao_selected from Question q, Options o ,attempt_option ao where q.qt_id = o.op_qt_id and o.op_id = ao.ao_op_id",nativeQuery=true)
	List<Object[]> getDetails();
}
