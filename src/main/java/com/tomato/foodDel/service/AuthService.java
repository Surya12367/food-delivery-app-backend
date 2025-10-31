package com.tomato.foodDel.service;

import java.util.concurrent.TimeoutException;

import com.tomato.foodDel.dto.LoginDto;
import com.tomato.foodDel.dto.OtpDto;
import com.tomato.foodDel.dto.PasswordDto;
import com.tomato.foodDel.dto.ResponseDto;
import com.tomato.foodDel.dto.UserDto;

public interface AuthService {
	ResponseDto register(UserDto userDto);
	ResponseDto verifyOtp(OtpDto otpDto) throws TimeoutException;
	ResponseDto resendOtp(String email);

	ResponseDto forgotPassword(String email);

	ResponseDto forgotPassword(PasswordDto passwordDto) throws TimeoutException;

	ResponseDto login(LoginDto loginDto);
}
