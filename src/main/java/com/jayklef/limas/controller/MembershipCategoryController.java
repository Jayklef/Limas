package com.jayklef.limas.controller;

import com.jayklef.limas.exception.MembershipCategoryNotFoundException;
import com.jayklef.limas.model.MembershipCategory;
import com.jayklef.limas.service.MembershipCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MembershipCategoryController{

    private MembershipCategoryService membershipCategoryService;

    private Logger logger = LoggerFactory.getLogger(MembershipCategory.class);

    @Autowired
    public MembershipCategoryController(MembershipCategoryService membershipCategoryService) {
        this.membershipCategoryService = membershipCategoryService;
    }

    @PostMapping("/membershipcategories")
    public MembershipCategory saveMembershipCategory(MembershipCategory membershipCategory){
        logger.info("Inside SaveMembershipCategory of MembershipController");
        return membershipCategoryService.saveMembershipCategory(membershipCategory);
    }

    @GetMapping("/membershipcategories")
    public List<MembershipCategory> getAllMembershipCategories(){
        logger.info("Inside getAllmembershipCategories of MembershipController");
        return membershipCategoryService.getAllMembershipCategories();
    }

    @GetMapping("membershipcategories/{id}")
    public MembershipCategory getMembershipCategoryById(@PathVariable("mcId") Long mcId) throws MembershipCategoryNotFoundException {
        return membershipCategoryService.getMembershipCategoryById(mcId);
    }
}
