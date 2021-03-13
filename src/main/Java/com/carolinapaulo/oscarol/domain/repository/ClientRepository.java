package com.carolinapaulo.oscarol.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carolinapaulo.oscarol.domain.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	List<Client> findByNomeContaining(String nome);
	Client findByEmail(String email);

}
