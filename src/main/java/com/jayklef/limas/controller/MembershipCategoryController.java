package com.jayklef.limas.controller;

import com.jayklef.limas.exception.MembershipCategoryNotFoundException;
import com.jayklef.limas.model.MembershipCategory;
import com.jayklef.limas.service.MembershipCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MembershipCategoryController{

    private MembershipCategoryService membershipCategoryService;

    @Autowired
    public MembershipCategoryController(MembershipCategoryService membershipCategoryService) {
        this.membershipCategoryService = membershipCategoryService;
    }

    @PostMapping("/membershipcategories")
    public MembershipCategory saveMembershipCategory(MembershipCategory membershipCategory){
        return membershipCategoryService.saveMembershipCategory(membershipCategory);
    }

    @GetMapping("/membershipcategories")
    public List<MembershipCategory> getAllMembershipCategories(){
        return membershipCategoryService.getAllMembershipCategories();
    }

    @GetMapping("membershipcategories/{id}")
    public MembershipCategory getMembershipCategoryById(@PathVariable("id") Long id) throws MembershipCategoryNotFoundException {
        return membershipCategoryService.getMembershipCategoryById(id);
    }
}
