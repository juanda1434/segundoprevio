<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/listar" class="nav-link">Users</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${user != null}">
                            <form action="editar" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insertar" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${user != null}">
                                    Edit User
                                </c:if>
                                <c:if test="${user == null}">
                                    Add New User
                                </c:if>
                            </h2>
                        </caption>
						<c:if test="${estamentos != null}">
						<div class="form-group"> 
						<label for="estamentos">Estamento</label>
						<select name="estamento" class="form-control" id="estamentos">
                            <c:forEach var="esta" items="${estamentos }">
                             <option value="${esta.id}">${esta.descripcion }</option>
                            </c:forEach>
                            </select>
  </div>
                        </c:if>
                        <c:if test="${tipos != null}">
						<div class="form-group"> 
						<label for="estamentos">Tipo documento</label>
						<select name="tipo" class="form-control" id="estamentos">
                            <c:forEach var="tipo" items="${tipos }">
                             <option value="${tipo.id}">${tipo.descripcion }</option>
                            </c:forEach>
                            </select>
  </div>
                        </c:if>
                        
                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                        </c:if>
<fieldset class="form-group">
                            <label>Documento</label> <input type="text" value="<c:out value='${user.documento}' />" class="form-control" name="documento" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Nombre</label> <input type="text" value="<c:out value='${user.nombre}' />" class="form-control" name="nombre" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="<c:out value='${user.email}' />" class="form-control" name="email">
                        </fieldset>

<c:if test="${estamentos != null}">
						<div class="form-group"> 
						<label for="estamentos">Estamento</label>
						<select name="eleccion" class="form-control" id="estamentos">
                            <c:forEach var="esta" items="${estamentos }">
                             <option value="${esta.eleccion.id}">${esta.eleccion.nombre }</option>
                            </c:forEach>
                            </select>
  </div>
                        </c:if>
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
</html>