package com.materialmanagement.Validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;
import com.materialmanagement.Model.MmProductMaster;

@Component
public class ProductMasterValidation implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return MmProductMaster.class.equals(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		ValidationUtils.
		
	}

}
