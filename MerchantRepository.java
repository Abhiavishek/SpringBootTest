package org.jsp.merchantproduct.repository;

import org.jsp.merchantproduct.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface MerchantRepository extends JpaRepository<Merchant, Integer>{
    @Query("select m from Merchant m where m.phone=?1 and m.password=?2")
	Optional<Merchant>verifyMerchant(long phone, String password);
   
}
