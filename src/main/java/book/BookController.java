package book;

import board.info.Response2DTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/book/*")
public class BookController extends HttpServlet {
    private BookService bookService;

    public BookController() {
        bookService = BookService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uri = req.getRequestURI();
        try {
            long boardPk = Long.parseLong(uri.substring(uri.lastIndexOf('/') + 1));
            insertBook(req, res, boardPk);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    private void insertBook(HttpServletRequest req, HttpServletResponse res, long boardPk) throws ServletException, IOException {

    }
}