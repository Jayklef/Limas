package com.jayklef.limas.service;

import com.jayklef.limas.exception.MembershipCategoryNotFoundException;
import com.jayklef.limas.model.MembershipCategory;

import java.util.List;

public interface MembershipCategoryService {
    MembershipCategory saveMembershipCategory(MembershipCategory membershipCategory);

    List<MembershipCategory> getAllMembershipCategories();

    MembershipCategory getMembershipCategoryById(Long id) throws MembershipCategoryNotFoundException;
}
