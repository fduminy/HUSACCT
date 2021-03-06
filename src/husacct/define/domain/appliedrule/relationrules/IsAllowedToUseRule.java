package husacct.define.domain.appliedrule.relationrules;

import husacct.define.domain.appliedrule.AppliedRuleStrategy;
import husacct.define.domain.conventions_checker.ModuleCheckerHelper;

public class IsAllowedToUseRule extends AppliedRuleStrategy{
	private ModuleCheckerHelper moduleCheckerHelper;

	@Override
	public boolean checkConvention() {
		moduleCheckerHelper = new ModuleCheckerHelper();

		if (!moduleCheckerHelper.rootIsNotIncludedInRule(getModuleFrom(), getModuleTo())){
			return false;
		}
		boolean conventionSuccess = moduleCheckerHelper.checkRuleTypeAlreadyFromThisToSelected("IsNotAllowedToUse",
					this.getModuleFrom(), this.getModuleTo());
			if (conventionSuccess) {
				conventionSuccess = moduleCheckerHelper
				    .checkRuleTypeAlreadyFromThisToOther("IsOnlyAllowedToUse",
				    	this.getModuleFrom(), this.getModuleTo());
			}
			if (conventionSuccess) {
				conventionSuccess = moduleCheckerHelper
				    .checkRuleTypeAlreadyFromOtherToSelected(
					    "IsTheOnlyModuleAllowedToUse", this.getModuleFrom(), this.getModuleTo());
			}
			if (conventionSuccess) {
				conventionSuccess = moduleCheckerHelper
						.checkRuleTypeAlreadyFromThisToSelected("IsAllowedToUse",
								this.getModuleFrom(), this.getModuleTo());
			}
			if (conventionSuccess) {
				conventionSuccess = moduleCheckerHelper
						.checkRuleTypeAlreadyFromThisToSelected("IsOnlyAllowedToUse",
								this.getModuleFrom(), this.getModuleTo());
			}
			return conventionSuccess;
	}

}
