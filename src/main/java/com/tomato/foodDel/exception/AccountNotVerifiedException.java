package com.tomato.foodDel.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountNotVerifiedException extends RuntimeException{
	
	private String message;

}
