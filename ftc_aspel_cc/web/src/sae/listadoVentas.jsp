<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iaspel - Listado de documentos venta</title>
    </head>
    <body>
        <h1>Listado de documentos ASPEL-SAE para generar p&oacute;lizas contables:</h1>
        <div>
            <div id="header">
                <table>
                    <tr>
                        <td>Tipo de p&oacute;liza COI</td>
                        <td>
                            <select id="tipoPoliza" name="tipoPoliza">
                                <option value="-1">(seleccione)</option>
                            </select>
                        </td>
                        <td>Per&iacute;odo COI</td>
                        <td>
                            <select id="periodoCOI" name="periodoCOI">
                                <option value="-1">(seleccione)</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Tipo de p&oacute;liza SAE</td>
                        <td>
                            <input type="text" name="tipoPolizaSAE" value="" maxlength="2" style="width: 50px" />
                        </td>
                        <td>Per&iacute;odo SAE</td>
                        <td>
                            <>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="list"></div>            
        </div>
    </body>
</html>
