package com.palestra.wf.test.engine;

import java.util.Iterator;
import java.util.List;
import com.palestra.wf.enums.TipoAccion;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Rol;
import com.palestra.wf.model.util.DoSomething;

public class Testing {


	public static void main(String[] args) {
		Actividad actividad = new Actividad();
		actividad.setDescripcion("Hallazgo de errores en escritrua");
		actividad.setNombre("Hallazgos");
		actividad.setTiempostd(1);
		actividad.setTiempolmt(3);
		actividad.setTipoAccion(TipoAccion.ACTIVIDAD.getCodigo());
		actividad.setSesion("");
		actividad.setIdentificador();
		DoSomething test = new DoSomething();
		test.insert(actividad);

		Actividad a1 = test.findById(Actividad.class, "00da5f28f39e3274d4364a3f91d20efb");
		a1.setNombre("Hallazgo modificado");
		test.update(a1);

		test.removeById(Actividad.class, "0b43960cc06c6733635371d79f15db69");

		List<Actividad> listado = test
				.list("Actividad.findAll", Actividad.class);
		Iterator<Actividad> elementos = listado.iterator();
		while (elementos.hasNext()) {
			Actividad a = elementos.next();
			System.out.printf("id=%s, nombre=%s%n", a.getIdentificador(), a.getNombre());
		}
		Rol rol = new Rol();
		rol.setIdentificador();
		rol.setDescripcion("Administrador");
		rol.setIdrol("elID");
		rol.setPrefijo("ADM");
		rol.setSesion("mi sesion");
		test.insert(rol);
	}

}
