package sn.ut.set.demo1SB.controleur;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import sn.ut.set.demo1SB.service.ServceRendezVous;
import sn.ut.set.demo1SB.modeles.RendezVous;
@RestController
@RequestMapping("/rv")
public class RendezVousControleur {
	private final ServceRendezVous serviceRendezVous;

	public RendezVousControleur(ServceRendezVous serviceRendezVous) {
		this.serviceRendezVous = serviceRendezVous;
	} 
	
	@GetMapping("/tousrv")
	public ResponseEntity<List<RendezVous>> getAllRvs(){
		List<RendezVous> rvs=serviceRendezVous.getAllRvs();
		return new ResponseEntity<List<RendezVous>>(rvs, HttpStatus.OK);
	}
	
	@GetMapping("/chercher/{id}")
	public ResponseEntity<RendezVous> chercherRvParId(@PathVariable("id") Long id){
		RendezVous rv=serviceRendezVous.trouverRVparID(id);
		return new ResponseEntity<RendezVous>(rv, HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<RendezVous> supprimerRvParId(@PathVariable("id") Long id){
		serviceRendezVous.supprimerUnRV(id);
		return new ResponseEntity<RendezVous>(HttpStatus.OK);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<RendezVous> ajouterUnRv(@RequestBody RendezVous rv){
		RendezVous newRv=serviceRendezVous.ajouterRV(rv);
		return new ResponseEntity<RendezVous>(newRv, HttpStatus.CREATED);
	}	
	
	@PutMapping("/miseajour")
	public ResponseEntity<RendezVous> miseajourUnRv(@RequestBody RendezVous rv){
		RendezVous updateRv=serviceRendezVous.miseajourRV(rv);
		return new ResponseEntity<RendezVous>(updateRv, HttpStatus.OK);
	}
}
