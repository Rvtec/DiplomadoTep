<!DOCTYPE html>
<html>
    <head>
        <link href="/css/cssEstudiantes.css" rel="stylesheet" />
        <title>${titulo}</title>
    <h1>Estudiantes</h1>
    </head>
<body>
    <div>
        <#--<form method="post" action="/borrarEstudiante">-->
        <table>
            <tbody>
                <tr ><td>Matricula</td><td>Nombre</td><td>Apellido</td><td>Telefono</td></tr>
            <#list estudiante as est>

               
                <tr><td name="matricula">${est.matricula}</td><td name="nombre">${est.nombre}</td><td name=apellido>${est.apellido}</td><td name="telefono">${est.telefono}</td>
                <#--<input type="hidden" name="borrarNombre" value=${est.nombre}></input>
                <input type="hidden" name="borrarMatricula" value=${est.matricula}></input>
                <input type="hidden" name="borrarApellido" value=${est.telefono}></input>
                <input type="hidden" name="borrarTelefono" value=${est.apellido}></input>
                    <td><button  name="Borrar" type="submit">Borrar</button></td></tr>
                    -->
               <td> <a  href="/borrarEstudiante?borrarNombre=${est.nombre}&borrarMatricula=${est.matricula}&borrarApellido=${est.apellido}&borrarTelefono=${est.telefono}" target="_self" > <input method="post" type="submit" name="newestudiante" value="borrar" /> </a></td></tr>
                    
       </#list>

                </tbody>
            </table>
            
          <#-- </form>-->
        </div>
    </body>
</html>

<a href="/formulario" target="_self"> <input type="button" name="newestudiante" value="Nuevo Estudiante" /> </a>

</body>
</html>