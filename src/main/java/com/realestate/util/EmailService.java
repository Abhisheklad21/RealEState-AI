package com.realestate.util;

import com.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    private UserService userService;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, UserService userService) {
        this.javaMailSender = javaMailSender;
        this.userService = userService;
    }

    public String generateOtp() {
        return String.format("%06d", new java.util.Random().nextInt(1000000));
    }

    public Map<String, String> sendOtpEmail(String email) {
        String otp = generateOtp();
//        emailOtpMapping.put(email, otp);
        sendEmail(email, "OTP for email Verification", "Your OTP is " + otp);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "OTP sent successfully !");
        return response;
    }
    public Map<String, String> sendOtpEmailLogin(String email) {
        String otp = generateOtp();
//        emailOtpMapping.put(email, otp);
        sendEmail(email, "OTP for  Login", "Your login OTP is " + otp);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "OTP sent successfully !");
        return response;
    }

    public void sendPlanExpiryEmail(String email) {
        sendEmail(email, "Your plan is Expired !!", "your plan of the realEstateAI is expired please renew ! " );
        System.out.println("Send email method");

    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("marketingapp665@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);

    }
}
