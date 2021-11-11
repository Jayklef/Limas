package com.jayklef.limas.repository;

import com.jayklef.limas.model.MembershipCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipCategoryRepository extends JpaRepository<MembershipCategory, Long> {
}
