package com.nick.ClientCaseData.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nick.ClientCaseData.models.Client;
import com.nick.ClientCaseData.models.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{
	
	List<Member> findAll();
	
	List<Member> findByClientNotContains(Client client);
	
}
