<!DOCTYPE html>
<html>
<head>

<title>${titulo}</title>
<h1>Estudiantes</h1>
</head>
<body>
<div>
    
    <table>
        <tbody>
           
          <tr ><td>Matricula</td><td>Nombre</td><td>Apellido</td><td>Telefono</td></tr>
            <#list estudiante as est>

                
                <tr><td>${est.matricula}</td><td>${est.nombre}</td><td>${est.apellido}</td><td>${est.telefono}</td></tr>

       </#list>

        </tbody>
    </table>
</body>
</html>
    </div>
<a href="/formulario" target="_self"> <input type="button" name="newestudiante" value="Nuevo Estudiante" /> </a>

</body>
</html>