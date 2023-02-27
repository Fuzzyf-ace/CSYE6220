package com.daiming.part5;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("book");
        String dir = request.getParameter("dir");
        if (dir != null) {
            modelAndView = new ModelAndView(dir);
        }
        BookDao bookDao = new BookDao();

        if (request.getMethod().equals("POST") && dir.equals("addBook")) {
            int numofBooks = Integer.parseInt(request.getParameter("num_books"));
            modelAndView.addObject("num", numofBooks);
        }
        if (request.getMethod().equals("POST") && dir.equals("addedBook")) {
            bookDao.addBook(request);
            modelAndView.addObject("num", request.getParameterValues("isbn").length);
        }
        return modelAndView;
    }
}
