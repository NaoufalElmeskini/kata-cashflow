package com.talan.banking.cashflow;

import org.springframework.data.jpa.repository.JpaRepository;
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
