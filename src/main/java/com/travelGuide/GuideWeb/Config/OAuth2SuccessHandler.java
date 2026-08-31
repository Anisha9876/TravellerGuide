package com.travelGuide.GuideWeb.Config;

import com.travelGuide.GuideWeb.Service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    JwtService jwtService;
    public OAuth2SuccessHandler(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException
    {
        OAuth2User oauthUser= (OAuth2User)authentication.getPrincipal();
        String email = oauthUser.getAttribute("email");
        String token = jwtService.generateToken(email);
        response.sendRedirect("http://localhost:8080/?token=" + token);
        response.getWriter().write(token);
    }
}
