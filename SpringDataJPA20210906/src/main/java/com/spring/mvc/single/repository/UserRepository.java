package com.spring.mvc.single.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.single.entity.User;

/*
 * ��k�R�W�W�h
 * 1. �d�ߤ�k�H find | read | get �}�Y
 * 2. �A�α���d�߮ɡA�����ݩ�(���r���j�g)�α�������r(�Ҧp�GAnd�BOr)�s��
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	//�ھ� name �Ө��o User
	List<User> getByName(String name);
	
	//WHERE name LIKE ? AND id >= ?
	List<User> getByNameStartingWithAndIdGreaterThanEqual(String name,Long id);
	
	//WHERE id IN (?,?,?)
	List<User> getByIdIn(List<Long> ids);
	
	//WHERE birth < ?
	List<User> getByBirthLessThan(Date birth);
	
	//WHERE birth >= ? AND birth <= ?
	//WHERE birth between ?(�t) AND ?(�t)
	List<User> getByBirthBetween(Date birthBegin,Date birthEnd);
	
}