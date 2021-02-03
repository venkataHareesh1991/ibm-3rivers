package com.example.threerivers.repositories;

import com.example.threerivers.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface AccountReposiotry extends  MongoRepository<Account, String>{

	Optional<Account> findAccountByacNo(String acNo);
	
}
