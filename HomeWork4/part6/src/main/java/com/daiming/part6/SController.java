package com.daiming.part6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class SController {
    @GetMapping("/shop")
    public ModelAndView authenticate(HttpServletRequest request, HttpServletResponse response) {
        String authorization = request.getHeader("Authorization");
        ModelAndView modelAndView = null;
        if (authorization == null) {
            askForPassword(response);
        } else {
            String userInfo = authorization.substring(6).trim();
            Base64.Decoder decoder = Base64.getDecoder();
            String nameAndPassword =
                    new String(decoder.decode(userInfo));
            // Decoded part looks like "username:password".
            int index = nameAndPassword.indexOf(":");
            String user = nameAndPassword.substring(0, index);
            String password = nameAndPassword.substring(index+1);
            if (user.equals("admin")  && password.equals("admin")) {
                HttpSession session = request.getSession(true);
                if (session.getAttribute("cart") == null) {
                    session.setAttribute("cart", new ArrayList<String>());
                }
                modelAndView = new ModelAndView("homepage");
            } else {
                askForPassword(response);
            }
        }
        return modelAndView;
    }



    @PostMapping("/cart")
    public ModelAndView addOrDelete(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("homepage");
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);

        if (action.equals("add")) {
            List<String> cart = (List<String>) session.getAttribute("cart");
            String[] items = request.getParameterValues("items");
            for (String item : items) {
                cart.add(item);
            }
        }
        if (action.equals("delete")) {
            String[] itemsToDelete = request.getParameterValues("items");
            List<String> cart = (List<String>) session.getAttribute("cart");
            for (String item : itemsToDelete) {
                cart.remove(item);
            }
        }
        return modelAndView;
    }



    private void askForPassword(HttpServletResponse response) {
        response.setStatus(response.SC_UNAUTHORIZED); // I.e., 401
        response.setHeader("WWW-Authenticate",
                "BASIC realm=\"Insider-Trading\"");
    }
    @GetMapping("/shop/books")
    public ModelAndView book() {
        return new ModelAndView("book");
    }
    @GetMapping("/shop/computer")
    public ModelAndView computer() {
        return new ModelAndView("computer");
    }
    @GetMapping("/shop/music")
    public ModelAndView music() {
        return new ModelAndView("music");
    }

}
