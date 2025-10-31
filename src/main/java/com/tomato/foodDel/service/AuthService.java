package com.tomato.foodDel.service;

import java.util.concurrent.TimeoutException;

import com.tomato.foodDel.dto.OtpDto;
import com.tomato.foodDel.dto.ResponseDto;
import com.tomato.foodDel.dto.UserDto;

public interface AuthService {
	ResponseDto register(UserDto userDto);
	ResponseDto verifyOtp(OtpDto otpDto) throws TimeoutException;

}
