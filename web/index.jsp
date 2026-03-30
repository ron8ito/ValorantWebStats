<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Partida</title>
</head>
<body>

<h2>Registrar Partida</h2>
    
<form action="RegistroServlet" method="post">

    Agente: <input type="text" name="agent"><br><br>

    Kills: <input type="number" name="kills"><br><br>

    Deaths: <input type="number" name="deaths"><br><br>

    Assists: <input type="number" name="assists"><br><br>

    Mapa: <input type="text" name="map"><br><br>

    Fecha: <input type="date" name="matchDate"><br><br>

    Resultado: 
    <select name="result">
        <option value="Win">Win</option>
        <option value="Lose">Lose</option>
    </select>
    <br><br>

    <input type="submit" value="Guardar">

</form>

</body>
</html>