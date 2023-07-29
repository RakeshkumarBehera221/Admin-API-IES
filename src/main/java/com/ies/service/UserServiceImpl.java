package com.ies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ies.bindings.DashboardCard;
import com.ies.bindings.LoginForm;
import com.ies.entities.EligEntity;
import com.ies.entities.UserEntity;
import com.ies.repositories.EligRepo;
import com.ies.repositories.PlanRepo;
import com.ies.repositories.UserRepo;
import com.ies.utils.EmailUtils;

public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepo userRepo;

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private EligRepo eligRepo;

    @Autowired
    private EmailUtils emailUtils;

    @Override
    public String login(LoginForm loginForm) {

        UserEntity entity = userRepo.findByEmailAndPwd(loginForm.getEmail(), loginForm.getPwd());

        if(entity == null){
            return "Invalid Credentials";
        }

        if("Y".equals(entity.getActiveSw()) && "UNLOCKED".equals(entity.getAccStatus())){
            return "success";
        }else {
            return "Account Locked/In-Active";
        }
    }

    @Override
    public boolean recoverPwd(String email) {
        UserEntity userEntity = userRepo.findByEmail(email);
        if(null == userEntity){
            return false;
        }else{
           String subject = "";
           String body = "";
          return emailUtils.sendEmail(subject, body, email);
        }
    }

    @Override
    public DashboardCard fetchDashboardInfo() {
        long plansCount = planRepo.count();

        List<EligEntity> eligList = eligRepo.findAll();

        Long approvedCnt =
                eligList.stream().filter(ed-> ed.getPlanStatus().equals("AP")).count();

        Long deniedCnt =
                eligList.stream().filter(ed -> ed.getPlanStatus().equals("DN")).count();

        Double total = eligList.stream().mapToDouble(ed -> ed.getBenefitAmt()).sum();

        DashboardCard card = new DashboardCard();

        card.setPlansCnt(plansCount);
        card.setApprovedCnt(approvedCnt);
        card.setDeniedCnt(deniedCnt);
        card.setBeniftAmtGiven(total);

        return card;
    }

}
