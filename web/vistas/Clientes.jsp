
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Clientes"%>
<%@page import="dao.DAOClientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.rtl.min.css" integrity="sha384-+4j30LffJ4tgIMrq9CwHvn0NjEvmuDCOfk6Rpg2xg7zgOxWWtLtozDEEVvBPgHqE" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
        <link href="css/estilos.css" rel="stylesheet" 
    </head>
    <body>
         <!-- NAVBAR de CINEMANIA -->
        <nav>
            <a href="#" class="enlace">
            <img src="img/logo.png" class="logo">
            </a>  
            <form action="SClientes" method='post' id='formulario'>
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
        
        <!--tercera ventana-->
        <section>
            <div>
                <div class="clientesNuevo">
                    <div></div>
                    <% if (request.getAttribute("codigo") != null) {
                            DAOClientes dao = new DAOClientes();
                            int codigo = Integer.parseInt(request.getAttribute("codigo").toString());
                            Clientes cliente = dao.buscar(codigo);
                            out.print("<div class='col-sm-8 col-md-6'>"
                                        + "<br> </br>"
                                        + "<div class='form-datos'>"
                                        + "<h3> Editar Clientes </h3>"
                                            + "<form method='POST' action='SClientes'>"
                                                + "<div class='mb-3'>"
                                                    + "<input type='hidden' name='tfCodigo' value='" + cliente.getCodigo() + "'>"
                                                    + "<input class='form-control' type='text' placeholder='Nombre' name='tfNombre' value='" + cliente.getNombre() + "'>"
                                                + "</div>"
                                                + "<div class='mb-3'>"
                                                    + "<input class='form-control' type='text' placeholder='Apellido Paterno' name='tfApellidoP' value='"+ cliente.getApellidoP()+"'>"
                                                + "</div>"
                                                + "<div class='mb-3'>"
                                                  + "<input class='form-control' type='text' placeholder='Apellido Materno' name='tfApellidoM' value='" + cliente.getApellidoM() + "'>"
                                                + "</div>"
                                                + "<div class='mb-3'>"
                                                  + "<input class='form-control' type='text' placeholder='Direccion' name='tfDirec' value='" + cliente.getDireccion() + "'>"
                                                + "</div>"
                                                + "<div class='mb-3'>"
                                                    + "<input class='form-control' type='text' placeholder='Telefono' name='tfTel' value='" + cliente.getTelefono() + "'>"
                                                + "</div>"
                                                + "<div class='p-t-20'>"
                                                    + "<button type='submit' class='bottons' name='tfAccion' value='Actualizar'>Actualizar</button>"
                                                + "</div>"
                                            + "</form>"
                                        + "</div>"
                                    + "</div>");
                        } else {
                            out.print("<div class='col-sm-9 col-md-6'>"
                                        + "<br> </br>"
                                        + "<div class='form-datos'>"
                                        + "<h3> Clientes </h3>"
                                            + "<form method='POST' action='SClientes'>"
                                                + "<div class='mb-3'>"
                                                    + "<input class='form-control' type='text' placeholder='Nombre del cliente' name='tfNombre'>"
                                                + "</div>"
                                                + "<div class='mb-3'>"
                                                    + "<input class='form-control' type='text' placeholder='Apellido Paterno' name='tfApellidoP'>"
                                                + "</div>"
                                                + "<div class='mb-3'>"
                                                    + "<input class='form-control' type='text' placeholder='Apellido Materno' name='tfApellidoM'>"
                                                + "</div>"
                                                + "<div class='mb-3'>"
                                                    + "<input class='form-control' type='text' placeholder='Direccion' name='tfDirec'>"
                                                + "</div>"
                                                + "<div class='mb-3'>"
                                                    + "<input class='form-control' type='text' placeholder='Telefono' name='tfTel'>"
                                                + "</div>"
                                                + "<div class='p-t-20'>"
                                                    + "<button type='submit' class='bottons' name='tfAccion' value='Registrar'>Agregar</button>"
                                                + "</div>"
                                            + "</form>"
                                        + "</div>"
                                    + "</div>");
                        }
                    %>
                </div>
                    
                    <div class="clientesLeft">
                        <table id="example" class="table table-striped" style="width:100%">
                            <thead>
                                <tr>
                                    <th>COCLIENTE</th>
                                    <th>Nombre</th
                                    <th></th>
                                    <th>ApellidoP</th
                                    <th></th>
                                    <th>ApellidoM</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>
                                    <th></th>
                                    <th></th>
                                    <th colspan = "2"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    DAOClientes daoClientes = new DAOClientes();
                                    ArrayList<Clientes> listClientes = daoClientes.mostrar();
                                    Clientes clientes = null;
                                    for (int i = 0; i < listClientes.size(); i++) {
                                        clientes = listClientes.get(i);
                                %>


                                <tr>
                                    <td><%= clientes.getCodigo()%></td>
                                    <td><%= clientes.getNombre()%></td>
                                    <td><%= clientes.getApellidoP()%></td>
                                    <td><%= clientes.getApellidoM()%></td>
                                    <td><%= clientes.getDireccion()%></td>
                                    <td><%= clientes.getTelefono()%></td>
                                    <td><a href="#" onclick="procesar('editar', '<%= clientes.getCodigo()%>')"><div class="iconE"><i class="bi bi-pencil-fill"></i></div></a></td>
                                    <td><a href="#" onclick="procesar('eliminar', '<%= clientes.getCodigo()%>')"><div class="iconEl"><i class="bi bi-trash"></i></div></a></td>
                                </tr> 
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>


   
    <script>
            function procesar(accion, codigo)
            {
                var tfAccion = document.createElement("INPUT");
                tfAccion.name = "tfAccion";
                tfAccion.type = "hidden";
                tfAccion.value = accion;

                var tfCodigoP = document.createElement("INPUT");
                tfCodigoP.name = "tfCodigoP";
                tfCodigoP.type = "hidden";
                tfCodigoP.value = codigo;

                var padre = document.getElementById("formulario");
                padre.appendChild(tfAccion);
                padre.appendChild(tfCodigoP);
                padre.submit();
            }
        </script>
    <!--Script de model-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>

    <script>
      $(document).ready(function () {
        $('#example').DataTable({

          'language':{
            "url":"https://cdn.datatables.net/plug-ins/1.12.1/i18n/es-MX.json"
          }

        });
      });
    </script>
</body>
</html>
