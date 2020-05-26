package srl.nexum.demoimmobiliare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import srl.nexum.demoimmobiliare.model.Immobile;
import srl.nexum.demoimmobiliare.repository.ImmobileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/immobili")
public class ImmobileController {

    @Autowired
    ImmobileRepository immobileRepository;

    @GetMapping("/")
    public ResponseEntity<List<Immobile>> getAllImmobili(@RequestParam(required = false) String indirizzo) {
        try {
            List<Immobile> immobili = new ArrayList<Immobile>();

            if (indirizzo == null)
                immobileRepository.findAll().forEach(immobili::add);
            else
                immobileRepository.findByIndirizzo(indirizzo).forEach(immobili::add);

            if (immobili.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(immobili, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Immobile> getImmobileById(@PathVariable("id") String id) {
        Optional<Immobile> immobileData = immobileRepository.findById(id);
        if(immobileData.isPresent()) {
            return new ResponseEntity<>(immobileData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Immobile> createImmobile(@RequestBody Immobile immobile) {
        try {
            Immobile _immobile = immobileRepository.save(new Immobile(immobile.getIndirizzo(), immobile.getMq()));
            return new ResponseEntity<>(_immobile, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Immobile> updateImmobile(@PathVariable("id") String id, @RequestBody Immobile immobile) {
        Optional<Immobile> immobileData = immobileRepository.findById(id);
        if(immobileData.isPresent()) {
            Immobile _immobile = immobileData.get();
            _immobile.setIndirizzo(immobile.getIndirizzo());
            _immobile.setMq(immobile.getMq());
            return new ResponseEntity<>(immobileRepository.save(_immobile), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteImmobile(@PathVariable("id") String id) {
        try {
            immobileRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllImmobili() {
        try {
            immobileRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping("/locale")
    public String locale() {
        return "locale";
    }

}
