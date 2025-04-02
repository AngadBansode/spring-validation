package com.validation.controller;

import com.validation.dto.IndustryProfile;
import com.validation.dto.MiIndustries;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/profile")
public class ProfileIndustryController {

    @PostMapping()
    public void getAllProfile(@RequestBody IndustryProfile industryProfile){
        System.out.println("Received profile");
        System.out.println(industryProfile);

        var miIndustries = industryProfile.getMi_industries();

        var gicsIndustriesArrayList = industryProfile.getGics_industries();

        System.out.println("MI :" + miIndustries);

        System.out.println("------------------------------------------------");

        System.out.println("Gics:" + gicsIndustriesArrayList);


    }

}
