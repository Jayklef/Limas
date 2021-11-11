package com.jayklef.limas.service;

import com.jayklef.limas.exception.MembershipCategoryNotFoundException;
import com.jayklef.limas.model.MembershipCategory;
import com.jayklef.limas.repository.MembershipCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipCategoryServiceImpl implements MembershipCategoryService{

    private MembershipCategoryRepository membershipCategoryRepository;

    @Autowired
    public MembershipCategoryServiceImpl(MembershipCategoryRepository membershipCategoryRepository) {
        this.membershipCategoryRepository = membershipCategoryRepository;
    }

    @Override
    public MembershipCategory saveMembershipCategory(MembershipCategory membershipCategory) {
        return membershipCategoryRepository.save(membershipCategory);
    }

    @Override
    public List<MembershipCategory> getAllMembershipCategories() {
        return membershipCategoryRepository.findAll();
    }

    @Override
    public MembershipCategory getMembershipCategoryById(Long id) throws MembershipCategoryNotFoundException {
        Optional<MembershipCategory> membershipCategory = membershipCategoryRepository.findById(id);

        if (!membershipCategory.isPresent()){
            throw new MembershipCategoryNotFoundException();
        }
        return membershipCategory.get();
    }
}
