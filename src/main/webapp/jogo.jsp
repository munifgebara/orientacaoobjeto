<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="heroi" class="br.com.munif.orientacaoobjetos.entidades.Heroi" scope="session"/>
<jsp:useBean id="mapa" class="br.com.munif.orientacaoobjetos.entidades.Mapa" scope="application"/>

<%
    
    String nome = request.getParameter("nome");
    if (nome != null) {
        heroi.setNome(nome);
    }
    if (heroi.getNome()==null){
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
    else if (heroi.getPosicao() == null) {
        heroi.setPosicao(mapa.getInicioHerois());
    }
    String acao = request.getParameter("acao");
    String observacao="";
    if (acao != null) {
        acao=acao.toLowerCase().trim();
        try {
            if (acao.equals("observe")) {
                observacao=heroi.observe();
            }
            else if (acao.startsWith("va para ")) {
                heroi.vaPara(acao.replaceFirst("va para ", ""));
            }
            else if (acao.startsWith("atire no ")) {
                heroi.atiraEm(acao.replaceFirst("atire no ", ""));
            }
            else {
                observacao="Não entendo '"+acao+"'";
            }
        } catch (Exception ex) {
            observacao=ex.toString();
        }
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jogo</title>
    </head>
    <body style="font-family: sans-serif">
        <h1>Jogo Orientado a Objetos</h1>
        ${heroi.nome}, você está na(o) ${heroi.posicao}, tem ${heroi.energia} de vida e ${heroi.armaEmUso.quantidadeMunicao}<br/>
        <%=observacao%><br/>
        O que você quer fazer?<br/>
        <form action="jogo.jsp">
            <input type="text" name="acao" size="40"/>
            <input type="submit"/>
        </form>
    </body>
</html>
