package com.ies.service;

import java.util.List;

import com.ies.bindings.PlanForm;

public interface PlanService {

	public boolean createPlan(PlanForm planForm);

    public List<PlanForm> fetchPlans( );

    public PlanForm getPlanById(Integer planId);

    public String changePlanStatus(Integer planId, String status);

}
