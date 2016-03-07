<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="heroi" class="br.com.munif.orientacaoobjetos.entidades.Heroi" scope="session"/>
<jsp:useBean id="mapa" class="br.com.munif.orientacaoobjetos.entidades.Mapa" scope="application"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jogo Orientação Objetos</title>
    </head>
    <body>
        <h1>Jogo Orientação Objetos</h1>
        <form action="jogo.jsp">
            Digite seu nome heroi:
            <input name="nome" />
            <input type="submit"/>
        </form>
    </body>
</html>
