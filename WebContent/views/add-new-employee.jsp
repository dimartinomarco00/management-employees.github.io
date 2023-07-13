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
    
     <!-- Custom CSS -->
     <style type="text/css">
	     form 
		 {
		    width: 50vw !important;
		    min-width: 300px !important;
		 }
     </style>
     
    <!-- Font Awesome -->
    <script src="https://kit.fontawesome.com/1ec278ba68.js"></script>
</head>
<body>
    <div class="container">
        <div class="text-center my-5">
            <h1>
               <c:if test="${dipendente != null}">Modifica dipendente</c:if>
			   <c:if test="${dipendente == null}">Aggiungi un nuovo dipendente</c:if>
            </h1>
            
            <p class="text-muted">
               <c:if test="${dipendente != null}">Completa il form per modificare i dati del dipendente</c:if>
			   <c:if test="${dipendente == null}">Completa il form per aggiungere un nuovo dipendente</c:if>
            </p>
        </div>

        <div class="container d-flex justify-content-center">
            <c:if test="${dipendente != null}"><form action="update" method="post"></c:if>
		    <c:if test="${dipendente == null}"><form action="insert" method="post"></c:if>
                <div class="row">
                
                    <c:if test="${dipendente != null}">
				      <input type="hidden" name="id" value="<c:out value='${dipendente.id}'/>"/>
				    </c:if>
				    
                    <div class="col">
                        <input type="text" value="<c:out value='${dipendente.nome}'/>" class="form-control" id="nome" name="nome" placeholder="Nome" required>
                    </div>

                    <div class="col">
                        <input type="text" value="<c:out value='${dipendente.cognome}'/>" class="form-control" id="cognome" name="cognome" placeholder="Cognome" required>
                    </div>

                    <div class="col">
                        <input type="text" value="<c:out value='${dipendente.eta}'/>" class="form-control" id="eta" name="eta" placeholder="Età" required>
                    </div>

                    <div class="form-group my-5">
                        <label class="form-label">Sesso:</label>
                        
                        &nbsp;
                        <c:choose>
                           <c:when test="${dipendente != null && dipendente.sesso == 'uomo'}">
                              &nbsp;
                              <input type="radio" class="form-check-input" name="sesso" id="uomo" value="uomo" checked required>
                              <label for="uomo" class="form-input-label">Uomo</label>
                              &nbsp;
                              <input type="radio" class="form-check-input" name="sesso" id="donna" value="donna" required>
                              <label for="donna" class="form-input-label">Donna</label>
                           </c:when>
                           
                           <c:when test="${dipendente != null && dipendente.sesso == 'donna'}">
                              &nbsp;
                              <input type="radio" class="form-check-input" name="sesso" id="uomo" value="uomo" required>
                              <label for="uomo" class="form-input-label">Uomo</label>
                              &nbsp;
                              <input type="radio" class="form-check-input" name="sesso" id="donna" value="donna" checked required>
                              <label for="donna" class="form-input-label">Donna</label>
                           </c:when>
                           
                           <c:otherwise>
                              &nbsp;
                              <input type="radio" class="form-check-input" name="sesso" id="uomo" value="uomo" required>
                              <label for="uomo" class="form-input-label">Uomo</label>
                              &nbsp;
                              <input type="radio" class="form-check-input" name="sesso" id="donna" value="donna" required>
                              <label for="donna" class="form-input-label">Donna</label>
                           </c:otherwise>
                        </c:choose> 
                    </div>

                    <div class="col">    
                        <input type="date" value="<c:out value='${dipendente.dataNascita}'/>" class="form-control" name="data" placeholder="Data di nascita" required>
                    </div>

                    <div class="col">
                        <input type="email" value="<c:out value='${dipendente.email}'/>" class="form-control" name="email" placeholder="Email" required>
                    </div>

                    <div class="col">
                        <input type="text" value="<c:out value='${dipendente.numeroTelefono}'/>" class="form-control" id="telefono" name="telefono" placeholder="N. cellulare" required>
                    </div>

                    <div class="col">
                        <input type="text" value="<c:out value='${dipendente.salario}'/>" class="form-control" id="salario" name="salario" placeholder="Salario" required>
                    </div>

                    <div class="mt-5 text-center">
                        <button type="submit" class="btn btn-success">Salva</button>
                        <a href="<%=request.getContextPath()%>/view-list" class="btn btn-danger">Annulla</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    
    
     <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- Custom JS -->
     <script type="text/javascript">
     (function()
	 {
	     "use strict";

	     const inputTelefono = document.getElementById("telefono");
	     const inputSalario = document.getElementById("salario");
	     const inputSoloCifre = document.querySelectorAll("#eta, #telefono");
	     const inputSoloCaratteriESpazi = document.querySelectorAll("#nome, #cognome");

	     for(let eachItem of inputSoloCaratteriESpazi)
	     {
	         eachItem.addEventListener('input', function()
	         {
	             this.value = this.value.replace(/[^A-Za-z\s]*$/, '');
	         });
	     }

	     for(let eachItem of inputSoloCifre)
	     {
	         eachItem.addEventListener('input', function()
	         {
	             this.value = this.value.replace(/[^0-9]/g, '');
	         });
	     }

	     inputTelefono.setAttribute('maxlength', '10');

	     //permette di inserire il punto decimale
	     inputSalario.addEventListener('input', function()
	     {
	         this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1').replace(/^0[^.]/, '0');
	     });
	 }());
     </script>
</body>
</html>