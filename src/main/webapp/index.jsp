<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Context Servlet Test</title>
</head>
<body>
<h1>Notepad</h1>
<form action="save" method="post">
    <fieldset>
        <label for="noteId">Note ID</label>
        <input name="noteId" id="noteId">
    </fieldset>

    <fieldset>
        <label for="noteContent">Note Input</label>
        <textarea name="noteContent" id="noteContent"></textarea>
    </fieldset>

    <fieldset>
        <label for="privateNote">Notatka prywatna</label>
        <input name="noteType" type="radio" value="priv" id="privateNote" checked />
        <label for="publicNote">Notatka publiczna</label>
        <input name="noteType" type="radio" value="pub" id="publicNote" />
    </fieldset>

    <input type="submit" value="Zapisz"/>
</form>
</body>
</html>