package item.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import item.dto.Item;

public class ItemValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

//		ValidationUtils.rejectIfEmpty(errors, "itemName", "required");
//		ValidationUtils.rejectIfEmpty(errors, "itemDetail", "required");
//		ValidationUtils.rejectIfEmpty(errors, "price", "required");
//		ValidationUtils.rejectIfEmpty(errors, "stock", "required");
	}

}
