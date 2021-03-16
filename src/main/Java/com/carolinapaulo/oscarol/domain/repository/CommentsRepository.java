package com.carolinapaulo.oscarol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carolinapaulo.oscarol.domain.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>{
	

}
