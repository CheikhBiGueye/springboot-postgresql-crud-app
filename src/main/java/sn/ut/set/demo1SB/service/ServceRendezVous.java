package sn.ut.set.demo1SB.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.ut.set.demo1SB.exceptions.RvNotFoundException;
import sn.ut.set.demo1SB.modeles.RendezVous;
import sn.ut.set.demo1SB.repo.RendezVousRepo;

@Service
@Transactional
public class ServceRendezVous {
	private final RendezVousRepo rendezVousRepo;

	@Autowired
	public ServceRendezVous(RendezVousRepo rendezVousRepo) {
		this.rendezVousRepo = rendezVousRepo;
	}

	public RendezVous ajouterRV(RendezVous rv) {
		rv.setCodeRV(UUID.randomUUID().toString());
		return rendezVousRepo.save(rv);
	}

	public List<RendezVous> getAllRvs() {
		return rendezVousRepo.findAll();
	}

	public void supprimerUnRV(Long id) {
		rendezVousRepo.deleteById(id);
	}

	public RendezVous trouverRVparID(Long id) {
		return rendezVousRepo.findById(id)
				.orElseThrow(() -> new RvNotFoundException("Rv avec ud " + id + "non trouvé !!!"));
	}
	
	public RendezVous miseajourRV(RendezVous rv) {
		return rendezVousRepo.save(rv);
	}
}
