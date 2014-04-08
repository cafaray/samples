package exercise1

//public class Test{}
import com.palestra.groovy.Persona;
//import com.sun.org.apache.xerces.internal.parsers.XMLParser
//
import groovy.sql.Sql
//
////def milista=["Jose","come","palomitas"]
//
////println milista.get(0) == "come"
////milista.add("el rifles")
////milista.add("la explosion")
////println milista.size()
////println milista.get(2)
////println milista.get(milista.size()-1)
//
//// println com.palestra.groovy.FirstClass.escribeAlgo("carlos")
//// println "git help".execute().text
//
///*
//def names = ["Jeff", "Spot", "Omar", "Ana", "Hermenegildo","Noell", "Silverio"]
//println names.join(" ")
//def shortNames = names.findAll{
//	it.size() <= 4
//} 
//println shortNames.size()
//shortNames.each{println(it)}
//
//new File("/home/omash/Downloads/facturas/AKKY_112279_FAAC750415PZ0.xml").eachLine {println it}
//*/
//
////def numbers = 0..100
////def odd = {it % 2 == 1}
////mayor90 = numbers.findAll(it > 90)
////println mayor90.join(", ")
////odds = numbers.findAll(odd)
////println odds.join(", ")
///*
//def xml = new File("/home/omash/Downloads/facturas/AKKY_112279_FAAC750415PZ0.xml").text
//println xml
//def root = new XmlParser().parseText(xml)
//println root."Impuestos".'@totalImpuestosTrasladados'
//println root.Impuestos.Traslados.Traslado.'@impuesto'.text()
//println root.Impuestos.Traslados.Traslado.'@tasa'.text()
//println root.Impuestos.Traslados.Traslado.'@importe'.text()
//*/
//
//def sql = Sql.newInstance( 'jdbc:mysql://localhost:3306/test', 'root', 'cfar21MySql', 'com.mysql.jdbc.Driver' )
//sql.eachRow( "SELECT identificador, CONCAT(nombre,' ',apellidos) AS nombre FROM persona;" ) { println "$it.identificador -- ${it.nombre} --" }
personas = Persona.getPersonas("Jacinto")
println personas.join("; ")
//
//
////def printSuma = {a,b,c -> println (a+b+c)}
////printSuma 5,3,13
//
//def nombres = ["Van Halen", "Simple Minds", "REM", "Roxette", "Iron Maiden"]
//def printNombre = {println "tu nombre es ${it[3]} de los ${it.size()} nombres"}
//printNombre nombres
//
//def localMethod () {
//	def localVariable = new Date()
//	return {println localVariable}
//}
//def method = localMethod()
//println "ejecutamos el metodo ${method}"
//method()
//
//
//class Class1 {
//	def closure = {
//		println this.class.name
//		println delegate.class.name
//		def nestedClosure = {
//			println owner.class.name
//		}
//		nestedClosure()
//	}
//}
//
//def clos = new Class1().closure
//clos.delegate = this
//clos()
//
//aaa = '"bread","apple","egg"'
//items = aaa.split(',')
//assert items[1] == '"apples"'
//items.each{ println "item: $it" }
