<!DOCTYPE html>
<html>
    <head>
        <title>${titulo}</title>
        <link href="/css/cssFormulario.css" rel="stylesheet" />
        </head>

    <body>
        <h1>Formulario Estudiante</h1>
        <div>
        <form action="/estudiantesProcesados" method="post">
            Matricula: <input name="Matricula" type="String"><br/><br/>
            Nombre:  <input name="Nombre" type="String"><br/><br/>
            Apellido: <input name="Apellido" type="String"><br/><br/>
            Telefono: <input name="Telefono" type="String"><br/><br/>

            </div>
        <button name="Enviar" type="submit">Enviar</button>
        <a href="/estudiantes" target="_self" > <button name="Ver" type="button" >Estudiantes</button> </a>
        
        <p>${guardado}</p>
        </form>
        </body>
    </html>