<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kredi Sonuc</title>
<style type="text/css">
    span {
        display: inline-block;
        width: 200px;
        text-align: left;
    }
</style>
</head>
<body>
    <div align="center">
        <h2>Kredi Basvurunuza Onay Verildi!</h2>
        <span>Ad:</span><span>${user.name}</span><br/>
        <span>Soyad:</span><span>${user.surname}</span><br/>
        <span>Kimlik No:</span><span>${user.id}</span><br/>
        <span>Telefon No:</span><span>${user.phonenum}</span><br/>
        <span>Aylik Gelir:</span><span>${user.salary}</span><br/>
         <span>Limit:</span><span>${user.limit}</span><br/>
    </div>
</body>
</html>