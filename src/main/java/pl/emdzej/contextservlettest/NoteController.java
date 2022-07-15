package pl.emdzej.contextservlettest;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = {"/private","/public"})
public class NoteController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        findNote(req).ifPresent(note -> req.setAttribute("note",note));
        req.getRequestDispatcher("/note.jsp").forward(req,resp);
    }


    private Optional<String> findNote(HttpServletRequest request)
    {
        String servletPath = request.getServletPath();
        String noteId = request.getParameter("id");
        String note = null;

        if (servletPath.contains(NoteUtils.PRIVATE_PATH))
        {
            note = (String) request.getSession().getAttribute(noteId);
        }
        else if (servletPath.contains(NoteUtils.PUBLIC_PATH))
        {
            note = (String) getServletContext().getAttribute(noteId);
        }
        return Optional.ofNullable(note);
    }
}
