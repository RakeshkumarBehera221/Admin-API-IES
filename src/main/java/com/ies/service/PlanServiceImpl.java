package com.ies.service;

import java.util.List;

import com.ies.bindings.PlanForm;

public class PlanServiceImpl implements PlanService{

	@Override
    public boolean createPlan(PlanForm planForm) {
        return false;
    }

    @Override
    public List<PlanForm> fetchPlans() {
        return null;
    }

    @Override
    public PlanForm getPlanById(Integer planId) {
        return null;
    }

    @Override
    public String changePlanStatus(Integer planId, String status) {
        return null;
    }
}
