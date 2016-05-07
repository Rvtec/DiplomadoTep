<!DOCTYPE html>
<html>
    <head>
        <title>${titulo}</title>
        <link href="/css/cssFormulario.css" rel="stylesheet" />
        </head>

    <body>
        <h1>Modificar Estudiante</h1>
        <div>
            <form action="/estudiantesProcesados" method="post">
                Matricula: <input name="Matricula" type="String" value=${matricula}><br/><br/>
                Nombre:  <input name="Nombre" type="String" value=${nombre}><br/><br/>
                Apellido: <input name="Apellido" type="String" value=${apellido}><br/><br/>
                Telefono: <input name="Telefono" type="String" value=${telefono}><br/><br/>
                
                
            </div>
        <button name="Enviar" type="submit">Enviar</button>
        <a href="/estudiantes" target="_self" > <button name="Ver" type="button" >Estudiantes</button> </a>


        </form>
    </body>
</html>