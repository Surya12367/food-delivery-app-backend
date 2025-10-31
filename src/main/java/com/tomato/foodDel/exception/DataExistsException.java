package com.tomato.foodDel.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataExistsException extends RuntimeException{
	
	String message = "Data Already Exists";

}
