<!DOCTYPE html>
<html>
    <head>
        <link href="/css/cssEstudiantes.css" rel="stylesheet" />
        <title>${titulo}</title>
    <h1>Estudiantes</h1>
    </head>
<body>
    <div>

        <table>
            <tbody>
           <#list estudiante as est>
            </#list>
            <#if est?has_content>
                <tr ><td>Matricula</td><td>Nombre</td><td>Apellido</td><td>Telefono</td></tr>
            <#list estudiante as est>


                <tr><td>${est.matricula}</td><td>${est.nombre}</td><td>${est.apellido}</td><td>${est.telefono}</td></tr>
            <h2>No existen estudiantes</h2>


       </#list>
                <#else>
            <h2>No existen estudiantes</h2>
</#if>
            </tbody>
            </table>
    </body>
</html>
</div>
<a href="/formulario" target="_self"> <input type="button" name="newestudiante" value="Nuevo Estudiante" /> </a>

</body>
</html>