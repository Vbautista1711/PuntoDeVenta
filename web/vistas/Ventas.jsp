<%-- 
    Document   : Ventas
    Created on : 28/08/2022, 08:33:10 PM
    Author     : vbaut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.rtl.min.css" integrity="sha384-+4j30LffJ4tgIMrq9CwHvn0NjEvmuDCOfk6Rpg2xg7zgOxWWtLtozDEEVvBPgHqE" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
        <link href="css/estilos.css" rel="stylesheet" 
    </head>
     <body id="page-top">
         <nav>
            <a href="#" class="enlace">
            <img src="img/logo.png" class="logo">
            </a>  
            <form action="Srutas" method='post' id='formulario'>
                <nav>
                    <div>  
                        <div>
                            <ul class="">
                                <li><img class="iconos" src="img/inicio.svg"><a href="#" onclick="procesar('menu')">Inicio</a></li>
                                <li><img class="iconos" src="img/categorias.svg"><a href="#" onclick="procesar('Categorias')">Categorias</a></li>
                                <li><img class="iconos" src="img/productos.svg"> <a href="#" onclick="procesar('Productos')">Productos</a></li>
                                <li><img class="iconos" src="img/clientes.svg"><a href="#" onclick="procesar('Clientes')">Clientes</a></li>
                                <li><img class="iconos" src="img/usuarios.svg"><a href="#" onclick="procesar('Usuarios')">Usuarios</a></li>
                                <li><img class="iconos" src="img/venta.svg"><a href="#" onclick="procesar('Ventas')">Venta</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </form>
        </nav>             
        
        <div class="venta">
            <div class="d-flex">
                <div class="col-sm-5">
                    <div class="card">
                        <form action="Controlador?menu=NuevaVenta" method="POST"> 
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Datos del Cliente:</label>
                                </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="Codigo">
                                        <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                                    </div>                            
                                    <div class="col-sm-6">
                                        <input type="text" name="nombrescliente" value="${c.getNom()}" placeholder="Datos Cliente" class="form-control">
                                    </div>                                                                                                                
                                </div>
                      <!-- Datos del Producto -->
                                <div class="form-group">
                                    <label>Datos Producto:</label>
                                </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo">  
                                        <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                    </div>                            
                                    <div class="col-sm-6">
                                        <input type="text" name="nombreproducto" value="${producto.getNom()}" placeholder="Datos Producto" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <input type="text" name="precio" value="${producto.getPre()}" class="form-control" placeholder="S/.0.00">                                
                                    </div>                            
                                    <div class="col-sm-3">
                                        <input type="number"  value="1" name="cant" class="form-control">
                                    </div>
                                    <div class="col-sm-3">
                                        <input type="text" name="stock" value="${producto.getStock()}" placeholder="Stock" class="form-control">
                                    </div>                            
                                </div>
                                <div class="form-group">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>
                                </div>
                            </div>
                        </form>
                    </div>                
                </div>   
                <div class="col-sm-7">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex col-sm-5 ml-auto"> 
                                <label>No.Serie:</label>
                                    <input type="text" name="N.Serie" class="form-control">
                            </div> 
                            <br>                        
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>Codigo</th>
                                        <th>Descripcion</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>Subtotal</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="list" items="${lista}">
                                        <tr>
                                            <td>${list.getItem()}</td>
                                            <td>${list.getIdproducto()}</td>
                                            <td>${list.getDescripcionP()}</td>
                                            <td>${list.getPrecio()}</td>
                                            <td>${list.getCantidad()}</td>
                                            <td>${list.getSubtotal()}</td>
                                            <td>
                                             </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div> 
                        <div class="card-footer">
                            <div>
                                <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                                <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script>
            function procesar(accion)
            {
                var tfAccion = document.createElement("INPUT");
                tfAccion.name = "tfAccion";
                tfAccion.type = "hidden";
                tfAccion.value = accion;

                var padre = document.getElementById("formulario");
                padre.appendChild(tfAccion);
                padre.submit();
            }
        </script>   
    </body>
</html>
