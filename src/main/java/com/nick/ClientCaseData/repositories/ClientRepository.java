package com.nick.ClientCaseData.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nick.ClientCaseData.models.Client;
import com.nick.ClientCaseData.models.Member;

@Repository 
public interface ClientRepository extends CrudRepository<Client, Long> {

	List<Client> findAll();
	
//	List<Client> findAllByOrderByFirstNameAsc();
	
	List<Client> findByNameContaining(String name);
	
	List<Client>findByCaseNumberContaining(String caseNumber);
	
	List<Client> findByMembersNotContains(Member member);
}
