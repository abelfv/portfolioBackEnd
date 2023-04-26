package com.portfolioap.abeldev.controller;

import com.portfolioap.abeldev.Dto.dtoEducacion;
import com.portfolioap.abeldev.entity.Educacion;
import com.portfolioap.abeldev.security.controller.Mensaje;
import com.portfolioap.abeldev.service.Seducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ABEL DEV
 */
@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://portfolio-front-abeldev.web.app","http://localhost:4200"})
public class CEducacion {

    @Autowired
    Seducacion sEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID INEXISTENTE"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID INEXISTENTE"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("SE ELIMINO CORRECTAMENTE LA EDUCACION"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion) {
        if (StringUtils.isBlank(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("ESTE CAMPO ES OBLIGATORIO"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existsByNombreE(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("NOMBRE EXISTENTE"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(
                dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE()
        );
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("SE CREO UNA NUEVA EDUCACION"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID INEXISTENTE"), HttpStatus.NOT_FOUND);
        }
        if (sEducacion.existsByNombreE(dtoeducacion.getNombreE()) && sEducacion.getByNmbreE(dtoeducacion.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("NOMBRE EXISTENTE"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("ESTE CAMPO ES OBLIGATORIO"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get();

        educacion.setNombreE(dtoeducacion.getNombreE());
        educacion.setDescripcionE(dtoeducacion.getDescripcionE());

        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("SE ACTUALIZO LA EDUCACION CORRECTAMENTE"), HttpStatus.OK);
    }
}
