package com.daiming.part4;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("movie");
        String dir = request.getParameter("dir");
        if (dir != null) {
            model = new ModelAndView(dir);
        }

        MovieDao movieDao = new MovieDao();

        if (request.getMethod().equals("POST")&& dir.equals("added")) {
            movieDao.addMovie(request);
        }
        if (request.getMethod().equals("POST")&& dir.equals("searchResult")) {
            String keyword = request.getParameter("keyword");
            String searchBy = request.getParameter("search_by");

//            request.setAttribute("keyword", keyword);
//            request.setAttribute("searchBy", searchBy);



            ResultSet resultSet = movieDao.searchMovie(request);

            List<Movie> movieList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Movie movie = new Movie();
                    movie.setTitle(resultSet.getString("title"));
                    movie.setActor(resultSet.getString("actor"));
                    movie.setActress(resultSet.getString("actress"));
                    movie.setGenre(resultSet.getString("genre"));
                    movie.setYear(resultSet.getInt("year"));
                    movieList.add(movie);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            model.addObject("keyword", keyword);
            model.addObject("searchBy", searchBy);
            model.addObject("searchResult", movieList);
        }
        return model;
    }
}
