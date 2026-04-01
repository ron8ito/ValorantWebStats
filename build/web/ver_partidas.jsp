<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Lista de Partidas</title>
    <style>
        body { font-family: sans-serif; background-color: #f4f4f4; padding: 20px; }
        table { width: 100%; border-collapse: collapse; background: white; }
        th, td { padding: 10px; border: 1px solid #ccc; text-align: left; }
        th { background-color: #ff4655; color: white; }
    </style>
</head>
<body>
    <h1>Mis Partidas Guardadas</h1>
    <table>
        <tr>
            <th>Agente</th>
            <th>Kills</th>
            <th>Deaths</th>
            <th>Assists</th>
            <th>Mapa</th>
            <th>Resultado</th>
        </tr>
        <%
            List<Map<String, String>> lista = (List<Map<String, String>>) request.getAttribute("misPartidas");
            if (lista != null && !lista.isEmpty()) {
                for (Map<String, String> p : lista) {
        %>
            <tr>
                <td><%= p.get("agent") %></td>
                <td><%= p.get("kills") %></td>
                <td><%= p.get("deaths") %></td>
                <td><%= p.get("assists") %></td>
                <td><%= p.get("map") %></td>
                <td><%= p.get("result") %></td>
            </tr>
        <%      } 
            } else {
        %>
            <tr>
                <td colspan="6">No hay partidas registradas aún.</td>
            </tr>
        <%  } %>
    </table>
    <br>
    <a href="index.jsp">Volver a registrar</a>
</body>
</html>