<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kredi Basvuru Formu</title>

<style type="text/css">
    label {
        display: inline-block;
        width: 200px;
        margin: 5px;
        text-align: left;
    }
    input[type=text], input[type=name], input[type=password], select {
        width: 200px;  
    }
     
    button {
        padding: 10px;
        margin: 10px;
    }
</style>
</head>
<body>
    <div align="center">
        <h2>KREDI BASVURU FORMU</h2>
        <form:form action="register2" method="post" modelAttribute="user">
            <form:label path="name">Ad:</form:label>
            <form:input path="name"/><br/>
            
            <form:label path="surname">Soyad:</form:label>
            <form:input path="surname"/><br/>
             
            <form:label path="id" >Kimlik No:</form:label>
            <form:input path="id" minlength= "11" maxlength="11" /><br/>
             
            
            <form:label path="phonenum" >Telefon No:</form:label>
            <form:password path="phonenum" placeholder="+90xxxxxxxxxx"/><br/>      
 
            <form:label path="salary">Aylik Gelir:</form:label>
            <form:input path="salary"/><br/>
            
                 
            <form:button>SORGULA</form:button>
        </form:form>
    </div>
</body>
</html>