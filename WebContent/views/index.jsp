<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestionale dipendenti</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" defer></script>
    <!-- Font Awesome -->
    <script src="https://kit.fontawesome.com/1ec278ba68.js"></script>
</head>
<body>
    <nav class="navbar navbar-light justify-content-center mb-5">
       <h1>Gestionale Dipendenti</h1>
    </nav>

    <div class="container">
        <a href="<%=request.getContextPath()%>/view-insert-form" class="btn btn-dark mb-5">Aggiungi dipendente</a>

        <table class="table table-hover text-center">
           <thead class="table-dark">
             <tr>
               <th scope="col">ID</th>
               <th scope="col">Nome</th>
               <th scope="col">Cognome</th>
               <th scope="col">Età</th>
               <th scope="col">Sesso</th>
               <th scope="col">Data di nascita</th>
               <th scope="col">Email</th>
               <th scope="col">N. cellulare</th>
               <th scope="col">Salario</th>
               <th scope="col">Azioni</th>
             </tr>
           </thead>

           <tbody>
             <!--   for (Todo todo: todos) {  -->
		     <c:forEach var="dipendente" items="${listaDipendenti}" varStatus="contatore">
	           <tr>
	              <th scope="row">${contatore.count}</th>
	              <td><c:out value="${dipendente.nome}"/></td>
	              <td><c:out value="${dipendente.cognome}"/></td>
	              <td><c:out value="${dipendente.eta}"/></td>
	              <td><c:out value="${dipendente.sesso}"/></td>
	              <td><c:out value="${dipendente.dataNascita}"/></td>
	              <td><c:out value="${dipendente.email}"/></td>
	              <td><c:out value="${dipendente.numeroTelefono}"/></td>
	              <td>€<c:out value="${dipendente.salario}"/></td>
	              <td>
	                 <a href="view-edit-form?id=<c:out value='${dipendente.id}'/>" class="link-dark"><i class="fa-solid fa-pen-to-square fs-5 me-3"></i></a>
	                 <a href="delete?id=<c:out value='${dipendente.id}'/>" class="link-dark"><i class="fa-solid fa-trash fs-5"></i></a>
	              </td>
	           </tr>
             </c:forEach>
		     <!-- } -->
           </tbody>
        </table>
    </div>
</body>
</html>
