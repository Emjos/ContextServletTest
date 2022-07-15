package pl.emdzej.contextservlettest;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/save")
public class SaveController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Note note = createNote(req);
        saveNote(note,req);
        String noteUrl = NoteUtils.buildNoteUrl(note);
        req.setAttribute("noteUrl",noteUrl);
        req.getRequestDispatcher("/confirmation.jsp").forward(req,resp);
    }

    private Note createNote(HttpServletRequest request)
    {
        String noteID = request.getParameter("noteId");
        String noteContent = request.getParameter("noteContent");
        String noteType = request.getParameter("noteType");
        return new Note(noteID,noteContent,noteType);

    }

    private void saveNote(Note note, HttpServletRequest request)
    {
        if (note.getType().equals(Note.TYPE_PRIVATE))
        {
            request.getSession().setAttribute(note.getId(), note.getContent());
        }
        else if (note.getType().equals(Note.TYPE_PUBLIC))
        {
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute(note.getId(),note.getContent());
        }

    }
}
