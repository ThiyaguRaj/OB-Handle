package com.onebill.productbilling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productbilling.dao.PlanDao;
import com.onebill.productbilling.dto.PlanChargeDto;
import com.onebill.productbilling.dto.PlanChargeRespDto;
import com.onebill.productbilling.dto.PlanDetailDto;
import com.onebill.productbilling.dto.PlanDetailRespDto;
import com.onebill.productbilling.dto.PlanDto;
import com.onebill.productbilling.dto.PlanOverdueDto;
import com.onebill.productbilling.dto.PlanOverdueRespDto;
import com.onebill.productbilling.dto.PlanRespDto;
import com.onebill.productbilling.exception.BillingException;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanDao dao;

	@Override
	public PlanRespDto addPlan(PlanDto plan) {
		PlanRespDto plan1 = null;
//		try {
//
//			if (plan.getPlanAmount() != 0.0) {
//				if (plan.getPlanFrequency() != 0) {
//					if (plan.getType() != null) {
//						try {
//							if (plan.getProduct() != null) {
//								try {
//									plan1 = dao.addPlan(plan);
//									if (plan1 != null) {
//										return plan1;
//									} else {
//										throw new BillingException("Failed to add plan");
//									}
//								} catch (Exception e) {
//									throw new BillingException(
//											"Plan type is already present for the product with same amount and same duration");
//								}
//							} else {
//								throw new BillingException(
//										"Task Failed. Plan added without product");
//							}
//						} catch (Exception e) {
//							throw new BillingException(
//									"Task Failed. Plan added without product");
//						}
//					} else {
//						throw new BillingException(
//								"Task Failed. Plan Type should not be null");
//					}
//				} else {
//					throw new BillingException(
//							"Task Failed. Plan Frequency should not be null");
//				}
//			} else {
//				throw new BillingException(
//						"Task Failed. Plan Amount should not be null");
//			}
//
//		} catch (Exception e) {
//			throw new BillingException(e.getMessage());
//		}
		try {
			if(plan.getPlanAmount() != 0.0 && plan.getPlanFrequency() != 0 && plan.getType() != null) {
				try {
					if(plan.getProduct() != null) {
						
					}else {
						throw new BillingException(
								"Task Failed. Plan added without product");
					}
				}catch (Exception e) {
					throw new BillingException(
							"Task Failed. Plan added without product");
				}
			}else {
				
			}
		}catch (Exception e) {
			
		}
	}

	@Override
	public List<PlanRespDto> getPlan(int productId) {
		List<PlanRespDto> plan1 = null;
		try {
			plan1 = dao.getPlan(productId);
			if (!plan1.isEmpty()) {
				return plan1;
			} else {
				throw new BillingException("No plan available for this product");
			}
		} catch (Exception e) {
			throw new BillingException("No plan available for this product");
		}
	}

	@Override
	public List<PlanRespDto> getAllPlans() {
		List<PlanRespDto> plan = null;
		try {
			plan = dao.getAllPlans();
			if (!plan.isEmpty()) {
				return plan;
			} else {
				throw new BillingException("No plan Available");
			}
		} catch (Exception e) {
			throw new BillingException("No plan Available");
		}
	}

	@Override
	public PlanRespDto updatePlan(PlanDto plan) {
		PlanRespDto plan1 = null;
		try {
			if (plan.getPlanAmount() != 0.0 && plan.getPlanFrequency() != 0) {
				plan1 = dao.updatePlan(plan);
				if (plan1 != null) {
					return plan1;
				} else {
					throw new BillingException("Failed to Update plan");
				}
			} else {
				throw new BillingException("Failed to Update plan with null values");
			}
		} catch (Exception e) {
			if (plan.getPlanAmount() == 0.0 || plan.getPlanFrequency() == 0) {
				throw new BillingException("Failed to Update plan with Amount (" + plan.getPlanAmount()
						+ ") and Frequency (" + plan.getPlanFrequency() + ")");
			} else {
				throw new BillingException("Failed to Update plan of id (" + plan.getPlanId() + ") amount ("
						+ plan.getPlanAmount() + ") and plan duration of (" + plan.getPlanFrequency() + ") and type ("
						+ plan.getType() + "). Please check with inputs.");
			}
		}
	}

	@Override
	public PlanRespDto removePlan(int planId) {
		PlanRespDto plan1 = null;
		try {
			plan1 = dao.removePlan(planId);
			if (plan1 != null) {
				return plan1;
			} else {
				throw new BillingException("Failed to remove plan of id " + planId);
			}
		} catch (Exception e) {
			throw new BillingException("Failed to remove plan of id " + planId);
		}
	}

	@Override
	public PlanDetailRespDto addPlanDetail(PlanDetailDto detail) {
		PlanDetailRespDto det = null;
		try {
			if (detail.getDetail() != 0) {
				det = dao.addPlanDetail(detail);
				if (det != null) {
					return det;
				} else {
					throw new BillingException("Failed to add plan detail");
				}
			} else {
				throw new BillingException("Failed to add plan detail");
			}
		} catch (Exception e) {
			if (detail.getDetail() == 0) {
				throw new BillingException("Failed to add plan detail with null detail value");
			} else {
				throw new BillingException("Failed to add plan detail. Please check with Your inputs. type ("
						+ detail.getServiceType() + ") and detail (" + detail.getDetail() + ") and unit ("
						+ detail.getUnit() + ") and for Given Plan ");

			}
		}
	}

	@Override
	public List<PlanDetailRespDto> getPlanDetail(int planId) {
		List<PlanDetailRespDto> detail = null;
		try {
			detail = dao.getPlanDetail(planId);
			if (!detail.isEmpty()) {
				return detail;
			} else {
				throw new BillingException("No details available for this plan");
			}
		} catch (Exception e) {
			throw new BillingException("No details available for this plan");
		}
	}

	@Override
	public PlanDetailRespDto updatePlanDetail(PlanDetailDto plan) {
		PlanDetailRespDto det = null;
		try {
			if (plan.getDetail() != 0) {
				det = dao.updatePlanDetail(plan);
				if (det != null) {
					return det;
				} else {
					throw new BillingException("Failed to update plan detail");
				}
			} else {
				throw new BillingException("Failed to update plan detail");
			}
		} catch (Exception e) {
			if (plan.getDetail() == 0) {
				throw new BillingException("Failed to update plan detail with null detail value");
			} else {
				throw new BillingException("Failed to update plan detail. Please check with Your inputs. type ("
						+ plan.getServiceType() + ") and detail (" + plan.getDetail() + ") and unit (" + plan.getUnit()
						+ ") and for Given Plan ");

			}
		}
	}

	@Override
	public PlanDetailRespDto removePlanDetail(PlanDetailDto plan) {
		PlanDetailRespDto detail = null;
		try {
			detail = dao.removePlanDetail(plan);
			if (detail != null) {
				return detail;
			} else {
				throw new BillingException("Failed to remove plan detail for given null values");
			}
		} catch (Exception e) {
			if (plan.getServiceType() == null) {
				throw new BillingException("Failed to remove plan detail for given null Type");
			} else {
				throw new BillingException(
						"Failed to remove plan detail for given type (" + plan.getServiceType() + ") and detail ("
								+ plan.getDetail() + ") and unit (" + plan.getUnit() + ") and for given plan ");
			}
		}
	}

	@Override
	public PlanChargeRespDto addPlanCharge(PlanChargeDto plan) {
		PlanChargeRespDto charge = null;
		try {
			if (plan.getCharge() != 0.0) {
				charge = dao.addPlanCharge(plan);
				if (charge != null) {
					return charge;
				} else {
					throw new BillingException("Failed to add plan charge details for given null values");
				}
			} else {
				throw new BillingException("Failed to add plan charge details for given null charge");
			}
		} catch (Exception e) {
			if (plan.getChargeType() == null) {
				throw new BillingException("Failed to add plan charge details for given null Type");
			} else {
				throw new BillingException("Failed to add plan charge details of input type (" + plan.getChargeType()
						+ ") and charge (" + plan.getCharge() + ") and doucment (" + plan.getDocument()
						+ ") for given plan. Please verify all the details");
			}
		}
	}

	@Override
	public List<PlanChargeRespDto> getPlanCharge(int planId) {
		List<PlanChargeRespDto> detail = null;
		try {
			detail = dao.getPlanCharge(planId);
			if (!detail.isEmpty()) {
				return detail;
			} else {
				throw new BillingException("No charges available");
			}
		} catch (Exception e) {
			throw new BillingException("No Extra charges available for this plan");
		}
	}

	@Override
	public PlanChargeRespDto updatePlanCharge(PlanChargeDto plan) {
		PlanChargeRespDto detail = null;
		try {
			if (plan.getCharge() != 0.0) {
				detail = dao.updatePlanCharge(plan);
				if (detail != null) {
					return detail;
				} else {
					throw new BillingException("Failed to update plan");
				}
			} else {
				throw new BillingException("Failed to update plan for given null values");
			}
		} catch (Exception e) {
			if (plan.getChargeType() == null) {
				throw new BillingException("Failed to update plan for given null Type");
			} else {
				throw new BillingException("Failed to update plan charge details of input type (" + plan.getChargeType()
						+ ") and charge (" + plan.getCharge() + ") and doucment (" + plan.getDocument()
						+ ") for given plan. Please verify all the details");
			}
		}
	}

	@Override
	public PlanChargeRespDto removePlanCharge(PlanChargeDto plan) {
		PlanChargeRespDto detail = null;
		try {
			detail = dao.removePlanCharge(plan);
			if (detail != null) {
				return detail;
			} else {
				throw new BillingException("Failed to remove charge details");
			}
		} catch (Exception e) {
			if (plan.getChargeType() == null) {
				throw new BillingException("Failed to remove charge details with null input");
			} else {
				throw new BillingException("Failed to remove plan charge details of input type (" + plan.getChargeType()
						+ ") and charge (" + plan.getCharge() + ") and doucment (" + plan.getDocument()
						+ ") for given plan. Please verify all the details ");
			}
		}
	}

	@Override
	public PlanOverdueRespDto addOverdueDetails(PlanOverdueDto plan) {
		PlanOverdueRespDto due = null;
		try {
			if (plan.getOverageService() != 0 && plan.getServiceCost() != 0.0) {
				due = dao.addOverdueDetails(plan);
				if (due != null) {
					return due;
				} else {
					throw new BillingException("Failed to add overdue details");
				}
			} else {
				throw new BillingException("Failed to add overdue details for Type NULL");
			}
		} catch (Exception e) {
			if (plan.getOverageType() == null) {
				throw new BillingException("Failed to add overdue details for Type NULL");
			} else {
				throw new BillingException("Failed to add overdue details of input type (" + plan.getOverageType()
						+ ") and service (" + plan.getOverageService() + ") of unit (" + plan.getUnit() + ") and cost ("
						+ plan.getServiceCost() + ") for plan. Please verify all the details");
			}
		}
	}

	@Override
	public List<PlanOverdueRespDto> getOverdueDetails(int planId) {
		List<PlanOverdueRespDto> due = null;
		try {
			due = dao.getOverdueDetails(planId);
			if (due.isEmpty()) {
				throw new BillingException("No overdue available for this plan");
			} else {
				return due;
			}
		} catch (Exception e) {
			throw new BillingException("No overdue details available for this plan " + planId);
		}
	}

	@Override
	public PlanOverdueRespDto updateOverdueDetails(PlanOverdueDto plan) {
		PlanOverdueRespDto due = null;
		try {
			if (plan.getOverageService() != 0 && plan.getServiceCost() != 0.0) {
				due = dao.updateOverdueDetails(plan);
				if (due != null) {
					return due;
				} else {
					throw new BillingException("Failed to update details");
				}
			} else {
				throw new BillingException("Failed to update details for TYPE - NULL");
			}
		} catch (Exception e) {
			if (plan.getOverageType() == null) {
				throw new BillingException("Failed to update details for TYPE - NULL");
			} else {
				throw new BillingException("Failed to update overdue details of input type (" + plan.getOverageType()
						+ ") and service (" + plan.getOverageService() + ") of unit (" + plan.getUnit() + ") and cost ("
						+ plan.getServiceCost() + ") for plan. Please verify all the details");
			}
		}
	}

	@Override
	public PlanOverdueRespDto removeOverdueDetails(PlanOverdueDto plan) {
		PlanOverdueRespDto due = null;
		try {
			due = dao.removeOverdueDetails(plan);
			if (due != null) {
				return due;
			} else {
				throw new BillingException("Failed to remove Details");
			}
		} catch (Exception e) {
			if (plan.getOverageType() == null) {
				throw new BillingException("Failed to remove Details of TYPE (NULL)");
			} else {
				throw new BillingException("Failed to remove overdue details of input type (" + plan.getOverageType()
						+ ") and service (" + plan.getOverageService() + ") of unit (" + plan.getUnit() + ") and cost ("
						+ plan.getServiceCost() + ") for plan. Please verify all the details");
			}
		}
	}

}
