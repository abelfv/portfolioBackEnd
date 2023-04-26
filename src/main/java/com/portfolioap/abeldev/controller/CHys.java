package com.portfolioap.abeldev.controller;

import com.portfolioap.abeldev.Dto.dtoHys;
import com.portfolioap.abeldev.entity.hys;
import com.portfolioap.abeldev.security.controller.Mensaje;
import com.portfolioap.abeldev.service.Shys;
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
@CrossOrigin(origins = {"https://portfolio-front-abeldev.web.app","http://localhost:4200"})
@RequestMapping("/skill")
public class CHys {
    @Autowired
    Shys shys;

    @GetMapping("/lista")
    public ResponseEntity<List<hys>> list() {
        List<hys> list = shys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<hys> getById(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("NO SE ENCONTRO"), HttpStatus.NOT_FOUND);
        }
        hys hYs = shys.getOne(id).get();
        return new ResponseEntity(hYs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("NO SE ENCONTRO"), HttpStatus.NOT_FOUND);
        }
        shys.delete(id);
        return new ResponseEntity(new Mensaje("HABILIDAD ELIMINADA"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("ESTE CAMPO ES OBLIGATORIO"), HttpStatus.BAD_REQUEST);
        }
        if (shys.existsByNombre(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("ESTA HABILIDAD YA EXISTE"), HttpStatus.BAD_REQUEST);
        }

        hys hYs = new hys(dtohys.getNombre(), dtohys.getPorcentaje());
        shys.save(hYs);

        return new ResponseEntity(new Mensaje("HABILIDAD AGREGADA CORRECTAMENTE"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID NO EXISTE"), HttpStatus.BAD_REQUEST);
        }
        if (shys.existsByNombre(dtohys.getNombre()) && shys.getByNombre(dtohys.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("ESTA HABILIDAD YA EXISTE"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("ESTE CAMPO ES OBLIGATORIO"), HttpStatus.BAD_REQUEST);
        }

        hys hYs = shys.getOne(id).get();
        hYs.setNombre(dtohys.getNombre());
        hYs.setPorcentaje(dtohys.getPorcentaje());

        shys.save(hYs);
        return new ResponseEntity(new Mensaje("HABILIDAD ACTUALIZADA CORRECTAMENTE"), HttpStatus.OK);
    }
}
