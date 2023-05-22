package com.LoginFunctionalityWork.controller;

import com.LoginFunctionalityWork.entity.UserDetails;
import com.LoginFunctionalityWork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ForgetPasswordController {
    @Autowired
    private UserService userService;

    @Autowired
    private MailSender mailSender;

    @GetMapping("/forget")
    public String forgetPasswordPage() {
        return "forget.jsp";
    }

    @PostMapping("/forget")
    public String forgetPassword(@RequestParam String email) {
        UserDetails user = userService.findByEmail(email);

        if (user != null) {
            // Generate and send password reset link to the user's email
            String resetLink = "https://yourwebsite.com/reset-password?token=xyz";
            sendResetPasswordEmail(user.getEmail(), resetLink);
        }

        // Redirect to a confirmation page or login page
        return "confirmation.jsp";
    }

    private void sendResetPasswordEmail(String toEmail, String resetLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Password Reset Request");
        message.setText("Please click the link below to reset your password:\n" + resetLink);

        mailSender.send(message);
    }
}
