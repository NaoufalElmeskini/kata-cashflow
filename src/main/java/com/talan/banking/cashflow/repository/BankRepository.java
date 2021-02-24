package com.talan.banking.cashflow.repository;

import com.talan.banking.cashflow.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
//public interface BankRepository extends JpaRepository<Account, Integer>{
public interface BankRepository extends CrudRepository<Account, Integer>{
	public Account findById(int id);
	//public Account findBy
	public Account save(Account account);
	public Account saveAndFlush(Account account);
}
